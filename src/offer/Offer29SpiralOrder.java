package offer;
// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 👍 152 👎 0

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20201119 To change this template use File | Settings | File Templates.
 */
public class Offer29SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length ==0){
            return new int[0];
        }
        //界定上下左右四个顶点
        int left = 0;
        int right =matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int x = 0;
        int[] result = new int[(right+1)*(bottom+1)];
        //顺时针left->right, top->bottom,right->left,bottom->top
        while(true){
            //left->right
            for (int i=left;i<=right;i++){
                result[x++] = matrix[top][i];
                System.out.println(matrix[top][i]);
            }
            if (++top>bottom){
                break;
            }
            //top->bottom
            for (int i=top;i<=bottom;i++){
                result[x++] = matrix[i][right];
                System.out.println(matrix[i][right]);
            }
            if (--right<left){
                break;
            }
            //right->left
            for (int i=right;i>=left;i--){
                result[x++] = matrix[bottom][i];
                System.out.println(matrix[bottom][i]);
            }
            if (--bottom<top){
                break;
            }
            //bottom->top
            for (int i=bottom;i>=top;i--){
                result[x++] = matrix[i][left];
                System.out.println(matrix[i][left]);
            }
            if (++left>right){
                break;
            }
        }
        return result;

    }

  public static void main(String[] args) {
      int [][] arr=new int[][]{{7,9,6}};
      spiralOrder(arr);
  }
}
