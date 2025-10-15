package com.example.tetris.GridMatrix;

public class gridMatrix {
    private final int rows;
    private final int columns;
    private final int[][] grid;

    public gridMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
        clearGrid();
    }

    private void clearGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    public boolean isCellEmpty(int row, int col) {
        return isValidPosition(row, col) && grid[row][col] == 0;
    }

    public void setCell(int row, int col, int value) {
        if (isValidPosition(row, col)) {
            grid[row][col] = value;
        }
    }

    public int getCell(int row, int col) {
        if (isValidPosition(row, col)) {
            return grid[row][col];
        }
        return -1;
    }
}
