package com.example.tetris.shapes;

import android.graphics.Color;

public class JShape extends BaseShape{
    public JShape(int x, int y) {
        super(x,y);
        this.shape = new int[][]{{1,0,0},{1,1,1}};
        this.color = Color.rgb(0, 255, 0);
    }
}
