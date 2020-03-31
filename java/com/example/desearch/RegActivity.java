package com.example.desearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegActivity extends AppCompatActivity {
    View view;
    private EditText userName,userPassword,userEmail,userContact;
    private Button regButton;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        view= this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.teal1);
        setupUIViews();

        firebaseAuth=FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valid()){
                    String user_email=userEmail.getText().toString().trim();
                    String user_password=userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegActivity.this,Activity2.class));
                            }
                            else{
                                Toast.makeText(RegActivity.this, "Opps.. Registration Failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });
    }
    private void setupUIViews(){
        userName=(EditText)findViewById(R.id.etUserEmail);
        userPassword=(EditText)findViewById(R.id.etUserPassword);
        userEmail=(EditText)findViewById(R.id.etUserEmail);
        userContact=(EditText)findViewById(R.id.etUserNumber);
        regButton=(Button)findViewById(R.id.btnRegister);

    }
    private boolean valid(){
    Boolean result = false;

    String name=userName.getText().toString();
    String password=userPassword.getText().toString();
    String email=userEmail.getText().toString();
    String contact=userContact.getText().toString();

    if (name.isEmpty() && password.isEmpty()&& email.isEmpty()&&contact.isEmpty()){
        Toast.makeText(this,"Please enter all the details.",Toast.LENGTH_SHORT).show();
    }
    else{

        result= true;
    }
    return result;
    }
}
