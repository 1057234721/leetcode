package tree;//给定一个二叉树，返回它的中序 遍历。
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 641 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import commont.TreeNode;

import java.util.ArrayList;
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
 *[94]Binary Tree Inorder Traversal
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class BinaryTreeInorderTraversal{
//    public List<Integer> inorderTraversal(TreeNode root) {
//        //递归遍历二叉树
//        List<Integer> list = new ArrayList<Integer>();
//        dfs(root,list);
//        return list;
//    }
//    private void dfs(TreeNode root,List<Integer> list ){
//        if(root == null){
//            return;
//        }
//        dfs(root.left,list);
//        list.add(root.val);
//        dfs(root.right,list);
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
     //前序遍历用queue，中后续用stack，前序是bfs，中后序是dfs
        //1 遍历所有节点，不为空则入栈，后续遍历该结点下的左节点，为空则出栈
        //2 记录出栈元素值
        //3 将右节点作为根，重复1
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        while(!stack.empty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
