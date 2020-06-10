package com.example.backgammon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Method;
import java.util.Random;

//import static com.example.backgammon.ActivityEinzelspieler.rollDice1;

public class ActivityMehrspieler extends AppCompatActivity {


    private int Player1Points;
    private int Player2Points;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    private Button rollDice;
    private Button btnAufgeben;
    private ImageView imageViewWuerfel1;
    private ImageView imageViewWuerfel2;
    public static final Random RANDOM = new Random();
    public ImageView w1,w2,w3,w4,w5,w6,w7,w8,w9,w10,w11,w12,w13,w14,w15,  s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15;
    public TextView txt;
    public LinearLayout layout13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mehrspieler);

        for (int i = 0; i < 15; i++) {
           findViewById(R.id.weisserstein1 + i).setOnTouchListener(new MyTouchListener());
        }
        for (int j = 0; j < 15; j++) {
          findViewById(R.id.schwarzerstein1 + j).setOnTouchListener(new MyTouchListener());
        }

        findViewById(R.id.ll1).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll2).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll3).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll4).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll5).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll6).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll7).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll8).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll9).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll10).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll11).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll12).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll15).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll16).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll17).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll18).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll19).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll20).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll21).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll22).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll23).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll24).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll25).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll26).setOnDragListener(new MyDragListener());
        layout13 = (LinearLayout) findViewById(R.id.ll13);
        txt = (TextView) findViewById(R.id.textView);
        w1 = (ImageView) findViewById(R.id.weisserstein1);
        w2 = (ImageView) findViewById(R.id.weisserstein2);
        w3 = (ImageView) findViewById(R.id.weisserstein3);
        w4 = (ImageView) findViewById(R.id.weisserstein4);
        w5 = (ImageView) findViewById(R.id.weisserstein5);
        w6 = (ImageView) findViewById(R.id.weisserstein6);
        w7 = (ImageView) findViewById(R.id.weisserstein7);
        w8 = (ImageView) findViewById(R.id.weisserstein8);
        w9 = (ImageView) findViewById(R.id.weisserstein9);
        w10 = (ImageView) findViewById(R.id.weisserstein10);
        w11 = (ImageView) findViewById(R.id.weisserstein11);
        w12 = (ImageView) findViewById(R.id.weisserstein12);
        w13 = (ImageView) findViewById(R.id.weisserstein13);
        w14 = (ImageView) findViewById(R.id.weisserstein14);
        w15 = (ImageView) findViewById(R.id.weisserstein15);


        s1 = (ImageView) findViewById(R.id.schwarzerstein1);
        s2 = (ImageView) findViewById(R.id.schwarzerstein2);
        s3 = (ImageView) findViewById(R.id.schwarzerstein3);
        s4 = (ImageView) findViewById(R.id.schwarzerstein4);
        s5 = (ImageView) findViewById(R.id.schwarzerstein5);
        s6 = (ImageView) findViewById(R.id.schwarzerstein6);
        s7 = (ImageView) findViewById(R.id.schwarzerstein7);
        s8 = (ImageView) findViewById(R.id.schwarzerstein8);
        s9 = (ImageView) findViewById(R.id.schwarzerstein9);
        s10 = (ImageView) findViewById(R.id.schwarzerstein10);
        s11 = (ImageView) findViewById(R.id.schwarzerstein11);
        s12 = (ImageView) findViewById(R.id.schwarzerstein12);
        s13 = (ImageView) findViewById(R.id.schwarzerstein13);
        s14 = (ImageView) findViewById(R.id.schwarzerstein14);
        s15 = (ImageView) findViewById(R.id.schwarzerstein15);


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


        //Button zum Aufgeben, damit ein extra PopUpWindow erscheint
        btnAufgeben = (Button) findViewById(R.id.btnAufgeben);
        btnAufgeben.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpopupinformation();
            }
        });


        //Für Spielstand aber noch nicht vollständig
        textViewPlayer1 = findViewById(R.id.textViewSie);
        textViewPlayer2 = findViewById(R.id.textViewGegner);


    }


    public static int rollDice1() {
        return RANDOM.nextInt(6) + 1;
    }

    private final class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.VISIBLE);
                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {


        @SuppressLint("ResourceType")
        @Override
        public boolean onDrag(View v, DragEvent event) {

            sete();


            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:
                    //Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    // LinearLayout container = (LinearLayout) v;
                    // container.addView(view);

                    LinearLayout linearLayouts1 = (LinearLayout) v;
                    linearLayouts1.getId();


                    String name = linearLayouts1.toString();


    for (int i=0; i<10; i++) {
   // for (int j=0; j<10; j++){
    if (name.contains("ll" + i )) {


        if (view.getId() <= 15) {
            if ((linearLayouts1.getChildAt(0) == null) && (linearLayouts1.getChildAt(1) == null)) {
                linearLayouts1.addView(view);

            } else if ((linearLayouts1.getChildAt(0).getId() >= 16) && (linearLayouts1.getChildAt(1) == null)) {
                View vv = linearLayouts1.getChildAt(0);
                linearLayouts1.removeAllViews();
                linearLayouts1.addView(view);
                layout13.addView(vv);
            } else if ((linearLayouts1.getChildAt(0).getId() >= 16) && (linearLayouts1.getChildAt(1).getId() >= 16)) {
                owner.addView(view);
                return false;
            } else if ((linearLayouts1.getChildAt(0).getId() <= 15) && (linearLayouts1.getChildAt(1) == null)) {
                linearLayouts1.addView(view);
            } else if ((linearLayouts1.getChildAt(0).getId() <= 15) && (linearLayouts1.getChildAt(2) == null)) {
                linearLayouts1.addView(view);
            } else if ((linearLayouts1.getChildAt(0).getId() <= 15) && (linearLayouts1.getChildAt(3) == null)) {
                linearLayouts1.addView(view);
            } else if ((linearLayouts1.getChildAt(0).getId() <= 15) && (linearLayouts1.getChildAt(4) == null)) {
                linearLayouts1.addView(view);
            }


        } else if (view.getId() >= 16) {
            if ((linearLayouts1.getChildAt(0) == null) && (linearLayouts1.getChildAt(1) == null)) {
                linearLayouts1.addView(view);
            } else if ((linearLayouts1.getChildAt(0).getId() <= 15) && (linearLayouts1.getChildAt(1) == null)) {
                View vv = linearLayouts1.getChildAt(0);
                linearLayouts1.removeAllViews();
                linearLayouts1.addView(view);
                layout13.addView(vv);
            } else if ((linearLayouts1.getChildAt(0).getId() <= 15) && (linearLayouts1.getChildAt(1).getId() <= 15)) {
                owner.addView(view);
                return false;
            } else if ((linearLayouts1.getChildAt(0).getId() >= 15) && (linearLayouts1.getChildAt(1) == null)) {
                linearLayouts1.addView(view);
            } else if ((linearLayouts1.getChildAt(0).getId() >= 15) && (linearLayouts1.getChildAt(2) == null)) {
                linearLayouts1.addView(view);
            } else if ((linearLayouts1.getChildAt(0).getId() >= 15) && (linearLayouts1.getChildAt(3) == null)) {
                linearLayouts1.addView(view);
            } else if ((linearLayouts1.getChildAt(0).getId() >= 15) && (linearLayouts1.getChildAt(4) == null)) {
                linearLayouts1.addView(view);
            }
        }

    }}
            view.setVisibility(View.VISIBLE);
            break;

            case DragEvent.ACTION_DRAG_ENDED:


            default:
            break;
        }
            return true;
    }}


    public void openpopupinformation() {
        PopUp popUp = new PopUp();
        popUp.show(getSupportFragmentManager(), "popup");


    }

    @SuppressLint("ResourceType")
    public void sete() {

        w1.setId(1);
        w2.setId(2);
        w3.setId(3);
        w4.setId(4);
        w5.setId(5);
        w6.setId(6);
        w7.setId(7);
        w8.setId(8);
        w9.setId(9);
        w10.setId(10);
        w11.setId(11);
        w12.setId(12);
        w13.setId(13);
        w14.setId(14);
        w15.setId(15);

        s1.setId(16);
        s2.setId(17);
        s3.setId(18);
        s4.setId(19);
        s5.setId(20);
        s6.setId(21);
        s7.setId(22);
        s8.setId(23);
        s9.setId(24);
        s10.setId(25);
        s11.setId(26);
        s12.setId(27);
        s13.setId(28);
        s14.setId(29);
        s15.setId(30);

        //txt.setText((String) "" + w5.getId());
    }
}







