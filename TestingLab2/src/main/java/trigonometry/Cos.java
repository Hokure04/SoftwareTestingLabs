package trigonometry;


public class Cos {
    private Sin sin;

    public Cos(Sin sin){
        this.sin = sin;
    }

    public double calculateCos(double x, double eps){
        return sin.calculateSin(Math.PI/ 2 - x, eps);
    }

}
