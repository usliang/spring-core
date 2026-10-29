package com.liang.springcore.coderpad;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PandemicSpread {
    public List<Coordinate> getNeighbors(int x, int y, int rows, int cols) {
        List<Coordinate> coordinates = new ArrayList<>();
        if (x-1 >= 0 && y-1 >= 0) {
            coordinates.add(new Coordinate(x-1, y-1));
        }
        if (x-1 >= 0) {
            coordinates.add(new Coordinate(x-1, y));
        }
        if (x-1 >= 0 && y+1 < cols) {
            coordinates.add(new Coordinate(x-1, y+1));
        }
        if (y-1 >= 0) {
            coordinates.add(new Coordinate(x, y-1));
        }
        if (y+1 < cols) {
            coordinates.add(new Coordinate(x, y+1));
        }
        if (x+1 < rows && y-1 >=0) {
            coordinates.add(new Coordinate(x+1, y-1));
        }
        if (x+1 < rows ) {
            coordinates.add(new Coordinate(x+1, y));
        }
        if (x+1 <rows && y+1< cols) {
            coordinates.add(new Coordinate(x+1, y+1));
        }
        return coordinates;
    }
    public void spread(String[][] data, int t) {
        for (int i=0; i< data.length; i++) {
            for (int j=0; j<data[0].length; j++) {
                if (data[i][j].equalsIgnoreCase(".")) {
                    List<Coordinate> neighbors = getNeighbors(i, j, data.length, data[0].length);
                    int infected = 0;
                    for (Coordinate coordinate : neighbors) {
                        if (data[coordinate.x][coordinate.y].equalsIgnoreCase("X")) {
                            infected++;
                        }
                        if (infected == t) {
                            data[i][j] = "X";
                            break;
                        }
                    }
                }
            }
        }
    }
}
