package com.example.job_moo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import android.app.Activity;
import android.content.Intent;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class WordActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private  DatabaseReference mReference;
    private ChildEventListener mChild;

    private ListView listView1;
    private ArrayAdapter<String> adapter1;
    List<Object> Array1 = new ArrayList<Object>();

    String msg;
    String room;

    TextView btn1;
    TextView btn2;
    TextView btn3;
    TextView btn4;



    public EditText editWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        Intent intent = getIntent();
        room = intent.getStringExtra("maker");


        listView1 = (ListView) findViewById(R.id.talkList);
        initDatabase();

        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                ViewGroup.LayoutParams params = view.getLayoutParams();
                params.height = 70;
                view.setLayoutParams(params);
                return view;
            }
        };
        listView1.setAdapter(adapter1);

        mReference = mDatabase.getReference("hotel").child(room);
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter1.clear();
                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    msg = messageData.getValue().toString();

                    Array1.add(msg);
                    adapter1.add(msg);
                }

                setListViewSize(listView1);
                adapter1.notifyDataSetChanged();
                listView1.setSelection(adapter1.getCount() - 1);


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }

    private void initDatabase() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("log");
        mReference.child("log").setValue("check");
        mChild = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        mReference.addChildEventListener(mChild);
    }

//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent){
//        convertView = inf
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReference.removeEventListener(mChild);
    }



    public void setListViewSize(ListView myListView) {
        ListAdapter myListAdapter = myListView.getAdapter();
        if (myListAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int size = 0; size < myListAdapter.getCount(); size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        params.height = totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
        myListView.setLayoutParams(params);

    }



    public void send(View view){

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
        String dateHour = sdf1.format(date);
        SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
        String dateMinute = sdf2.format(date);

        Intent intent = getIntent();
        String key = intent.getStringExtra("user");

        editWord = (EditText)findViewById(R.id.editWord);
        String word = editWord.getText().toString();
        String userId = key.replace(",", ".");
        String words = "(" + dateHour + ":" + dateMinute + ")" + userId + ": " + word;


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("hotel").child(room).push().setValue(words);
        editWord.setText(null);

    }


    int started = 0;

    public void start(View view) {
        if(started == 0) {
            btn1 = (TextView) findViewById(R.id.sendno);
            btn2 = (TextView) findViewById(R.id.sendone);
            btn3 = (TextView) findViewById(R.id.sendcancle);
            btn4 = (TextView) findViewById(R.id.sendstart);

            started = 1;

            btn1.setBackgroundColor(Color.rgb(255, 0, 102));
            btn2.setBackgroundColor(Color.rgb(0, 204, 255));
            btn3.setBackgroundColor(Color.GRAY);
            btn4.setBackgroundColor(Color.GRAY);

            btn1.setText("미완료");
            btn2.setText("완료");
        }
    }


    public void cancle(View view) {
        if(started == 0) {
            Intent intent1 = getIntent();
            String key = intent1.getStringExtra("user");

            Intent intent = new Intent(this, QuestActivity.class);
            intent.putExtra("user", key);
            startActivity(intent);
        }
    }




    public void done(View view) {

        if(started == 1) {

            Intent intent1 = getIntent();
            String key = intent1.getStringExtra("user");

            Intent intent = new Intent(this, QuestActivity.class);
            intent.putExtra("user", key);
            startActivity(intent);
        }else {

        }
    }


    public void no(View view) {
        if(started == 1) {
            Intent intent1 = getIntent();
            String key = intent1.getStringExtra("user");

            Intent intent = new Intent(this, SinGo.class);
            intent.putExtra("user", key);
            startActivity(intent);
        }
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