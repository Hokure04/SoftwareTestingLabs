package unit.logarithms;

import function.CsvExporter;
import logarithms.Ln;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {
    double eps = 1e-8;
    double accuracy = 1e-10;
    private final Ln ln = new Ln();
    private final CsvExporter csvExporter = new CsvExporter(ln::calculateLn);

    @Test
    public void testAndSaveLnResults() {
        for (double x = 0.1; x <= 10.0; x += 0.1) {
            double expected = Math.log(x);
            double actual = ln.calculateLn(x, accuracy);

            assertEquals(expected, actual, eps);

        }
        csvExporter.testAndExportCsv(0.1, 10.0, 0.1, "ln_result.csv", eps);
    }


    @Test
    public void testNaturalLogarithmOfOne(){
        double one = 1;
        double expectedRes = Math.log(1);
        double actualRes = ln.calculateLn(one, accuracy);
        assertEquals(expectedRes, actualRes, eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.001, 0.1, 0.2, 0.5, 0.9, -0.001, -0.1, -0.2, -0.5, -0.9})
    public void testValidValues(double x){
        assertEquals(Math.log(x), ln.calculateLn(x,accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, 1.7, 2.0, 5.0, -1.0, -1.7, -2.0, -5.0, Double.NEGATIVE_INFINITY})
    public void testInvalidValues(double x){
        assertEquals(Math.log(x), ln.calculateLn(x,accuracy), eps);
    }

}