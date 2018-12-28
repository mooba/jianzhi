package jianzhioffer;

/**
 * 数值的整数次方s
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */

public class PowerOfNumber {
    public static double Power(double base, int exponent) {
        if (base == 0.0) 
        return 0.0;
    
        if (exponent == 0)
            return 1;

        if (exponent < 0)
            return 1/PowerHelper(base, -exponent);
        else
            return PowerHelper(base, exponent);
    }

    public static double PowerHelper(double base, int exponent) {
        if (exponent == 1)
            return base;

        
        if (exponent % 2 == 0) {
            return Power(base, exponent>>1) * Power(base, exponent>>1);
        } else {
            return Power(base, exponent - 1) * base;
        }
    }

    public static void main(String[] args) {
        double ret = PowerOfNumber.Power(5, -2);
        System.out.println(ret); // 0.04
    }
}