package tree;//给定一个二叉树，返回它的 前序 遍历。
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 352 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }+++++
 *
 * }
 */
/**
 * Created by IntelliJ IDEA.
 *[144]Binary Tree Preorder Traversal
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class BinaryTreePreOrderTraversal{
    public List<Integer> preorderTraversal(TreeNode root) {
       //前序遍历 根左右，优先入栈根节点，在遍历，依次入栈右节点，左节点即可
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        stack.push(root);
        while (!stack.empty() && root!=null){
            root = stack.pop();
            list.add(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
