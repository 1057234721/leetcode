package practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20210408
 * To change this template use File | Settings | File Templates.
 */
public class SyncList {
    // 实际元素个数
    private int size;
    private Object[] elementData;
    final Object lock;
    public SyncList(int initialCapacity, Object lock) {
        this.size = 10;
        this.elementData = new Object[initialCapacity];
        this.lock = lock;
    }
    public boolean add(Object o) {
        synchronized (lock){
            elementData[size++] = o;
            return true;
        }
    }
    public Object remove(int index) {
    synchronized (lock) {
      if (index > size) {
        return null;
      }
      Object oldValue = elementData[index];
      int numMoved = size - index - 1;
      if (numMoved > 0) {
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
      }
      elementData[--size] = null; // clear to let GC do its work
      return oldValue;
        }
    }

  public Object get(int index) {
    synchronized (lock) {
      if (index > size) {
        return null;
      }
      return elementData[index];
    }
    }
}
