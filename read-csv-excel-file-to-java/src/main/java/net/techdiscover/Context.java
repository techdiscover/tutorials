package net.techdiscover;

import java.util.*;
import net.techdiscover.reader.Reader;

public class Context {
    private Reader strategy;

    public Context(Reader strategy) {
        this.strategy = strategy;
    }

    public List extractEmployees(String filePath){
        return strategy.extractEmployeesFromFile(filePath);
    }
}
