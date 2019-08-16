package net.techdiscover.utils;

import java.io.*;
import java.util.*;

import net.techdiscover.model.Employee;

public class PrintFiles {

    public void printEmployees(Context context, String pathname) throws Exception {
        File folder = new File(pathname);
        List<String> filePathList = getAllFilesFromPath(folder);

        for (String filePath : filePathList) {
            List<Employee> employees = context.extractEmployees(filePath);
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }
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
