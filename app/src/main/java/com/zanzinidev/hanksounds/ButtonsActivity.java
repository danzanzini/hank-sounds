package com.zanzinidev.hanksounds;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class ButtonsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        final Button booyahButton = (Button) findViewById(R.id.booyah);
        booyahButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playSound(R.raw.booyah);
            }
        });

        final Button naileditButton = (Button) findViewById(R.id.nailedIt);
        naileditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playSound(R.raw.nailedit);
            }
        });

        final Button madafakaBigButton = (Button) findViewById(R.id.madafaka_big);
        madafakaBigButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playSound(R.raw.madafaka_big);
            }
        });

        final Button madafakaButton = (Button) findViewById(R.id.madafaka);
        madafakaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playSound(R.raw.madafaka);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buttons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
