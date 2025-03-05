package function;

import java.util.function.Function;

public class MainFunction {
    private LogarithmFunction logarithmFunc;
    private TrigonometricFunction trigonometricFunc;

    public MainFunction(LogarithmFunction logarithmFunc, TrigonometricFunction trigonometricFunc){
        this.logarithmFunc = logarithmFunc;
        this.trigonometricFunc = trigonometricFunc;
    }

    public double calculateFunction(double x, double accuracy){
        if(x > 0){
            return logarithmFunc.calculateLogFunc(x, accuracy);
        }else{
            return trigonometricFunc.calculateTrgFunc(x, accuracy);
        }
    }
}
