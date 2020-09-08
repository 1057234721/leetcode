package common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20200908 To change this template use File | Settings | File Templates.
 * 树扁平化，序列化时需要用null将树补充成完全二叉树
 * 将输入数组构造成node数组，
 * 树跟数组index建立对应关系
 * root.left = treeNodes[2 * i + 1];
 * root.right = treeNodes[2 * i + 2];
 * root 为 0 left 2*0 +1 right 2*0+2
 * root 为 1 left 为2*1+1 right 为2*1+2
 */
public class TreeNodeUtils {
  public static TreeNode parseString(String string) {
    String usefulPart;
    if (string.length() < 2
        || (usefulPart = string.substring(1, string.length() - 1)).length() == 0) {
      return null;
    }
    String[] split = usefulPart.split(",");
    TreeNode[] treeNodes = new TreeNode[split.length];
    for (int i = 0; i < split.length; i++) {
      if (!"null".equals(split[i])) {
        treeNodes[i] = new TreeNode(Integer.parseInt(split[i]));
      } else {
        treeNodes[i] = null;
      }
    }
    for (int i = 0; i < split.length; i++) {
      if (treeNodes[i] != null) {
        if (2 * i + 1 < split.length) {
          treeNodes[i].left = treeNodes[2 * i + 1];
        }
        if (2 * i + 2 < split.length) {
          treeNodes[i].right = treeNodes[2 * i + 2];
        }
      }
    }
    return treeNodes[0];
  }

  public static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }
    printTree(root.left);
    System.out.println(root);
    printTree(root.right);
  }

  public static void main(String[] args) {
    TreeNode treeNode = parseString("[0,1,2,3]");
    printTree(treeNode);
  }
}
