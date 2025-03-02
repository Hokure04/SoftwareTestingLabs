package trigonometry;

public class Tan {

    public static double calculateTan(double x, int n){
        double sinX = Sin.calculateSin(x, n);
        double cosX = Cos.calculateCos(x, n);

        if(Math.abs(cosX) < 1e-10 || Math.abs((x % Math.PI) - Math.PI/2) < 1e-10){
            return Double.NaN;
        }

        return sinX/cosX;
    }
}
