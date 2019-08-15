package net.techdiscover.utils;

import net.techdiscover.model.Employee;
import net.techdiscover.readerFileService.ReadFiles;

import java.util.List;

public class Context {
    private ReadFiles strategy;

    public Context(ReadFiles strategy) {
        this.strategy = strategy;
    }

    public List<Employee> extractEmployees(String filePath) throws Exception {
        return strategy.extractEmployeesFromFile(filePath);
    }
}
