package function;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TrigonometryFunctionTest {
    private final TrigonometryFunction trigonometryFunc = new TrigonometryFunction();
    private final int precision = 10000;

    @ParameterizedTest
    @ValueSource(doubles = {1, Math.PI/6, Math.PI/4, Math.PI/15, 3*Math.PI/20})
    public void testValidTrigonometryFunction(double x){
        assertDoesNotThrow(() -> trigonometryFunc.calculateTrigonometryFunction(x, precision));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI/2, 3*Math.PI, -Math.PI/2, 2*Math.PI, Math.PI})
    public void testInvalidTrigonometryFunction(double x){
        assertThrows(ArithmeticException.class, () -> trigonometryFunc.calculateTrigonometryFunction(x, precision));
    }

}