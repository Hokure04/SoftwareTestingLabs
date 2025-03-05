package integration.logarithms;

import logarithms.Ln;
import logarithms.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LogIntegrationTest {
    private double accuracy = 1e-8;
    private Ln lnMock;
    private Log log;

    @BeforeEach
    public void initializeStub(){
        lnMock = mock(Ln.class);

        when(lnMock.calculateLn(1.0, accuracy)).thenReturn(0.0);
        when(lnMock.calculateLn(2.0, accuracy)).thenReturn(0.693147);
        when(lnMock.calculateLn(3.0, accuracy)).thenReturn(1.09861228867);
        when(lnMock.calculateLn(8.0, accuracy)).thenReturn(2.079441);
        when(lnMock.calculateLn(10.0, accuracy)).thenReturn(2.30258509299);
        when(lnMock.calculateLn(16.0, accuracy)).thenReturn(2.772588);
        when(lnMock.calculateLn(20.0, accuracy)).thenReturn(2.99573227355);

        log = new Log(lnMock, 2);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0,2.0, 3.0, 8.0, 10.0, 16.0, 20.0})
    public void testLogValues(double x){
        double expected = Math.log(x) / Math.log(2.0);
        double actual = log.calculateLog(x, accuracy);

        assertEquals(expected, actual, 1e-5);

        if(x == 2.0){
            verify(lnMock, times(2)).calculateLn(x, accuracy);
        }else{
            verify(lnMock, times(1)).calculateLn(x, accuracy);
        }
    }
}
