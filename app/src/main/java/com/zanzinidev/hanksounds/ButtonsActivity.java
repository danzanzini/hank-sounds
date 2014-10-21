package com.zanzinidev.hanksounds;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.File;

public class ButtonsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        final ImageButton booyahButton = (ImageButton) findViewById(R.id.booyah_button);
        booyahButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playSound(R.raw.booyah);
            }
        });

        final ImageButton naileditButton = (ImageButton) findViewById(R.id.nailedit_button);
        naileditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playSound(R.raw.nailedit);
            }
        });


        final ImageButton madafakaButton = (ImageButton) findViewById(R.id.madafaka_button);
        madafakaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playSound(R.raw.madafaka_big);
            }
        });
    }

    private void playSound(int sound){

        MediaPlayer mp = MediaPlayer.create(this, sound);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }

        });
        mp.start();

    }
}
