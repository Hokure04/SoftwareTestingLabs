package function;

public class MainFunction {
    private final LogFunction logFunction;
    private final TrigonometryFunction trigonometryFunction;

    public MainFunction(LogFunction logFunction, TrigonometryFunction trigonometryFunction){
        this.logFunction = logFunction;
        this.trigonometryFunction = trigonometryFunction;
    }

    public double calculateResult(double x, int n){
        if(x > 0){
            return logFunction.calculateLogFunction(x ,n);
        }else{
            return trigonometryFunction.calculateTrigonometryFunction(x, n);
        }
    }
}
