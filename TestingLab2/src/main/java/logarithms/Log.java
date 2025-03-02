package logarithms;

public class Log {
    private int base;

    public Log(int base){
        this.base = base;
    }

    public double calculateLog(double x, int n){
        if(x < 0){
            return Double.NaN;
        }

        if(x == 0){
            return Double.NEGATIVE_INFINITY;
        }

        if(base <= 1){
            return Double.NaN;
        }


        double lnDenominator = Ln.calculateNaturalLogarithm(getBase()-1, n);
        double lnNumerator = Ln.calculateNaturalLogarithm(x-1, n);
        return lnNumerator/lnDenominator;
    }

    public int getBase(){
        return base;
    }
}
