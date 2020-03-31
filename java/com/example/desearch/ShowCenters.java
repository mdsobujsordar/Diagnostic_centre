package com.example.desearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShowCenters extends AppCompatActivity {
    private Button TA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_centers);

        TA=(Button)findViewById(R.id.ta);
        TA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TakeAppointment();
            }
        });
    }
    public void TakeAppointment(){
        Intent intent=new Intent(this,TakeAppointment.class);
        startActivity(intent);
    }
}
