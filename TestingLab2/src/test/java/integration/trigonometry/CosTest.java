package integration.trigonometry;

import org.junit.jupiter.api.Test;
import trigonometry.Cos;
import trigonometry.Sin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CosTest {

    @Test
    public void testCalculateCos(){
        Sin sinMock = mock(Sin.class);
        when(sinMock.calculateSin(Math.PI/2 - 1.0, 0.0001)).thenReturn(0.5403);
        Cos cos = new Cos(sinMock);
        double result = cos.calculateCos(1.0, 0.0001);
        assertEquals(0.5403, result, 0.0001);
        verify(sinMock, times(1)).calculateSin(Math.PI / 2 - 1.0, 0.0001);

    }
}
