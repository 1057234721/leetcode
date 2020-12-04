package offer;
// 给定一棵二叉搜索树，请找出其中第k大的节点。
//
//
//
// 示例 1:
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//    2
// 输出: 4
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
// 输出: 4
//
//
//
// 限制：
//
// 1 ≤ k ≤ 二叉搜索树元素个数
// Related Topics 树
// 👍 93 👎 0

// leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201203
 * To change this template use File | Settings | File Templates.
 */
public class Offer54KthLargest {
    private int result;
    private int count;

    public int kthLargest(TreeNode root, int k) {
        // 中序遍历为递增数组,右根左的方式为递减数组
        this.count = 0;
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        dfs(root.right, k);
        count++;
        if(count==k){
            result = root.val;
            return;
        }
        dfs(root.left, k);
    }
}
