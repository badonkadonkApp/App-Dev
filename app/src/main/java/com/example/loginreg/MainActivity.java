package com.example.loginreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText eEmail, ePass, eConfirmpass, eName, eAddress, eGender, eStatus;
    Button bRegister, bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        eEmail = (EditText) findViewById(R.id.email);
        ePass = (EditText) findViewById(R.id.pass);
        eConfirmpass = (EditText) findViewById(R.id.cpass);
        eName = (EditText) findViewById(R.id.name);
        eAddress = (EditText) findViewById(R.id.address);
        eGender = (EditText) findViewById(R.id.gender);
        eStatus = (EditText) findViewById(R.id.status);
        bRegister = (Button) findViewById(R.id.register);
        bLogin = (Button) findViewById(R.id.login);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sEmail = eEmail.getText().toString();
                String sPassword = ePass.getText().toString();
                String sConfirmpass = eConfirmpass.getText().toString();
                String sName = eName.getText().toString();
                String sAddress = eAddress.getText().toString();
                String sGender = eGender.getText().toString();
                String sStatus = eStatus.getText().toString();
                if (sEmail.equals(" ") || sPassword.equals(" ") || sConfirmpass.equals(" ") || sName.equals(" ") || sAddress.equals(" ") || sGender.equals(" ") || sStatus.equals(" ")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (sPassword.equals(sConfirmpass)) {
                        Boolean chkemail = db.chkemail(sEmail);
                        if ( chkemail==true) {
                            Boolean insert = db.insert(sEmail, sPassword, sConfirmpass, sName, sAddress, sGender, sStatus);
                            if (insert==true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });
    }

}