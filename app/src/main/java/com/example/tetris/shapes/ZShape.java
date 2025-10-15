package com.example.tetris.shapes;

import android.graphics.Color;

public class ZShape extends BaseShape {
    public ZShape(int centerX, int centerY) {
        super(centerX, centerY);
        this.coord = new int[][]{{0, 0}, {1, 0}, {1, 1}, {2, 1}};
    }
}
