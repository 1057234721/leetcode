package offer;
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回：
//
// [3,9,20,15,7]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
// Related Topics 树 广度优先搜索
// 👍 50 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201124
 * To change this template use File | Settings | File Templates.
 */
public class Offer32LevelOrder {
    //前序遍历只需队列改成涨，交换左右节点入栈循序即可
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            //如果出栈之前记录了deque的size，就可以从0遍历size，得到分层的二维层级遍历数组
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            if(node.left !=null){
                deque.addLast(node.left );
            }
            if(node.right !=null){
                deque.addLast(node.right );
            }
        }
        int[] result = new int[list.size()];
        for (int i=0;i <list.size();i++){
            result[i] = list.get(i);
        }
        return result;


    }
}
