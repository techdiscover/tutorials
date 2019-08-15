package net.techdiscover;

import java.io.*;
import java.util.*;

import net.techdiscover.reader.*;

public class App
{
   private static Context reader;

    public static void main( String[] args )
    {
        readCSVFilesFromDisk();
        readExcelFilesFromDisk();
    }

    private static void readExcelFilesFromDisk() {
        reader = new Context(new ExcelReader());
        printEmployees("src/test/resources/excel");
    }

    private static void printEmployees(String pathname) {
        File folder = new File(pathname);
        List<String> filePathList = getAllFilesFromPath(folder);

        for (String filePath : filePathList) {
            List<Employee> employees = reader.extractEmployees(filePath);
            for (Employee employee : employees) {
                employee.print();
            }
        }
    }

    private static void readCSVFilesFromDisk() {
        reader = new Context(new CSVReader());
        printEmployees("src/test/resources/csv");
    }

    private static List getAllFilesFromPath(File file) {
        List<String> files = new ArrayList<String>();
        for (final File fileEntry : file.listFiles()) {
            if (fileEntry.isDirectory()) {
                files.addAll(getAllFilesFromPath(fileEntry));
            } else {
                files.add(fileEntry.getAbsoluteFile().toString());
            }
        }
        return files;
    }
}
