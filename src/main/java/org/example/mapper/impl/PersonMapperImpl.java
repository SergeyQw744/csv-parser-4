package org.example.mapper.impl;

import org.example.entity.Division;
import org.example.entity.Person;
import org.example.exception.CSVMapperException;
import org.example.mapper.PersonMapper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person convertStringToPerson(String personString) throws ParseException {
        String[] tokens = personString.replace("[", "")
                .replace("]", "")
                .split(";");
        if (tokens.length == 6){
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                Person person = new Person.Builder()
                        .setId(Integer.parseInt(tokens[0]))
                        .setName(tokens[1])
                        .setGender(tokens[2])
                        .setDivision(new Division(tokens[4]))
                        .setBirthDate(format.parse(tokens[3]))
                        .setSalary(BigDecimal.valueOf(Double.parseDouble(tokens[5])))
                        .build();
                return person;
            } catch(Exception e){
                throw new CSVMapperException("Ошибка при анализе CSV");
            }
        } else {
            throw new CSVMapperException("Ошибка при анализе CSV");
        }
    }
}
