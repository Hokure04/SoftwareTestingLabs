package logarithms;


public class Log {
    private Ln ln = new Ln();
    private int base;

    public Log(Ln ln, int base){
        this.ln = ln;
        this.base = base;
    }

    public double calculateLog(double x, double eps){
        if (this.base <= 1){
            return Double.NaN;
        }
        return ln.calculateLn(x, eps)/ ln.calculateLn(base, eps);
    }
}
