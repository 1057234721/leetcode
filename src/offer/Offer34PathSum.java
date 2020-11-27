package offer;
//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
//
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 10000
//
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
// Related Topics 树 深度优先搜索
// 👍 110 👎 0
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201124
 * To change this template use File | Settings | File Templates.
 */
public class Offer34PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
         dfs(root,0,sum,list,temp);
         return list;
    }
    private void dfs(TreeNode root, int sum,int target,List<List<Integer>> list,List<Integer> temp){
        if (root == null ){
            return;
        }
        if(sum == target && root.left==null&& root.right==null){
            list.add(new ArrayList<>(temp));
        }
        sum = sum + root.val;
        temp.add(root.val);
        dfs( root.left,  sum, target,list,temp);
        dfs( root.right,  sum, target, list, temp);
        temp.remove(temp.size()-1);
    }
}
