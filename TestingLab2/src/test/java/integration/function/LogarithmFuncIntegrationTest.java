package integration.function;

import function.LogarithmFunction;
import logarithms.Ln;
import logarithms.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LogarithmFuncIntegrationTest {
    private double accuracy = 1e-15;
    private Ln lnMock;
    private Log log2Mock;
    private Log log10Mock;
    private LogarithmFunction logarithmFunction;

    @BeforeEach
    public void initializeMocks(){
        lnMock = mock(Ln.class);
        log2Mock = mock(Log.class);
        log10Mock = mock(Log.class);

        when(lnMock.calculateLn(2.0, accuracy)).thenReturn(0.69314718056);
        when(lnMock.calculateLn(5.0, accuracy)).thenReturn(1.60943791243);
        when(lnMock.calculateLn(3.0, accuracy)).thenReturn(1.09861228867);

        when(log2Mock.calculateLog(2.0, accuracy)).thenReturn(1.0);
        when(log2Mock.calculateLog(5.0, accuracy)).thenReturn(2.32192809489);
        when(log2Mock.calculateLog(3.0, accuracy)).thenReturn(1.58496250072);

        when(log10Mock.calculateLog(2.0, accuracy)).thenReturn(0.301029995664);
        when(log10Mock.calculateLog(5.0, accuracy)).thenReturn(0.698970004336);
        when(log10Mock.calculateLog(3.0, accuracy)).thenReturn(0.47712125472);

        logarithmFunction = new LogarithmFunction(lnMock, log2Mock, log10Mock);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.0,3.0, 5.0})
    public void testLogarithmFunction(double x){
        double expected = Math.pow((Math.pow(Math.pow(log10Mock.calculateLog(x, accuracy), 3), 3) / log10Mock.calculateLog(x, accuracy))
                - Math.pow((Math.pow(lnMock.calculateLn(x, accuracy), 3) * log2Mock.calculateLog(x, accuracy)), 3), 3);

        double actual = logarithmFunction.calculateLogFunc(x, accuracy);
        assertEquals(expected, actual, accuracy);

    }
}
