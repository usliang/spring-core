package com.liang.springcore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InstrumentalistTest {

    @Autowired
    Performer performer;

    @Autowired
    MyService service;

    @Test
    void testPerform() throws PerformanceException {

        String s1 = "one";
        String s2 = s1;

        boolean b1 = s1 == s2;
        performer.perform();
    }

    @Test
    void testService()  {
        service.doSomething();
        service.processData();
    }

    @Test
    void testAnagrams() {
        String s1= "battt";
        String s2 = "tabtt";
        assertThat(isAnagram(s1, s2)).isTrue();
    }
    boolean isAnagram(String s1, String s2) {
        int[] frequency1 = countFrequency(s1);
        int[] frequency2 = countFrequency(s2);
        for (int i = 0; i < frequency1.length; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }
        return true;
    };
    int[] countFrequency(String s) {
        String lowerCase = s.toLowerCase();
        int[] frequency = new int[26];
        for (int i = 0; i < lowerCase.length(); i++) {
            frequency[lowerCase.charAt(i) - 'a']++;
        }
        return frequency;
    }
}