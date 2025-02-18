package task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static task3.Gender.MALE;
import static task3.Status.HAPPY;

public class CreatureTest {
    static Creature butterfly;
    static Creature dragon;
    static Person sasha;

    @BeforeAll
    public static void initializeEntities(){
        butterfly = new Creature("бабочка",false,true,false);
        dragon = new Creature("дракон", true, true, false);
        sasha = new Person("Саша", 20, MALE, HAPPY, true, 79);
    }

    @Test
    public void checkCreatureGetMethods() {
        assertEquals("бабочка", butterfly.getCreatureName());
        assertFalse(butterfly.isDangerous());
        assertTrue(butterfly.isCanFly());
        assertFalse(butterfly.isCanHypnotize());
    }


    @Test
    public void testAttackByDangerous() {
        String expected = "дракон атакует Саша";
        assertEquals(expected, captureConsoleOutput(() -> dragon.attack(sasha)));
    }

    @Test
    public void testAttackByHarmless() {
        String expected = "бабочка решило не атаковать Саша";
        assertEquals(expected, captureConsoleOutput(() -> butterfly.attack(sasha)));
    }

    private String captureConsoleOutput(Runnable action){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        action.run();
        System.setOut(System.out);
        return out.toString().trim();
    }
}