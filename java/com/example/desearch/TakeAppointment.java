package com.example.desearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TakeAppointment extends AppCompatActivity {
    private Button T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_appointment);

        T=(Button)findViewById(R.id.t);
        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Confirm();
            }
        });
    }
    public void Confirm(){
        Intent intent=new Intent(this,Confirm.class);
        startActivity(intent);

    }
}
