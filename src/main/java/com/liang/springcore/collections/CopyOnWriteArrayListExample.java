package com.liang.springcore.collections;

/****
 * Created by liliang on 4/23/25.
 ****/
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Iterator;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Get iterator before modification
        Iterator<String> iterator1 = list.iterator();

        // Modify the list
        list.add("Date");
        list.remove("Banana");

        // Get iterator after modification
        Iterator<String> iterator2 = list.iterator();

        System.out.println("Iterator 1 (before modification):");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("\nIterator 2 (after modification):");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}