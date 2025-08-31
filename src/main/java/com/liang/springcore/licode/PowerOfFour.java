package com.liang.springcore.licode;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        if (n ==1) {
            return true;
        }
        if (isPowerOfTwo(n)) {
            int fourRight = n;
            while (fourRight > 0) {
                fourRight = fourRight >> 2;
                if (fourRight == 1) {
                    return true;
                }
            }
            return false;
        } else  {
            return false;
        }
    }
    private boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
