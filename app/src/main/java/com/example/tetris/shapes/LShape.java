package com.example.tetris.shapes;

import android.graphics.Color;

public class LShape extends BaseShape{
    public LShape(int centerX, int centerY) {
        super(centerX, centerY);
        this.coord = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 2}
        };
    }
}
