package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201028
 * To change this template use File | Settings | File Templates.
 */
public class Offer12Exist {
    public static boolean exist(char[][] board, String word) {
        //遍历二维数组
        for (int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //回溯判断是否属于word
                if( dfs(i,j,board,word,0)){
                    return true;
                }

            }
        }

        return false;


    }
    //level,目标单词下标

    private static boolean dfs(int i, int j, char[][] board, String word, int level) {
        if(level== word.length()){
            return true;
        }
        if(i<0 || i==board.length || j<0 || j==board[0].length || board[i][j] != word.charAt(level) ){
            return false;
        }
        //要做重复标记，先保存board[i][j]，在恢复
        char temp = board[i][j];
        //标记
        board[i][j] = '*';
        //前后左右有一个满足条件即可；
        Boolean result =
                //左
                dfs(i-1, j,  board,  word,  level+1)||
                        //右
                        dfs(i+1, j,  board,  word,  level+1)||
                        //上
                        dfs(i, j-1,  board,  word,  level+1)||
                        //下
                        dfs(i, j+1,  board,  word,  level+1);
        board[i][j] = temp;
        return result;
    }

  public static void main(String[] args) {
    //
      char[][] board = {{'a'}};
      String word = "ab";
    System.out.println(exist(board,word));

  }
}
