package com.liang.springcore.recursive;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FabCal {
    private final Map<Integer, BigInteger> map;

    public FabCal() {
        map = new HashMap<>();
    }

    public BigInteger calculateRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        if (n < 2) {
            log.debug("Put in map for n: {}", n);
            BigInteger result = BigInteger.valueOf(n);
            map.put(n, result);
            return result;
        }
        if (!map.containsKey(n)) {
            BigInteger result = calculateRecursive(n - 1).add(calculateRecursive(n - 2));
            log.debug("Put in map for n: {}", n);
            map.put(n, result);
            return result;
        } else {
            log.debug("Find in map for n: {}", n);
            return map.get(n);
        }
    }
}
