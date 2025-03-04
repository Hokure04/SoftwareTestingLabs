package function;

import logarithms.Ln;
import logarithms.Log;

public class LogarithmFunction {
    private Ln ln;
    private Log log2;
    private Log log10;

    public LogarithmFunction(Ln ln, Log log2, Log log10){
        this.ln = ln;
        this.log2 = log2;
        this.log10 = log10;
    }

    public double calculateLogFunc(double x, double accuracy){
        return Math.pow((Math.pow(Math.pow(log10.calculateLog(x, accuracy), 3), 3)/ log10.calculateLog(x, accuracy))
                - Math.pow((Math.pow(ln.calculateLn(x,accuracy), 3) * log2.calculateLog(x, accuracy)), 3), 3);
    }

    /*public static void main(String[] args) {
        double accuracy = 1e-10;
        Ln ln = new Ln();
        Log log2 = new Log(ln, 2);
        Log log10 = new Log(ln, 10);

        LogarithmFunction logarithmFunction = new LogarithmFunction(ln, log2, log10);

        double[] testValues = {0.2, 0.7,1.5, 2, 2.5, 2.6, 3, 4, 5, 6, 7, 10, 20};


        for(double x : testValues){
            double result = logarithmFunction.calculateLogFunc(x, accuracy);
            System.out.println("logFunction " + x + " = " + result);
        }
    }*/
}
