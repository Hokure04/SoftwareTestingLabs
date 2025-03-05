package unit.function;

import function.CsvExporter;
import function.LogarithmFunction;
import function.MainFunction;
import function.TrigonometricFunction;
import logarithms.Ln;
import logarithms.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainFunctionTest {
    private static final double accuracy = 1e-10;

    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln, 2);
    private final Log log10 = new Log(ln, 10);
    private final LogarithmFunction logarithmFunc = new LogarithmFunction(ln, log2, log10);

    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Tan tan = new Tan(sin, cos);
    private final Cot cot = new Cot(sin, cos);
    private final Cosec cosec = new Cosec(sin);
    private final TrigonometricFunction trigonometricFunc = new TrigonometricFunction(cos, tan, cot, cosec);

    private final MainFunction mainFunc = new MainFunction(logarithmFunc, trigonometricFunc);
    private final CsvExporter csvExporter = new CsvExporter(mainFunc::calculateFunction);

    @Test
    public void testAndSaveTrigFunc(){
        csvExporter.testAndExportCsv(-10.0, -0.1, 0.1, "main_result.csv", accuracy);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.7, 1.5, 2, 2.5, 2.6, 3, 4, 5, 6, 7, 10, 20})
    public void testMainFuncPositive(double x){
        double expected = logarithmFunc.calculateLogFunc(x, accuracy);
        double actual = mainFunc.calculateFunction(x, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.2, -0.7, -1.5, -2, -2.5, -2.6, -3, -4, -5, -6, -7, -10, -20})
    public void testMainFunctionNegative(double x){
        double expected = trigonometricFunc.calculateTrgFunc(x, accuracy);
        double actual = mainFunc.calculateFunction(x, accuracy);
        assertEquals(expected, actual, accuracy);
    }
}
