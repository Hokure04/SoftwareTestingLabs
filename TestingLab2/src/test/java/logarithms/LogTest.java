package logarithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {
    private static Log log2;
    private static Log log10;
    private static Log log3;
    double eps = 0.01;

    @BeforeAll
    public static void initializeLogarithms(){
        log2 = new Log(2);
        log3 = new Log(3);
        log10 = new Log(10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1,2,4,8,16,32,50, 100})
    public void testLog2(double x){
        double actual = log2.calculateLog(x, 1000);
        assertEquals(Math.log(x)/Math.log(2), actual, eps);
    }


    @ParameterizedTest
    @ValueSource(doubles = {1, 3, 9, 27, 81, 100})
    public void testLog3(double x){
        double actual = log3.calculateLog(x, 1000);
        assertEquals(Math.log(x)/Math.log(3), actual, eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 10, 100, 1000, 10000, 20})
    public void testLog10(double x){
        double actual = log10.calculateLog(x, 10000);
        assertEquals(Math.log10(x), actual, eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -2, -5, -10, -100})
    public void testInvalidValues(double x){
        assertEquals(Math.log(x)/Math.log(2), log2.calculateLog(x, 1000));
        assertEquals(Math.log(x)/Math.log(3), log3.calculateLog(x, 1000));
        assertEquals(Math.log10(x), log10.calculateLog(x, 1000));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -5, -10})
    public void testBases(int base){
        Log invalidLog = new Log(base);
        assertTrue(Double.isNaN(invalidLog.calculateLog(10,100)));
    }
}