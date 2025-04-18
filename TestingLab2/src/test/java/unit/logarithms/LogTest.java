package unit.logarithms;

import function.CsvExporter;
import logarithms.Ln;
import logarithms.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    private static Ln ln;
    private static Log log2;
    private static Log log10;
    private static Log log3;
    double eps = 1e-8;
    double accuracy = 1e-10;
    private final CsvExporter csvLog2Exporter = new CsvExporter(log2::calculateLog);
    private final CsvExporter csvLog3Exporter = new CsvExporter(log3::calculateLog);
    private final CsvExporter csvLog10Exporter = new CsvExporter(log10::calculateLog);

    @BeforeAll
    public static void initializeLogarithms(){
        ln = new Ln();
        log2 = new Log(ln, 2);
        log3 = new Log(ln,3);
        log10 = new Log(ln,10);
    }

    @Test
    public void testAndSaveLogResults(){
        for(double x = 0.1; x <= 10.0; x += 0.1){
            double expectedLog2 = Math.log(x)/Math.log(2);
            double actualLog2 = log2.calculateLog(x, accuracy);
            assertEquals(expectedLog2, actualLog2, eps);

            double expectedLog3 = Math.log(x)/Math.log(3);
            double actualLog3 = log3.calculateLog(x, accuracy);
            assertEquals(expectedLog3, actualLog3, eps);

            double expectedLog10 = Math.log10(x);
            double actualLog10 = log10.calculateLog(x, accuracy);
            assertEquals(expectedLog10, actualLog10, eps);
        }

        csvLog2Exporter.testAndExportCsv(0.1, 10.0, 0.1, "log2_result.csv", eps);
        csvLog3Exporter.testAndExportCsv(0.1, 10.0, 0.1, "log3_result.csv", eps);
        csvLog10Exporter.testAndExportCsv(0.1, 10.0, 0.1, "log10_result.csv", eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1,2,4,8,16,32,50, 100})
    public void testLog2(double x){
        double actual = log2.calculateLog(x, accuracy);
        assertEquals(Math.log(x)/Math.log(2), actual, eps);
    }


    @ParameterizedTest
    @ValueSource(doubles = {1, 3, 9, 27, 81, 100})
    public void testLog3(double x){
        double actual = log3.calculateLog(x, accuracy);
        assertEquals(Math.log(x)/Math.log(3), actual, eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 10, 100, 1000, 10000, 20})
    public void testLog10(double x){
        double actual = log10.calculateLog(x, accuracy);
        assertEquals(Math.log10(x), actual, eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -2, -5, -10, -100})
    public void testInvalidValues(double x){
        assertEquals(Math.log(x)/Math.log(2), log2.calculateLog(x, accuracy));
        assertEquals(Math.log(x)/Math.log(3), log3.calculateLog(x, accuracy));
        assertEquals(Math.log10(x), log10.calculateLog(x, accuracy));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -5, -10})
    public void testBases(int base){
        Log invalidLog = new Log(ln,base);
        assertTrue(Double.isNaN(invalidLog.calculateLog(10, accuracy)));
    }
}