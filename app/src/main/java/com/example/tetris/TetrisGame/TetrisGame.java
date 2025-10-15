package com.example.tetris.TetrisGame;

import com.example.tetris.EnumShapes.EnumShapes;
import com.example.tetris.controller.ManagerLayout;
import com.example.tetris.shapes.BaseShape;
import com.example.tetris.shapes.IShape;
import com.example.tetris.shapes.JShape;
import com.example.tetris.shapes.LShape;
import com.example.tetris.shapes.OShape;
import com.example.tetris.shapes.SShape;
import com.example.tetris.shapes.TShape;
import com.example.tetris.shapes.ZShape;

import java.util.Random;

public class TetrisGame {
    private ManagerLayout manager;
    private BaseShape currentShape;
    private Random random;
    private boolean gameOver;
    private int score;

    public TetrisGame() {
        this.manager = new ManagerLayout();
        this.random = new Random();
        this.gameOver = false;
        this.score = 0;
        spawnNewShape();
    }

    public void spawnNewShape() {
        EnumShapes[] shapes = EnumShapes.values();
        EnumShapes randomShape = shapes[random.nextInt(shapes.length)];
        int startX = manager.getCols() / 2;
        int startY = 0;

        switch (randomShape) {
            case I_shape:
                currentShape = new IShape(startX, startY);
                break;
            case J_shape:
                currentShape = new JShape(startX, startY);
                break;
            case L_shape:
                currentShape = new LShape(startX, startY);
                break;
            case O_shape:
                currentShape = new OShape(startX, startY);
                break;
            case S_shape:
                currentShape = new SShape(startX, startY);
                break;
            case T_shape:
                currentShape = new TShape(startX, startY);
                break;
            case Z_shape:
                currentShape = new ZShape(startX, startY);
                break;
        }

        // Проверка game over
        if (manager.isCollision(currentShape)) {
            gameOver = true;
        }
    }

    public void moveLeft() {
        if (!gameOver && currentShape != null) {
            manager.moveLeft(currentShape);
        }
    }

    public void moveRight() {
        if (!gameOver && currentShape != null) {
            manager.moveRight(currentShape);
        }
    }

    public boolean moveDown() {
        if (gameOver || currentShape == null) {
            return false;
        }
        manager.moveDown(currentShape);
        if (!manager.canMoveDown(currentShape)) {
            manager.placeShape(currentShape);
            int linesCleared = manager.clearLines();
            updateScore(linesCleared);
            spawnNewShape();
            return false;
        }
        return true;
    }

    public void rotate() {
        if (!gameOver && currentShape != null) {
            manager.moveRotate(currentShape);
        }
    }

    private void updateScore(int linesCleared) {
        switch (linesCleared) {
            case 1:
                score += 100;
                break;
            case 2:
                score += 200;
                break;
            case 3:
                score += 300;
                break;
            case 4:
                score += 400;
                break;
        }
    }

    public int[][] getGrid() {
        return manager.getGrid();
    }

    public BaseShape getCurrentShape() {
        return currentShape;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }

    public void resetGame() {
        manager = new ManagerLayout();
        gameOver = false;
        score = 0;
        spawnNewShape();
    }

    public int getRows() {
        return manager.getRows();
    }

    public int getCols() {
        return manager.getCols();
    }
}

