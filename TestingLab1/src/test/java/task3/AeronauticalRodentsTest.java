package task3;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static task3.Gender.FEMALE;
import static task3.Gender.MALE;
import static task3.Status.HAPPY;
import static task3.Status.IN_DESPAIR;

public class AeronauticalRodentsTest {
    static AeronauticalRodents rodents;
    static Person artur;

    @BeforeAll
    public static void initializeEntities(){
        artur = new Person("Артур", 20, MALE, HAPPY, true, 89 );
        rodents = new AeronauticalRodents();
    }

    @Test
    public void checkAeronauticalRodentsFields(){
        assertEquals("воздухоплавающие грызуны", rodents.creatureName);
        assertTrue(rodents.isDangerous);
        assertTrue(rodents.canFly);
        assertTrue(rodents.canHypnotize);
    }

    @Test
    public void attack(){
        String expectedOutput = "воздухоплавающие грызуны загипнотизировали Артур";
        assertEquals(expectedOutput, captureConsoleOutput(() -> rodents.attack(artur)));
    }

    private String captureConsoleOutput(Runnable action){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        action.run();
        System.setOut(System.out);
        return out.toString().trim();
    }
}