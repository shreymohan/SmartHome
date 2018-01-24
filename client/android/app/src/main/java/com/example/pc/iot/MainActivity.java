package com.example.pc.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements BackgroundWorker.ILoginHandler {
    EditText user_name,Password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name=(EditText)findViewById(R.id.et_username);
        Password=(EditText)findViewById(R.id.et_password);
        login=(Button)findViewById(R.id.login);
    }
    public void login(View view){
        String username=user_name.getText().toString();
        String password=Password.getText().toString();
        String type="login";
        new BackgroundWorker(MainActivity.this).execute(type,username,password);

    }

    @Override
    public void LoginSuccessHandler(String result) {

        if(result.toLowerCase().contains("no")) {
            Toast.makeText(MainActivity.this,"Login Successful but rspi not connected",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, UserHome.class);
            startActivity(intent);
        }
        else if(result.toLowerCase().contains("yes")) {
            Toast.makeText(MainActivity.this,"Login Successful and rspi is connected",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, UserHome.class);
            startActivity(intent);
        }

        else {
            Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
        }
    }
}
