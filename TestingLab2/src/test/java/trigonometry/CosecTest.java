package trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CosecTest {
    double eps = 1e-8;

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI/2, Double.POSITIVE_INFINITY})
    public void testPiValues(double x){
        assertEquals(1/Math.sin(x), Cosec.calculateCosec(x , 20), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI/2, Double.NEGATIVE_INFINITY})
    public void testNegativePi(double x){
        assertEquals(1/Math.sin(x), Cosec.calculateCosec(x, 20), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, -Math.PI, -2*Math.PI, 2*Math.PI})
    public void testInvalidValues(double x){
        assertTrue(Double.isNaN(Cosec.calculateCosec(x, 20)));
    }

}