package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

import org.apache.http.message.BasicNameValuePair;

import java.lang.ref.WeakReference;

/**
 * Created by Mitzy Valencia on 16/07/2014.
 */
public class CrearAsyncTask extends AsyncTask<String,String, String> {

    //private Activity context;
    //
    private ConsultarAsyncTask adpt;

    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;


    public CrearAsyncTask(Activity ctx)
    {
        this.context = new WeakReference<Activity>(ctx);
        progressDialog = new ProgressDialog(context.get());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("si paso por aqui ");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialog){
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
                new BasicNameValuePair("descripcion", params[2]),new BasicNameValuePair("docPersona", params[1]));
    }
}
