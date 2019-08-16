package net.techdiscover.reader.impl;

import net.techdiscover.utils.Context;
import net.techdiscover.model.Employee;
import net.techdiscover.utils.PrintFiles;
import net.techdiscover.reader.Reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderCSVImpl implements Reader {

    public static final String SRC_TEST_RESOURCES_CSV = "src/test/resources/csv";
    private PrintFiles printEmployees = new PrintFiles();

    public void readCSVFilesFromDisk() throws IOException {
        PrintFiles.reader = new Context(new ReaderCSVImpl());
        printEmployees.printEmployees(SRC_TEST_RESOURCES_CSV);
    }

    public List<Employee> extractEmployeesFromFile(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();

        com.opencsv.CSVReader reader;

        reader = new com.opencsv.CSVReader(new FileReader(filePath));
        String[] line;
        while ((line = reader.readNext()) != null) {
            employees.add(new Employee(line[0], line[1], line[2], line[3], line[4]));
        }

        return employees;
    }
}
