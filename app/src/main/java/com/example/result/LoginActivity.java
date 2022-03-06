package com.example.result;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText mEmailid,mPassword;
    TextView btn;
    ProgressBar progressBar;

    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailid=findViewById(R.id.loginid);
        mPassword=findViewById(R.id.loginpass);
        fAuth= FirebaseAuth.getInstance();
        progressBar= findViewById(R.id.progressBar);


        btn=findViewById(R.id.Ques2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity. this,MainActivity.class));
            }
        });

        Button btn2=findViewById(R.id.loginbtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = mEmailid.getText().toString().trim();
                String password1 = mPassword.getText().toString().trim();



                if (TextUtils.isEmpty(email1)){
                    mEmailid.setError("Email Field Cannot Be Empty");
                    return;
                }

                if (TextUtils.isEmpty(password1)){
                    mPassword.setError("Password Field Cannot Be Empty");
                    return;
                }
                if(password1.length() < 8){
                    mPassword.setError("Password must contain atleast 8 characters");
                    return;
                }
                fAuth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Logged In",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Error!" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            startActivity(new Intent(LoginActivity. this,LoginActivity.class));
                            progressBar.setVisibility(view.GONE);
                        }
                    }
                });
            }

        });


    }
}