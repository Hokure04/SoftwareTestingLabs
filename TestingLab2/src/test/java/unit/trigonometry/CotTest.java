package unit.trigonometry;

import function.CsvExporter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cos;
import trigonometry.Cot;
import trigonometry.Sin;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CotTest {
    double accuracy = 1e-10;
    double eps = 1e-8;
    private Sin sin = new Sin();
    private Cos cos = new Cos(sin);
    private Cot cot = new Cot(sin, cos);
    private CsvExporter csvExporter = new CsvExporter(cot::calculateCot);


    @Test
    public void testAndSaveCotResults(){
        for (double x = 0.1; x <= 2*Math.PI; x += 0.1) {
            double expected = Math.cos(x)/Math.sin(x);
            double actual = cot.calculateCot(x, accuracy);

            assertEquals(expected, actual, eps, "Ошибка при вычислении cos(" + x + ")");

        }
        csvExporter.testAndExportCsv(0.1, 2*Math.PI,0.1, "cot_result.csv", eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI/6, Math.PI/4, Math.PI/3, Math.PI/2, 3*Math.PI/2})
    public void testPiValues(double x){
        assertEquals(Math.cos(x)/Math.sin(x), cot.calculateCot(x, accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI/6, -Math.PI/4,-Math.PI/3 -Math.PI/2, -3*Math.PI/2})
    public void testNegativePi(double x){
        assertEquals(Math.cos(x)/Math.sin(x), cot.calculateCot(x, accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, -Math.PI,2*Math.PI, -2*Math.PI, 0})
    public void testInvalidValues(double x){
        assertEquals(Double.NaN, cot.calculateCot(x, accuracy), eps);
    }
}