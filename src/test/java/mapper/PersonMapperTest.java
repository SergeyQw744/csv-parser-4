package mapper;

import org.example.entity.Division;
import org.example.entity.Person;
import org.example.exception.CSVMapperException;
import org.example.mapper.impl.PersonMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PersonMapperTest {

    @InjectMocks
    PersonMapperImpl mapper;

    @Test
    void testMapStringDataToPerson_returnedPerson() throws ParseException {
        String personString = "[28288;Aamori;Female;07.12.1984;I;9000]";
        Person actualPerson = new Person.Builder()
                .setId(28288)
                .setName("Aamori")
                .setGender("Female")
                .setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("07.12.1984"))
                .setDivision(new Division("I"))
                .setSalary(BigDecimal.valueOf(9000.0))
                .build();
        Person expectedPerson = mapper.convertStringToPerson(personString);
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getName(), actualPerson.getName());
        assertEquals(expectedPerson.getGender(), actualPerson.getGender());
        assertEquals(expectedPerson.getBirthDate(), actualPerson.getBirthDate());
        assertEquals(expectedPerson.getDivision().getName(), actualPerson.getDivision().getName());
        assertEquals(expectedPerson.getSalary(), actualPerson.getSalary());
    }

    @Test
    void testMapStringDataToPerson_throwsException(){
        String personStringInvalid1 = "[28288;Aamori;Female;I;9000]";
        assertThrows(CSVMapperException.class, () -> mapper.convertStringToPerson(personStringInvalid1));
        String personStringInvalid2 = "[hfg99;Aamori;Female;07.12.1984;I;9000]";
        assertThrows(CSVMapperException.class, () -> mapper.convertStringToPerson(personStringInvalid2));
        String personStringInvalid3 = "[28288;Aamori;Female;07.12;I;9000]";
        assertThrows(CSVMapperException.class, () -> mapper.convertStringToPerson(personStringInvalid3));
        String personStringInvalid4 = "[28288;Aamori;Female;07.12.1984;I;????]";
        assertThrows(CSVMapperException.class, () -> mapper.convertStringToPerson(personStringInvalid4));
    }
}
