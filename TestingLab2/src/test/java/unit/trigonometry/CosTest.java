package unit.trigonometry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cos;
import trigonometry.Sin;

import static org.junit.jupiter.api.Assertions.*;

class CosTest {
    double accuracy = 1e-10;
    double eps = 1e-8;
    private Sin sin = new Sin();
    private Cos cos = new Cos(sin);

    @ParameterizedTest
    @ValueSource(doubles = {2*Math.PI, Math.PI, 0.5*Math.PI, 0.25*Math.PI})
    public void testPositiveValues(double x){
        assertEquals(Math.cos(x), cos.calculateCos(x,accuracy),eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2*Math.PI, -Math.PI, -0.5*Math.PI})
    public void testNegativeValues(double x){
        assertEquals(Math.cos(x), cos.calculateCos(x, accuracy), eps);
    }

    @Test
    public void testZeroValue(){
        double value = 0;
        double expectedRes = Math.cos(value);
        double actualRes = cos.calculateCos(value, accuracy);
        assertEquals(expectedRes, actualRes, eps);
    }
}