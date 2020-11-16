package offer;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1：
//
// 输入：[3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
// 输入：[2,2,2,0,1]
//输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/
// Related Topics 二分查找
// 👍 168 👎 0
/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201026
 * To change this template use File | Settings | File Templates.
 */
public class Offer11MinArray {
  public int minArray(int[] numbers) {
    // 二分法，如果总间数字和两端数字重复，则可将两端数字靠拢一步。
    int left = 0;
    int right = numbers.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (numbers[mid] < numbers[right]) {
        right = mid;
      } else if (numbers[mid] > numbers[right]) {
        left = mid + 1;
      } else {
        right--;
      }
    }
    return numbers[left];
    }
}
