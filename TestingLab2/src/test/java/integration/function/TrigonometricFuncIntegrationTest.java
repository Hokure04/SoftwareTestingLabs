package integration.function;

import function.TrigonometricFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Cos;
import trigonometry.Cosec;
import trigonometry.Cot;
import trigonometry.Tan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigonometricFuncIntegrationTest {
    public double accuracy = 1e-10;
    private Cos cosMock;
    private Tan tanMock;
    private Cot cotMock;
    private Cosec cosecMock;
    private TrigonometricFunction trigonometricFunc;

    @BeforeEach
    public void initializeStubs(){
        cosMock = mock(Cos.class);
        tanMock = mock(Tan.class);
        cotMock = mock(Cot.class);
        cosecMock = mock(Cosec.class);

        when(cosMock.calculateCos(2.0, accuracy)).thenReturn(-0.416146836547);
        when(cosMock.calculateCos(-1.0, accuracy)).thenReturn(0.540302305868);
        when(cosMock.calculateCos(-5.0, accuracy)).thenReturn(0.283662185463);

        when(tanMock.calculateTan(2.0, accuracy)).thenReturn(-2.18503986326);
        when(tanMock.calculateTan(-1.0, accuracy)).thenReturn(-1.55740772465);
        when(tanMock.calculateTan(-5.0, accuracy)).thenReturn(3.38051500625);

        when(cotMock.calculateCot(2.0, accuracy)).thenReturn(-0.45765755436);
        when(cotMock.calculateCot(-1.0, accuracy)).thenReturn(-0.642092615934);
        when(cotMock.calculateCot(-5.0, accuracy)).thenReturn(0.295812915533);

        when(cosecMock.calculateCosec(2.0, accuracy)).thenReturn(1.09975017029);
        when(cosecMock.calculateCosec(-1.0, accuracy)).thenReturn(-1.18839510578);
        when(cosMock.calculateCos(-5.0, accuracy)).thenReturn(1.04283521277);

        trigonometricFunc = new TrigonometricFunction(cosMock, tanMock, cotMock, cosecMock);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.0, -1.0, -5.0})
    public void testTrgFunc(double x){
        double expected = (Math.pow((cosMock.calculateCos(x, accuracy) * tanMock.calculateTan(x, accuracy))
                * (Math.pow(cotMock.calculateCot(x, accuracy), 2)), 3)
                - (cotMock.calculateCot(x, accuracy) * cosecMock.calculateCosec(x, accuracy)))
                / (cosMock.calculateCos(x, accuracy) + cotMock.calculateCot(x, accuracy));

        double actual = trigonometricFunc.calculateTrgFunc(x, accuracy);

        assertEquals(expected, actual, accuracy);
    }
}
