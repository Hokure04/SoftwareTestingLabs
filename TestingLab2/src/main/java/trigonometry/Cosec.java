package trigonometry;

public class Cosec {

    public static double calculateCosec(double x, int n){
        double sinX = Sin.calculateSin(x, n);

        if(Math.abs(sinX) < 1e-10){
            return Double.NaN;
        }

        return 1.0/sinX;
    }

}
