package task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static task3.Gender.FEMALE;
import static task3.Status.*;

public class StatusTest {
    static Person despairPerson;
    static Person happyPerson;
    static Person scaredPerson;
    static Person tiredPerson;

    @BeforeAll
    public static void initializeTestPersons(){
        despairPerson = new Person("some", 10, FEMALE, IN_DESPAIR, true, 80);
        happyPerson = new Person("some", 10, FEMALE, HAPPY, true, 80);
        scaredPerson = new Person("some", 10, FEMALE, SCARED, true, 80);
        tiredPerson = new Person("some", 10, FEMALE, TIRED, true, 80);
    }

    @Test
    void getDescription() {
        assertEquals("в отчаянии", despairPerson.personStatus.getDescription());
        assertEquals("с счастьем", happyPerson.personStatus.getDescription());
        assertEquals("с испугом", scaredPerson.personStatus.getDescription());
        assertEquals("с усталостью", tiredPerson.personStatus.getDescription());
    }
}