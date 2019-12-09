package com.example.job_moo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {


    private Button btnlogout;
    private Button mypage;
    private Button center;
    private FirebaseAuth firebaseAuth;


    public static String userID;
    public static String test;
    public static String enume;
    public static String userKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }

        btnlogout=(Button)findViewById(R.id.btlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });



        Intent intent4 = getIntent();
        userID = intent4.getStringExtra("user");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        /*
        DatabaseReference rClass = database.getReference("Class");
        rClass.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {

                test = dataSnapshot.getValue().toString();
                //Toast.makeText(getApplicationContext(), "가" + test, Toast.LENGTH_SHORT).show();

                enume = "{" + "ID" + "=" + userID + "}";
                //Toast.makeText(getApplicationContext(), "나" + enume, Toast.LENGTH_SHORT).show();

                if(test.equals(enume)) {
                    userKey = dataSnapshot.getKey();
                    //Toast.makeText(getApplicationContext(), "did", Toast.LENGTH_SHORT).show();
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



        mypage=(Button)findViewById(R.id.mypage);
        center=(Button)findViewById(R.id.center);


        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CenterActivity.class);
                startActivity(intent);
            }
        });


        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MypageActivity.class);
                startActivity(intent);
            }
        });




/*
        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference rMon1 = database.getReference("class").child(userID).child("mon").child("09");
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


    public static String result;

    public void tableClick(View view){

        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        Intent intent = new Intent(this, TableActivity.class);
        intent.putExtra("user", userID);
        startActivity(intent);
    }


    public void questClick(View view){

        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        String key = userID.replace(".", ",");

        Intent intent = new Intent(this, QuestActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }


    public void payClick(View view){

        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        String key = userID.replace(".", ",");

        Intent intent = new Intent(this, PayActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }


/*
    public void mOnPopup1 (View v) {
        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        Intent intent = new Intent(this, Popup1Activity.class);
        intent.putExtra("class", "1교시");
        intent.putExtra("user", userID);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup2 (View v) {
        Intent intent = new Intent(this, Popup2Activity.class);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup6 (View v) {
        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("class", "2교시");
        intent.putExtra("user", userID);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup11 (View v) {
        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        Intent intent = new Intent(this, Popup11Activity.class);
        intent.putExtra("class", "3교시");
        intent.putExtra("user", userID);
        startActivityForResult(intent, 1);
    }

    public void mOnPopup16 (View v) {
        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        Intent intent = new Intent(this, Popup16Activity.class);
        intent.putExtra("class", "4교시");
        intent.putExtra("user", userID);
        startActivityForResult(intent, 1);
    }
*/


}