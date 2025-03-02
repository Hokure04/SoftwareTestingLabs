package trigonometry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CotTest {
    double eps = 1e-8;

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI/2, 3*Math.PI/2, Double.POSITIVE_INFINITY})
    public void testPiValues(double x){
        assertEquals(Math.cos(x)/Math.sin(x), Cot.calculateCot(x, 20), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI/6, -Math.PI/4,-Math.PI/3 -Math.PI/2, -3*Math.PI/2, Double.NEGATIVE_INFINITY})
    public void testNegativePi(double x){
        assertEquals(Math.cos(x)/Math.sin(x), Cot.calculateCot(x, 20), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, -Math.PI,2*Math.PI, -2*Math.PI, 0})
    public void testInvalidValues(double x){
        assertEquals(Double.NaN, Cot.calculateCot(x, 20), eps);
    }
}