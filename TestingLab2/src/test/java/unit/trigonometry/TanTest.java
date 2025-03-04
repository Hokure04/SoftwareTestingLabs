package unit.trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cos;
import trigonometry.Sin;
import trigonometry.Tan;

import static org.junit.jupiter.api.Assertions.*;

class TanTest {
    double accuracy = 1e-10;
    double eps = 1e-8;
    private Sin sin = new Sin();
    private Cos cos = new Cos(sin);
    private Tan tan = new Tan(sin, cos);

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI, 2*Math.PI, 0})
    public void testPiValues(double x){
        assertEquals(Math.tan(x), tan.calculateTan(x, accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI/6, -Math.PI/4, -Math.PI/3, -Math.PI, -2*Math.PI})
    public void testNegativeValues(double x){
        assertEquals(Math.tan(x), tan.calculateTan(x, accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/2, 3*Math.PI/2, -Math.PI/2, -3*Math.PI/2})
    public void testInvalidValues(double x){
        assertEquals(Double.NaN, tan.calculateTan(x, accuracy), eps);
    }

}