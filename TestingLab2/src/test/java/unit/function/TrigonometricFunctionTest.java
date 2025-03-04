package unit.function;

import function.TrigonometricFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import trigonometry.*;

import static org.junit.jupiter.api.Assertions.*;

class TrigonometricFunctionTest {
    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Tan tan = new Tan(sin, cos);
    private final Cot cot = new Cot(sin, cos);
    private final Cosec cosec = new Cosec(sin);
    private final TrigonometricFunction trigonometricFunc = new TrigonometricFunction(cos, tan, cot, cosec);
    private final double eps = 1e-3;
    private final double accuracy = 1e-8;


    /*@BeforeAll
    public static void initializeTrigonometricFunctions(){
        sin = new Sin();
    }*/

    @Test
    public void testValues(){
        assertEquals(34.87078, trigonometricFunc.calculateTrgFunc(-0.2, accuracy), eps);
        assertEquals(17.73753, trigonometricFunc.calculateTrgFunc(-0.3, accuracy), eps);
        assertEquals(11.36493, trigonometricFunc.calculateTrgFunc(-0.4, accuracy), eps);
        assertEquals(8.35704, trigonometricFunc.calculateTrgFunc(-0.5, accuracy), eps);
        assertEquals(6.82705, trigonometricFunc.calculateTrgFunc(-0.6, accuracy), eps);
    }
}

