package com.example.loginreg;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Eusername, Epass;
    Button b1;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        Eusername = (EditText)findViewById(R.id.username);
        Epass = (EditText)findViewById(R.id.Password);
        b1 = (Button)findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Eusername.getText(). toString();
                String password = Epass.getText(). toString();
                Boolean Chkemailpass = db.emailpassword(email,password);

                if(Chkemailpass==true)
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            }

        });
    }




}