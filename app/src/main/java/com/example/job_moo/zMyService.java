package com.example.job_moo;

import android.app.NotificationChannel;
import android.app.Service;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import android.graphics.BitmapFactory;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class zMyService extends Service {
    private int num = 0;

    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
    String dateHour = sdf1.format(date);
    SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
    String dateMinute = sdf2.format(date);

    public static String rhr = "01";
    public static String rmn;
    public static String tmp;
    public static String test1 = "00";

    public static int tFlag = 0;

    public static String test;
    public static String enume;
    public static String userKey;

    public static String caller;
    public static String title;
    public static String week = "00";
    public static String hour;
    public static String min;
    public static String place1;
    public static String place2;
    public static String cost;
    public static String written;
    public static String muxed;
    public static String dead;
    public static String detail;

    public  String userName;


    private String doDayOfWeek(){
        Calendar cal = Calendar.getInstance();
        String strWeek = null;
        int nWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (nWeek == 1){
            strWeek = "일요일";
        }
        else if (nWeek == 2){
            strWeek = "월요일";
        }
        else if (nWeek == 3){
            strWeek = "화요일";
        }
        else if (nWeek == 4){
            strWeek = "수요일";
        }
        else if (nWeek == 5){
            strWeek = "목요일";
        }
        else if (nWeek == 6){
            strWeek = "금요일";
        }
        else if (nWeek == 7){
            strWeek = "토요일";
        }
        return strWeek;
    }

    private Thread mThread;

    public zMyService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();

    }


    private static final String TAG = zMyService.class.getSimpleName();



    public int i;
    @Override
    public int onStartCommand(final Intent intent, int flags, final int startId){
        super.onStartCommand(intent, flags, startId);


        if(mThread == null){
            mThread = new Thread("My Thread"){

                String tempo = intent.getStringExtra("user");
                String userID = tempo.replace(".", ",");


                @Override
                public void run(){

                    userName = userID;
/*
                    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
                    DatabaseReference rClass = database1.getReference("test");
                    rClass.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {

                            test = dataSnapshot.getValue().toString();
                            enume = "{" + "id" + "=" + userID + "}";

                            if(test.equals(enume)) {
                                userKey = dataSnapshot.getKey();
                                Toast.makeText(getApplicationContext(), userKey, Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                        }
                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {}

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                        @Override
                        public void onCancelled(DatabaseError databaseError) {}
                    });
*/

                    for (i = 0; i < 10000; i++){
                        try {
                            Thread.sleep(3000);
                        }
                        catch (InterruptedException e){
                            break;
                        }
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference rHour = database.getReference("Post");
                        rHour.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                rhr = dataSnapshot.getValue().toString();

                                String[] parsing = rhr.split("_");
                                test1 = parsing[3];

                                caller = parsing[0];
                                title = parsing[1];
                                week = parsing[2];
                                hour = parsing[3];
                                //min = parsing[4];
                                place1 = parsing[5];
                                //place2 = parsing[6];
                                cost = parsing[7];
                                //written = parsing[8];
                                //muxed = parsing[9];
                                //dead = parsing[10];
                                //detail = parsing[11];


                                //test1 = rhr.substring(rhr.lastIndexOf("_") + 1);
                                //Toast.makeText(getApplicationContext(), test1, Toast.LENGTH_SHORT).show();

                            }
                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                            }
                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) {}

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                            @Override
                            public void onCancelled(DatabaseError databaseError) {}
                        });



                        DatabaseReference rMatch = database.getReference("class").child(userID).child(week).child(test1);
                        rMatch.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();

                                //Toast.makeText(getApplicationContext(), userID, Toast.LENGTH_SHORT).show();
                                //Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_SHORT).show();

                                if(tmp.equals("")){
                                    //Toast.makeText(getApplicationContext(), "stop", Toast.LENGTH_SHORT).show();
                                    tFlag = 1;
                                    i = 100000;
                                    stopSelf();
                                }
                            }
                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                            }
                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) {}

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                            @Override
                            public void onCancelled(DatabaseError databaseError) {}
                        });


                        DatabaseReference rApply = database.getReference("Apply").child(userID);
                        rApply.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                rmn = dataSnapshot.getValue().toString();
                                //Toast.makeText(getApplicationContext(), rmn, Toast.LENGTH_SHORT).show();
                                if(rmn.equals("click")){
                                    tFlag = 2;
                                    i = 100000;
                                    stopSelf();
                                }
                            }
                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                            }
                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) {}

                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

                            @Override
                            public void onCancelled(DatabaseError databaseError) {}
                        });


                    }
                }
            };
            mThread.start();
        }


        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        //Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
        createNotification();

    }


    private void createNotification(){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");

        if(tFlag == 1) {
            Intent intent3 = new Intent(this, Why.class);
            intent3.putExtra("user", userName);
            intent3.putExtra("msg", rhr);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent3, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentTitle(title);
            builder.setContentText(cost + "/" + hour + "/" + place1);
            builder.setColor(Color.BLUE);
            builder.setAutoCancel(true);
            builder.setContentIntent(pendingIntent);
        }
        if(tFlag == 2) {
            Intent intent4 = new Intent(this, WordActivity.class);
            intent4.putExtra("user", userName);
            intent4.putExtra("maker", userName);
            PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 0, intent4, PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentTitle("요청이 수락됨");
            builder.setContentText(title);
            builder.setColor(Color.RED);
            builder.setAutoCancel(true);
            builder.setContentIntent(pendingIntent2);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference();
            myRef.child("Apply").child(userName).child("-").setValue("");

        }


        NotificationManager notificationManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }

        notificationManager.notify(1, builder.build());

    }



}
