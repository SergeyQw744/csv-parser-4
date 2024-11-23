package org.example.parser.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.example.entity.Person;
import org.example.mapper.impl.PersonMapperImpl;
import org.example.parser.CSVParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс CSVParserImpl.
 * Реализует интерфейс CSVParser.
 * Класс имеет поле, являющееся объектом класса PersonMapperImpl, нужное для преобразования
 * строкового представления человека в объект класса Person. Класс CSVParserImpl
 * предназначен для парсинга CSV файла и записи данных в список. У класса есть один
 * публичный метод
 * @see #parse(String path)
 */
public class CSVParserImpl implements CSVParser<Person> {

    private PersonMapperImpl personMapperImpl;

    public CSVParserImpl(){
        personMapperImpl = new PersonMapperImpl();
    }

    /**
     * Метод List<Person> parse(String path)
     * Метод принимает на вход строковый параметр path, который является путем к CSV
     * файлу. Метод возвращает список объектов Person с данными из файла. Сначала создается
     * пустой список со строковыми значениями. Применяется поток чтения из файла, при этом
     * первая строка не добавляется в список, поскольку содержит названия полей. После
     * список со строковыми значениями преобразуется в список объектов Person с помощью
     * класса PersonMapperImpl.
     * @param #path путь к файлу CSV
     * @see PersonMapperImpl
     * @throws RuntimeException
     */
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
        return dataList.stream()
                .map(list -> list.toString())
                .map(list -> {
                    try {
                        return personMapperImpl.convertStringToPerson(list);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}
