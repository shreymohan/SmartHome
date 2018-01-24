package com.example.pc.iot;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by pc on 03/12/2016.
 */

/*public class BackgroundWorker3 extends AsyncTask<Void,Void,String> {

    String postData;
    BufferedWriter bufferedWriter;
    private Context context;



    public BackgroundWorker3(thermo thermo) {
    }
    //public BackgroundWorker1(Context c){this.context=context;}

    protected String doInBackground(Integer... params) {
        int setTemp = params[0];
        String login_url = "http://192.168.1.3:8080/thermo1.php";
        String st=Integer.toString(setTemp);
        try {
            URL url = new URL(login_url);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            InputStream inputStream = http.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    protected void onPostExecute(String result){
        if(result!=null)

    }
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    {
}*/
