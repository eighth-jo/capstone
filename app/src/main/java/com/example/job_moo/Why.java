package com.example.job_moo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Why extends AppCompatActivity {

    TextView textTitle;
    TextView textCost;
    TextView textWant;
    TextView textPlace;
    TextView textDead;
    TextView textWritten;
    TextView textMain;

    String idid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.why);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");

        String[] parsing = msg.split("_");
        String wID = parsing[0];
        String wTitle = parsing[1];
        String wHour = parsing[2];
        String wMin = parsing[3];
        String wPlc1 = parsing[4];
        String wPlc2 = parsing[5];
        String wCost = parsing[6] + "원";
        String wTime = parsing[7];
        String wMux = parsing[8];
        String wDead = parsing[9];
        String wText = parsing[10];

        idid = wID;

        String wWant = wHour + ":" + wMin;

        String wPlc;
        if(wPlc2.equals("장소")) {
            wPlc = wPlc1;
        }else {
            wPlc = wPlc1 + "," + wPlc2;
        }

        int aa = Integer.parseInt(wMux);
        int bb = Integer.parseInt(wDead);
        int ccc = (aa + bb) % 1440;
        int hour = ccc / 60;
        int min = ccc % 60;
        String dead = String.valueOf(hour) + ":" + String.valueOf(min);


        textTitle = (TextView)findViewById(R.id.title);
        textCost = (TextView)findViewById(R.id.cost);
        textWant = (TextView)findViewById(R.id.want);
        textPlace = (TextView)findViewById(R.id.place);
        textDead = (TextView)findViewById(R.id.dead);
        textWritten = (TextView)findViewById(R.id.written);
        textMain = (TextView)findViewById(R.id.cont);

        textTitle.setText(wTitle);
        textCost.setText(wCost);
        textWant.setText("희망시간: " + wWant);
        textPlace.setText("업무장소: " + wPlc);
        textDead.setText("마감시간: " + dead);
        textWritten.setText("작성시간: " + wTime);
        textMain.setText(wText);
/*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference rABC = database.getReference("abc");
        rABC.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String result = snapshot.getValue().toString();
                    textView.setText(result);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });*/
    }

    public void apply(View v){
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("Apply").child(idid).child("-").setValue("click");
        myRef.child("Post").child("-").setValue("a,b" + "_" + "c" + "_" + "d" + "_" + "24"  + "_" + "60"  + "_" +  "e"  + "_" + "f" + "_" + "0" + "_" + "0" + "_" + "0" + "_" + "0" + "_" + "g");


        Intent intent = new Intent(this, WordActivity.class);
        intent.putExtra("user", key);
        intent.putExtra("maker", idid);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, QuestActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }
}
