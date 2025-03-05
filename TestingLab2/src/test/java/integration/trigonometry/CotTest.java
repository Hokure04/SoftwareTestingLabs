package integration.trigonometry;

import org.junit.jupiter.api.Test;
import trigonometry.Cos;
import trigonometry.Cot;
import trigonometry.Sin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CotTest {

    @Test
    public void testCalculateCot(){
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);

        when(sinMock.calculateSin(1.0, 0.00001)).thenReturn(0.8415);
        when(cosMock.calculateCos(1.0, 0.00001)).thenReturn(0.5403);

        Cot cot = new Cot(sinMock, cosMock);

        double result = cot.calculateCot(1.0, 0.00001);
        assertEquals(0.5403/0.8415, result, 0.0001);

        verify(sinMock, times(1)).calculateSin(1.0, 0.00001);
        verify(cosMock, times(1)).calculateCos(1.0, 0.00001);
    }

    @Test
    public void testCalculateCot_NaN(){
        Sin sinMock = mock(Sin.class);
        Cos cosMock = mock(Cos.class);

        when(sinMock.calculateSin(Math.PI, 0.00001)).thenReturn(0.0);
        when(cosMock.calculateCos(Math.PI, 0.00001)).thenReturn(-1.0);
        Cot cot = new Cot(sinMock, cosMock);

        double result = cot.calculateCot(Math.PI, 0.00001);
        assertTrue(Double.isNaN(result));

        verify(sinMock, times(1)).calculateSin(Math.PI, 0.00001);
        verify(cosMock, times(1)).calculateCos(Math.PI, 0.00001);
    }
}
