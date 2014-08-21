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
public class NaileditAppWidget extends AppWidgetProvider {

    public static String PLAY_NAILEDIT_ACTION = "PlayNaileditAction";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.nailedit_app_widget);

        Intent active = new Intent(context, NaileditAppWidget.class);
        active.setAction(PLAY_NAILEDIT_ACTION);
        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        remoteViews.setOnClickPendingIntent (R.id.nailedit_widget_button, actionPendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(PLAY_NAILEDIT_ACTION)) {
            MediaPlayer mPlay = MediaPlayer.create(context, R.raw.nailedit);
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


