package com.example.tetris.shapes;


import com.example.tetris.ShapeInterface.ShapeInterface;

public abstract class BaseShape implements ShapeInterface {
    protected int[][] shape;
    protected int x, y;
    protected int color;

    public BaseShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int[][] getShape() {
        return shape;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public int getWidth() {
        return shape[0].length;
    }

    @Override
    public int getHeight() {
        return shape.length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y--;
    }
    public void rotate() {
        int[][] newShape = new int[shape[0].length][shape.length];

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                newShape[j][shape.length - 1 - i] = shape[i][j];
            }
        }

        shape = newShape;
    }

}
