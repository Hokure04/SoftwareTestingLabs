package logarithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {
    double eps = 1e-8;

    @Test
    public void testNaturalLogarithmOfOne(){
        double zero = 0;
        double expectedRes = Math.log(1);
        int n = 20;
        double actualRes = Ln.calculateNaturalLogarithm(zero, n);
        assertEquals(expectedRes, actualRes, eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.001, 0.1, 0.2, 0.5, 0.9, -0.001, -0.1, -0.2, -0.5, -0.9})
    public void testValidValues(double x){
        assertEquals(Math.log(1+x), Ln.calculateNaturalLogarithm(x,100), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, 1.7, 2.0, 5.0, -1.0, -1.7, -2.0, -5.0, Double.NaN, Double.NEGATIVE_INFINITY})
    public void testInvalidValues(double x){
        assertEquals(Math.log(1+x), Ln.calculateNaturalLogarithm(x,100), eps);
    }

}