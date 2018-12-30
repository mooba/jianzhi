package jianzhioffer;

import java.util.ArrayList;

/**
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0 ;
        ArrayList<Integer> uglyNum = new ArrayList<Integer>();
        uglyNum.add(1);
        int m2 = 0, m3 = 0, m5 = 0;
        int uglyLen = 1;
        while (uglyLen < index) {
            int curMax = uglyNum.get(uglyNum.size() - 1);
            while (uglyNum.get(m2) * 2 <= curMax)
                m2++;
            while (uglyNum.get(m3) * 3 <= curMax)
                m3++;
            while (uglyNum.get(m5) * 5 <= curMax)
                m5++;

            int min = minNum(uglyNum.get(m2) * 2, uglyNum.get(m3) * 3, uglyNum.get(m5) * 5);
            uglyNum.add(min);
            uglyLen++;
        }

        return uglyNum.get(uglyNum.size() - 1);
    }

    public int minNum(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static void main(String[] args) {
        UglyNumber solution = new UglyNumber();
        System.out.println(solution.GetUglyNumber_Solution(3));;
    }
}