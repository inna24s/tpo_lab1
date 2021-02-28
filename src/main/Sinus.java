package main;
public class Sinus {
    public static double sin(double val) {
        double result = 0;
        for(int n = 1; n < 8; n++) {
            result += Math.pow(-1, n-1) * Math.pow(val, 2 * n - 1) / factorial(2 * n - 1);
        }
        return result;
    }

    private static int factorial(int val) {
        if(val <= 1)
            return 1;
        else
            return val * (factorial(val - 1));
    }

}
