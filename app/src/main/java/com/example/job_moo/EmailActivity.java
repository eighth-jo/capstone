package com.example.job_moo;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class EmailActivity extends AppCompatActivity {


    private static final String TAG = "EmailActivity";
    public static EditText editMail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

    }


    public void buildActionCodeSettings() {

        ActionCodeSettings actionCodeSettings =
                ActionCodeSettings.newBuilder()

                        .setUrl("https://mportal.cau.ac.kr/")
                        .setHandleCodeInApp(true)
                        .setAndroidPackageName(
                                "com.example.job_moo", true, "12")
                        .build();
    }


    public void sendSignInLink(String email, ActionCodeSettings actionCodeSettings) {

        editMail = (EditText)findViewById(R.id.editEmail);
        email = editMail + "@cau.ac.kr";

        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.sendSignInLinkToEmail(email, actionCodeSettings).addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Email sent.");
                        }
                    }
                });
    }



}
