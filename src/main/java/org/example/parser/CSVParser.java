package org.example.parser;

import java.util.List;

public interface CSVParser<T> {
    List<T> parser(String path);
}
