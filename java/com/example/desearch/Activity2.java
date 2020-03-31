package com.example.desearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity2 extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button button;
    private FirebaseAuth firebaseAuth;
    private Button clickhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button= (Button) findViewById(R.id.tvRegister);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegActivity();
            }
        });


        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tv);
        Login=(Button)findViewById(R.id.btnLogin);
        clickhere=(Button) findViewById(R.id.tvForgotPass);

        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if (user!=null){
          finish();
          startActivity(new Intent(Activity2.this,SecondActivity.class));

        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString() , Password.getText().toString());
            }
        });
        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this,PasswordActivity.class));
            }
        });
    }

    public void openRegActivity() {
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }
    private void validate(String userName, String userPassword){

        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Activity2.this,"Log In Successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity2.this,SecondActivity.class));
                }
                else{
                    Toast.makeText(Activity2.this,"Opps !! Log In failed",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
