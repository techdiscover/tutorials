package net.techdiscover.reader;

import net.techdiscover.model.Employee;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<Employee> extractEmployeesFromFile(String filePath) throws IOException;
}
