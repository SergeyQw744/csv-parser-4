package org.example.parser;

import java.util.List;

/**
 * Интерфейс CSVParser.
 * Требуется переопределить один метод parse(String path).
 * Предназначен для парсинга CSV файла и записи данных в
 * список.
 */
public interface CSVParser<T> {
    List<T> parse(String path);
}
