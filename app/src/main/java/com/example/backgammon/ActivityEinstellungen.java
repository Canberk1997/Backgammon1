package com.example.backgammon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityEinstellungen extends AppCompatActivity {

    private Button btnSoundStart;
    private Button btnSoundEnd;
    private SwitchCompat switchCompat;
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
    }
}
