package com.example.pc.iot;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pc on 06/12/2016.
 */

public class ThermoStatGetAsycTask extends AsyncTask<Void,Void,String> {

    IDataUpdate iDataUpdate;
    public ThermoStatGetAsycTask(IDataUpdate iDataUpdate) {
        this.iDataUpdate = iDataUpdate;
    }

    @Override
    protected String doInBackground(Void... params) {
        URL url = null;
        StringBuilder sb = new StringBuilder();
        try {
            url = new URL("http://192.168.1.2/get_temp.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));

            String line = "";
            while ( (line = bufferedReader.readLine()) !=null)
            {
                sb.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
       if (s !=null)
           iDataUpdate.SetTempratureData(s);
    }

    interface IDataUpdate
    {
        void SetTempratureData(String temp);
    }
}
