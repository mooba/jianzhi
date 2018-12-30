package jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class MinNumberFromArray {
    public String PrintMinNumber(int [] numbers) { // 使用比较器的方法
        if (numbers.length == 0)
            return "";

        Integer[] integers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integers[i] = Integer.valueOf(numbers[i]);
        }

        Arrays.sort(integers, new Cmp());

        StringBuilder sb = new StringBuilder("");
        for (int item: integers)
            sb.append(item);

        return sb.toString();
    }

    class Cmp implements Comparator<Integer> {
        public int compare(Integer num1, Integer num2) {
            String str1 = num1 + "" + num2;
            String str2 = num2 + "" + num1;
            return str1.compareTo(str2);
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        MinNumberFromArray solution = new MinNumberFromArray();
        System.out.println(solution.PrintMinNumber(array));
        
    }
}

