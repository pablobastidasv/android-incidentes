package com.bsiprosoft.incidencia.myapplication5.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.asynctask.ConsultarAsyncTask;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import java.lang.ref.WeakReference;

/**
 * Created by Mitzy Valencia
 */
public class InfoListInc extends Activity {


    private IncidenciaVO inc;
    private WeakReference<Activity> context;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.infolist_inc);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            message =  bundle.getString("numIncidencia");
        }

        String  url = "http://146.148.36.217:7004/incidencias/"+message;
        new ConsultarAsyncTask(this).execute(url);

        TextView numIncidencia = (TextView) this.findViewById(R.id.txtNumIncidencia);
        numIncidencia.setText(message);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void onClickVerSeguimientos (View view){


        try{

            Intent i = new Intent(this, InfoListSeg.class);
            this.startActivity(i);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            Toast.makeText(this, "Error ", Toast.LENGTH_SHORT).show();
        }





    }


    @Override
    protected void onStart() {
        super.onStart();
    }



}


