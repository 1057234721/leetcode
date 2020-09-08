package tree;
//Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 659 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.HashMap;
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
 * [105]Construct Binary Tree from Preorder and Inorder Traversal
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class ConstructBinaryTreeFromPreOrderAndInOrderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder ) {
        //前序遍历第一个元素为root节点，
        //中序遍历找到root节点下标i,左子树[in_start,i),右子树（i,length-1],左子树长度d = i-in_start+1
        //前序遍历左子树[p_start+1，p_start+d],右子树[p_start+d+1,length-1]
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,preorder.length -1,inorder,0,inorder.length -1,map);

    }
    private static TreeNode dfs(int[] preorder,int preStart,int preEnd,int[] inorder ,int inStart,int inEnd,Map<Integer,Integer>  map){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        //中序遍历root下标
        int rootIndex = map.get(preorder[preStart]);
        //rootIndex到inStart的距离（间隔）
        int d = rootIndex - inStart;
        root.left = dfs(preorder,preStart+1,preStart+d,inorder,inStart,rootIndex-1,map);
        root.right = dfs(preorder,preStart+d+1,preEnd,inorder,rootIndex+1,inEnd,map);
        return root;
    }

  public static void main(String[] args) {
    //
      int[] a = {3,9,20,15,7};
      int[] b = {9,3,15,20,7};
      TreeNode node =  buildTree(a,b);
    System.out.println(node);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
