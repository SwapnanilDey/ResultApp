package com.example.result;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText mUsername,mEmail,mPassword,mRePass;
    Button btn2;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mUsername=findViewById(R.id.loginid);
        mEmail=findViewById(R.id.loginpass);
        mPassword=findViewById(R.id.EnterPassword);
        mRePass=findViewById(R.id.ReEnterPassword);
        fAuth= FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        /*if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }*/

        btn2=findViewById(R.id.button);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mUsername.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String repass = mRePass.getText().toString().trim();



                if (TextUtils.isEmpty(username)){
                    mUsername.setError("Username Field Cannot Be Empty");
                    return;
                }

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email Field Cannot Be Empty");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password Field Cannot Be Empty");
                    return;
                }

                if(password.length() < 8){
                    mPassword.setError("Password must contain atleast 8 characters");
                    return;
                }
                if(!repass.equals(password)){
                    mRePass.setError("Password Not Matched");
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);


                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"User Created",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Error!" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(view.GONE);
                        }
                    }
                });
            }
        });

        //Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_LONG).show();

        TextView btn=findViewById(R.id.alreadyHaveAnAcc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }

        });

    }
}