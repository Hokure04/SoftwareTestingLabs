package task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static task3.Gender.FEMALE;
import static task3.Gender.MALE;
import static task3.Status.*;

public class DoorTest {
    static Door door;
    static List<Person> onePerson = new ArrayList<>();
    static List<Person> twoPersons = new ArrayList<>();
    static List<Person> manyPersons = new ArrayList<>();
    static List<Person> noPersons = new ArrayList<>();
    static Person artur;
    static Person trillian;
    static Person sasha;
    static Person ford;

    @BeforeAll
    public static void initializeEntities(){
        door = new Door(false, true);
        artur = new Person("Артур", 20, MALE, HAPPY, true, 89 );
        trillian = new Person("Триллиан", 18, FEMALE, IN_DESPAIR, true, 70 );
        sasha = new Person("Саша", 20, MALE, TIRED, true, 65 );
        ford = new Person("Форд", 19, MALE, SCARED, true, 70);
        onePerson.add(artur);
        twoPersons.add(artur);
        twoPersons.add(sasha);
        manyPersons.add(artur);
        manyPersons.add(sasha);
        manyPersons.add(trillian);
        manyPersons.add(ford);
    }

    @Test
    public void checkFields(){
        assertEquals("дверь", door.thingName);
        assertFalse(door.isOpen);
        assertTrue(door.isSomethingPreventing);
    }

    @Test
    public void open(){
        door.isSomethingPreventing = false;
        String expectedForZeroPersons = "Никто не пытается открыть дверь";
        assertEquals(expectedForZeroPersons, captureConsoleOutput(() -> door.open(noPersons)));
        assertFalse(door.open(noPersons));
        String expectedForOne = "Артур попытались открыть дверь\nдверь открылась";
        assertEquals(expectedForOne, captureConsoleOutput(() -> door.open(onePerson)));
        assertTrue(door.open(onePerson));
        String expectedForTwo = "Артур и Саша попытались открыть дверь\nдверь открылась";
        assertEquals(expectedForTwo, captureConsoleOutput(() -> door.open(twoPersons)));
        assertTrue(door.open(twoPersons));
        String expectedForMany = "Артур, Саша, Триллиан и Форд попытались открыть дверь\nдверь открылась";
        assertEquals(expectedForMany, captureConsoleOutput(() -> door.open(manyPersons)));
        assertTrue(door.open(manyPersons));
        door.isSomethingPreventing = true;
        String expectedForPreventing = "Что-то мешает открыть дверь";
        assertEquals(expectedForPreventing, captureConsoleOutput(() -> door.open(twoPersons)));
        assertFalse(door.open(twoPersons));
    }

    @Test
    public void close(){
        door.isSomethingPreventing = false;
        String expectedForZeroPersons = "Никто не пытается закрыть дверь";
        assertEquals(expectedForZeroPersons, captureConsoleOutput(() -> door.close(noPersons)));
        assertFalse(door.close(noPersons));
        String expectedForOne = "Артур попытались закрыть дверь\nдверь закрылась";
        assertEquals(expectedForOne, captureConsoleOutput(() -> door.close(onePerson)));
        assertTrue(door.close(onePerson));
        String expectedForTwo = "Артур и Саша попытались закрыть дверь\nдверь закрылась";
        assertEquals(expectedForTwo, captureConsoleOutput(() -> door.close(twoPersons)));
        assertTrue(door.close(twoPersons));
        String expectedForMany = "Артур, Саша, Триллиан и Форд попытались закрыть дверь\nдверь закрылась";
        assertEquals(expectedForMany, captureConsoleOutput(() -> door.close(manyPersons)));
        assertTrue(door.close(manyPersons));
        door.isSomethingPreventing = true;
        String expectedForPreventing = "Что-то мешает закрыть дверь";
        assertEquals(expectedForPreventing, captureConsoleOutput(() -> door.close(twoPersons)));
        assertFalse(door.close(twoPersons));

    }

    private String captureConsoleOutput(Runnable action){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        action.run();
        System.setOut(System.out);
        return out.toString().trim();
    }

}