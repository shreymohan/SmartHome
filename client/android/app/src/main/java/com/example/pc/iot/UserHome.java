package com.example.pc.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHome extends AppCompatActivity implements ThermoStatGetAsycTask.IDataUpdate{
    Button light,thermostat,weather,camera;
    public static final String TAGTEMP = "CURRENTTEMP";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        light=(Button)findViewById(R.id.btn_light);
        thermostat=(Button)findViewById(R.id.btn_thermostat);
        weather=(Button)findViewById(R.id.btn_weather);
        camera=(Button)findViewById(R.id.btn_camera);
    }

    public void light(View view){
       Intent intent=new Intent(UserHome.this,light.class);
        startActivity(intent);
    }
    public void thermo(View view){

        new ThermoStatGetAsycTask(this).execute();


    }

    @Override
    public void SetTempratureData(String temp) {
        Intent intent = new Intent(UserHome.this, thermo.class);
        if(temp !=null) {
            intent.putExtra(TAGTEMP,temp);
        }
        startActivity(intent);
    }
}
