package org.example.mapper;

import org.example.entity.Person;

import java.text.ParseException;

/**
 * Интерфейс PersonMapper.
 * Требуется переопределить метод convertStringToPerson(String personString).
 * Предназначен для перевода строкового представления человека в объект класса
 * Person.
 */
public interface PersonMapper {
    Person convertStringToPerson(String personString) throws ParseException;
}
