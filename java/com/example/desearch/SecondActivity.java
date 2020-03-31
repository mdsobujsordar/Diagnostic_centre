package com.example.desearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button Logout;
    private Button SC;
    private SearchView mySearchView;
    private ListView myList;

    ArrayList<String>list;
    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mySearchView=(SearchView)findViewById(R.id.searchView);
        myList=(ListView)findViewById(R.id.myList);
        list=new ArrayList<>();

        list.add("Diarrhea");
        list.add("Dengue");
        list.add("Heart Diseases");
        list.add("High Pressure");
        list.add("Diabetics");
        list.add("Pregnancy");
        list.add("Polio");
        list.add("Typhoid");
        list.add("Tuberculosis");
        list.add("Hepatitis A");
        list.add("Hepatitis b");
        list.add("Varicella");
        list.add("Rabies");

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();
        Logout=(Button)findViewById(R.id.btnLogout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(SecondActivity.this,Activity2.class));
            }
        });
        SC=(Button)findViewById(R.id.sc);
        SC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowCenters();
            }
        });

    }
    public void ShowCenters(){

        Intent intent=new Intent(this,ShowCenters.class);
        startActivity(intent);
    }
}
