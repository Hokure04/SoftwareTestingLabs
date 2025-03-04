package function;

import trigonometry.*;

public class TrigonometricFunction {
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Cosec cosec;

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


    /*public static void main(String[] args){
        Sin sin = new Sin();
        Cos cos = new Cos(sin);
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Cosec cosec = new Cosec(sin);
        double eps = 1e-10;

        TrigonometricFunction trigonometricFunction = new TrigonometricFunction(cos, tan, cot, cosec);

        double[] testValues = {-0.2, -0.7, -1.5, -2, -2.5, -2.6, -3, -4, -5, -6, -7, -10, -20};

        for(double x : testValues){
            double result = trigonometricFunction.calculateTrgFunc(x, eps);
            System.out.println("trigFunc = " + x + " = " + result);
        }
    }*/
}
