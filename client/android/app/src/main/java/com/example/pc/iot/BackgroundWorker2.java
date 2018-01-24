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
 * Created by pc on 27/11/2016.
 */
public class BackgroundWorker2 extends AsyncTask<Integer,Void,String> implements Runnable{
    public static back2userhome back2userhome;
    String postData;
    BufferedWriter bufferedWriter;
    private Context context;

    public BackgroundWorker2(back2userhome back2userhome) {
        this.back2userhome = back2userhome;
    }

    //public BackgroundWorker1(Context c){this.context=context;}
    @Override
    protected String doInBackground(Integer... params) {
        int setTemp = params[0];
        String login_url = "http://192.168.1.2/thermo.php";
        String st=Integer.toString(setTemp);
        try {
            URL url = new URL(login_url);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream outputStream = http.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String postData = URLEncoder.encode("setTemp", "UTF-8") + "=" + URLEncoder.encode(st, "UTF-8");
            bufferedWriter.write(postData);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
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
            back2userhome.backtohome(result);
    }
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    public void run() {

    }
}
interface back2userhome{
    void backtohome(String result);
}