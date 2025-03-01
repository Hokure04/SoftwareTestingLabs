package logarithms;

import static java.lang.Double.NaN;

public class Ln {

    public static double calculateNaturalLogarithm(double x, int n) {
        if(x == -1){
            return Double.NEGATIVE_INFINITY;
        }

        if(x < -1){
            return Double.NaN;
        }

        if(x > 1){
            return -calculateNaturalLogarithm(-x/(1+x), n);
        }



        double y = x/(2+x);
        double sum = 0;
        double term = y;

        for(int i = 0; i <= n; i++){
            sum += term/(2*i + 1);
            term *= y*y;
        }
        return 2*sum;
    }
}
