package trigonometry;

public class Cosec{
    private Sin sin;

    public Cosec(Sin sin){
        this.sin = sin;
    }

    public double calculateCosec(double x, double eps){
        double sinX = sin.calculateSin(x, eps);
        if(Math.abs(sinX) < 1e-10){
            return Double.NaN;
        }

        return 1.0/sinX;
    }
}
