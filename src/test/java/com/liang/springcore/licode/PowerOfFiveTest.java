package com.liang.springcore.licode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfFiveTest {
    PowerOfFive powerOfFive = new PowerOfFive();
    @Test
    void isPowerOfThree1() {
        assertTrue(powerOfFive.isPowerOfFive(1));
    }

    @Test
    void isPowerOfThree2() {
        assertTrue(powerOfFive.isPowerOfFive(5));
    }

    @Test
    void isPowerOfThree3() {
        assertTrue(powerOfFive.isPowerOfFive(5 * 5));
    }

    @Test
    void isPowerOfThree4() {
        assertTrue(powerOfFive.isPowerOfFive(5 * 5 * 5));
    }

    @Test
    void isPowerOfThree5() {
        assertTrue(powerOfFive.isPowerOfFive((int)Math.pow(5, 13)));
    }

    @Test
    void isPowerOfThree6() {
        String result = compressString("aaa");
        assertTrue(result.equals("a3"));

        result = compressString("aaabb");
        assertTrue(result.equals("a3b2"));

        result = compressString("aabcccccaaa");
        assertTrue(result.equals("a2b1c5a3"));

    }

    public String compressString(String s){
        int count = 0;
        StringBuilder compressed = new StringBuilder();
        char lastChar = s.charAt(s.length() - 1);
        char diff = (char) (lastChar + 1);
        String orgAddOne = s + diff;
        char cursor = s.charAt(0);
        for(int i = 0; i < orgAddOne.length(); i++){
            if (cursor == orgAddOne.charAt(i)) {
                count++;
            }else {
                compressed.append(cursor);
                compressed.append(count);
                cursor = orgAddOne.charAt(i);
                count = 1;
            }
        }
        if (compressed.length() < s.length()){
            return compressed.toString();
        } else {
            return s;
        }
    }

    @Test
    void isPowerOfThree7() {
        int[][] meetings = new int[][]{{2,3}, {4,5}, {6,10}, {8,9}};
        assertTrue(canAttendMeetings(meetings));

    }
    @Test
    void isPowerOfThree8() {

    }
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length -1; i++) {
                if (intervals[i][1] > intervals[i+1][0]) {
                    return false;
                }
        }
        return true;
    }
    //public boolean
    @Test
    void isPowerOfThree9() {
        int[] nums = new int[]{1, 1, 1, 1};
        int result = subarraySum(nums, 4);
        assertEquals(1, result);
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            } else if (sum < k) {
                for (int j = i + 1; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        count++;
                        break;
                    } else if (sum > k) {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return count;
    }

    @Test
    void isPowerOfThree10() {
        int[][] meetings = new int[][]{{0, 30}, {5, 10}, {15,20}, {2, 6}, {11, 12}};
        int result = minMeetingRooms(meetings);
        assertEquals(3, result);

    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> room1 = new ArrayList<>();
        List<List<int[]>> rooms = new ArrayList<>();
        room1.add(intervals[0]);
        rooms.add(room1);
        for (int i = 1; i < intervals.length; i++) {
            //add the meetings to a room
            boolean canUsedExisting = false;
            for (List<int[]> room : rooms) {
                int[] lastMeeting = room.get(room.size() - 1);
                if (lastMeeting[1] < intervals[i][0]) {
                    //no conflict, add meeting into this room
                    room.add(intervals[i]);
                    canUsedExisting = true;
                    break;
                }
            }
            //can not find an existing room
            if (!canUsedExisting) {
                List<int[]> newRoom = new ArrayList<>();
                newRoom.add(intervals[i]);
                rooms.add(newRoom);
            }
        }
        return rooms.size();
    }

    @Test
    void isPowerOfThree11() {

    }

    


}