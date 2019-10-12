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
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


public class MainReports extends AppCompatActivity {


    private static final String TAG = "MainReports";
    private TextView tvHello;

    ImageButton createNewButton;
    ImageButton allReportsButton;
    ImageButton inProgressButton;
    ImageButton doneButton;
    Database db;
    ArrayList<String> theList = new ArrayList<>();
    private RecyclerViewAdapter adapter;

    public void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, theList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

   //     adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
   //         @Override
   //         public void onDeleteClick(int position) {

    //        }

    //        @Override
    //        public void onItemClick(int position) {
    //            theList.get(position, "Clicked");

    //        }

            //   adapter.setOnItemClickListener (new adapter.setOnItemClickListener() {
            //@Override
            //      public void onItemClick (int position){
            //open new intent
            //      }


    //    });
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

        Bundle Extra = getIntent().getExtras();
        String getText = Extra.getString("MyInput");
        tvHello = (TextView)findViewById(R.id.tvHello);
        tvHello.setText(getText);


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

    public void onClickFab (View view) {

        Intent intent = new Intent(this, Details.class);
        startActivity(intent);
    }


}
