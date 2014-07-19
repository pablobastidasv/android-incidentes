package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.os.AsyncTask;

/**
 * Created by Mitzy Valencia on 16/07/2014.
 */
public class CrearAsyncTask extends AsyncTask<String,String, String> {

    private Activity context;
    //
    private ConsultarAsyncTask adpt;

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    }
}
