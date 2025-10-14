package com.example.tetris.shapes;

import android.graphics.Color;

public class SShape extends BaseShape{
    public SShape(int x, int y) {
        super(x,y);
        this.shape = new int[][]{ {0,1,1},{1,1,0}};
        this.color = Color.rgb(0,0,0);
    }
}
