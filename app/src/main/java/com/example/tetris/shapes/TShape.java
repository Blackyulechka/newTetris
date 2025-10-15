package com.example.tetris.shapes;

import android.graphics.Color;

public class TShape extends BaseShape {
    public TShape(int centerX, int centerY) {
        super(centerX, centerY);
        this.coord = new int[][]{{-1, 0}, {0, -1}, {0, 0}, {1, 0}};
    }
}
