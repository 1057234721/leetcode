package offer;
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。
//
// 例如，
//
// [2,3,4] 的中位数是 3
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
// 设计一个支持以下两种操作的数据结构：
//
//
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。
// double findMedian() - 返回目前所有元素的中位数。
//
//
// 示例 1：
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
//
//
// 示例 2：
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000]
//
//
//
// 限制：
//
//
// 最多会对 addNum、findMedian 进行 50000 次调用。
//
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/
// Related Topics 堆 设计
// 👍 82 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201030
 * To change this template use File | Settings | File Templates.
 */
public class Offer41MedianFinder {

    /**
     * 中位数右半部分
     */
    private PriorityQueue<Integer> minHeap;

    /**
     * 中位数左半部分
     */
    private PriorityQueue<Integer>  maxHeap;

    /** initialize your data structure here. */
    public Offer41MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

    }

    public void addNum(int num) {
        //需要向任一队列加入元素时，则先将该元素加入另一堆，并在该堆弹出最值加入该队列
        if (maxHeap.size()==minHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
        double result = 0;
        if (maxHeap.size()==minHeap.size()){
            result = (maxHeap.peek()+minHeap.peek())/2.0;
        }else {
            result = maxHeap.peek();
        }
        return result;
    }
}
