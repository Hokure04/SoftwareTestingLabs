package unit.trigonometry;

import function.CsvExporter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cosec;
import trigonometry.Sin;

import static org.junit.jupiter.api.Assertions.*;

class CosecTest {
    double eps = 1e-8;
    double accuracy = 1e-10;
    private final Sin sin = new Sin();
    private final Cosec cosec = new Cosec(sin);
    private final CsvExporter csvExporter = new CsvExporter(cosec::calculateCosec);

    @Test
    public void testAndSaveCosecResults(){
        for (double x = 0.1; x <= 2*Math.PI; x += 0.1) {
            double expected = 1/Math.sin(x);
            double actual = cosec.calculateCosec(x, accuracy);

            assertEquals(expected, actual, eps);

        }
        csvExporter.testAndExportCsv(0.1,2*Math.PI,0.1,"cosec_results.csv", eps);
    }

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