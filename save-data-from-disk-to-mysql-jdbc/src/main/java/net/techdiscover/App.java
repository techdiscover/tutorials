package net.techdiscover;

import net.techdiscover.model.Employee;
import net.techdiscover.mysqlService.MySqlService;
import net.techdiscover.readerFileService.impl.ReaderCSVImpl;

import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        List<Employee> employees = new ReaderCSVImpl().collectDatafromCSV();
        new MySqlService().saveEmployeesToDB(employees);
    }
}
