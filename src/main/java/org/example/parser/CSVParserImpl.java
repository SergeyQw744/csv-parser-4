package org.example.parser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.example.entity.Person;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParserImpl implements CSVParser<Person> {

    @Override
    public List<Person> parse(String path) {
        List<List<String>> dataList = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(path))){

            String[] nextLine;
            csvReader.readNext();
            while ((nextLine = csvReader.readNext()) != null) {
                dataList.add(Arrays.asList(nextLine));
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        for (List<String> line : dataList) {
            System.out.println(line);
        }
        return null;
    }
}
