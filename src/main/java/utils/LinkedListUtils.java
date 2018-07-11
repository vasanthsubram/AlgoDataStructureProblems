package utils;

import datastructure.LinkedList.LinkedList;

public class LinkedListUtils {
    public static LinkedList createList(){
        LinkedList list = new LinkedList();
        list.insert(3);
        list.insert(5);
        list.insert(1);
        list.insert(18);
        list.insert(8);
        list.insert(22);
        return list;
    }


}
