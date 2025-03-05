package function;

import trigonometry.*;

public class TrigonometricFunction {
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Cosec cosec;

    public TrigonometricFunction(Cos cos, Tan tan, Cot cot, Cosec cosec){
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.cosec = cosec;
    }

    public double calculateTrgFunc(double x, double eps){
        return (Math.pow((cos.calculateCos(x, eps)* tan.calculateTan(x, eps))*(Math.pow(cot.calculateCot(x, eps), 2)),3)
                - (cot.calculateCot(x, eps) * cosec.calculateCosec(x, eps)))/(cos.calculateCos(x, eps) + cot.calculateCot(x, eps));
    }

}
