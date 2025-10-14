package com.example.tetris.shapes;

import android.graphics.Color;

public class OShape extends BaseShape{
    public OShape(int x, int y) {
        super(x,y);
        this.shape = new int[][]{ {1,1},{1,1}};
        this.color = Color.rgb(255, 69, 0);
    }
}
