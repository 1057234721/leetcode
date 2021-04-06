package practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 2214006
 * To change this template use File | Settings | File Templates.
 */
public class LruLinkedHashMap<K,V>  extends LinkedHashMap {
    public LruLinkedHashMap(int initialCapacity, float loadFactor,Boolean accessOrder){
        super(initialCapacity,loadFactor,accessOrder);
    }

    @Override
    protected   boolean removeEldestEntry(Map.Entry eldest){
        if (size()>6){
            return true;
        }
        return false;


    }

    public static void main(String[] args) {

        LruLinkedHashMap<Character, Integer> lru = new LruLinkedHashMap<Character, Integer>(
                16, 0.75f, true);

        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }

}
