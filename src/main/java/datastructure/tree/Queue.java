package datastructure.tree;

import java.util.LinkedList;

public class Queue {
    private LinkedList list = new LinkedList();
    public Queue() {
    }
    public void clear() {
        list.clear();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public Object firstEl() {
        return list.getFirst();
    }
    public Object dequeue() {
        return list.removeFirst();
    }
    public void enqueue(Object el) {
        list.add(el);
    }
    public String toString() {
        return list.toString();
    }
}


