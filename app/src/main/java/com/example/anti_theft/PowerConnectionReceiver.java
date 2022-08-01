package com.example.anti_theft;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    public PowerConnectionReceiver(MediaPlayer mediaPlayer) {
//        super();
//        this.context = context;
//        Log.d("abc","ye1");
        this.mp = mediaPlayer;
    }

    @Override
    public IBinder peekService(Context myContext, Intent service) {
        return super.peekService(myContext, service);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("abc","ye2");

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Log.d("abc","charging");
            Toast.makeText(context, "The device is charging", Toast.LENGTH_SHORT).show();

//            mp.pause();



        } else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){;
            Log.d("abc","not charging");
            Toast.makeText(context, "The device is not charging", Toast.LENGTH_SHORT).show();

            mp.setLooping(true);
            mp.start();

        }
    }

}
