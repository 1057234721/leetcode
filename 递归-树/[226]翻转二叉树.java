//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 550 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution {
//    public TreeNode invertTree(TreeNode root) {
//        //遍历的时候交换左右节点即可
//        recursion(root);
//        return root;
//
//    }
//   private void recursion(TreeNode root){
//        if(root == null){
//            return;
//        }
//       TreeNode temp = root.left;
//        root.left = root.right;
//       root.right = temp;
//       recursion(root.left);
//       recursion(root.right);
//   }
public TreeNode invertTree(TreeNode root) {
    //遍历的时候交换左右节点即可
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.empty() ){
        TreeNode node =  stack.pop();
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
         if(node.left!= null){
             stack.push(node.left);
         }
         if(node.right!= null){
             stack.push(node.right);
         }
    }
    return root;

}


}
//leetcode submit region end(Prohibit modification and deletion)
