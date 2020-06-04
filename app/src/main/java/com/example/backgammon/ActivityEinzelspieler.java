package com.example.backgammon;

import androidx.appcompat.app.AppCompatActivity;

import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class ActivityEinzelspieler extends AppCompatActivity {

    private LinearLayout[][] linearLayouts = new LinearLayout[3][2];
    public ImageView stein1;
    private boolean player1Turn = true;
    public LinearLayout LinearLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einzelspieler);


        linearLayouts[0][0] = (LinearLayout) findViewById(R.id.ll_00);
        linearLayouts[1][0] = (LinearLayout) findViewById(R.id.ll_01);

      ImageView neu = new ImageView(this);
      neu.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
      neu.setImageResource(R.drawable.weisserstein);
      linearLayouts[0][0].addView(neu);



    }
}



        /*for (int i = 0; i < 0; i++) {
            for (int j = 0; j < 0; j++) {
                String layoutID = "ll_" + i + j;
                int resID = getResources().getIdentifier(layoutID, "id", getPackageName());
                linearLayouts[i][j] = findViewById(resID);
                linearLayouts[0][0].addView(stein1);
               // LinearLayout3.addView(linearLayouts[0][0]);

            }

        }
    }
}
    /*
    @Override
    public void onClick(View v) {
        if (!((LinearLayout) v).getContext().toString().equals("")) {
            return;
        }
        if (player1Turn){
            ((LinearLayout) v).setContextClickable(true);
        }
    }
}

     */