package practice;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 2021049
 * To change this template use File | Settings | File Templates.
 * 	从十万个ip中找出重复数top10的ip
 */
public class MapContains {
    private List<String> findTop10(List<String> list){
        List<String> result = new ArrayList<>();
        Map<String,Integer> map = new HashMap<String,Integer>(16);
        for(String s : list){
            Integer temp = map.get(s);
            if(temp == null){
                map.put(s,1);
            }else {
                map.put(s,temp++);
            }
        }
        Set<Map.Entry<String,Integer>> set  = map.entrySet();
        List<Integer>  listTemp = new ArrayList<>(map.values());
        Collections.sort(listTemp);
        for(Map.Entry<String,Integer> e : set){
        for (int i=0;i<11;i++) {
        if (e.getValue().equals(listTemp.get(i))) { // 如果Set集合中的值和我们要的值一样时，在集合中添加key值
            result.add(e.getKey());
        }
          }
        }

        return result;

    }

}
