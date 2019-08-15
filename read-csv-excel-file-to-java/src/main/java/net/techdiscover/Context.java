package net.techdiscover;

import net.techdiscover.reader.Reader;

import java.io.IOException;
import java.util.List;

class Context {
    private Reader strategy;

    Context(Reader strategy) {
        this.strategy = strategy;
    }

    List<Employee> extractEmployees(String filePath) throws IOException {
        return strategy.extractEmployeesFromFile(filePath);
    }
}
