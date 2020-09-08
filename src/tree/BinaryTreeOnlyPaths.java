package tree;
//给定一个二叉树，返回从根节点到指定节点q节点的路径。
//
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
// q=5
//输出: "1->2->5"
//

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20200908
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeOnlyPaths {
    public static List<Integer> BinaryTreeOnlyPaths(TreeNode root, int q) {
        //是节点q，当前路径末尾添加该节点，当前路径添加到结果
        //不是节点q，当前路径末尾添加该节点
        //要清扫当前层状态
        List<Integer>  listTemp = new ArrayList<>();
        List<Integer>  listResult = new ArrayList<>();
        dfs(root,q,listTemp,listResult);
        return listResult;

    }

    private static void dfs(TreeNode root, int q, List<Integer> listTemp, List<Integer> listResult) {
        if(root == null){
            return;
        }
        if(root.val == q ){
            listTemp.add(q);
            listResult.addAll(listTemp);
        }
        listTemp.add(root.val);
        dfs(root.left,q,listTemp,listResult);
        dfs(root.right,q,listTemp,listResult);
        //恢复当前层状态
        listTemp.remove(listTemp.size()-1);
    }

  public static void main(String[] args) {
    //TreeNode
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node5 = new TreeNode(5);
      node1.left =node2;
      node1.right = node3;
      node2.right = node5;
     List l =  BinaryTreeOnlyPaths(node1,2);
    System.out.println(l);
  }
}
