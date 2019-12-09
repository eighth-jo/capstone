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


public class InquireActivity extends AppCompatActivity {

    private EditText texttitle;
    private EditText usertext;
    private EditText editdetail;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private Button buttonwrite;
    private Button back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire);


        texttitle=(EditText)findViewById(R.id.texttitle);
        usertext=(EditText)findViewById(R.id.usertext);
        editdetail=(EditText)findViewById(R.id.editdetail);
        back=(Button)findViewById(R.id.back);
        buttonwrite=(Button)findViewById(R.id.buttonwrite);
        databaseReference= FirebaseDatabase.getInstance().getReference("Center");
        buttonwrite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                NewWrite();
                startActivity(new Intent(InquireActivity.this, CenterActivity.class));

            }
        });


        //클릭 시 이번트 처리
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InquireActivity.this,CenterActivity.class));
            }
        });
    }

    private void NewWrite(){
        String texttitle1=texttitle.getText().toString().trim();
        String usertext1=usertext.getText().toString().trim();
        String editdetail1=editdetail.getText().toString().trim();


        if(!TextUtils.isEmpty(texttitle1)){
            String id =databaseReference.push().getKey();
            Write write=new Write(texttitle1,usertext1,editdetail1);
            databaseReference.child(id).setValue(write);
            Toast.makeText(this,"완료되었습니다.",Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,"이메일을 입력해주세요",Toast.LENGTH_SHORT).show();
        }
    }

}
