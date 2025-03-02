package function;

import trigonometry.Cos;
import trigonometry.Cosec;
import trigonometry.Cot;
import trigonometry.Tan;

public class TrigonometryFunction {

    public double calculateTrigonometryFunction(double x, int n){
         double cos = Cos.calculateCos(x, n);
         double tan = Tan.calculateTan(x, n);
         double cot = Cot.calculateCot(x, n);
         double cosec = Cosec.calculateCosec(x, n);
         double res = (Math.pow(((cos*tan)*Math.pow(cot, 2)), 3) - (cot*cosec))/(cos + cot);
         if(Double.isNaN(res)) throw new ArithmeticException("Недопустимое значение x");
         return res;
    }
}
