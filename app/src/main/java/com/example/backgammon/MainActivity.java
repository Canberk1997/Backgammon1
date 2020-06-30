package com.example.backgammon;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

private Button btnEinstellungen;
private Button btnEinzelSpieler;
private Button btnMehrSpieler;
public String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Textausgabe mit Name bis Zeile 46

        Intent i = getIntent();
        String texteingabe = getIntent().getStringExtra(login_activity.EXTRA_TEXT);
        name = texteingabe;
        TextView textausgabe = (TextView) findViewById(R.id.textausgabe);
        textausgabe.setText("Hallo "+ texteingabe + ", Willkommen auf unserer App");
        btnEinstellungen = (Button) findViewById(R.id.btnEinstellungen);
        btnEinstellungen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityEinstellungen();
            }
        });


       btnEinzelSpieler = (Button) findViewById(R.id.btnEinzelspieler);
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
            writeFB(name);
        }

        public void opeenActivityMehrSpieler(){
            Intent intent = new Intent(this, ActivityMehrspieler.class);
            startActivity(intent);
            writeFB(name);
        }

        public void writeFB(String name){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
            for(int i = 0; i<24; i++){
                if(i == 4){
                    db.getReference(name+"/blackStone/"+i).setValue(3);
                }else if(i == 12){
                    db.getReference(name+"/blackStone/"+i).setValue(5);
                }else if(i == 7){
                    db.getReference(name+"/blackStone/"+i).setValue(5);
                }
                else if(i == 23){
                    db.getReference(name+"/blackStone/"+i).setValue(2);
                } else {
                    db.getReference(name+"/blackStone/"+i).setValue(0);
                }
            }
            for(int i = 0; i<24; i++){

                if(i == 0){
                    db.getReference(name+"/whiteStone/"+i).setValue(2);
                }else if(i == 11){
                    db.getReference(name+"/whiteStone/"+i).setValue(5);
                }else if(i == 18){
                    db.getReference(name+"/whiteStone/"+i).setValue(5);
                }
                else if(i == 16){
                    db.getReference(name+"/whiteStone/"+i).setValue(3);
                } else {
                    db.getReference(name+"/whiteStone/"+i).setValue(0);
                }
            }
    }
    }