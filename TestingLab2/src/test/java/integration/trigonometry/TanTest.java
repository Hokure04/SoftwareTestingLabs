package integration.trigonometry;

import org.junit.jupiter.api.Test;
import trigonometry.Cos;
import trigonometry.Sin;
import trigonometry.Tan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TanTest {

    @Test
    public void testCalculateTan(){
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);

        when(sinMock.calculateSin(1.0, 0.0001)).thenReturn(0.8415);
        when(cosMock.calculateCos(1.0, 0.0001)).thenReturn(0.5403);

        Tan tan = new Tan(sinMock, cosMock);

        double result = tan.calculateTan(1.0, 0.0001);
        assertEquals(0.8415/0.5403, result, 0.0001);

        verify(sinMock, times(1)).calculateSin(1.0, 0.0001);
        verify(cosMock, times(1)).calculateCos(1.0, 0.0001);
    }

    @Test
    public void testCalculate_NaN(){
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);

        when(sinMock.calculateSin(Math.PI/2, 0.00001)).thenReturn(1.0);
        when(cosMock.calculateCos(Math.PI/2, 0.00001)).thenReturn(1.0);

        Tan tan = new Tan(sinMock, cosMock);
        double result = tan.calculateTan(Math.PI/2, 0.0001);
        assertTrue(Double.isNaN(result));

        verify(sinMock, times(1)).calculateSin(Math.PI/2, 0.0001);
        verify(cosMock, times(1)).calculateCos(Math.PI/2, 0.0001);
    }
}
