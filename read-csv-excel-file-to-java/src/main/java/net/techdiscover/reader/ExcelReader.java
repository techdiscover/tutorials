package net.techdiscover.reader;

import java.io.*;
import java.util.*;

import net.techdiscover.Employee;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader implements Reader {

    public List extractEmployeesFromFile(String filePath){
        List<Employee> employees = new ArrayList<Employee>();
        try
        {
            FileInputStream file = new FileInputStream(new File(filePath));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                Employee employee = new Employee(row.getCell(0).toString(), row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
                employees.add(employee);
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employees;
    }
}

