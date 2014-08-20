package com.zanzinidev.hanksounds;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.RemoteViews;


/**
 * Implementation of App Widget functionality.
 */
public class MadafakaAppWidget extends AppWidgetProvider {

    public static String PLAY_MADAFAKA_ACTION = "PlaySoundAction";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.madafaka_app_widget);

        Intent active = new Intent(context, MadafakaAppWidget.class);
        active.setAction(PLAY_MADAFAKA_ACTION);
        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        remoteViews.setOnClickPendingIntent (R.id.madafaka_widget, actionPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PLAY_MADAFAKA_ACTION)) {
            MediaPlayer mPlay = MediaPlayer.create(context, R.raw.madafaka);
            mPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
            mPlay.start();
        }
        super.onReceive(context, intent);
    }

}


