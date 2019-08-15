package net.techdiscover;

import java.io.*;
import java.util.*;
import net.techdiscover.reader.CSVReader;
import net.techdiscover.reader.ExcelReader;

class FileReader {

    private static Context reader;

    void run() throws IOException {
        readCSVFilesFromDisk();
        readExcelFilesFromDisk();
    }

    private void readExcelFilesFromDisk() throws IOException {
        reader = new Context(new ExcelReader());
        printEmployees("src/test/resources/excel");
    }

    private void printEmployees(String pathname) throws IOException {
        File folder = new File(pathname);
        List<String> filePathList = getAllFilesFromPath(folder);

        for (String filePath : filePathList) {
            List<Employee> employees = reader.extractEmployees(filePath);
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }
    }

    private void readCSVFilesFromDisk() throws IOException {
        reader = new Context(new CSVReader());
        printEmployees("src/test/resources/csv");
    }

    private List<String> getAllFilesFromPath(File file) {
        List<String> files = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(file.listFiles())) {
            if (fileEntry.isDirectory()) {
                files.addAll(getAllFilesFromPath(fileEntry));
            } else {
                files.add(fileEntry.getAbsoluteFile().toString());
            }
        }
        return files;
    }
}
