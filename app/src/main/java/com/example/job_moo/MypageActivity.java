package com.example.job_moo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MypageActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    Button btnlogout;
    TextView email;
    TextView point;
    TextView trust;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        firebaseAuth = FirebaseAuth.getInstance();

        btnlogout = (Button) findViewById(R.id.btlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(MypageActivity.this, LoginActivity.class));
            }
        });

        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        email = (TextView)findViewById(R.id.email123);
        point = (TextView)findViewById(R.id.point);
        trust = (TextView)findViewById(R.id.trust);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("User").child(key);
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                String tmp = dataSnapshot.getValue().toString();
                //Toast.makeText(getApplicationContext(), tmp, Toast.LENGTH_SHORT).show();
                String[] parsing = tmp.split("_");
                email.setText(parsing[0]);
                point.setText(parsing[1] + "원");
                trust.setText(parsing[2] + "점");
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


    public void payClick(View view){

        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        String key = userID.replace(".", ",");

        Intent intent = new Intent(this, PayActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }

    public void moon2Click(View view){

        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, Moon2Activity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }


    public void sinGoClick(View view1){

        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, SinGo.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, TableActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }
}