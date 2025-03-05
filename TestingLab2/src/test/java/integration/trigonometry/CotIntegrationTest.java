package integration.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cos;
import trigonometry.Cot;
import trigonometry.Sin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CotIntegrationTest {
    private double accuracy = 1e-10;
    private Sin sinMock;
    private Cos cosMock;
    private Cot cot;

    @BeforeEach
    public void initializeStub(){
        sinMock = mock(Sin.class);
        cosMock = mock(Cos.class);

        when(sinMock.calculateSin(-3*Math.PI/2, accuracy)).thenReturn(1.0);
        when(sinMock.calculateSin(-Math.PI, accuracy)).thenReturn(0.0);
        when(sinMock.calculateSin(-Math.PI/2, accuracy)).thenReturn(-1.0);
        when(sinMock.calculateSin(0.0, accuracy)).thenReturn(0.0);
        when(sinMock.calculateSin(Math.PI/2, accuracy)).thenReturn(1.0);
        when(sinMock.calculateSin(Math.PI, accuracy)).thenReturn(0.0);
        when(sinMock.calculateSin(3*Math.PI/2, accuracy)).thenReturn(-1.0);

        when(cosMock.calculateCos(-3*Math.PI/2, accuracy)).thenReturn(0.0);
        when(cosMock.calculateCos(-Math.PI, accuracy)).thenReturn(-1.0);
        when(cosMock.calculateCos(-Math.PI/2,accuracy)).thenReturn(0.0);
        when(cosMock.calculateCos(0.0, accuracy)).thenReturn(1.0);
        when(cosMock.calculateCos(Math.PI/2,accuracy)).thenReturn(0.0);
        when(cosMock.calculateCos(Math.PI, accuracy)).thenReturn(-1.0);
        when(cosMock.calculateCos(3*Math.PI/2, accuracy)).thenReturn(0.0);

        cot = new Cot(sinMock, cosMock);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-3*Math.PI/2, -Math.PI, -Math.PI/2, 0.0, Math.PI/2, Math.PI, 3*Math.PI/2})
    public void testCotMockValues(double x){
        double expected = 1/Math.tan(x);
        double actual = cot.calculateCot(x, accuracy);

        if(x % Math.PI == 0){
            assertTrue(Double.isNaN(actual));
        }else{
            assertEquals(expected,actual, 1e-8);
        }

        verify(sinMock, times(1)).calculateSin(x, accuracy);
        verify(cosMock, times(1)).calculateCos(x, accuracy);
    }
}
