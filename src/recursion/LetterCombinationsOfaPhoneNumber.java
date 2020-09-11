package recursion;//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics 字符串 回溯算法 
// 👍 908 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by IntelliJ IDEA.
 * [17]Letter Combinations of a Phone Number
 * @author : huangdewei
 * Date: 20200910
 * To change this template use File | Settings | File Templates.
 */
//leetcode submit region begin(Prohibit modification and deletion)
class LetterCombinationsOfaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>(16);
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list = new ArrayList<>();
        dfs(digits,list,new StringBuffer(),map,0);

        return list;

    }

    private static void dfs(String digits, List<String> list, StringBuffer stringBuffer, Map<Character, String> map,int level) {
        if (digits.length() == stringBuffer.length()){
            list.add(stringBuffer.toString());
            return;
        }

        String s = map.get(digits.charAt(level));
        for (Character c : s.toCharArray()){
            stringBuffer.append(c);
            dfs(digits,list,stringBuffer,map,level+1);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);

        }
    }

  public static void main(String[] args) {
    //
    System.out.println(letterCombinations("23"));
  }
}
//leetcode submit region end(Prohibit modification and deletion)
