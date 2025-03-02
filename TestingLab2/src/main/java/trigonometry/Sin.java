package trigonometry;

public class Sin {

    public static double calculateSin(double x, int n){
        double res = 0;
        for(int i=0; i<n; i++){
            double memberTaylorSequence = Math.pow(-1, i)*Math.pow(x, 2*i + 1)/factorial(2*i + 1);
            res += memberTaylorSequence;
        }
        return res;
    }

    public static double factorial(int num){
        if(num ==0 || num == 1){
            return 1;
        }

        double fact = 1.0;
        for(int i = 2; i <= num; i++){
            fact *= i;
        }
        return fact;
    }
}
