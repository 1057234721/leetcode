package offer;
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 233 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201023
 * To change this template use File | Settings | File Templates.
 */
public class Offer07BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return  recursion(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

    }

    private static TreeNode recursion(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {

        if(preStart >preEnd || inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        //中序遍历根节点下标
        int rootNode = map.get(preorder[preStart]);
        //左子树长度
        int d = rootNode - inStart;

        node.left = recursion(preorder,  preStart+1,  preStart+d,  inorder,  inStart,  rootNode-1,  map) ;
        node.right = recursion(preorder,  preStart+d+1,  preEnd,  inorder,  rootNode+1,  inEnd,  map) ;
        return node;
    }
    public static void main(String[] args) {
        //
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        TreeNode node =  buildTree(a,b);
        System.out.println(node);
    }
}
