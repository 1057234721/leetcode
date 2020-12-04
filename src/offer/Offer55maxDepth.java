package offer;

import common.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201204
 * To change this template use File | Settings | File Templates.
 */
public class Offer55maxDepth {
    private int max;
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        max =0;
        dfs(root,0);
        return max+1;

    }
    private void dfs(TreeNode root, int level){
        if (root ==null){
            return;
        }
        max = Math.max(max,level);

        dfs(root.left,level+1);
        dfs(root.right,level+1);


    }
}
