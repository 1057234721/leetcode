package tree;//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 684 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import commont.TreeNode;

import java.util.Map;

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
 *[104]Maximum Depth of Binary Tree
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class MaximumDepthOfBinaryTree {
//    //层序遍历
//    private int maxLevel = 0;
//    public int maxDepth(TreeNode root) {
//        if(root== null){
//            return 0;
//        }
//        bfs(root,0);
//      return maxLevel +1;
//    }
//    private void bfs(TreeNode root,int level){
//        if(root == null){
//            return;
//        }
//        maxLevel = Math.max(level,maxLevel);
//        bfs(root.left,level+1);
//        bfs(root.right,level+1);
//    }
     //max(l,r)+1
        public int maxDepth(TreeNode root) {
      return recursion(root) ;
    }
    private int recursion(TreeNode root){
            if(root == null){
                return 0;
            }
        return Math.max(recursion(root.left),recursion(root.right)) +1;
    }
//    public class Solution {
//        public int maxDepth(TreeNode root) {
//            return root==null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
//        }
//    }


}
//leetcode submit region end(Prohibit modification and deletion)
