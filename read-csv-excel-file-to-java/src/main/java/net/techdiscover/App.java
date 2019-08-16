package net.techdiscover;

import net.techdiscover.reader.impl.ReaderCSVImpl;
import net.techdiscover.reader.impl.ReaderExcelImpl;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        new ReaderCSVImpl().readCSVFilesFromDisk();
        new ReaderExcelImpl().readExcelFilesFromDisk();
    }
}
