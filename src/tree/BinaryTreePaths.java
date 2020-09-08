package tree;
//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 356 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

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
 * [257]Binary Tree Paths
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        //是叶子节点，当前路径末尾添加该节点，当前路径添加到结果
        //不是叶子节点，当前路径末尾添加该
        //StringBuffer 可变字符串，使用要设置length
        List<String>  list = new ArrayList<>();
        dfs(root,"",list);
        return list;

    }
    private void dfs(TreeNode root, String s, List<String> list){
        if(root ==null){
            return;
        }
        if(root.left==null && root.right == null){
            list.add(s + root.val);
        }
        s = s + root.val + "->";
        dfs(root.left,s,list);
        dfs(root.right,s,list);


    }
}
//leetcode submit region end(Prohibit modification and deletion)
