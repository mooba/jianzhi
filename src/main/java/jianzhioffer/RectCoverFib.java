package jianzhioffer;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCoverFib {
    public static int RectCover(int target) { // 依旧是斐波那契数列
        if (target <= 0)
            return 0;

        int a = 0, b = 1;
        while (target > 0) {
            int tmp = a + b;
            a = b;
            b = tmp;
            target --;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(RectCoverFib.RectCover(8));;
    }
}