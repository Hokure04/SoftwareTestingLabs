package unit.function;

import function.LogarithmFunction;
import logarithms.Ln;
import logarithms.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogarithmFunctionTest {
    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln,2);
    private final Log log10 = new Log(ln, 10);
    private final LogarithmFunction logFunction = new LogarithmFunction(ln , log2, log10);
    private final double accuracy = 1e-10;
    private final double eps = 1e-5;

    @Test
    public void testValues(){
        assertEquals(0,logFunction.calculateLogFunc(1.5, accuracy), eps);
        assertEquals(-1.161422,logFunction.calculateLogFunc(0.4, accuracy), eps);
        assertEquals(-0.00005, logFunction.calculateLogFunc(0.5, accuracy), eps);
        assertEquals(0, logFunction.calculateLogFunc(0.6, accuracy), eps);
        assertEquals(-0.00005, logFunction.calculateLogFunc(2, accuracy), eps);
        assertEquals(-1.161422, logFunction.calculateLogFunc(2.5, accuracy), eps);
        assertEquals(-5.25296, logFunction.calculateLogFunc(2.6, accuracy), eps);
        assertEquals(-21.19059, logFunction.calculateLogFunc(2.7, accuracy), eps);
    }

}