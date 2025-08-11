package com.liang.springcore.recursive;

public class PowCal {
    public double myPow(double x, int n) {
        double epsilon = 1e-9;
        if (n == 0) {
            return 1;
        }
        if (Math.abs(x-1) <epsilon) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            double res = binaryPow(x, Integer.MAX_VALUE);
            return 1/(res * x);
        }

        if (n < 0) {
            return 1/binaryPow(x, -n);
        }else  {
            return binaryPow(x, n);
        }
    }
    private double binaryPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = binaryPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
