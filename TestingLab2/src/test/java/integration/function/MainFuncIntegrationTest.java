package integration.function;

import function.LogarithmFunction;
import function.MainFunction;
import function.TrigonometricFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MainFuncIntegrationTest {
    private double accuracy = 1e-10;
    private LogarithmFunction logarithmFuncMock;
    private TrigonometricFunction trigonometricFuncMock;
    private MainFunction mainFunction;

    @BeforeEach
    public void initializeStubs() {
        logarithmFuncMock = mock(LogarithmFunction.class);
        trigonometricFuncMock = mock(TrigonometricFunction.class);

        when(logarithmFuncMock.calculateLogFunc(2.0, accuracy)).thenReturn(5.0);
        when(trigonometricFuncMock.calculateTrgFunc(-3.0, accuracy)).thenReturn(7.0);

        mainFunction = new MainFunction(logarithmFuncMock, trigonometricFuncMock);
    }

    @Test
    public void testMainFunction_Logarithmic() {
        double x = 2.0;
        double expected = 5.0;
        double actual = mainFunction.calculateFunction(x, accuracy);

        assertEquals(expected, actual, 1e-8);

        verify(logarithmFuncMock, times(1)).calculateLogFunc(x, accuracy);
        verify(trigonometricFuncMock, times(0)).calculateTrgFunc(x, accuracy);
    }

    @Test
    public void testMainFunction_Trigonometric(){
        double x = -3.0;
        double expected = 7.0;
        double actual = mainFunction.calculateFunction(x, accuracy);

        assertEquals(expected, actual, accuracy);

        verify(trigonometricFuncMock, times(1)).calculateTrgFunc(x, accuracy);
        verify(logarithmFuncMock, times(0)).calculateLogFunc(x, accuracy);
    }
}
   