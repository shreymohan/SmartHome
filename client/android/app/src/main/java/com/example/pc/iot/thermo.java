package com.example.pc.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class thermo extends AppCompatActivity implements back2userhome{
    TextView tv1, tv2;
    EditText et1,et2;
    Button b1;
    int st,ct;
    private Handler handler;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermo);
        String currentTemp = "";
        tv1=(TextView)findViewById(R.id.tv_1);
        tv2=(TextView)findViewById(R.id.tv_2);
        et1=(EditText) findViewById(R.id.et_1);
        if(getIntent().getExtras().containsKey(UserHome.TAGTEMP))
        {
            currentTemp = getIntent().getExtras().getString(UserHome.TAGTEMP);
            et1.setText(currentTemp);
        }

        et2=(EditText) findViewById(R.id.et_2);
        b1=(Button) findViewById(R.id.btn_1);
    }
    public void setTemperature(View view){
        String curTemp= et1.getText().toString();
         ct=Integer.parseInt(curTemp);
        String setTemp=et2.getText().toString();
         st=Integer.parseInt(setTemp);
        new BackgroundWorker2(this).execute(st);

    }


    @Override
    public void backtohome(String result) {
        if(result!=null) {
            et1.setText(result);
            Toast.makeText(thermo.this, "status of thermostat is updated", Toast.LENGTH_LONG);
            Intent intent = new Intent(thermo.this, UserHome.class);
            startActivity(intent);
        }
    }


}


