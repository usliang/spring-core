package com.liang.springcore.memeleak;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    public void givenMap_whenEqualsAndHashCodeNotOverridden_thenMemoryLeak() {
        Map<Person, Integer> map = new HashMap<>();
        for(int i=0; i<100; i++) {
            map.put(new Person("jon"), 1);
        }
        assertFalse(map.size() == 1);
    }

}