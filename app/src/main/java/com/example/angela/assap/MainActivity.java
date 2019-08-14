package com.example.angela.assap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnLogon;
    private TextView tvAttempt;
    private TextView tvRegister;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etLogin = (EditText)findViewById(R.id.etLogin);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogon = (Button)findViewById(R.id.btnLogon);
        tvAttempt = (TextView)findViewById(R.id.tvAttempt);


        btnLogon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(etLogin.getText().toString(), etPassword.getText().toString());
            }
        });

        etLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etLogin.setText("");
            }
        });

        etPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etPassword.setText("");
            }
        });

    }

    private void validate(String userName, String userPassword) {
        tvAttempt.setText(Integer.toString(counter));

        if ((userName.equals("Admin@ing.com")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, MainReports.class);
            Toast.makeText(MainActivity.this,"Username and password are correct. Welcome !",
                    Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this,"Username and password is NOT correct.",
                    Toast.LENGTH_SHORT).show();
            counter--;
            tvAttempt.setText(Integer.toString(counter));
            if(counter==0) {
                btnLogon.setEnabled(false);
                Toast.makeText(MainActivity.this, "After 5 failed login restart application.",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}
