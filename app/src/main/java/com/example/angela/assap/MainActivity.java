package com.example.angela.assap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

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

        etLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // if (s.length() > 0) {
                //if (!etLogin.getText().toString().contains("@ing.com") && !etLogin.getText().toString().matches("")) {
                if (!etLogin.getText().toString().contains("@ing.com") && s.length() > 0) {
                    etLogin.setError("E-mail needs to contain @ing.com");
                    btnLogon.setEnabled(false);
                }

                if (etLogin.getText().toString().contains("@ing.com") && s.length() < 0 && counter > 0) {
                    btnLogon.setEnabled(true);
                }
            }
        });

        etPassword = (EditText)findViewById(R.id.etPassword);
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // if (s.length() > 0) {
                //if (!etLogin.getText().toString().contains("@ing.com") && !etLogin.getText().toString().matches("")) {
                if (s.length() == 0) {
                    etPassword.setError("Password cannot be empty");
                    btnLogon.setEnabled(false);
                }
                if (s.length() > 0 && counter > 0) {
                    btnLogon.setEnabled(true);
                }
            }
        });
        btnLogon = (Button)findViewById(R.id.btnLogon);
        tvRegister = (TextView)findViewById(R.id.tvRegister);
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

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivityRegister.class);
                startActivityForResult(myIntent,0);
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
            Toast.makeText(MainActivity.this,"Username and password is NOT correct.\nNumber of left attempts to logon: " + Integer.toString(counter),

                    Toast.LENGTH_SHORT).show();

            counter--;
            tvAttempt.setText("Number of attempts to logon: " + Integer.toString(counter));
            if(counter==0) {
                btnLogon.setEnabled(false);
                Toast.makeText(MainActivity.this, "After 5 failed login restart application.",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}
