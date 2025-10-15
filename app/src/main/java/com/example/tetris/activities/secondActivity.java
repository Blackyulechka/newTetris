package com.example.tetris.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tetris.R;
import com.example.tetris.TetrisGame.TetrisGame;
import com.example.tetris.shapes.BaseShape;

public class secondActivity extends AppCompatActivity {

    private TetrisGame game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        game= new TetrisGame();
        setupControls();
        updateUI();
    }
        private void setupControls() {
            findViewById(R.id.buttonLeft).setOnClickListener(v -> game.moveLeft());
            updateUI();
            findViewById(R.id.buttonRight).setOnClickListener(v -> game.moveRight());
            updateUI();
            findViewById(R.id.buttonDown).setOnClickListener(v -> game.moveDown());
            updateUI();
            findViewById(R.id.buttonRotate).setOnClickListener(v -> game.rotate());
            updateUI();
        }
    private void updateUI() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                String cellId = "i_" + i + "_" + j;
                int resId = getResources().getIdentifier(cellId, "id", getPackageName());
                LinearLayout cell = findViewById(resId);
                cell.setBackgroundColor(Color.TRANSPARENT);
            }
        }
        int[][] grid = game.getGrid();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                if (grid[i][j] != 0) {
                    String cellId = "i_" + i + "_" + j;
                    int resId = getResources().getIdentifier(cellId, "id", getPackageName());
                    LinearLayout cell = findViewById(resId);
                    cell.setBackgroundColor(Color.BLACK);
                }
            }
        }

        BaseShape currentShape = game.getCurrentShape();
        if (currentShape != null) {
            int[][] shapeCoords = currentShape.getCoord();
            int centerX = currentShape.getCenterX();
            int centerY = currentShape.getCenterY();

            for (int[] coord : shapeCoords) {
                int x = centerX + coord[0];
                int y = centerY + coord[1];

                if (y >= 0 && y < 10 && x >= 0 && x < 6) {
                    String cellId = "i_" + y + "_" + x;
                    int resId = getResources().getIdentifier(cellId, "id", getPackageName());
                    LinearLayout cell = findViewById(resId);
                    cell.setBackgroundColor(Color.BLACK);
                }
            }
        }
    }
}