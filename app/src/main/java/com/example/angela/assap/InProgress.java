package com.example.angela.assap;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InProgress extends AppCompatActivity {

    ImageButton createNewButton;
    ImageButton allReportsButton;
    ImageButton inProgressButton;
    ImageButton doneButton;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inprogress);

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
