package unit.trigonometry;

import function.CsvExporter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cos;
import trigonometry.Sin;

import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CosTest {
    double accuracy = 1e-10;
    double eps = 1e-8;
    private Sin sin = new Sin();
    private Cos cos = new Cos(sin);
    private CsvExporter csvExporter = new CsvExporter(cos::calculateCos);

    @Test
    public void testAndSaveCosResults(){
        for (double x = 0; x <= 2*Math.PI; x += 0.1) {
            double expected = Math.cos(x);
            double actual = cos.calculateCos(x, accuracy);

            assertEquals(expected, actual, eps, "Ошибка при вычислении cos(" + x + ")");

        }
        csvExporter.testAndExportCsv(0, 2*Math.PI, 0.1,"cos_result.csv", eps);
    }

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