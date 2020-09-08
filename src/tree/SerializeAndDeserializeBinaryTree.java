package tree;//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 344 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

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
 * [297]Serialize and Deserialize Binary Tree
 * @author : huangdewei
 * Date: 20200907
 * To change this template use File | Settings | File Templates.
 */
public class SerializeAndDeserializeBinaryTree     {
    private final static String split = ",";
    private final static String end = "null";

    // Encodes a tree to a single string.
    //遍历二叉树
    public String serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        dfs(root,s);
        return s.toString();
    }

    private void dfs(TreeNode root, StringBuffer s){
        if(root == null){
            s.append(end).append(split);
            return;
        }
        s.append(root.val).append(split);
        dfs(root.left,s);
        dfs(root.right,s);
    }
    // Decodes your encoded data to tree.
    //递归反序列化二叉树,用队列移除元素
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(data.split(split))) ;
       return dedfs(list );
    }
    private TreeNode dedfs( LinkedList<String> list){
        String  s = list.remove();
        if(end.equals(s)){
            return null;
        }
        TreeNode node = new  TreeNode(Integer.valueOf(s));
        node.left = dedfs(list);
        node.right = dedfs(list);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
