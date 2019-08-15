package net.techdiscover.readerFileService.impl;

import com.opencsv.CSVReader;
import net.techdiscover.model.Employee;
import net.techdiscover.readerFileService.ReadFiles;
import net.techdiscover.utils.Context;
import net.techdiscover.utils.PrintFiles;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderCSVImpl implements ReadFiles {

    private static final String CSV_CSV_FILE_1_CSV = "./csv/csvFile_1.csv";
    private PrintFiles printEmployees = new PrintFiles();

    public List<Employee> collectDatafromCSV() throws Exception {
        Context contextCSV = new Context(new ReaderCSVImpl());
         return contextCSV.extractEmployees(CSV_CSV_FILE_1_CSV);
    }

    public List<Employee> extractEmployeesFromFile(String filePath) throws Exception {
        List<Employee> employees = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(CSV_CSV_FILE_1_CSV).toURI()));
                CSVReader csvReader = new CSVReader(reader);
                ) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                employees.add(new Employee(line[0], line[1], line[2], line[3], line[4]));
            }
        }

        return employees;
    }
}
