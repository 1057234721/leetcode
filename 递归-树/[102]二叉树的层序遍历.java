//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 613 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        //递归，用level标记层级
//        List<List<Integer>> list  = new ArrayList<>();
//        bfs(root,list,0);
//        return list;
//    }
//    private void bfs(TreeNode root,List<List<Integer>> list,Integer level){
//        if(root == null){
//            return;
//        }
//        if(level > list.size()-1){
//            list.add(new ArrayList<>());
//        }
//        list.get(level).add(root.val);
//
//        bfs(root.left,list,level+1);
//        bfs(root.right,list,level+1);
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //迭代，前序遍历演化，使用队列，先push根节点，弹出队列，此时不再是弹出一个元素，而是所有元素出队，每个元素在push左右节点，

        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root == null){
            return list;
        }
        deque.add(root);
        while ( !deque.isEmpty() && root != null){
            int leveLength = deque.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i= 0;i<leveLength;i++){
                root = deque.pollFirst();
                tempList.add(root.val);
                if(root.left != null){
                    deque.addLast(root.left);
                }
                if(root.right != null){
                    deque.addLast(root.right);
                }

            }
            list.add(tempList);
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
