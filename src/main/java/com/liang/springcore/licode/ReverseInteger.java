package com.liang.springcore.licode;

/****
 * Created by liliang on 5/22/25.
 ****/
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        int x = 123;
        int res = r.reverse(x);
        assert res == 321;
        x=-123;
        res = r.reverse(x);
        assert res == -321;
        x = 0;
        res = r.reverse(x);
        assert res == 0;
        x= 100;
        res = r.reverse(x);
        assert res == 1;
        x= Integer.MAX_VALUE;
        res = r.reverse(x);
    }
    public int reverse(int x) {
        //

        boolean negative = false;
        if (x < 0) {
            negative = true;
        }

        String s = Integer.toString(x);

        if (negative) {
            s = s.substring(1);
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        if (negative) {
            try {
                result = (-1) * result;
            } catch (Exception e) {
                result = 0;
            }


        }
        return result;
    }
}
