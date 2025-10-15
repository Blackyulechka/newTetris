package com.example.tetris.shapes;

import android.graphics.Color;

public class IShape extends BaseShape{
    public IShape(int centerX, int centerY) {
        super(centerX, centerY);
        this.coord = new int[][]{{0, -1}, {0, 0}, {0, 1}, {0, 2}
        };
    }
}
