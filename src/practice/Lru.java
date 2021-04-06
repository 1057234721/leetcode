package practice;

import practice.common.ListNode;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20210406
 * To change this template use File | Settings | File Templates.
 */
/*
 问题2：简单版本的 LRU(Least Recently Used) Cache 算法实现.
 LRU Cache应该满足下面的条件:

- LRU Cache有一定的容量, 当小于这个容量时, 可以往cache中正常添加数据.
- 如果添加之后会超过容量, 那么需要把最近不被访问的元素淘汰掉.

也就是说LRU Cache中应该保持的是最近被使用的元素.
请尝试实现一个简单版本的LRU Cache, 满足上面的条件.
*/
public class Lru<K ,V> {

    /**
     * 容量
     */
    private int capacity;

    /**
     * lru队列大小
     */
    private int size  = 10;

    /**
     * Node记录表
     */
    private Map<K, ListNode<K, V>> table = new ConcurrentHashMap<>();
    /**
     * 双向链表头部
     */
    private ListNode<K, V> head;
    /**
     * 双向链表尾部
     */
    private ListNode<K, V> tail;

    private Lru(int capacity){
        this.capacity =capacity;
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    private void addLast(ListNode node){
        node.next = tail;
        node.prev= tail.prev;

        tail.prev.next = node;
        tail.prev = node;
    }
    private void removeNode(ListNode node){
        ListNode<K,V> prev = node.prev;
        ListNode<K,V> next = node.next;

        prev.next = next;
        next.prev = prev;

    }
    private void moveToLast(ListNode node){
        removeNode(node);
        addLast(node);
    }

    private void add(K k, V v){
        ListNode<K, V> node = table.get(k);
        if(node  == null){
            if(size > capacity ){
                removeNode(head.next);
            }
            node= new ListNode<>();
            node.key = k;
            node.value =v;
            table.put(k,node);
            addLast(node);
        }else{
            moveToLast(node);
        }

    }
    private V  get(K k){

        ListNode<K, V> node = table.get(k);
        //如果Node不在表中，代表缓存中并没有
        if (node == null) {
            return null;
        }
        moveToLast(node);
        return node.value;

    }



}
