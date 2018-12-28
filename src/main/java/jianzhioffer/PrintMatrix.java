package jianzhioffer;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int rowNum = matrix.length;
        if (rowNum == 0) return null;
        int colNum = matrix[0].length;

        int start = 0;
        while ((rowNum > start * 2) && (colNum > start * 2)) {
            arrayList = getNumberInCircle(matrix, rowNum, colNum,  start, arrayList); 
            start++;
        }

        return arrayList;
    }

    public ArrayList<Integer> getNumberInCircle(int[][] matrix, int rowNum, int colNum, int start, ArrayList<Integer> arrayList) {
        int endX = colNum - start - 1;
        int endY = rowNum - start - 1;

        // 从左到右
        for (int i = start; i <= endX; i ++) {
            arrayList.add(matrix[start][i]);
        }

        // 从上到下
        if (start + 1 <= endY ) {
            for (int i = start + 1; i <= endY; i++) {
                arrayList.add(matrix[i][endX]);
            }
        }
        
        // 从右到左
        if (endX - 1 >= start && start != endY) {
            for (int i = endX - 1; i >= start; i--) {
                arrayList.add(matrix[endY][i]);
            }
        } 
        
        // 从下到上
        if (endY - 1 > start && start != endX) {
            for (int i = endY - 1; i > start; i--) {
                arrayList.add(matrix[i][start]);
            }
        }

        return arrayList;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        
        PrintMatrix printMatrix = new PrintMatrix();
        System.out.println(printMatrix.printMatrix(matrix));
    }
}