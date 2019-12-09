package com.example.job_moo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PopupActivity extends Activity {

    TextView textView;
    EditText editText;

    private Thread nThread;
    public int i;

    public static String key = "mon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);


        Intent intent1 = getIntent();
        key = intent1.getStringExtra("user");

        textView = (TextView)findViewById(R.id.title);

        Intent intent = getIntent();
        String time = intent.getStringExtra("title");
        textView.setText(time);
    }


    public  void mOnclose(View v){
        editText = (EditText)findViewById(R.id.clss);
        editText.setPrivateImeOptions("defaultInputmode=korean;");

        //Intent intent1 = getIntent();
        //String key = intent1.getStringExtra("user");

        //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_SHORT).show();

        if(nThread == null){
            nThread = new Thread("My Thread"){

                Intent intent = getIntent();
                String tempo = intent.getStringExtra("user");
                String userID = tempo.replace(".", ",");

                String week = intent.getStringExtra("day");
                String time = intent.getStringExtra("class");

                @Override
                public void run(){

                    for (i = 0; i < 10000; i++){
                        try {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e){
                            break;
                        }
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference rUser = database.getReference("class").child(userID).child(week).child(time).child("-");
                        rUser.setValue(editText.getText().toString());
                    }
                }
            };
            nThread.start();
        }



        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference rUser = database.getReference("class").child(key).child("mon").child("09").child("-");
        //rUser.setValue(editText.getText().toString());

        //Intent intent2 = new Intent(this, TableActivity.class);
        //intent2.putExtra("mon09", editText.getText().toString());

        //startActivity(intent2);
        //setResult(RESULT_OK, intent2);
        //startActivity(intent2);
        finish();
    }


    @Override
    public boolean onTouchEvent (MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

}
