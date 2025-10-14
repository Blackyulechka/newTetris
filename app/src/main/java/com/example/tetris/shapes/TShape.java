package com.example.tetris.shapes;

import android.graphics.Color;

public class TShape extends BaseShape{
    public TShape(int x, int y) {
        super(x,y);
        this.shape = new int[][]{ {1,1,1},{0,1,0}};
        this.color = Color.rgb(143,0,255);
    }
}
