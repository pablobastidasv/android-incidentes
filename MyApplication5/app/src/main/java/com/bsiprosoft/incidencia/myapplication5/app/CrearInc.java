package com.bsiprosoft.incidencia.myapplication5.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by mikillo on 09/07/2014.
 */
public class CrearInc extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.crear_inc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onClickVolverMain (View view){

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }

    public void onClickCrearIncidencia (){

    }

}
