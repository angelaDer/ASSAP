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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


public class MainReports extends AppCompatActivity {


    private static final String TAG = "MainReports";

    ImageButton createNewButton;
    Database db;
    ArrayList<String> theList = new ArrayList<>();

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, theList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

/*
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        theList.add("Havasu Falls");
        theList.add("Trondheim");
        theList.add("Portugal");
        theList.add("Rocky Mountain National Park");


    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allreports);

        initRecyclerView();

/*      ListView listView = (ListView) findViewById(R.id.recyclerv_view);*/
        db = new Database(this);

        Cursor data = db.viewData();

        if(data.getCount() == 0){

            Toast.makeText(MainReports.this,"Database was empty",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
              //  theList.setAdapter(listAdapter);
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
