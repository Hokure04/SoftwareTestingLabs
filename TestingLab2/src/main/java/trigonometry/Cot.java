package trigonometry;

public class Cot {

    public static double calculateCot(double x ,int n){
        double sinX = Sin.calculateSin(x, n);
        double cosX = Cos.calculateCos(x, n);

        if(sinX == 0 || x % Math.PI == 0){
            return Double.NaN;
        }

        return cosX/sinX;
    }
}
