package task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SinTest {
    double eps = 0.001;

    @Test
    public void testZeroValue() {
        double value = 0;
        double expectedRes = Math.sin(value);
        int tailorSequenceCount = 100;
        double actualRes = Sin.calculate(value, tailorSequenceCount);
        assertEquals(expectedRes, actualRes, eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, -0.5*Math.PI})
    public void testNegativeValues(double x){
        assertEquals(Math.sin(x), Sin.calculate(x, 100), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2*Math.PI, Math.PI, 0.5*Math.PI})
    public void testPositiveValues(double x){
        assertEquals(Math.sin(x), Sin.calculate(x, 100), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2, 3, 10, -2, -3, -10})
    public void outOfRangeValues(double x){
        assertEquals(Math.sin(x), Sin.calculate(x,100), eps);
    }


}