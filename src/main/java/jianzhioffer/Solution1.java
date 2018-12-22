package jianzhioffer;

/**
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */

public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int rowNum = array.length;
        int colNum = array[0].length;
        
        if (rowNum <= 0 || colNum <= 0)
            return false;
        
        for (int i = 0, j = colNum - 1; i < rowNum && j >= 0; ) {
            if (target < array[i][j])
                j--;
            else if (target > array[i][j])
                i++;
            else
                return true;
        }

        return false;
    }
}