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
public class Offer50FirstUniqChar {
    public static  char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<Character,Boolean>();
        char[] arr = s.toCharArray();
        for(Character c : arr){
            map.put(c,map.containsKey(c));
        }
        for (Character c : arr) {
            if (!map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

  public static void main(String[] args) {
    System.out.println(firstUniqChar("loveleetcode"));
  }
}
