package com.example.r0b0n.maps;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by R0B0N on 11/12/2017.
 */

public class DownloadURL {

    //reads the URL
    public String readURL(String MyURL) throws IOException{
        String data = "";
        //handaling methods that reads the string
        InputStream inputStream= null;
        HttpURLConnection urlConnection = null;

        try {
            //creates the url
            URL url = new URL(MyURL);
            //opens the url
            urlConnection = (HttpURLConnection)url.openConnection();
            //connects to the url
            urlConnection.connect();

            //reads the data from the url
            inputStream = urlConnection.getInputStream();


            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            //reads each line
            while((line = br.readLine())!=null){
                //appends to the string buffer
                sb.append(line);
            }

            //converts the string buffers to a string and put it in data
            //and close the string buffer
            data = sb.toString();
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //this fanally blocks always runs even if there is an exception
        finally {
            inputStream.close();
            urlConnection.disconnect();
        }
        Log.d("DownloadURL","Returning data= "+data);
        return data;
    }
}
