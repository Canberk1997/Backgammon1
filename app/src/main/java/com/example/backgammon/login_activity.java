package com.example.backgammon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;

public class login_activity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.backgammon.EXTRA_TEXT";
    private Button btnStart;
    public String name1;
    public EditText beispielname;
    public String name;
    public TextView title;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        title = (TextView) findViewById(R.id.editName);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openMainActivity();

            }

        });
    }


    public void openMainActivity() {

        //Textübernahme in nächste Activity
        EditText editName = (EditText) findViewById(R.id.editName);
        String texteingabe = editName.getText().toString();

        //bei Button klick öffnen der neuen Activity
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT, texteingabe);
        startActivity(intent);

    }


}
