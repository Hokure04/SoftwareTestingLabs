package trigonometry;

public class Cot{
    private final Sin sin;
    private final Cos cos;

    public Cot(Sin sin, Cos cos){
        this.sin = sin;
        this.cos = cos;
    }

    public double calculateCot(double x, double eps){
        double sinX = sin.calculateSin(x, eps);
        double cosX = cos.calculateCos(x, eps);

        if(sinX == 0 || x % Math.PI == 0){
            return Double.NaN;
        }

        return cosX/sinX;
    }
}
