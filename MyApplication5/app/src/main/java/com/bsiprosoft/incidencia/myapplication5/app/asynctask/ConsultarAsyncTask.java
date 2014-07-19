package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class ConsultarAsyncTask extends AsyncTask<String,String, String> {

    private Activity context;
    //
    private ConsultarAsyncTask adpt;

    public ConsultarAsyncTask(Activity context, ConsultarAsyncTask adpt) {
        this.context = context;
        this.adpt = adpt;
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
