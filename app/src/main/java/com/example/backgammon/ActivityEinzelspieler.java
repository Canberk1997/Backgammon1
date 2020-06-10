package com.example.backgammon;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.media.ImageReader;
import android.os.Build;
import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class ActivityEinzelspieler extends AppCompatActivity {

    public LinearLayout[][] linearLayouts = new LinearLayout[50][50];
    public ImageView stein1 ;
    private boolean player1Turn = true;
    public LinearLayout LinearLayout3;
    public ImageView s1 ;
    public TextView tv;

   // public ImageView w1 = new ImageView(this);
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einzelspieler);
      //setContentView(R.layout.activity_test);

    tv = (TextView)findViewById(R.id.textView);

        linearLayouts[0][0] = (LinearLayout) findViewById(R.id.ll_01);
        linearLayouts[0][1] = (LinearLayout) findViewById(R.id.ll_02);

        linearLayouts[1][2] = (LinearLayout) findViewById(R.id.ll_12);
        linearLayouts[1][1] = (LinearLayout) findViewById(R.id.ll_11);

        ImageView w1 = new ImageView(this);
        w1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        w1.setImageResource(R.drawable.weissterstein1);
        linearLayouts[0][0].addView(w1);
        w1.setId(01);

        ImageView w2 = new ImageView(this);
        w2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        w2.setImageResource(R.drawable.weissterstein1);
        linearLayouts[0][1].addView(w2);
        w2.setId(02);



        ImageView s1 = new ImageView(this);
        s1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        s1.setImageResource(R.drawable.schwarzerstein1);
        linearLayouts[1][2].addView(s1);
        s1.setId(21);

        ImageView s2 = new ImageView(this);
        s2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        s2.setImageResource(R.drawable.schwarzerstein1);
        linearLayouts[1][1].addView(s2);
        s2.setId(22);

        w1.setOnTouchListener(new MyTouchListener());
        w2.setOnTouchListener(new MyTouchListener());
        s1.setOnTouchListener(new MyTouchListener());
        s2.setOnTouchListener(new MyTouchListener());


        findViewById(R.id.ll_01).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_02).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_03).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_04).setOnDragListener(new MyDragListener());

        findViewById(R.id.ll_11).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_12).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_13).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_14).setOnDragListener(new MyDragListener());

        findViewById(R.id.ll_21).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_22).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_23).setOnDragListener(new MyDragListener());
        findViewById(R.id.ll_24).setOnDragListener(new MyDragListener());

    }

    private final class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                        v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.VISIBLE);
                return true;
            }
            else {
                return false;
            }
        }
    }

    class MyDragListener implements View.OnDragListener {


        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public boolean onDrag(View v, DragEvent event) {

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
                    LinearLayout linearLayouts1= (LinearLayout) v;



                                 linearLayouts1.getId();

                    String name = linearLayouts1.toString();
                    if(name.contains("ll_21")) {



                            if (linearLayouts1.getChildAt(0) == null) {
                                linearLayouts1.addView(view);
                            } else if (
                                    linearLayouts1.getChildAt(0) != null) {

                                owner.addView(view);
                                return false;
                            }

                    }

                    if (name.contains("ll_22")) {
                        if (linearLayouts1.getChildAt(0) == null) {
                            linearLayouts1.addView(view);
                        } else if (
                                linearLayouts1.getChildAt(0) != null) {
                            owner.addView(view);
                            return false;

                        }

                    }
                    if (name.contains("ll_23")) {
                            if (linearLayouts1.getChildAt(0) == null) {
                                linearLayouts1.addView(view);
                            }
                            else if(
                                linearLayouts1.getChildAt(0) != null) {
                                owner.addView(view);
                                return false;
                        }


                    }






                    view.setVisibility(View.VISIBLE);

                case DragEvent.ACTION_DRAG_ENDED:


                default:
                    break;
            }
            return true;
        }

    }
}

//  if (linearLayouts1.getChildAt(0).getId() == (int) 1  ) {
//    linearLayouts1.removeAllViews();

//}
//  if (linearLayouts1.getChildAt(1).getId() == (int) 2  )    {
//     linearLayouts1.removeAllViews();
//tv.setText(""+ linearLayouts1);
//tv.setText(""+ linearLayouts1);
//  if (linearLayouts1.getChildAt(0).getId() == (int) 1  ) {
//    linearLayouts1.removeAllViews();
//}
//  if (linearLayouts1.getChildAt(1).getId() == (int) 2  )    {
//     linearLayouts1.removeAllViews();
//tv.setText(""+ linearLayouts1);
//tv.setText(""+ linearLayouts1);


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