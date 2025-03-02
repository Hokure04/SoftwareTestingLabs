package function;

import logarithms.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LogFunctionTest {
    private final Log log2 = new Log(2);
    private final Log log10 = new Log(10);
    private final LogFunction logFunction = new LogFunction(log2, log10);
    private final int precision = 1000000;

    @ParameterizedTest
    @ValueSource(doubles = { 2, 4, 8, 10, 16, 32, 50, 100})
    public void testValidLogFunction(double x){
        assertDoesNotThrow(() -> logFunction.calculateLogFunction(x, precision));
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 0, -1, -10, -100})
    public void testInvalidLogFunction(double x){
        assertThrows(ArithmeticException.class, () -> logFunction.calculateLogFunction(x, precision));
    }

    @Test
    public void testLargeValue(){
        assertEquals(-0.03687, logFunction.calculateLogFunction(0.5, precision));
        assertEquals(0, logFunction.calculateLogFunction(0.7, precision));
        assertEquals(0, logFunction.calculateLogFunction(1.5, precision));
        assertEquals(-0.03687, logFunction.calculateLogFunction(2, precision));
        assertEquals(-147.15095, logFunction.calculateLogFunction(3, precision));


    }

}