package jianzhioffer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

public class GetTopK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> retList = new ArrayList<Integer>(k);
        if (input.length < k || k == 0)
            return retList;

        for (int item: input) {
            if (retList.size() < k)
                retList.add(item);
            else {
                int maxIndex = 0;
                int maxInList = retList.get(0);
                for (int i = 0; i < retList.size(); i++) {
                    if (retList.get(i) > maxInList) {
                        maxInList = retList.get(i);
                        maxIndex = i;
                    }
                }

                if (maxInList > item)
                    retList.set(maxIndex, item);
            }
        }        
        return retList;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        GetTopK solution = new GetTopK();
        System.out.println(solution.GetLeastNumbers_Solution(arr, 4));;
    }
}