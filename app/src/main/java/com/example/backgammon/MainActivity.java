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

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

private Button btnEinstellungen;
private Button btnEinzelSpieler;
private Button btnMehrSpieler;
private EditText nameInput;


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

            writeFB("charlie");

        }

        public void opeenActivityMehrSpieler(){
            Intent intent = new Intent(this, ActivityMehrspieler.class);
            startActivity(intent);
        }


        public void writeFB(String name){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        db.getReference(name+"/whiteStone/00").setValue(4);

        }



        public void writeFB(){

            FirebaseDatabase database = FirebaseDatabase.getInstance();
          //  DatabaseReference myRef = database.getReference("Spielbrett/whiteStone/00");


            database.getReference("Spielfeld/whiteStone/00").setValue(2);
            database.getReference("Spielfeld/whiteStone/11").setValue(5);
            database.getReference("Spielfeld/whiteStone/16").setValue(3);
            database.getReference("Spielfeld/whiteStone/18").setValue(5);
            database.getReference("Spielfeld/whiteStone/01").setValue(0);
            database.getReference("Spielfeld/whiteStone/02").setValue(0);
            database.getReference("Spielfeld/whiteStone/03").setValue(0);
            database.getReference("Spielfeld/whiteStone/04").setValue(0);
            database.getReference("Spielfeld/whiteStone/05").setValue(0);
            database.getReference("Spielfeld/whiteStone/06").setValue(0);
            database.getReference("Spielfeld/whiteStone/07").setValue(0);
            database.getReference("Spielfeld/whiteStone/08").setValue(0);
            database.getReference("Spielfeld/whiteStone/09").setValue(0);
            database.getReference("Spielfeld/whiteStone/10").setValue(0);
            database.getReference("Spielfeld/whiteStone/12").setValue(0);
            database.getReference("Spielfeld/whiteStone/13").setValue(0);
            database.getReference("Spielfeld/whiteStone/14").setValue(0);
            database.getReference("Spielfeld/whiteStone/15").setValue(0);
            database.getReference("Spielfeld/whiteStone/17").setValue(0);
            database.getReference("Spielfeld/whiteStone/19").setValue(0);
            database.getReference("Spielfeld/whiteStone/20").setValue(0);
            database.getReference("Spielfeld/whiteStone/21").setValue(0);
            database.getReference("Spielfeld/whiteStone/22").setValue(0);
            database.getReference("Spielfeld/whiteStone/23").setValue(0);


//alternativ in for schleife

            for(int i = 0; i<24; i++){

                if(i == 4){
                    database.getReference("Spielfeld/blackStone/"+i).setValue(3);
                }if(i == ( 7 | 12)){
                    database.getReference("Spielfeld/blackStone/"+i).setValue(5);
                }if(i == 23){
                    database.getReference("Spielfeld/blackStone/"+i).setValue(2);
                } else {
                    database.getReference("Spielfeld/blackStone/"+i).setValue(0);
                }
            }

            database.getReference("Spielfeld/blackStone/00").setValue(0);
            database.getReference("Spielfeld/blackStone/11").setValue(0);
            database.getReference("Spielfeld/blackStone/16").setValue(0);
            database.getReference("Spielfeld/blackStone/18").setValue(0);
            database.getReference("Spielfeld/blackStone/01").setValue(0);
            database.getReference("Spielfeld/blackStone/02").setValue(0);
            database.getReference("Spielfeld/blackStone/03").setValue(0);
            database.getReference("Spielfeld/blackStone/04").setValue(3);
            database.getReference("Spielfeld/blackStone/05").setValue(0);
            database.getReference("Spielfeld/blackStone/06").setValue(0);
            database.getReference("Spielfeld/blackStone/07").setValue(5);
            database.getReference("Spielfeld/blackStone/08").setValue(0);
            database.getReference("Spielfeld/blackStone/09").setValue(0);
            database.getReference("Spielfeld/blackStone/10").setValue(0);
            database.getReference("Spielfeld/blackStone/12").setValue(5);
            database.getReference("Spielfeld/blackStone/13").setValue(0);
            database.getReference("Spielfeld/blackStone/14").setValue(0);
            database.getReference("Spielfeld/blackStone/15").setValue(0);
            database.getReference("Spielfeld/blackStone/17").setValue(0);
            database.getReference("Spielfeld/blackStone/19").setValue(0);
            database.getReference("Spielfeld/blackStone/20").setValue(0);
            database.getReference("Spielfeld/blackStone/21").setValue(0);
            database.getReference("Spielfeld/blackStone/22").setValue(0);
            database.getReference("Spielfeld/blackStone/23").setValue(2);

        }

    }

























