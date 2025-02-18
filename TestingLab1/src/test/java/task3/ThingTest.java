package task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThingTest {
    static Thing glass;

    @BeforeAll
    public static void initializeThing(){
        glass = new Thing("стакан");
    }

    @Test
    public void testGetThingName(){
        assertEquals("стакан",glass.getThingName());
    }

}