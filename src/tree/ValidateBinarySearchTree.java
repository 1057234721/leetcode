package tree;//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 736 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import commont.TreeNode;

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
 * [98]Validate Binary Search Tree
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class ValidateBinarySearchTree {
//    private TreeNode pre;
//    public boolean isValidBST(TreeNode root) {
//        //中序遍历递增
//        return dfs(root);
//    }
//    //中序遍歷
//    private Boolean dfs(TreeNode root){
//        //这是前序遍历了
//
////        if(root == null){
////            return true;
////        }
////        if(pre != null && root.val<=pre.val){
////            return false;
////        }
////        pre = root;
////        return  dfs(root.left) &&   dfs(root.right);
////    }
//        //中序遍历
//        if(root == null){
//            return true;
//        }
//       boolean preResult = dfs(root.left);
//        if(pre != null && root.val<=pre.val){
//            return false;
//        }
//        pre = root;
//        boolean nextResult  = dfs(root.right);
//
//        return  nextResult &&  preResult ;
//    }
    //搜索树，根节点的范围应当落在左右节点区间范围内，（min，max），搜索左子树时，根为左子树的上限，搜索右子树时，根为右子树下限
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    //min,max 根节点落入的区间上下界
    private Boolean dfs(TreeNode root,long min,long max){
        if(root == null ){
            return true;
        }
        //根节点不在区间内返回false
        if(root.val <= min || root.val >= max){
            return false;
        }
        //根子树不在区间内返回false
        //左子树的上限是根，右子树下限还是根
        return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
