package com.example.tetris.shapes;

import android.graphics.Color;

public class SShape extends BaseShape{
    public SShape(int centerX, int centerY) {
        super(centerX, centerY);
        this.coord = new int[][]{{0, 0}, {1, 0}, {0, 1}, {-1, 1}};
    }
}
