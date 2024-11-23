package org.example;


import org.example.entity.Person;
import org.example.parser.impl.CSVParserImpl;

import java.util.List;

public class Main {
    public static void main(String[] args){

        CSVParserImpl parser = new CSVParserImpl();
        List<Person> persons = parser.parse("csv/foreign_names.csv");
    }
}