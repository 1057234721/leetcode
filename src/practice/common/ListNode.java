package practice.common;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20210406 To change this template use File | Settings | File Templates.
 */
public class ListNode<K, V> {
    public K key;
    public V value;
    public ListNode<K, V> prev;
    public ListNode<K, V> next;

  public ListNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public ListNode() {}
    }
