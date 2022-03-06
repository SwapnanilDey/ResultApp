package com.example.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewRecordActivity extends AppCompatActivity {

    private EditText StudentName, Physics, Chemistry, Math;
    private Button submit,addRecord;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("StudentRecord");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newrecord);
        StudentName = findViewById(R.id.StudentName);
        Physics = findViewById(R.id.Physics);
        Chemistry = findViewById(R.id.Chemistry);
        Math = findViewById(R.id.Math);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Students");

                String name = StudentName.getText().toString();
                String phy = Physics.getText().toString();
                String chem = Chemistry.getText().toString();
                String mathematics = Math.getText().toString();

                int num1 = Integer.parseInt(phy);
                int num2 = Integer.parseInt(chem);
                int num3 = Integer.parseInt(mathematics);
                int sum = num1+num2+num3;
                String total = String.valueOf(sum);

                UserHelperClass helperClass = new UserHelperClass(phy, chem, mathematics, total);
                reference.child(name).setValue(helperClass);
            }
        });
        addRecord = findViewById(R.id.addRecord);
        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewRecordActivity.this, NewRecordActivity.class));
            }
        });
    }
}