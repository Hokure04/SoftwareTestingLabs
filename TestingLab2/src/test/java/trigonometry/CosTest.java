package trigonometry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CosTest {
    double eps = 1e-8;

    @ParameterizedTest
    @ValueSource(doubles = {2*Math.PI, Math.PI, 0.5*Math.PI, 0.25*Math.PI})
    public void testPositiveValues(double x){
        assertEquals(Math.cos(x), Cos.calculateCos(x,20),eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2*Math.PI, -Math.PI, -0.5*Math.PI})
    public void testNegativeValues(double x){
        assertEquals(Math.cos(x), Cos.calculateCos(x, 20), eps);
    }

    @Test
    public void testZeroValue(){
        double value = 0;
        double expectedRes = Math.cos(value);
        int n = 20;
        double actualRes = Cos.calculateCos(value, n);
        assertEquals(expectedRes, actualRes, eps);
    }
}