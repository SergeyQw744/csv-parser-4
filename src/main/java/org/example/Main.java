package org.example;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String csvFilePath = "csv/foreign_names.csv";
        List<List<String>> dataList = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))){

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                dataList.add(Arrays.asList(nextLine));
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        for (List<String> line : dataList) {
            System.out.println(line);
        }
    }
}