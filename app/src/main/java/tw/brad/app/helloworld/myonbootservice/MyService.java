package tw.brad.app.helloworld.myonbootservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;


public class MyService extends Service {
    private Timer timer;
    private NotificationManager nmgr;
    private int i;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nmgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        timer = new Timer();
        timer.schedule(new MyTask(), 0, 10*1000);
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            sendNotice();
        }
    }

    private void sendNotice(){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("xxxxxx");
        builder.setLights(Color.argb(255,0,255,0),200,500);
        builder.setContentTitle("標題" + i++);
        builder.setContentText("Content");
        builder.setAutoCancel(true);


        Notification notification = builder.build();

        nmgr.notify(i,notification);

    }

}
