package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Message;
import android.util.JsonReader;
import android.util.LogPrinter;
import android.util.Printer;
import android.widget.EditText;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.CrearInc;
import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class CrearAsyncTask extends AsyncTask<String,String, String> {


    private IncidenciaAdapter adpt;

    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;


    public CrearAsyncTask(Activity ctx) {
        this.context = new WeakReference<Activity>(ctx);
        progressDialog = new ProgressDialog(context.get());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Creando Incidencia ... ");
        progressDialog.setCancelable(false);
        progressDialog.setMax(200);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            String responseText = "";
            try {


                //JSONObject obj = new JSONObject(s);
                JSONArray jsonArray = new JSONArray(new JSONObject(s).getString("mensaje"));

                ArrayList<IncidenciaVO> responsePost = new ArrayList<IncidenciaVO>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                    IncidenciaVO inc = new IncidenciaVO();
                    inc.setNumIncidencia(jsonObject.getString("numeroIncidencia"));
                    responsePost.add(inc);

                }

                //adpt.setListItemsInc(responsePost);
                //adpt.notifyDataSetChanged();

            } catch (JSONException e) {

                //Toast.makeText(context.get(), "Su incidencia no pudo ser creada !!!", Toast.LENGTH_SHORT).show();
                Toast.makeText(context.get(), e.toString(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(context.get(), "FAIL !!!", Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                CrearAsyncTask.this.cancel(true);
            }
        });
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected String doInBackground(String... params) {

        return com.bsiprosoft.incidencia.myapplication5.app.helpers.RequestManagerHelper.startPostRequest(params[0],
                new BasicNameValuePair("descripcion", params[2]), new BasicNameValuePair("docPersona", params[1]));
    }


}