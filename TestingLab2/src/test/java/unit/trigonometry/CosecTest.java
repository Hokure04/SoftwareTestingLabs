package unit.trigonometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cosec;
import trigonometry.Sin;

import static org.junit.jupiter.api.Assertions.*;

class CosecTest {
    double eps = 1e-8;
    double accuracy = 1e-10;
    private Sin sin = new Sin();
    private Cosec cosec = new Cosec(sin);

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI/2})
    public void testPiValues(double x){
        assertEquals(1/Math.sin(x), cosec.calculateCosec(x , accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI/2})
    public void testNegativePi(double x){
        assertEquals(1/Math.sin(x), cosec.calculateCosec(x, accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, -Math.PI, -2*Math.PI, 2*Math.PI})
    public void testInvalidValues(double x){
        assertTrue(Double.isNaN(cosec.calculateCosec(x, accuracy)));
    }

}