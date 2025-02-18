package task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static task3.Gender.FEMALE;
import static task3.Gender.MALE;
import static task3.Status.HAPPY;
import static task3.Status.IN_DESPAIR;

class PersonTest {
    static Person trillian;
    static Person artur;
    static Door door;

    @BeforeAll
    public static void initializeEntities(){
        artur = new Person("Артур", 20, MALE, HAPPY, true, 89 );
        trillian = new Person("Триллиан", 18, FEMALE, IN_DESPAIR, true, 70 );
        door = new Door(false, true);
    }

    @Test
    public void testGrabHandMethod(){
        String expectedIfPersonHaveHands = "Триллиан в отчаянии схватила за руку Артур";
        assertEquals(expectedIfPersonHaveHands, captureConsoleOutput(() -> trillian.grabHand(artur)));
        artur.isHaveAnyHand = false;
        String expectedIfPersonWithoutHands = "У Триллиан не получилось схватить Артур за руку";
        assertEquals(expectedIfPersonWithoutHands, captureConsoleOutput(() -> trillian.grabHand(artur)));
    }

    @Test
    public void testPullMethod(){
        String expectedIfWeightEnough = "Триллиан потянул Артур к дверь";
        assertEquals(expectedIfWeightEnough, captureConsoleOutput(() -> trillian.pull(artur, door)));
        trillian.weight = 10;
        String expectedIfWeightNotEnough = "У Триллиан не хватило сил, чтобы потянуть Артур к дверь";
        assertEquals(expectedIfWeightNotEnough, captureConsoleOutput(() -> trillian.pull(artur, door)));
    }


    private String captureConsoleOutput(Runnable action){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        action.run();
        System.setOut(System.out);
        return out.toString().trim();
    }

}