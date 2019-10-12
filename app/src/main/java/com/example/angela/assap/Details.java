package com.example.angela.assap;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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

        //Nie działa
        //((TextView) findViewById(R.id.twdetails1)).setText(title);
        //twdetails1 = (EditText)findViewById(R.id.twdetails1);


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