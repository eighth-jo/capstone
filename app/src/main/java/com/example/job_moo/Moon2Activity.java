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


public class Moon2Activity extends AppCompatActivity {

    private EditText titlee;
    private EditText reason;
    private EditText detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moon2);

    }

    public void moonee(View view){

        Intent intent = getIntent();
        String key = intent.getStringExtra("user");

        titlee=(EditText)findViewById(R.id.titlee);
        reason=(EditText)findViewById(R.id.reason);
        detail=(EditText)findViewById(R.id.detail);
        String aa = titlee.getText().toString();
        String bb = reason.getText().toString();
        String cc = detail.getText().toString();
        String dd = aa + "_" + bb + "_" + cc;

        //Toast.makeText(getApplicationContext(), dd, Toast.LENGTH_SHORT).show();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Inquire");

        myRef.child(key).push().setValue(dd);

        Intent intent2 = new Intent(this, MypageActivity.class);
        intent2.putExtra("user", key);
        startActivity(intent2);
        finish();

    }


    public void canclClick(View view) {
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
