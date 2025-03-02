package function;

import logarithms.Ln;
import logarithms.Log;

public class LogFunction {
    private final Log log2;
    private final Log log10;

    public LogFunction(Log log2, Log log10){
        this.log2 = log2;
        this.log10 = log10;
    }

    public double calculateLogFunction(double x, int n){
        double lnPow3 = Ln.calculateNaturalLogarithm(Math.pow(x, 3), n);
        double log2Pow3 = log2.calculateLog(Math.pow(x, 3), n);
        double log10Simple = log10.calculateLog(x, n);
        double log10Pow3 = log10.calculateLog(Math.pow(x, 3), n);

        double res = (log10Pow3/log10Simple) - Math.pow((lnPow3*log2Pow3), 3);
        if(Double.isNaN(res)) throw new ArithmeticException("Недопустимое значение x");
        return res;
    }
}
