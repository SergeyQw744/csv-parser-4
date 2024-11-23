package org.example.mapper;

import org.example.entity.Person;

import java.text.ParseException;

public interface PersonMapper {
    Person convertStringToPerson(String personString) throws ParseException;
}
