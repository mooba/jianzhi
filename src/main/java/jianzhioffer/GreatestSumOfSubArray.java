package jianzhioffer;

/**
 * 连续子数组的最大和
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和
 */

public class GreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if (len == 0)
            return 0;

        int maxSum = array[0];
        int curSum = 0;
        for (int i = 0; i < len; i ++) {
            if (curSum < 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if (curSum > maxSum)
                maxSum = curSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}