package net.techdiscover.reader;

import java.io.*;
import java.util.*;

import net.techdiscover.Employee;

public class CSVReader implements Reader {

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
