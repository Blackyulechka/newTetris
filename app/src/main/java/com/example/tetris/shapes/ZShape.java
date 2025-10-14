package com.example.tetris.shapes;

import android.graphics.Color;

public class ZShape extends BaseShape {
    public ZShape(int x, int y) {
        super(x,y);
        this.shape = new int[][]{ {0,0,1},{1,1, 1}};
        this.color = Color.rgb(0,255,255);
    }
}
