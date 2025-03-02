package trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TanTest {
    double eps = 1e-8;

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI, 2*Math.PI, 0})
    public void testPiValues(double x){
        assertEquals(Math.tan(x), Tan.calculateTan(x, 20), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI/6, -Math.PI/4, -Math.PI/3, -Math.PI, -2*Math.PI})
    public void testNegativeValues(double x){
        assertEquals(Math.tan(x), Tan.calculateTan(x, 20), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2, 3*Math.PI/2, -Math.PI/2, -3*Math.PI/2})
    public void testInvalidValues(double x){
        assertEquals(Double.NaN, Tan.calculateTan(x, 20), eps);
    }

}