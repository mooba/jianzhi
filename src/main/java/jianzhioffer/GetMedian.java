package jianzhioffer;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。 
 */

public class GetMedian {
	private PriorityQueue<Integer> maxHeap_left = new PriorityQueue<Integer>(Collections.reverseOrder());
	private PriorityQueue<Integer> minHeap_right = new PriorityQueue<Integer>();
	private static int cnt = 0;

    public void Insert(Integer num) {
        cnt++;
        if (cnt % 2 == 0) { // 插入第偶数个到最小堆中，然后把最小堆的顶插入到最大堆中，再把最大堆中的顶插入到最小堆中
        	minHeap_right.offer(num);
        	int minHeapTop = minHeap_right.poll();
        	maxHeap_left.offer(minHeapTop);
        	int maxHeapTop = maxHeap_left.poll();
        	minHeap_right.offer(maxHeapTop);
        } else { // 插入第基数个
        	maxHeap_left.offer(num);
        	int maxHeapTop = maxHeap_left.poll();
        	minHeap_right.offer(maxHeapTop);
        	int minHeapTop = minHeap_right.poll();
        	maxHeap_left.offer(minHeapTop);
        }
    }
    

    public Double getMedian() {
        Double retNum;
    	if (cnt % 2 == 0)
        	retNum = (maxHeap_left.peek() + minHeap_right.peek()) / 2.0;
    	else
    		retNum = maxHeap_left.peek() / 1.0;
    	return retNum;
    }
    
    public static void main(String[] args) {
    	GetMedian getMedian = new GetMedian();
    	int[] array = {1,2,3,4,5,9,6,7,5,5,5};
    	for (int item: array) 
    		getMedian.Insert(item);
    	
    	System.out.println(getMedian.getMedian());
	}
}
