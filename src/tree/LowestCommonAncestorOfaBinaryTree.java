package tree;//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
//in the tree. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).” 
//
// Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// Example 1: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
//
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant o
//f itself according to the LCA definition.
// 
//
// 
//
// Note: 
//
// 
// All of the nodes' values will be unique. 
// p and q are different and both values will exist in the binary tree. 
// 
// Related Topics 树 
// 👍 727 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;
import common.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

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
 * [236]Lowest Common Ancestor of a Binary Tree
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class LowestCommonAncestorOfaBinaryTree {

        public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return root;
            }
            if(root == p || root ==q){
                return root;
            }
            TreeNode left =  lowestCommonAncestor(root.left,p,q);
            TreeNode right =  lowestCommonAncestor(root.right,p,q);
            //在左右子树，只在左子树，只在右子树
            if(left != null && right != null){
                return root;
            }
            if (left==null){
                return  right;
            }
            if (right==null){
                return  left;
            }
            return root;

    }



//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //找到root到p的路径，找到root到q的路径，转化为两链表的最近公共祖先
//        List<TreeNode> listP = BinaryTreeOnlyPaths(root,p.val);
//        List<TreeNode>  listQ =  BinaryTreeOnlyPaths(root, q.val);
//        int i = 0;
//        TreeNode node = root;
//        while (i< Math.min(listP.size(),listQ.size())){
//           if( listP.get(i).val == listQ.get(i).val){
//               node =  listP.get(i);
//           }else {
//               return node;
//           }
//           i++;
//
//
//        }
//        return node;
//    }
//
//    public static List<TreeNode> BinaryTreeOnlyPaths(TreeNode root, int q) {
//        //是节点q，当前路径末尾添加该节点，当前路径添加到结果
//        //不是节点q，当前路径末尾添加该节点
//        //要清扫当前层状态
//        List<TreeNode>  listTemp = new ArrayList<>();
//        List<TreeNode>  listResult = new ArrayList<>();
//        dfs(root,q,listTemp,listResult);
//        return listResult;
//
//    }
//
//    private static void dfs(TreeNode root, int q, List<TreeNode> listTemp, List<TreeNode> listResult) {
//        if(root == null){
//            return;
//        }
//        if(root.val == q ){
//            listTemp.add(root);
//            listResult.addAll(listTemp);
//        }
//        listTemp.add(root);
//        dfs(root.left,q,listTemp,listResult);
//        dfs(root.right,q,listTemp,listResult);
//        //恢复当前层状态
//        listTemp.remove(listTemp.size()-1);
//    }
//

    public static void main(String[] args) {
        //TreeNode
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left =node5;
        node3.right = node1;
        node5.left =node6;
        node5.right = node2;
        node2.left =node7;
        node2.right = node4;
        node1.left =node0;
        node1.right = node8;

//        TreeNode l =  lowestCommonAncestor(node3,node5,node4);
        TreeNode node =  TreeNodeUtils.parseString("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode l =  lowestCommonAncestor(node,node5,node1);
        System.out.println(l.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
