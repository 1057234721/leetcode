package offer;

import common.TreeNode;
import common.TreeNodeUtils;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20201119 To change this template use File | Settings | File Templates.
 */
public class Offer26IsSubStructure {
  // 1，在a中找到b的根节点，
  // 2.比较a是否包含b子树
  public static boolean isSubStructure(TreeNode a, TreeNode b) {
    if (a == null || b == null) {
      return false;
    }
    if (subTree(a, b)) {
      return true;
    }
    return isSubStructure(a.left, b) || isSubStructure(a.right, b);
  }

  public static  boolean subTree(TreeNode a, TreeNode b) {
    if (a == null) {
      return false;
    }
    if (b == null) {
      return true;
    }
    if (a.val != b.val) {
      return false;
    }
    return subTree(a.left, b.left) && subTree(a.right, b.right);
  }

  public static void main(String[] args) {
      TreeNode a =  TreeNodeUtils.parseString("[0,1,2,3]");
      TreeNode b = TreeNodeUtils.parseString("[3]");
    System.out.println(isSubStructure(a,b));
  }
}
