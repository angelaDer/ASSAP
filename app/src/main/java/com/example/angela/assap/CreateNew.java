package com.example.angela.assap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.support.v4.app.ActivityCompat;



public class CreateNew extends AppCompatActivity {

    ImageButton cameraButton;
    ImageView photo1;
    Intent intent;

    Database db;
    Button add_data;
    EditText editText;
    EditText editTextDescription;
    EditText editTextLocalisation;

    ImageButton createNewButton;
    ImageButton allReportsButton;
    ImageButton inProgressButton;
    ImageButton doneButton;

    public static final int RequestPermissionCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnew);

        photo1 = findViewById(R.id.photo1);
        cameraButton = findViewById(R.id.cameraButton);

        EnableRuntimePermission();

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 7);

            }
        });


        add_data = findViewById(R.id.button3);
        editText = findViewById(R.id.editText5);
        editTextDescription = findViewById(R.id.editText6);
        editTextLocalisation = findViewById(R.id.editText7);
        db = new Database(this);



        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText.getText().toString();
                String newDescription = editTextDescription.getText().toString();
                String newLocalisation = editTextLocalisation.getText().toString();

                if(editText.length() != 0){

                    AddData(newEntry, newDescription, newLocalisation);
                    editText.setText("");
                    editTextDescription.setText("");
                    editTextLocalisation.setText("");
                   // Intent createNewActivity = new Intent(CreateNew.this, MainReports.class);
                   // startActivity(createNewActivity);
                }else{

                    Toast.makeText(CreateNew.this,"Add something",Toast.LENGTH_LONG).show();

                }
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

    public void AddData(String newEntry, String newDescription, String newLocalisation){
        boolean insertData = db.addData(newEntry, newDescription, newLocalisation);

        if(insertData==true){
            Toast.makeText(CreateNew.this,"Data added",Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(CreateNew.this,"Data not added!!!",Toast.LENGTH_LONG).show();
        }
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 7 && resultCode == RESULT_OK) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            photo1.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(CreateNew.this,
                Manifest.permission.CAMERA))
        {

            Toast.makeText(CreateNew.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(CreateNew.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(CreateNew.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(CreateNew.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
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
