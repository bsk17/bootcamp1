package com.dsc.android.bcamp1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEditText, emaileditText, passEditText, cnfPassEdittext;
    private Button regButton;
    private String name, email, password, cnfpassword;
    private TinyDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new TinyDB(this);
        initView();
        regButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.regButton:
                getInfo();
                register();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                break;
        }
    }


    // this is to initialize the components
    private void initView() {
        nameEditText = findViewById(R.id.nameEditText);
        emaileditText = findViewById(R.id.emailEditText);
        passEditText = findViewById(R.id.passEditText);
        cnfPassEdittext = findViewById(R.id.cnfpassEditText);
        regButton = findViewById(R.id.regButton);
    }


    private void getInfo(){
        name = nameEditText.getText().toString().trim();
        email = emaileditText.getText().toString().trim();
        password = passEditText.getText().toString();
        cnfpassword = cnfPassEdittext.getText().toString();

    }

    private void register(){
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || cnfpassword.isEmpty() ){
            Toast.makeText(this, "One or more fields is Empty", Toast.LENGTH_SHORT).show();
        }else{
            if (password.equals(cnfpassword)){
                db.putString("Name", name);
                db.putString("Email", email);
                db.putString("Password", password);
                Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Login.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Passwords did not match", Toast.LENGTH_LONG).show();
            }
        }
    }
}
