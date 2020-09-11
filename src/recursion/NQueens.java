package recursion;//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placem
//ent, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as show
//n above.
// 
// Related Topics 回溯算法 
// 👍 600 👎 0
/**
 * Created by IntelliJ IDEA.
 *[51]N-Queens
 * @author : huangdewei
 * Date: 20200911
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        //pie 斜率的唯一值x+y
        //na 泄露的唯一值x-y
        //col列值y
        //设行值为row，每次遍历一行，一行只能放一个皇后，且不再，pie，na，col容器内
        List<List<String>> list = new ArrayList<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        //结果数组，每一行的列下标数组，a[0]=1 表示第0行第一列
        int[] result = new int[n];
        dfs(pies,nas,cols,n,0,result,list);
        return list;
    }

    private static void dfs(Set<Integer> pies, Set<Integer> nas, Set<Integer> cols, int n, int row, int[] result, List<List<String>> list) {
        if(row == n){
            list.add(getBoard(result,n));
            return;
        }
        for (int y=0;y<n;y++){
            int pie = row +y;
            int na = row -y;
            int col = y;
            if(pies.contains(pie)){
                continue;
            }
            if(nas.contains(na)){
                continue;
            }
            if(cols.contains(col)){
                continue;
            }
            result[row]= y;
            pies.add(pie);
            nas.add(na);
            cols.add(col);
            dfs(pies,nas,cols,n,row+1,result,list);
            pies.remove(pie);
            nas.remove(na);
            cols.remove(col);

            result[row]= 0;
        }
    }

    private static List<String> getBoard(int[] result,int n){
        List<String> lists = new ArrayList<>();
        for (int i=0;i<result.length;i++){
            char[] temp = new char[n];
            Arrays.fill(temp, '.');
            temp[result[i]]= 'Q';
            lists.add(new String(temp));
        }
        return lists;
    }

  public static void main(String[] args) {
    //
    System.out.println(solveNQueens(4));
  }
}
//leetcode submit region end(Prohibit modification and deletion)
