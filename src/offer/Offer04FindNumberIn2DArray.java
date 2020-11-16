package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20201021 To change this template use File | Settings | File Templates.
 *     在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *     <p>
 *     <p>示例:
 *     <p>现有矩阵 matrix 如下：
 *     [
 *     [1, 4, 7, 11, 15],
 *     [2, 5, 8, 12, 19],
 *     [3, 6, 9, 16, 22],
 *     [10, 13, 14, 17, 24],
 *     [18, 21,23, 26, 30]
 *     ]
 *     给定 target = 5，返回 true。
 *     <p>给定 target = 20，返回 false。
 *     <p>
 *     <p>限制：
 *     <p>0 <= n <= 1000
 *     <p>0 <= m <= 1000
 */
public class Offer04FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
    /**
     * 右上角开始，小于目标值下移一行，大于目标值，左移一列
     *
     * <p>0 <= m <= 1000
     */
    if(matrix== null || matrix.length==0 ||matrix[0].length==0){
        return false;
    }
    int col = matrix[0].length-1;
    int row = 0;
    while (col>=0 && row < matrix.length){
        if(matrix[row][col] == target){
            return true;
        }else  if(matrix[row][col] >=target){
            col --;
        }else{
            row++;
        }
    }

        return false;

    }
}
