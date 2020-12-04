package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201203
 * To change this template use File | Settings | File Templates.
 */
public class Offer48LengthOfLongestSubstring {
    public static  int lengthOfLongestSubstring(String s) {
//        设动态规划列表 dp ，dp[j] 代表以字符 s.charAt(j) 为结尾的 “最长不重复子字符串” 的长度
//        设两重复字符之间的距离为d,当前无重复子串sub,sub起始下标i，当s.charAt(j)=s.charAt(i)时，确认下标j，;
//        1.设s.charAt(j) ，等值对应下标的i不存在，即首次出现；则d为无穷大；dp[j]=dp[j-1]+1;
//        2.等值对应下标的i存在，但是s.charAt(i)不在sub中，在其左边，即d>j-i ；dp[j]=dp[j-1]+1;
//        3.等值对应下标的i存在，s.charAt(i)在sub中，即d <=j-i ；dp[j]=j-i;

//        if (s== null){
//            return 0;
//        }
//        if (s.length()<=1){
//            return s.length();
//        }
//        //数组状态只与上一个元素有关，可用变量temp滚动数组节省空间；
//        int[] dp = new int[s.length()+1];
//        int max = 0;
//        int i=0;
//        dp[0] =1;
//        //记录i值最近坐标
//        Map<Character,Integer> map = new HashMap<Character,Integer>();
//        map.put(s.charAt(0),0);
//
//        for (int j=1;j<s.length();j++){
//            if(map.get(s.charAt(j))== null){
//                i= -1;
//            }else {
//                i=map.get(s.charAt(j));
//            }
//            map.put(s.charAt(j),j);
//            //map.getOrDefault(map.get(s.charAt(j)),-1);
//            int d =j-i;
//           dp[j] = d > dp[j-1] ?  dp[j-1]+1 : d;
//           max =Math.max(dp[j],max);
//
//        }
//        return max;

        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int max =0;
        int temp =0;
        int i =0;

        for (int j=0;j<s.length();j++){
            if(map.get(s.charAt(j))== null){
                i= -1;
            }else {
                i=map.get(s.charAt(j));
            }
            map.put(s.charAt(j),j);
            //map.getOrDefault(map.get(s.charAt(j)),-1);
            int d =j-i;
            temp = d > temp?  temp+1 : d;
            max =Math.max(temp,max);

        }
        return  max;

    }
}
