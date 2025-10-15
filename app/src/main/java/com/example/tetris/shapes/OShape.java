package com.example.tetris.shapes;

import android.graphics.Color;

public class  OShape extends BaseShape{
    public OShape(int centerX, int centerY) {
        super(centerX, centerY);
        this.coord = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    }
}
