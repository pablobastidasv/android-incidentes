package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class ConsultarAsyncTask extends AsyncTask<String,String, String> {

    //private Activity context;
    //
    private ConsultarAsyncTask adpt;

    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;


    public ConsultarAsyncTask(Activity ctx)
    {
        this.context = new WeakReference<Activity>(ctx);
        progressDialog = new ProgressDialog(context.get());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("si paso por aqui pa consultar ");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
    }

//    public ConsultarAsyncTask(Activity context, ConsultarAsyncTask adpt) {
//        this.context = context;
//        this.adpt = adpt;
//    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... params) {


        return null;
    }
}
