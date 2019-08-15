package net.techdiscover.utils;

import net.techdiscover.model.Employee;
import net.techdiscover.reader.Reader;

import java.io.IOException;
import java.util.List;

public class Context {
    private Reader strategy;

    public Context(Reader strategy) {
        this.strategy = strategy;
    }

    public List<Employee> extractEmployees(String filePath) throws IOException {
        return strategy.extractEmployeesFromFile(filePath);
    }
}
