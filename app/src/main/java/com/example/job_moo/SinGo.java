package com.example.job_moo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SinGo extends AppCompatActivity {

    private EditText titleee;
    private EditText target;
    private EditText detaill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singo);

    }

    public void singogo(View view){

        Intent intent = getIntent();
        String key = intent.getStringExtra("user");

        titleee=(EditText)findViewById(R.id.titleee);
        target=(EditText)findViewById(R.id.target);
        detaill=(EditText)findViewById(R.id.detaill);
        String aa = titleee.getText().toString();
        String bb = target.getText().toString();
        String cc = detaill.getText().toString();
        String dd = aa + "_" + bb + "_" + cc;



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Report");

        myRef.child(key).push().setValue(dd);


        Intent intent2 = new Intent(this, MypageActivity.class);
        intent2.putExtra("user", key);
        startActivity(intent2);
        finish();

    }


    public void sinnono(View view) {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, MypageActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Intent intent1 = getIntent();
        String key = intent1.getStringExtra("user");

        Intent intent = new Intent(this, MypageActivity.class);
        intent.putExtra("user", key);
        startActivity(intent);
    }

}
