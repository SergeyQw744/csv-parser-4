package org.example;


import org.example.parser.CSVParserImpl;

public class Main {
    public static void main(String[] args) {
        CSVParserImpl parser = new CSVParserImpl();
        parser.parse("csv/foreign_names.csv");
    }
}