package com.example.backgammon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityEinstellungen extends AppCompatActivity {


    private SwitchCompat switchCompat;
    private Dialog dialog;
    private TextView txtClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.spielsound);

    switchCompat = (SwitchCompat) findViewById(R.id.switchButton);
    switchCompat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (switchCompat.isChecked()) {
                mediaPlayer.start();
            } else {
                mediaPlayer.pause();
            }
        }
    });

    dialog = new Dialog(this);

    }
    //hier wurde da erscheinen des PopUp's anders gestaltet als in 'ActivityMehrspieler'
    //hier wurde das PopUp durch ein layout (spielregelPopup) erstellt in Act.Mehrspieler durch eine klasse'PopUp'
    //deshalb konnte man in der act.Mehrsp. die Klasse direkt aufrufen was hier anders durch die Methode ShowPopup gelöst wurde

    public void ShowPopup (View v){
        dialog.setContentView(R.layout.spielregelpopup);
        dialog.show();
        txtClose = (TextView) dialog.findViewById(R.id.txtViewClose);
        txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }




    }


