package com.liang.springcore.coderpad;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PandemicSpreadTest {
    PandemicSpread pandemicSpread = new PandemicSpread();

    @Test
    void testGetNeighbors1() {
        List<Coordinate> coordinates = pandemicSpread.getNeighbors(0,0, 2, 2);
        assertEquals(3, coordinates.size());
    }

    @Test
    void testGetNeighbors2() {
        List<Coordinate> coordinates = pandemicSpread.getNeighbors(0,1, 2, 2);
        assertEquals(3, coordinates.size());
    }

    @Test
    void testGetNeighbors3() {
        List<Coordinate> coordinates = pandemicSpread.getNeighbors(1,0, 2, 2);
        assertEquals(3, coordinates.size());
    }
    @Test
    void testGetNeighbors4() {
        List<Coordinate> coordinates = pandemicSpread.getNeighbors(1,1, 2, 2);
        assertEquals(3, coordinates.size());
    }

    @Test
    void testGetNeighbors5() {
        List<Coordinate> coordinates = pandemicSpread.getNeighbors(0,0, 3, 3);
        assertEquals(3, coordinates.size());
    }
    @Test
    void testGetNeighbors6() {
        List<Coordinate> coordinates = pandemicSpread.getNeighbors(0,1, 3, 3);
        assertEquals(5, coordinates.size());
    }
    @Test
    void testGetNeighbors7() {
        List<Coordinate> coordinates = pandemicSpread.getNeighbors(1,1, 3, 3);
        assertEquals(8, coordinates.size());
    }

    @Test
    void testSpead() {
        
    }
}