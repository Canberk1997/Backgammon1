package com.example.backgammon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

private Button btnEinstellungen;
private Button btnEinzelSpieler;
private Button btnMehrSpieler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEinstellungen = (Button) findViewById(R.id.btnEinstellungen);
        btnEinstellungen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityEinstellungen();
            }
        });

        btnEinzelSpieler = (Button) findViewById(R.id.btnEinzelSpieler);
        btnEinzelSpieler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             openActivityEinzelspieler();
            }
        });

        btnMehrSpieler = findViewById(R.id.btnMehrSpieler);
        btnMehrSpieler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opeenActivityMehrSpieler();
            }
        });

        }
        public void openActivityEinstellungen () {
            Intent intent = new Intent(this, ActivityEinstellungen.class);
            startActivity(intent);
        }

        public void openActivityEinzelspieler(){
            Intent intent = new Intent(this,ActivityEinzelspieler.class);
            startActivity(intent);
        }

        public void opeenActivityMehrSpieler(){
            Intent intent = new Intent(this, ActivityMehrspieler.class);
            startActivity(intent);
        }
    }

























