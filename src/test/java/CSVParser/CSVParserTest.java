package CSVParser;

import org.example.entity.Division;
import org.example.entity.Person;
import org.example.mapper.impl.PersonMapperImpl;
import org.example.parser.impl.CSVParserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CSVParserTest {

    @Mock
    PersonMapperImpl mapper;

    @InjectMocks
    CSVParserImpl parser;

    @BeforeEach
    void initParser(){
        parser = new CSVParserImpl();
    }

    @Test
    void testCSVParse_returnedListPerson() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        List<Person> peopleExpected = List.of(
                new Person.Builder()
                        .setId(28281)
                        .setName("Aahan")
                        .setGender("Male")
                        .setBirthDate(format.parse("15.05.1970"))
                        .setDivision(new Division("I"))
                        .setSalary(BigDecimal.valueOf(4800.0))
                        .build(),
                new Person.Builder()
                        .setId(28282)
                        .setName("Aala")
                        .setGender("Female")
                        .setBirthDate(format.parse("07.02.1983"))
                        .setDivision(new Division("J"))
                        .setSalary(BigDecimal.valueOf(2600.0))
                        .build(),
                new Person.Builder()
                        .setId(28283)
                        .setName("Aaleahya")
                        .setGender("Female")
                        .setBirthDate(format.parse("06.11.1949"))
                        .setDivision(new Division("F"))
                        .setSalary(BigDecimal.valueOf(1000.0))
                        .build()
        );
        List<Person> peopleActual = parser.parse("src/test/java/CSVParser/csv/test.csv");
        assertEquals(peopleExpected.size(), peopleActual.size());
        int size = peopleActual.size();
        for (int i = 0; i < size; i++){
            Person actualPerson = peopleActual.get(i);
            Person expectedPerson = peopleExpected.get(i);
            assertEquals(expectedPerson.getId(), actualPerson.getId());
            assertEquals(expectedPerson.getName(), actualPerson.getName());
            assertEquals(expectedPerson.getGender(), actualPerson.getGender());
            assertEquals(expectedPerson.getBirthDate(), actualPerson.getBirthDate());
            assertEquals(expectedPerson.getDivision().getName(), actualPerson.getDivision().getName());
            assertEquals(expectedPerson.getSalary(), actualPerson.getSalary());
        }
    }
}
