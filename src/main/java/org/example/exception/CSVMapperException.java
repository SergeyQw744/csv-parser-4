package org.example.exception;

/**
 * Класс CSVMapperException
 * Этот класс является исключением, которое выбрасывается при некорректном
 * парсинге строки с данными об объекте класса Person
 */
public class CSVMapperException extends RuntimeException{
    public CSVMapperException(String message){
        super(message);
    }
}
