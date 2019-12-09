package com.example.job_moo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.content.Intent;

import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TableActivity extends AppCompatActivity {

    TextView monClass1;
    TextView monClass2;
    TextView monClass3;
    TextView monClass4;
    TextView monClass5;
    TextView monClass6;
    TextView monClass7;
    TextView monClass8;
    TextView monClass9;
    TextView monClass10;
    TextView monClass11;
    TextView monClass12;

    TextView tueClass1;
    TextView tueClass2;
    TextView tueClass3;
    TextView tueClass4;
    TextView tueClass5;
    TextView tueClass6;
    TextView tueClass7;
    TextView tueClass8;
    TextView tueClass9;
    TextView tueClass10;
    TextView tueClass11;
    TextView tueClass12;

    TextView wedClass1;
    TextView wedClass2;
    TextView wedClass3;
    TextView wedClass4;
    TextView wedClass5;
    TextView wedClass6;
    TextView wedClass7;
    TextView wedClass8;
    TextView wedClass9;
    TextView wedClass10;
    TextView wedClass11;
    TextView wedClass12;

    TextView thuClass1;
    TextView thuClass2;
    TextView thuClass3;
    TextView thuClass4;
    TextView thuClass5;
    TextView thuClass6;
    TextView thuClass7;
    TextView thuClass8;
    TextView thuClass9;
    TextView thuClass10;
    TextView thuClass11;
    TextView thuClass12;

    TextView friClass1;
    TextView friClass2;
    TextView friClass3;
    TextView friClass4;
    TextView friClass5;
    TextView friClass6;
    TextView friClass7;
    TextView friClass8;
    TextView friClass9;
    TextView friClass10;
    TextView friClass11;
    TextView friClass12;


    //BackgroundTask task;
    int value;

    private Thread mThread;
    public int i;
    public static String rhr = "01";
    public static String rmn;
    public static String tmp;
    public static String test1 = "00";

    //public FirebaseDatabase database;
    //public String key = "mon";
    public String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        monClass1 = (TextView)findViewById(R.id.button01);
        monClass2 = (TextView)findViewById(R.id.button06);
        monClass3 = (TextView)findViewById(R.id.button11);
        monClass4 = (TextView)findViewById(R.id.button16);
        monClass5 = (TextView)findViewById(R.id.button21);
        monClass6 = (TextView)findViewById(R.id.button26);
        monClass7 = (TextView)findViewById(R.id.button31);
        monClass8 = (TextView)findViewById(R.id.button36);
        monClass9 = (TextView)findViewById(R.id.button41);
        monClass10 = (TextView)findViewById(R.id.button46);
        monClass11 = (TextView)findViewById(R.id.button51);
        monClass12 = (TextView)findViewById(R.id.button56);


        tueClass1 = (TextView)findViewById(R.id.button02);
        tueClass2 = (TextView)findViewById(R.id.button07);
        tueClass3 = (TextView)findViewById(R.id.button12);
        tueClass4 = (TextView)findViewById(R.id.button17);
        tueClass5 = (TextView)findViewById(R.id.button22);
        tueClass6 = (TextView)findViewById(R.id.button27);
        tueClass7 = (TextView)findViewById(R.id.button32);
        tueClass8 = (TextView)findViewById(R.id.button37);
        tueClass9 = (TextView)findViewById(R.id.button42);
        tueClass10 = (TextView)findViewById(R.id.button47);
        tueClass11 = (TextView)findViewById(R.id.button52);
        tueClass12 = (TextView)findViewById(R.id.button57);


        wedClass1 = (TextView)findViewById(R.id.button03);
        wedClass2 = (TextView)findViewById(R.id.button08);
        wedClass3 = (TextView)findViewById(R.id.button13);
        wedClass4 = (TextView)findViewById(R.id.button18);
        wedClass5 = (TextView)findViewById(R.id.button23);
        wedClass6 = (TextView)findViewById(R.id.button28);
        wedClass7 = (TextView)findViewById(R.id.button33);
        wedClass8 = (TextView)findViewById(R.id.button38);
        wedClass9 = (TextView)findViewById(R.id.button43);
        wedClass10 = (TextView)findViewById(R.id.button48);
        wedClass11 = (TextView)findViewById(R.id.button53);
        wedClass12 = (TextView)findViewById(R.id.button58);


        thuClass1 = (TextView)findViewById(R.id.button04);
        thuClass2 = (TextView)findViewById(R.id.button09);
        thuClass3 = (TextView)findViewById(R.id.button14);
        thuClass4 = (TextView)findViewById(R.id.button19);
        thuClass5 = (TextView)findViewById(R.id.button24);
        thuClass6 = (TextView)findViewById(R.id.button29);
        thuClass7 = (TextView)findViewById(R.id.button34);
        thuClass8 = (TextView)findViewById(R.id.button39);
        thuClass9 = (TextView)findViewById(R.id.button44);
        thuClass10 = (TextView)findViewById(R.id.button49);
        thuClass11 = (TextView)findViewById(R.id.button54);
        thuClass12 = (TextView)findViewById(R.id.button59);



        friClass1 = (TextView)findViewById(R.id.button05);
        friClass2 = (TextView)findViewById(R.id.button10);
        friClass3 = (TextView)findViewById(R.id.button15);
        friClass4 = (TextView)findViewById(R.id.button20);
        friClass5 = (TextView)findViewById(R.id.button25);
        friClass6 = (TextView)findViewById(R.id.button30);
        friClass7 = (TextView)findViewById(R.id.button35);
        friClass8 = (TextView)findViewById(R.id.button40);
        friClass9 = (TextView)findViewById(R.id.button45);
        friClass10 = (TextView)findViewById(R.id.button50);
        friClass11 = (TextView)findViewById(R.id.button55);
        friClass12 = (TextView)findViewById(R.id.button60);




        //Intent intent1 = getIntent();
        //key = intent1.getStringExtra("user");
        //String result = intent1.getStringExtra("result");

        //task = new BackgroundTask();
        //task.execute(key);



        if(mThread == null){
            mThread = new Thread("My Thread"){

                Intent intent = getIntent();
                String tempo = intent.getStringExtra("user");
                String userID = tempo.replace(".", ",");


                @Override
                public void run(){

                    for (i = 0; i < 1000000; i++){
                        try {
                            Thread.sleep(500);
                        }
                        catch (InterruptedException e){
                            break;
                        }
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference rMon09 = database.getReference("class").child(userID).child("mon").child("09");
                        rMon09.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                //Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_SHORT).show();
                                monClass1.setText(tmp);
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

                        DatabaseReference rMon10 = database.getReference("class").child(userID).child("mon").child("10");
                        rMon10.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass2.setText(tmp);
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

                        DatabaseReference rMon11 = database.getReference("class").child(userID).child("mon").child("11");
                        rMon11.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass3.setText(tmp);
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

                        DatabaseReference rMon12 = database.getReference("class").child(userID).child("mon").child("12");
                        rMon12.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass4.setText(tmp);
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

                        DatabaseReference rMon13 = database.getReference("class").child(userID).child("mon").child("13");
                        rMon13.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass5.setText(tmp);
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

                        DatabaseReference rMon14 = database.getReference("class").child(userID).child("mon").child("14");
                        rMon14.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass6.setText(tmp);
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

                        DatabaseReference rMon15 = database.getReference("class").child(userID).child("mon").child("15");
                        rMon15.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass7.setText(tmp);
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

                        DatabaseReference rMon16 = database.getReference("class").child(userID).child("mon").child("16");
                        rMon16.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass8.setText(tmp);
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

                        DatabaseReference rMon17 = database.getReference("class").child(userID).child("mon").child("17");
                        rMon17.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass9.setText(tmp);
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

                        DatabaseReference rMon18 = database.getReference("class").child(userID).child("mon").child("18");
                        rMon18.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass10.setText(tmp);
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

                        DatabaseReference rMon19 = database.getReference("class").child(userID).child("mon").child("19");
                        rMon19.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass11.setText(tmp);
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

                        DatabaseReference rMon20 = database.getReference("class").child(userID).child("mon").child("20");
                        rMon20.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                monClass12.setText(tmp);
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








                        DatabaseReference rTue09 = database.getReference("class").child(userID).child("tue").child("09");
                        rTue09.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass1.setText(tmp);
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

                        DatabaseReference rT10 = database.getReference("class").child(userID).child("tue").child("10");
                        rT10.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass2.setText(tmp);
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

                        DatabaseReference rT11 = database.getReference("class").child(userID).child("tue").child("11");
                        rT11.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass3.setText(tmp);
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

                        DatabaseReference rT12 = database.getReference("class").child(userID).child("tue").child("12");
                        rT12.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass4.setText(tmp);
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

                        DatabaseReference rT13 = database.getReference("class").child(userID).child("tue").child("13");
                        rT13.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass5.setText(tmp);
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

                        DatabaseReference rT14 = database.getReference("class").child(userID).child("tue").child("14");
                        rT14.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass6.setText(tmp);
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

                        DatabaseReference rT15 = database.getReference("class").child(userID).child("tue").child("15");
                        rT15.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass7.setText(tmp);
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

                        DatabaseReference rT16 = database.getReference("class").child(userID).child("tue").child("16");
                        rT16.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass8.setText(tmp);
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

                        DatabaseReference rT17 = database.getReference("class").child(userID).child("tue").child("17");
                        rT17.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass9.setText(tmp);
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

                        DatabaseReference rT18 = database.getReference("class").child(userID).child("tue").child("18");
                        rT18.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass10.setText(tmp);
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

                        DatabaseReference rT19 = database.getReference("class").child(userID).child("tue").child("19");
                        rT19.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass11.setText(tmp);
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

                        DatabaseReference rT20 = database.getReference("class").child(userID).child("tue").child("20");
                        rT20.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                tueClass12.setText(tmp);
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







                        DatabaseReference rW09 = database.getReference("class").child(userID).child("wed").child("09");
                        rW09.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass1.setText(tmp);
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

                        DatabaseReference rW10 = database.getReference("class").child(userID).child("wed").child("10");
                        rW10.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass2.setText(tmp);
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

                        DatabaseReference rW11 = database.getReference("class").child(userID).child("wed").child("11");
                        rW11.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass3.setText(tmp);
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

                        DatabaseReference rW12 = database.getReference("class").child(userID).child("wed").child("12");
                        rW12.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass4.setText(tmp);
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

                        DatabaseReference rW13 = database.getReference("class").child(userID).child("wed").child("13");
                        rW13.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass5.setText(tmp);
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

                        DatabaseReference rW14 = database.getReference("class").child(userID).child("wed").child("14");
                        rW14.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass6.setText(tmp);
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

                        DatabaseReference rW15 = database.getReference("class").child(userID).child("wed").child("15");
                        rW15.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass7.setText(tmp);
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

                        DatabaseReference rW16 = database.getReference("class").child(userID).child("wed").child("16");
                        rW16.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass8.setText(tmp);
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

                        DatabaseReference rW17 = database.getReference("class").child(userID).child("wed").child("17");
                        rW17.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass9.setText(tmp);
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

                        DatabaseReference rW18 = database.getReference("class").child(userID).child("wed").child("18");
                        rW18.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass10.setText(tmp);
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

                        DatabaseReference rW19 = database.getReference("class").child(userID).child("wed").child("19");
                        rW19.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass11.setText(tmp);
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

                        DatabaseReference rW20 = database.getReference("class").child(userID).child("wed").child("20");
                        rW20.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                wedClass12.setText(tmp);
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






                        DatabaseReference rH09 = database.getReference("class").child(userID).child("thu").child("09");
                        rH09.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass1.setText(tmp);
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

                        DatabaseReference rH10 = database.getReference("class").child(userID).child("thu").child("10");
                        rH10.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass2.setText(tmp);
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

                        DatabaseReference rH11 = database.getReference("class").child(userID).child("thu").child("11");
                        rH11.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass3.setText(tmp);
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

                        DatabaseReference rH12 = database.getReference("class").child(userID).child("thu").child("12");
                        rH12.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass4.setText(tmp);
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

                        DatabaseReference rH13 = database.getReference("class").child(userID).child("thu").child("13");
                        rH13.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass5.setText(tmp);
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

                        DatabaseReference rH14 = database.getReference("class").child(userID).child("thu").child("14");
                        rH14.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass6.setText(tmp);
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

                        DatabaseReference rH15 = database.getReference("class").child(userID).child("thu").child("15");
                        rH15.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass7.setText(tmp);
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

                        DatabaseReference rH16 = database.getReference("class").child(userID).child("thu").child("16");
                        rH16.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass8.setText(tmp);
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

                        DatabaseReference rH17 = database.getReference("class").child(userID).child("thu").child("17");
                        rH17.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass9.setText(tmp);
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

                        DatabaseReference rH18 = database.getReference("class").child(userID).child("thu").child("18");
                        rH18.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass10.setText(tmp);
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

                        DatabaseReference rH19 = database.getReference("class").child(userID).child("thu").child("19");
                        rH19.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass11.setText(tmp);
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

                        DatabaseReference rH20 = database.getReference("class").child(userID).child("thu").child("20");
                        rH20.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                thuClass12.setText(tmp);
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






                        DatabaseReference rF09 = database.getReference("class").child(userID).child("fri").child("09");
                        rF09.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass1.setText(tmp);
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

                        DatabaseReference rF10 = database.getReference("class").child(userID).child("fri").child("10");
                        rF10.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass2.setText(tmp);
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

                        DatabaseReference rF11 = database.getReference("class").child(userID).child("fri").child("11");
                        rF11.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass3.setText(tmp);
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

                        DatabaseReference rF12 = database.getReference("class").child(userID).child("fri").child("12");
                        rF12.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass4.setText(tmp);
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

                        DatabaseReference rF13 = database.getReference("class").child(userID).child("fri").child("13");
                        rF13.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass5.setText(tmp);
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

                        DatabaseReference rF14 = database.getReference("class").child(userID).child("fri").child("14");
                        rF14.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass6.setText(tmp);
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

                        DatabaseReference rF15 = database.getReference("class").child(userID).child("fri").child("15");
                        rF15.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass7.setText(tmp);
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

                        DatabaseReference rF16 = database.getReference("class").child(userID).child("fri").child("16");
                        rF16.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass8.setText(tmp);
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

                        DatabaseReference rF17 = database.getReference("class").child(userID).child("fri").child("17");
                        rF17.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass9.setText(tmp);
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

                        DatabaseReference rF18 = database.getReference("class").child(userID).child("fri").child("18");
                        rF18.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass10.setText(tmp);
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

                        DatabaseReference rF19 = database.getReference("class").child(userID).child("fri").child("19");
                        rF19.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass11.setText(tmp);
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

                        DatabaseReference rF20 = database.getReference("class").child(userID).child("fri").child("20");
                        rF20.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                                tmp = dataSnapshot.getValue().toString();
                                friClass12.setText(tmp);
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




/*
        Intent intentM9 = getIntent();
        String mon09 = intentM9.getStringExtra("mon09");
        monClass1.setText(mon09);

        Intent intentM10 = getIntent();
        String mon10 = intentM10.getStringExtra("mon10");
        monClass2.setText(mon10);

        Intent intentM11 = getIntent();
        String mon11 = intentM11.getStringExtra("mon11");
        monClass3.setText(mon11);

        Intent intentM12 = getIntent();
        String mon12 = intentM12.getStringExtra("mon12");
        monClass4.setText(mon12);
*/



/*
        DatabaseReference rMon1 = database.getReference("class").child("mon").child("09");
        rMon1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    monClass1.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        DatabaseReference rMon2 = database.getReference("class").child("mon").child("10");
        rMon2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    monClass2.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        DatabaseReference rMon3 = database.getReference("class").child("mon").child("11");
        rMon3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    monClass2.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        DatabaseReference rMon4 = database.getReference("class").child("mon").child("12");
        rMon4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    monClass2.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/
/*
        DatabaseReference rMon1 = database.getReference("Class").child(userKey);
        rMon1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




/*
        DatabaseReference rMon2 = database.getReference("class").child(userID).child("mon").child("10");
        rMon2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    monClass2.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference rMon3 = database.getReference("class").child(userID).child("mon").child("11");
        rMon3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    monClass3.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference rMon4 = database.getReference("class").child(userID).child("mon").child("12");
        rMon4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    monClass4.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
*/


    }

/*
    public class BackgroundTask extends AsyncTask<String, String, String>{

        protected void onPreExecute(){

        }

        protected String doInBackground(String ... values){
            try {
                publishProgress();
            }catch (Exception e){
                e.printStackTrace();
            }
            return result;
        }

        protected void onProgressUpdate(String ... values){

            //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_SHORT).show();
            database = FirebaseDatabase.getInstance();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_SHORT).show();

                    DatabaseReference rMon1 = database.getReference("class").child(key).child("mon").child("09");/*
                    rMon1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String result = snapshot.getValue().toString();
                                monClass1.setText(result);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }, 5000);
            DatabaseReference rMon1 = database.getReference("class").child(key).child("mon").child("09");
            rMon1.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        String result = snapshot.getValue().toString();
                        monClass1.setText(result);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        protected void onPostExecute(String result){

            database = FirebaseDatabase.getInstance();
            DatabaseReference rMon1 = database.getReference("class").child(key).child("mon").child("09");
            rMon1.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        String result = snapshot.getValue().toString();
                        monClass1.setText(result);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        protected void onCancelled(){}

    }
*/

    public void questClick(View view){

        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        String key = userID.replace(".", ",");

        Intent intent = new Intent(this, QuestActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }

    public void mypageClick(View view){

        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        String key = userID.replace(".", ",");

        Intent intent = new Intent(this, MypageActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }



//    public void onBackPressed() {
//        Intent intent1 = getIntent();
//        String key = intent1.getStringExtra("user");
//
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("user", key);
//        startActivity(intent);
//    }


    public void mOnPopup1 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 1교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "09");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup6 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 2교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "10");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup11 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 3교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "11");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup16 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 4교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "12");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup21 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 5교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "13");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup26 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 6교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "14");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup31 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 7교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "15");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup36 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 8교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "16");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup41 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 9교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "17");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup46 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 10교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "18");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup51 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 11교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "19");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup56 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "월요일 12교시");
        intent.putExtra("day", "mon");
        intent.putExtra("class", "20");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }




    public void mOnPopup2 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 1교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "09");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup7 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 2교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "10");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup12 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 3교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "11");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup17 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 4교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "12");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup22 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 5교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "13");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup27 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 6교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "14");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup32 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 7교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "15");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup37 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 8교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "16");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup42 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 9교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "17");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup47 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 10교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "18");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup52 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 11교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "19");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup57 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "화요일 12교시");
        intent.putExtra("day", "tue");
        intent.putExtra("class", "20");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }







    public void mOnPopup3 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 1교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "09");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup8 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 2교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "10");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup13 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 3교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "11");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup18 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 4교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "12");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup23 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 5교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "13");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup28 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 6교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "14");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup33 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 7교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "15");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup38 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 8교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "16");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup43 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 9교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "17");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup48 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 10교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "18");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup53 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 11교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "19");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup58 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "수요일 12교시");
        intent.putExtra("day", "wed");
        intent.putExtra("class", "20");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }








    public void mOnPopup4 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 1교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "09");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup9 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 2교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "10");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup14 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 3교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "11");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup19 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 4교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "12");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup24 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 5교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "13");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup29 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 6교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "14");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup34 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 7교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "15");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup39 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 8교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "16");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup44 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 9교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "17");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup49 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 10교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "18");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup54 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 11교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "19");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup59 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "목요일 12교시");
        intent.putExtra("day", "thu");
        intent.putExtra("class", "20");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }







    public void mOnPopup5 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 1교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "09");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup10 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 2교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "10");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup15 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 3교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "11");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup20 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 4교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "12");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup25 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 5교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "13");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup30 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 6교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "14");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup35 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 7교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "15");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup40 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 8교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "16");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup45 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 9교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "17");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }


    public void mOnPopup50 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 10교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "18");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup55 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 11교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "19");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup60 (View v) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("title", "금요일 12교시");
        intent.putExtra("day", "fri");
        intent.putExtra("class", "20");
        intent.putExtra("user", key);
        startActivityForResult(intent, 1);
    }















    private ArrayAdapter<String> _arrAdaper;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
/*
                String mon09 = intent.getStringExtra("mon09");
                monClass1.setText(mon09);

                String mon10 = intent.getStringExtra("mon10");
                monClass2.setText(mon10);

                String mon11 = intent.getStringExtra("mon11");
                monClass3.setText(mon11);

                String mon12 = intent.getStringExtra("mon12");
                monClass4.setText(mon12);

 */
            }
        }
    }


/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentM10){
        super.onActivityResult(requestCode, resultCode, intentM10);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Intent intentM9 = getIntent();
                String mon09 = intentM9.getStringExtra("mon09");
                monClass1.setText(mon09);

                String mon10 = intentM10.getStringExtra("mon10");
                monClass2.setText(mon10);

                Intent intentM11 = getIntent();
                String mon11 = intentM11.getStringExtra("mon11");
                monClass3.setText(mon11);

                Intent intentM12 = getIntent();
                String mon12 = intentM12.getStringExtra("mon12");
                monClass4.setText(mon12);
            }
        }
    }
*/
}
