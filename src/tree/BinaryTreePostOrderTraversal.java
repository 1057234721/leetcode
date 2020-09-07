package tree;//给定一个二叉树，返回它的 后序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 383 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import commont.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Created by IntelliJ IDEA.
 *[145]Binary Tree Postorder Traversal
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class BinaryTreePostOrderTraversal     {
    public List<Integer> postorderTraversal(TreeNode root) {
        //前序遍历根左右，翻转一次右左根，子节点互换，左右根即为后续遍历
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        stack.push(root);
        while (root!= null && !stack.empty()){
            root = stack.pop();
            //此处翻转
            list.addFirst(root.val);
            //交换左右节点顺序
            if(root.left != null){
                stack.push(root.left);
            }
            if(root.right != null){
                stack.push(root.right);
            }
        }
        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
