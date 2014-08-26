package com.syshelp.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.syshelp.app.R;
import com.syshelp.app.asynctask.CrearAsyncTask;

/**
 * Created by Mitzy Valencia on 24/08/2014.
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

    // metodo para la creacion de una nueva incidencia externa
    public void onClickCrearIncidencia (View view){

        try{
            EditText txtIdCliente = (EditText) this.findViewById(R.id.txtIdCliente);
            EditText txtDescripcion = (EditText) this.findViewById(R.id.txtDescripcion);
            Intent i = new Intent(this, InfoCreated.class);
            i.putExtra("usuarioId", txtIdCliente.getText().toString());
            i.putExtra("descripcion", txtDescripcion.getText().toString());
            this.startActivity(i);
        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //
    }



}

