package com.example.tetris.TetrisGame;

import com.example.tetris.EnumShapes.EnumShapes;
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
    private static final int widthLayout = 10;
    private static final int heightlayout = 20;
    private int[][] gameBoard;
    private BaseShape shape;
    private Random random;

    public TetrisGame() {
        gameBoard = new int[heightlayout][widthLayout];
        random = new Random();
        spawnNewShape();
    }
    public int[][] getGameBoard() {
        return gameBoard;
    }

    public BaseShape getCurrentShape() {
        return shape;
    }
    private void spawnNewShape() {
        EnumShapes[] shapes = EnumShapes.values();
        EnumShapes randomShape = shapes[random.nextInt(shapes.length)];
        int startX = widthLayout / 2;
        switch (randomShape) {
            case I_shape:
                shape = new IShape(startX, 0);
                break;
            case J_shape:
                shape = new JShape(startX, 0);
                break;
            case L_shape:
                shape = new LShape(startX, 0);
                break;
            case O_shape:
                shape = new OShape(startX, 0);
                break;
            case S_shape:
                shape = new SShape(startX, 0);
                break;
            case T_shape:
                shape = new TShape(startX, 0);
                break;
            case Z_shape:
                shape = new ZShape(startX, 0);
                break;
        }
    }

    public boolean IsFilled() {
        int[][] shapeBar = shape.getShape();
        int x = shape.getX();
        int y = shape.getY();

        for (int i = 0; i<shapeBar.length;i++){
            for (int j=0; j<shapeBar[i].length; j++){
                if (shapeBar[i][j] != 0){
                    int gameX = x+j;
                    int gameY = y+i;
                    if (gameX <0 || gameX >= widthLayout || gameY >= heightlayout || (gameY >=0 && gameBoard[gameX][gameY]!=0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void moveLeft() {
        shape.moveLeft();
        if (IsFilled()) {
            shape.moveRight();
        }
    }
    public void moveRight() {
        shape.moveLeft();
        if (IsFilled()) {
            shape.moveLeft();
        }
    }
    public boolean moveDown() {
        shape.moveDown();
        if (IsFilled()) {
            shape.moveDown();
            BildGameBoard();
            clearLines();
            spawnNewShape();
            return false;
        }
        return true;
    }
    public void moveRotate() {
        shape.rotate();
        if (IsFilled()) {
            for (int i = 0; i < 3; i++) {
                shape.rotate();
            }
        }
    }
    public void clearLines() {
        for (int i = 0; i < heightlayout; i++) {
            int filled = 0;
            for (int j = 0; j < widthLayout; j++) {
                if (gameBoard[i][j] != 0) {
                    filled++;
                }
            }
            if (filled == widthLayout) {
                for (int k = i; k > 0; k--) {
                    gameBoard[k] = gameBoard[k - 1].clone();
                }
                gameBoard[0] = new int[widthLayout];
            }
        }
    }
    public void BildGameBoard(){
        int[][] s = shape.getShape();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (s[i][j] == 1) {
                    gameBoard[shape.getY() + i][shape.getX() + j] = shape.getColor();
                }
            }
        }
    }
}
