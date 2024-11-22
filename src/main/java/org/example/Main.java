package org.example;


import org.example.parser.CSVParserImpl;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        CSVParserImpl parser = new CSVParserImpl();
        parser.parse("csv/foreign_names.csv");
    }
}