package com.example.angela.assap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainReports extends AppCompatActivity {

    ImageButton createNewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allreports);

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
