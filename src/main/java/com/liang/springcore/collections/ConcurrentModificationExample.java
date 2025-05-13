package com.liang.springcore.collections;

/****
 * Created by liliang on 4/23/25.
 ****/
import java.util.*;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));

        // Example causing ConcurrentModificationException
        try {
            for (String s : list) {
                if (s.equals("two")) {
                    list.remove(s); // Structural modification during iteration
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught!");
        }

        // Example using Iterator to avoid ConcurrentModificationException
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("two")) {
                iterator.remove(); // Safe removal using iterator
            }
        }
        System.out.println(list);
    }
}