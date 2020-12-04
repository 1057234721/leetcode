package offer;

import common.TreeNode;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201204
 * To change this template use File | Settings | File Templates.
 */
public class Offer55IsBalanced {
    public boolean isBalanced(TreeNode root) {
        //当前树平衡，左子树平衡，右子树平衡
        if (root==null){
            return true;
        }
        return Math.abs(getHeight(root.left)-getHeight(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);



    }

    private int  getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;

    }
}
