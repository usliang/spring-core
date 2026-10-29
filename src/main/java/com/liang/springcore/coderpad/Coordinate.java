package com.liang.springcore.coderpad;

import lombok.Data;
import lombok.NonNull;

@Data
public class Coordinate {
    @NonNull
    int x;
    @NonNull
    int y;
}
