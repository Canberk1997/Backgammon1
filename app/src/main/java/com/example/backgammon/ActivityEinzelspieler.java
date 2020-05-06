package com.example.backgammon;

import androidx.appcompat.app.AppCompatActivity;

import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ActivityEinzelspieler extends AppCompatActivity {

    private Button rollDice;
    private ImageView imageViewWuerfel1;
    private ImageView imageViewWuerfel2;
    public static final Random RANDOM = new Random();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einzelspieler);

        rollDice = (Button) findViewById(R.id.rollDice);

        imageViewWuerfel1 = (ImageView) findViewById(R.id.image_view_wuerfel1);
        imageViewWuerfel2 = (ImageView) findViewById(R.id.image_view_wuerfel2);

        rollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int Wert1 = rollDice1();
              int Wert2 = rollDice1();

              int res1 = getResources().getIdentifier("wuerfel" + Wert1, "drawable", "com.example.backgammon");
              int res2 = getResources().getIdentifier("wuerfel" + Wert2, "drawable", "com.example.backgammon");

              imageViewWuerfel1.setImageResource(res1);
              imageViewWuerfel2.setImageResource(res2);
            }
        });

    }

    public static int rollDice1() {
        return RANDOM.nextInt(6) + 1;
    }
}
