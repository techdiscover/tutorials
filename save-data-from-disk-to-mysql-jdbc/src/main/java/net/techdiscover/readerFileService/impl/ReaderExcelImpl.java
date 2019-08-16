package net.techdiscover.readerFileService.impl;

import net.techdiscover.utils.Context;
import net.techdiscover.model.Employee;
import net.techdiscover.utils.PrintFiles;
import net.techdiscover.readerFileService.ReadFiles;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReaderExcelImpl implements ReadFiles {
    private static final String SRC_TEST_RESOURCES_EXCEL = "resources/excel";
    private PrintFiles printEmployees = new PrintFiles();

    public void readExcelFilesFromDisk() throws Exception {
        Context contextExcel = new Context(new ReaderExcelImpl());
        printEmployees.printEmployees(contextExcel, SRC_TEST_RESOURCES_EXCEL);
    }

    public List<Employee> extractEmployeesFromFile(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();

        FileInputStream file = new FileInputStream(new File(filePath));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Employee employee = new Employee(row.getCell(0).toString(), row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
            employees.add(employee);
        }
        file.close();

        return employees;
    }
}

