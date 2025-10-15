package com.example.tetris.Interfaces;

import com.example.tetris.shapes.BaseShape;

public interface TetrisInterface {
    public void moveLeft(BaseShape shape);
    public void moveRight(BaseShape shape);
    public void moveDown(BaseShape shape);
    public void moveRotate(BaseShape shape);
    public int clearLines();
    public int[][] getGrid();
}
