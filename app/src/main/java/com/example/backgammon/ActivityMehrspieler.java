package com.example.backgammon;

import androidx.appcompat.app.AppCompatActivity;

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

import java.lang.reflect.Method;
import java.util.Random;

import static com.example.backgammon.ActivityEinzelspieler.rollDice1;

public class ActivityMehrspieler extends Activity {

    private Button rollDice;
    private ImageView imageViewWuerfel1;
    private ImageView imageViewWuerfel2;
    public static final Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mehrspieler);

        findViewById(R.id.profile_image1).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image2).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image3).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image4).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image5).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image6).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image7).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image8).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image9).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image10).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image11).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image12).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image13).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image14).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image15).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image16).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image17).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image18).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image19).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image20).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image21).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image22).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image23).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image24).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image25).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image26).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image27).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image28).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image29).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.profile_image30).setOnTouchListener(new MyTouchListener());

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
    public static int rollDice1 () {
        return RANDOM.nextInt(6) + 1;
    }

            private final class MyTouchListener implements View.OnTouchListener {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        ClipData data = ClipData.newPlainText("","");
                        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                                v);
                        v.startDrag(data, shadowBuilder, v, 0);
                        v.setVisibility(View.INVISIBLE);
                        return true;
                    }
                        else {
                            return false;
                    }
                }
            }

            class MyDragListener implements View.OnDragListener{

             Drawable enterShape = getResources().getDrawable(
                     R.drawable.shape_droptarget);
             Drawable normalShape = getResources().getDrawable(R.drawable.weissesdreieck);
                Drawable normalShape1 = getResources().getDrawable(R.drawable.schwarzesdreieck);

                @Override
                public boolean onDrag(View v, DragEvent event) {

                    int action = event.getAction();
                    switch (event.getAction()) {
                        case DragEvent.ACTION_DRAG_STARTED:
                            //do nothing
                            break;
                        case DragEvent.ACTION_DRAG_ENTERED:
                            v.setBackground(enterShape);
                            break;
                        case DragEvent.ACTION_DRAG_EXITED:
                            v.setBackground(normalShape);
                            break;
                        case DragEvent.ACTION_DROP:
                            //Dropped, reassign View to ViewGroup
                            View view = (View) event.getLocalState();
                            ViewGroup owner = (ViewGroup) view.getParent();
                            owner.removeView(view);
                            LinearLayout container = (LinearLayout) v;
                            container.addView(view);
                            view.setVisibility(View.VISIBLE);
                            break;
                        case DragEvent.ACTION_DRAG_ENDED:
                            v.setBackground(normalShape);
                            v.setBackground(normalShape1);
                        default:
                            break;
                    }
                    return true;
                }
    }
}







