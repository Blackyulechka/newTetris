package com.example.tetris.shapes;


import com.example.tetris.Interfaces.ShapeInterface;

public abstract class BaseShape implements ShapeInterface {
    protected int[][] coord;
    protected int centerX, centerY;
    //protected int color;

    public BaseShape(int centerX, int centerY){
        this.centerX = centerX;
        this.centerY = centerY;
    }
    @Override
    public int[][] getCoord(){
        return coord;
    }
    @Override
    public int getCenterX(){
        return centerX;
    }
    @Override
    public int getCenterY(){
        return centerY;
    }
    @Override
    public void setCenter(int x, int y){
        this.centerX =x;
        this.centerY = y;
    }
    @Override
    public void rotate() {
        int[][] newCoords = new int[coord.length][2];
        for (int i = 0; i < coord.length; i++) {
            int x = coord[i][0];
            int y = coord[i][1];
            newCoords[i][0] = -y;
            newCoords[i][1] = x;
        }
        coord = newCoords;
    }
    @Override
    public void rotateBack() {
        int[][] newCoords = new int[coord.length][2];
        for (int i = 0; i < coord.length; i++) {
            int x = coord[i][0];
            int y = coord[i][1];
            newCoords[i][0] = y;
            newCoords[i][1] = -x;
        }
        coord = newCoords;
    }

}
