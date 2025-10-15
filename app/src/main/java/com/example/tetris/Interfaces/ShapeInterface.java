package com.example.tetris.Interfaces;

public interface ShapeInterface {
    public int[][] getCoord();
    public int getCenterX();
    public int getCenterY();
    public void setCenter(int x,int y);
    public void rotate();
    public void rotateBack();
}
