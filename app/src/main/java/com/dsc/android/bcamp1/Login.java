package com.dsc.android.bcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText lnameEdittext, lpassEditText;
    private Button loginButton;
    String lname, lpass;
    TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new TinyDB(this);
        initView();
        loginButton.setOnClickListener(this);
    }

    private void initView(){
        lnameEdittext = findViewById(R.id.lnameEditText);
        lpassEditText = findViewById(R.id.lpassEditText);
        loginButton = findViewById(R.id.loginButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                getInfo();
                break;
        }
    }

    private void getInfo(){
        lname = lnameEdittext.getText().toString();
        lpass = lpassEditText.getText().toString();
        if (lname.isEmpty() || lpass.isEmpty()) {
            Toast.makeText(this, "One or more fields is Empty", Toast.LENGTH_SHORT).show();
        }
        if (lname.equals(db.getString("Name")) && lpass.equals(db.getString("Password"))){
            Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
