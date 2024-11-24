package org.example.mapper.impl;

import org.example.entity.Division;
import org.example.entity.Person;
import org.example.exception.CSVMapperException;
import org.example.mapper.PersonMapper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Класс PersonMapperImpl
 * Этот класс реализует интерфейс PersonMapper.
 * Предназначен для перевода данных о человеке из строки в объект класса Person.
 * Этот класс имеет один публичный метод
 * @see #convertStringToPerson(String personString)
 */
public class PersonMapperImpl implements PersonMapper {

    /**
     * Метод convertStringToPerson(String personString)
     * Метод принимает на вход строковое представление человека и возвращает объект класса
     * Person. Сначала подающаяся на вход строка делится на составные части - значения полей.
     * Дальше делается проверка на количество токенов, которых должно быть 6. Также мы создаем
     * объект, который необходимо будет вернуть, также парсим числовые данные и дату. Дата
     * парсится при помощи класса SimpleDateFormat. Если в процессе анализа строки возникает
     * проблема сопоставления данных из строки с объектом выбрасывается исключение CSVMapperException.
     * @param personString данные о человеке в виде строки
     * @throws CSVMapperException выбрасывается при ошибке парсинга
     */
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
