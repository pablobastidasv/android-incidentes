package com.bsiprosoft.incidencia.myapplication5.app.helpers;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class RequestManagerHelper {


    public static String startPostRequest(String url, BasicNameValuePair... params)
    {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        String text = null;
        JSONObject j = new JSONObject();
        try {
            // Add your data
            JSONObject jsonRequest = new JSONObject();
            for (BasicNameValuePair p : params) {
                jsonRequest.put(p.getName(), p.getValue());
            }

            httppost.setHeader("content-type", "application/json");
            httppost.setEntity(new StringEntity(jsonRequest.toString()));

            HttpResponse response = httpclient.execute(httppost);
            response.setHeader("content-type", "application/json");
            HttpEntity entity = response.getEntity();

            if (entity != null){

                InputStream instream = entity.getContent();
                text = convertStreamToString(instream);
                instream.close();
            }

        } catch (ClientProtocolException e) {
            Log.e(RequestManagerHelper.class.getCanonicalName(), e.getMessage(), e);

        } catch (IOException e) {
            Log.e(RequestManagerHelper.class.getCanonicalName(), e.getMessage(), e);
        } catch (JSONException e) {
            Log.e(RequestManagerHelper.class.getCanonicalName(), e.getMessage(), e);
        }
        return text;

    }


    public static String startGetRequest(String url)
    {
        HttpClient httpClient = new DefaultHttpClient();

        HttpContext localContext = new BasicHttpContext();

        HttpGet httpGet = new HttpGet(url);

        String text = null;
        try {

            httpGet.setHeader("content-type", "application/json");
            HttpResponse response = httpClient.execute(httpGet, localContext);

            response.setHeader("content-type", "application/json");
            HttpEntity entity = response.getEntity();

            if (entity != null){

                InputStream instream = entity.getContent();
                text = convertStreamToString(instream);
                instream.close();
            }


        } catch (Exception e) {
            //return e.getLocalizedMessage();
            Log.e(RequestManagerHelper.class.getCanonicalName(), e.getMessage(), e);
        }
        return text;

    }

    private static  String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
        InputStream in = entity.getContent();
        StringBuffer out = new StringBuffer();
        int n = 1;
        while (n>0) {
            byte[] b = new byte[4096];
            n =  in.read(b);
            if (n>0) out.append(new String(b, 0, n));
        }
        return out.toString();
    }
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}
