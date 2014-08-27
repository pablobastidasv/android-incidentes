package com.syshelp.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

import com.syshelp.app.R;
import com.syshelp.app.asynctask.CrearAsyncTask;

/**
 * Created by Mitzy Valencia on 24/08/2014.
 */
public class InfoCreated extends ActionBarActivity{

    private String id , descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.info_created_inc);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            id =  bundle.getString("usuarioId");
            descripcion = bundle.getString("descripcion");
            new CrearAsyncTask(this).execute("http://146.148.36.217:7004/incidencias/crear",
                    id,descripcion);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onClickVolverMain(View view){

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }


}
