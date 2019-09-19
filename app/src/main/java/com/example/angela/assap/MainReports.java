package com.example.angela.assap;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainReports extends AppCompatActivity {

    ImageButton createNewButton;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allreports);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        db = new Database(this);


        ArrayList<String> theList = new ArrayList<>();
        Cursor data = db.viewData();

        if(data.getCount() == 0){

            Toast.makeText(MainReports.this,"Database was empty",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }

        }

        createNewButton = (ImageButton) findViewById(R.id.createnew);
        createNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createNewActivity = new Intent(MainReports.this, CreateNew.class);
                startActivity(createNewActivity);
            }
        });
    }
}
