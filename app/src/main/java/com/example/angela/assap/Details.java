package com.example.angela.assap;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Details extends AppCompatActivity {

    ImageButton createNewButton;
    ImageButton allReportsButton;
    ImageButton inProgressButton;
    ImageButton doneButton;
    String title;
    String description;
    String localisation;
    Database db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        createNewButton = (ImageButton) findViewById(R.id.createnew);
        createNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateNew();
            }
        });


        allReportsButton = (ImageButton) findViewById(R.id.imageButton2);
        allReportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainReports();
            }
        });

        inProgressButton = (ImageButton) findViewById(R.id.imageButton5);
        inProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInProgress();
            }
        });

        doneButton = (ImageButton) findViewById(R.id.imageButton6);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDone();
            }
        });


        Bundle Extra = getIntent().getExtras();
        title = Extra.getString("image_name");
        description = Extra.getString("description");

        //Nie działa
        ((TextView) findViewById(R.id.twdetails1)).setText(title);

        db = new Database(this);

        Cursor data = db.viewDescription(title);

        if(data.getCount() == 0){
            Toast.makeText(Details.this,"Database was empty",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                description = data.getString(2);
                localisation = data.getString(3);
            }
        }

        ((TextView) findViewById(R.id.twdetails2)).setText(description);
        ((TextView) findViewById(R.id.twdetails3)).setText(localisation);

    }

    public void openCreateNew() {

        Intent intent = new Intent(this, CreateNew.class);
        startActivity(intent);
    }

    public void openMainReports() {

        Intent intent = new Intent(this, MainReports.class);
        startActivity(intent);
    }


    public void openInProgress() {

        Intent intent = new Intent(this, InProgress.class);
        startActivity(intent);
    }



    public void openDone() {

        Intent intent = new Intent(this, Done.class);
        startActivity(intent);
    }

}