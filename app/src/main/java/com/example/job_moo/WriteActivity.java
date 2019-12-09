package com.example.job_moo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteActivity extends AppCompatActivity{


    public EditText editTitle;
    public EditText editCost;
    public EditText editText;
    public EditText editClose;
    public static String hour;
    public static String minute;
    public static String place1;
    public static String place2;


    long now3;
    long now1;
    long now2;
    Date date3;
    Date date1;
    Date date2;
    SimpleDateFormat sdf1;
    String dateHour;
    SimpleDateFormat sdf2;
    String dateMinute;
    SimpleDateFormat sdf3;
    String dayOfWeek;
    int Yo1;

    public String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

/*
        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        mUser.getIdToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
            @Override
            public void onComplete(@NonNull Task<GetTokenResult> task) {
                if (task.isSuccessful()) {
                    idToken = task.getResult().getToken();

                } else {
                }
            }
        });
*/



        now3 = System.currentTimeMillis();
        date3 = new Date(now3);
        sdf3 = new SimpleDateFormat("EE");
        dayOfWeek = sdf3.format(date3);

//        switch (dayOfWeek){
//            case "son":
//                Yo1 = 0;
//                break;
//            case "mon":
//                Yo1 = 1;
//                break;
//            case "tue":
//                Yo1 = 2;
//                break;
//            case "wed":
//                Yo1 = 3;
//                break;
//            case "thu":
//                Yo1 = 4;
//                break;
//            case "fri":
//                Yo1 = 5;
//                break;
//            case "sat":
//                Yo1 = 6;
//                break;
//        }

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

        String Yo2 = String.valueOf(Yo1);
        //Toast.makeText(getApplicationContext(), Yo2, Toast.LENGTH_SHORT).show();



        final TextView textView1 = (TextView)findViewById(R.id.TextHour);
        final Spinner spinner1 = (Spinner)findViewById(R.id.SpinnerHour);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView1.setText(parent.getItemAtPosition(position) + "");
                textView1.setTextSize(18);
                textView1.getGravity();

                hour = spinner1.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        final TextView textView2 = (TextView)findViewById(R.id.TextMin);
        final Spinner spinner2 = (Spinner)findViewById(R.id.SpinnerMin);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView2.setText(parent.getItemAtPosition(position) + "");
                textView2.setTextSize(18);
                textView2.getGravity();

                minute = spinner2.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        final TextView textView3 = (TextView)findViewById(R.id.TextPlace1);
        final Spinner spinner3 = (Spinner)findViewById(R.id.SpinnerPlace1);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView3.setText(parent.getItemAtPosition(position) + "");
                textView3.setTextSize(18);
                textView3.getGravity();

                place1 = spinner3.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        final TextView textView4 = (TextView)findViewById(R.id.TextPlace2);
        final Spinner spinner4 = (Spinner)findViewById(R.id.SpinnerPlace2);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView4.setText(parent.getItemAtPosition(position) + "");
                textView4.setTextSize(18);
                textView4.getGravity();

                place2 = spinner4.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public static String result;
    public static int count;

    public void askWrite(View view){

        editTitle = (EditText)findViewById(R.id.TextTitle);
        editCost = (EditText)findViewById(R.id.EditCost);
        editText = (EditText)findViewById(R.id.EditDetail);
        editClose = (EditText)findViewById(R.id.EditClose);

        editTitle.setPrivateImeOptions("defaultInputmode=korean;");

        String upTitle = editTitle.getText().toString();
        String upCost = editCost.getText().toString();
        String upDetail = editText.getText().toString();

        String dead = editClose.getText().toString();
        //int delPost = Integer.parseInt(delete);

        if(hour.equals("시")){
            now1 = System.currentTimeMillis();
            date1 = new Date(now1);
            sdf1 = new SimpleDateFormat("HH");
            dateHour = sdf1.format(date1);

            hour = dateHour;
        }
        if(minute.equals("분")){
            now1 = System.currentTimeMillis();
            date1 = new Date(now1);
            sdf2 = new SimpleDateFormat("mm");
            dateMinute = sdf2.format(date1);

            minute = dateMinute;
        }
        if(place1.equals("장소")){
            place1 = "없음";
        }
        if(dead.equals("")){
            dead = "10000";
        }
        if(upDetail.equals("")){
            upDetail = "없음";
        }
/*
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int Yo1 = dayOfWeek * 24 * 60;
*/
        now2 = System.currentTimeMillis();
        date2 = new Date(now2);

        sdf2 = new SimpleDateFormat("HH");
        String dateHour2 = sdf2.format(date2);
        int dHour = Integer.parseInt(dateHour2);

        sdf2 = new SimpleDateFormat("mm");
        String dateMinute2 = sdf2.format(date2);
        int dMin = Integer.parseInt(dateMinute2);

        String upTime = dateHour2 + ":" + dateMinute2;

        int dTime = Yo1 * 60 * 24 + dHour * 60 + dMin;
        String mux = Integer.toString(dTime);


        //intent.putExtra("title", editText1.getText().toString());
        //intent.putExtra("cost", editText2.getText().toString());

        Intent intent1 = getIntent();
        String userID = intent1.getStringExtra("user");

        String upBoard = userID + "_" + upTitle + "_" + hour  + "_" + minute  + "_" +  place1  + "_" + place2 + "_" + upCost + "_" + upTime + "_" + mux + "_" + dead + "_" + upDetail;
        String upPost = userID + "_" + upTitle + "_" + dayOfWeek + "_" + hour  + "_" + minute  + "_" +  place1  + "_" + place2 + "_" + upCost + "_" + upTime + "_" + mux + "_" + dead + "_" + upDetail;


/*
        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
        DatabaseReference rU = database1.getReference("user").child(userID);
        rU.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                String tmp = dataSnapshot.getValue().toString();
                String[] parsing = tmp.split("_");
                money = parsing[1];
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




        if(upTitle.equals("")){
            Toast.makeText(getApplicationContext(), "제목을 입력하세요.", Toast.LENGTH_SHORT).show();
        }else if (upCost.equals("")){
            Toast.makeText(getApplicationContext(), "금액을 입력하세요.", Toast.LENGTH_SHORT).show();
        }else {

            FirebaseDatabase database = FirebaseDatabase.getInstance();

            DatabaseReference myRef = database.getReference();
            myRef.child("Board").push().setValue(upBoard);
            myRef.child("Post").child("-").setValue(upPost);
/*
//            int cal1 = Integer.parseInt(money);
            int cal2 = Integer.parseInt(upCost);
            int calcu = 1000000 - cal2;
//            int calcu = cal1 - cal2;
            String rest = Integer.toString(calcu);


            DatabaseReference mR = database.getReference();
            String userData = userID + "_" + rest + "_" + "1000";
            String userIDID = userID.replace(",", ".");
            mR.child("User").child(userIDID).setValue(userData);
*/

        /*
        myRef.child("Quest").child("new").child("ID").child("-").setValue(userID);
        myRef.child("Quest").child("new").child("cost").setValue(editText2.getText().toString());
        myRef.child("Quest").child("new").child("hour").child("-").setValue(hour);
        myRef.child("Quest").child("new").child("minute").child("-").setValue(minute);
        myRef.child("Quest").child("new").child("place1").setValue(place1);
        myRef.child("Quest").child("new").child("place2").setValue(place2);
*/
/*
        myRef.child("ask").child("cost").setValue(editText2.getText().toString());
        myRef.child("ask").child("hour").child("-").setValue(hour);
        myRef.child("ask").child("minute").child("-").setValue(minute);
        myRef.child("ask").child("place1").setValue(place1);
        myRef.child("ask").child("place2").setValue(place2);
*/


            //Intent intent11 = new Intent(WriteActivity.this, zTimeService.class);
            //startService(intent11);

            Intent intent123 = getIntent();
            String key = intent123.getStringExtra("user");

            Intent intent = new Intent(this, QuestActivity.class);
            intent.putExtra("user", key);
            startActivity(intent);
            finish();
        }
    }


    public void cancel(View view){
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, QuestActivity.class);
        intent.putExtra("user", key);
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
