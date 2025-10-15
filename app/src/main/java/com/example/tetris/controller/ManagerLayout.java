package com.example.tetris.controller;

import com.example.tetris.GridMatrix.gridMatrix;
import com.example.tetris.Interfaces.TetrisInterface;
import com.example.tetris.shapes.BaseShape;

public class ManagerLayout implements TetrisInterface {
    private static final int ROWS = 10;
    private static final int COLS = 6;
    private gridMatrix gameGrid;

    public ManagerLayout() {
        this.gameGrid = new gridMatrix(ROWS, COLS);
    }

    @Override
    public void moveLeft(BaseShape shape) {
        if (shape == null)
            return;
        int oldX = shape.getCenterX();
        int oldY = shape.getCenterY();
        shape.setCenter(oldX - 1, oldY);
        if (isCollision(shape)) {
            shape.setCenter(oldX, oldY);
        }
    }

    @Override
    public void moveRight(BaseShape shape) {
        if (shape == null) return;
        int oldX = shape.getCenterX();
        int oldY = shape.getCenterY();

        shape.setCenter(oldX + 1, oldY);

        if (isCollision(shape)) {
            shape.setCenter(oldX, oldY);
        }
    }

    @Override
    public void moveDown(BaseShape shape) {
        if (shape == null)
            return;
        int oldX = shape.getCenterX();
        int oldY = shape.getCenterY();

        shape.setCenter(oldX, oldY + 1);

        if (isCollision(shape)) {
            shape.setCenter(oldX, oldY);
        }
    }

    @Override
    public void moveRotate(BaseShape shape) {
        if (shape == null)
            return;
        shape.rotate();
        if (isCollision(shape)) {
            shape.rotateBack();
        }
    }

    public boolean isCollision(BaseShape shape) {
        if (shape == null)
            return true;
        int[][] coords = shape.getCoord();
        int centerX = shape.getCenterX();
        int centerY = shape.getCenterY();
        for (int[] coord : coords) {
            int col = centerX + coord[0];
            int row = centerY + coord[1];
            if (col < 0 || col >= COLS || row >= ROWS) {
                return true;
            }
            if (row >= 0 && !gameGrid.isCellEmpty(row, col)) {
                return true;
            }
        }
        return false;
    }
    public void placeShape(BaseShape shape) {
        if (shape == null)
            return;
        int[][] coords = shape.getCoord();
        int centerX = shape.getCenterX();
        int centerY = shape.getCenterY();
        for (int[] coord : coords) {
            int col = centerX + coord[0];
            int row = centerY + coord[1];
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                gameGrid.setCell(row, col, 1);
            }
        }
    }

    @Override
    public int clearLines() {
        int linesCleared = 0;
        int[][] grid = gameGrid.getGrid();
        for (int row = ROWS - 1; row >= 0; row--) {
            boolean lineComplete = true;
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 0) {
                    lineComplete = false;
                    break;
                }
            }
            if (lineComplete) {
                for (int r = row; r > 0; r--) {
                    for (int c = 0; c < COLS; c++) {
                        grid[r][c] = grid[r - 1][c];
                    }
                }
                for (int c = 0; c < COLS; c++) {
                    grid[0][c] = 0;
                }
                linesCleared++;
                row++;
            }
        }

        return linesCleared;
    }

    @Override
    public int[][] getGrid() {
        return gameGrid.getGrid();
    }

    public gridMatrix getGameGrid() {
        return gameGrid;
    }

    public int getRows() {
        return ROWS;
    }

    public int getCols() {
        return COLS;
    }

    public boolean canMoveDown(BaseShape shape) {
        if (shape == null) return false;
        int oldX = shape.getCenterX();
        int oldY = shape.getCenterY();
        shape.setCenter(oldX, oldY + 1);
        boolean canMove = !isCollision(shape);
        shape.setCenter(oldX, oldY);
        return canMove;
    }
}
