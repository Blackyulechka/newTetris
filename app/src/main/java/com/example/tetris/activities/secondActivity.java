package com.example.tetris.activities;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tetris.R;
import com.example.tetris.TetrisGame.TetrisGame;

public class secondActivity extends AppCompatActivity {

    private TetrisGame game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        game = new TetrisGame();


        findViewById(R.id.buttonLeft).setOnClickListener(v -> game.moveLeft());
        findViewById(R.id.buttonRight).setOnClickListener(v -> game.moveRight());
        findViewById(R.id.buttonDown).setOnClickListener(v -> game.moveDown());
        findViewById(R.id.buttonRotate).setOnClickListener(v -> game.moveRotate());
    }
}