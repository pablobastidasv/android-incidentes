package com.bsiprosoft.incidencia.myapplication5.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.asynctask.ConsultarAsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by Mitzy Valencia
 */
public class ConsultarInc  extends ActionBarActivity{

    private WeakReference<Activity> context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.consultar_inc);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onClickVolverMain (View view){

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }


    public void onClickConsultarIncidencia (View view){


       try{
		EditText txtNumIncidencia = (EditText) this.findViewById(R.id.txtNumIncidencia);
            String  url = "http://146.148.36.217:7004/incidencias/"+txtNumIncidencia.getText().toString();
            new ConsultarAsyncTask(this).execute(url);
		}
		catch(Exception ex)
		{
            ex.printStackTrace();

			Toast.makeText(this, "Error ", Toast.LENGTH_SHORT).show();
		}

     /*  Intent i = new Intent(this, InfoListInc.class);
        this.startActivity(i);*/



    }

}
