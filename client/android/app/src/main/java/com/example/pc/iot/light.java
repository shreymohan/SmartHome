package com.example.pc.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class light extends AppCompatActivity implements backtouserhome {
    Button on,off;
    TextView light;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        on=(Button)findViewById(R.id.btn_on);
        off=(Button)findViewById(R.id.btn_off);
        light=(TextView)findViewById(R.id.tv_light);
    }

    public void light_on(View view){
        String status="on";
        new BackgroundWorker1(this).execute(status);
    }

    public void light_off(View view){
        String status="off";
        new BackgroundWorker1(this).execute(status);
    }


    public void backtohome(String result) {
        if(result!=null) {
            Toast.makeText(light.this, "status of lights is updated", Toast.LENGTH_LONG);
            Intent intent = new Intent(light.this, UserHome.class);
            startActivity(intent);
        }
    }
}
