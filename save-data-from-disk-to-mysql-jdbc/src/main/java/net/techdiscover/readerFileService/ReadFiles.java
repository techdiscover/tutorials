package net.techdiscover.readerFileService;

import net.techdiscover.model.Employee;

import java.util.List;

public interface ReadFiles {
    List<Employee> extractEmployeesFromFile(String filePath) throws Exception;
}
