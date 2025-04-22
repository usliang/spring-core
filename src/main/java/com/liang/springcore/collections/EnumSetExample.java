package com.liang.springcore.collections;

import java.util.EnumSet;

/****
 * Created by liliang on 4/22/25.
 ****/
public class EnumSetExample {
    public static void main(String[] args) {
        // Creating an EnumSet containing all days of the week
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println("All days: " + allDays);

        // Creating an EnumSet containing specific days
        EnumSet<Day> weekendDays = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend days: " + weekendDays);

        // Creating an empty EnumSet
        EnumSet<Day> emptySet = EnumSet.noneOf(Day.class);
        System.out.println("Empty set: " + emptySet);

        // Adding elements to an EnumSet
        emptySet.add(Day.MONDAY);
        System.out.println("Empty set after adding Monday: " + emptySet);

            // Removing elements from an EnumSet
            allDays.remove(Day.SUNDAY);
            System.out.println("All days after removing Sunday: " + allDays);

            // Checking if an EnumSet contains an element
            boolean containsTuesday = allDays.contains(Day.TUESDAY);
            System.out.println("Contains Tuesday: " + containsTuesday);
        }
}
