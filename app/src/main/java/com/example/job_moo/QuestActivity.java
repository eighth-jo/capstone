package com.example.job_moo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class QuestActivity extends AppCompatActivity {

    TextView receiveTitle;
    TextView receiveCost;

    private FirebaseDatabase mDatabase;
    private  DatabaseReference mReference;
    private ChildEventListener mChild;

    private ListView listView1;
    private ListView listView2;
    private ListView listView3;
    private ListView listView4;
    private ListView listView5;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private ArrayAdapter<String> adapter4;
    private ArrayAdapter<String> adapter5;
    List<Object> Array1 = new ArrayList<Object>();
    List<Object> Array2 = new ArrayList<Object>();
    List<Object> Array3 = new ArrayList<Object>();
    List<Object> Array4 = new ArrayList<Object>();
    List<Object> Array5 = new ArrayList<Object>();

    List<Object> Items = new ArrayList<Object>();
    int timeNow;
    String msg2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

/*
        String receiveTtl = intent.getStringExtra("title");
        receiveTitle = (TextView)findViewById(R.id.title1);
        receiveTitle.setText(receiveTtl);

        String receiveCst = intent.getStringExtra("cost");
        receiveCost = (TextView)findViewById(R.id.cost1);
        receiveCost.setText(receiveCst);
*/

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat sdf1 = new SimpleDateFormat("EE");
        String dayOfWeek = sdf1.format(date);
        int Yo1;
        if(dayOfWeek.equals("Sun")){
            Yo1 = 0;
        }else if(dayOfWeek.equals("Mon")){
            Yo1 = 1;
        }else if(dayOfWeek.equals("Tue")){
            Yo1 = 2;
        }else if(dayOfWeek.equals("Wed")){
            Yo1 = 3;
        }else if(dayOfWeek.equals("Thu")){
            Yo1 = 4;
        }else if(dayOfWeek.equals("Fri")){
            Yo1 = 5;
        }
        else {
            Yo1 = 6;
        }

        SimpleDateFormat sdf2 = new SimpleDateFormat("HH");
        String dateHour = sdf2.format(date);
        int dHour = Integer.parseInt(dateHour);

        SimpleDateFormat sdf3 = new SimpleDateFormat("mm");
        String dateMinute = sdf3.format(date);
        int dMin = Integer.parseInt(dateMinute);

        timeNow = Yo1 * 60 * 24 + dHour * 60 + dMin;


        listView1 = (ListView) findViewById(R.id.listView1);
        listView2 = (ListView) findViewById(R.id.listView2);
        listView3 = (ListView) findViewById(R.id.listView3);
        listView4 = (ListView) findViewById(R.id.listView4);
        listView5 = (ListView) findViewById(R.id.listView5);

        initDatabase();

        adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        listView1.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        listView2.setAdapter(adapter2);

        adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        listView3.setAdapter(adapter3);

        adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        listView4.setAdapter(adapter4);

        adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new ArrayList<String>());
        listView5.setAdapter(adapter5);


        mReference = mDatabase.getReference("Board");
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                adapter1.clear();
                adapter2.clear();
                adapter3.clear();
                adapter4.clear();
                adapter5.clear();
                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    msg2 = messageData.getValue().toString();

                    String[] parsing = msg2.split("_");
                    //String wID = parsing[0];
                    String wTitle = parsing[1];
                    String wHour = parsing[2] + "시";
                    String wMin = parsing[3] + "분";
                    String wPlc1 = parsing[4];
                    //String wPlc2 = parsing[5];
                    String wCost = parsing[6] + "원";
                    //String wTime = parsing[7];
                    String wMux = parsing[8];
                    String wDead = parsing[9];
                    //String wText = parsing[10];

                    int aa = Integer.parseInt(wMux);
                    int bb = Integer.parseInt(wDead);

                    if(aa + bb <= timeNow){

                        continue;
                    }


                    Items.add(msg2);

                    Array1.add(wTitle);
                    Array2.add(wHour);
                    Array3.add(wPlc1);
                    Array4.add(wCost);
                    Array5.add(wMin);

                    adapter1.insert(wTitle, 0);
                    adapter2.insert(wHour, 0);
                    adapter3.insert(wPlc1, 0);
                    adapter4.insert(wCost, 0);
                    adapter5.insert(wMin, 0);
                }
                //Collections.reverse(Array);
                adapter1.notifyDataSetChanged();
                listView1.setSelection(adapter1.getCount() - 1);

                adapter2.notifyDataSetChanged();
                listView2.setSelection(adapter2.getCount() - 1);

                adapter3.notifyDataSetChanged();
                listView3.setSelection(adapter3.getCount() - 1);

                adapter4.notifyDataSetChanged();
                listView4.setSelection(adapter4.getCount() - 1);

                adapter5.notifyDataSetChanged();
                listView5.setSelection(adapter5.getCount() - 1);

                Collections.reverse(Items);

                listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), Why.class);
                        int num = position;
                        Object tmmmp = Items.get(num);
                        String tmmp = tmmmp.toString();
                        //Toast.makeText(getApplicationContext(), tmmp, Toast.LENGTH_LONG).show();
                        intent.putExtra("msg", tmmp);

                        Intent intent2 = getIntent();
                        String key = intent2.getStringExtra("user");
                        intent.putExtra("user", key);
                        startActivity(intent);
                    }
                });
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReference.removeEventListener(mChild);
    }

/*
    public void enterList(View view){

    }
*/


    public void writeClick(View view){

        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, WriteActivity.class);
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