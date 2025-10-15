package com.example.tetris.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tetris.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart  =  findViewById(R.id.button5);
        buttonStart.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, secondActivity.class);
            startActivity(intent);
        });
    }

}