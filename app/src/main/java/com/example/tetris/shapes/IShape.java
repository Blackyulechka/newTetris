package com.example.tetris.shapes;

import android.graphics.Color;

public class IShape extends BaseShape{
    public IShape(int x, int y) {
        super(x,y);
        this.shape = new int[][]{ {1,1,1,1}};
        this.color = Color.rgb(255, 0, 0);
    }
}
