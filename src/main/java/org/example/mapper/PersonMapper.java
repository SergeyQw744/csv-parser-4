package org.example.mapper;

import org.example.entity.Person;

public interface PersonMapper {
    Person convertStringToPerson(String personString);
}
