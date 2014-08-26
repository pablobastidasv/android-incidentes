package com.syshelp.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.syshelp.app.R;
import com.syshelp.app.adapters.SeguimientoAdapter;
import com.syshelp.app.asynctask.ConsultarAsyncTask;
import com.syshelp.app.pojos.IncidenciaVO;
import com.syshelp.app.pojos.SeguimientoVO;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Mitzy Valencia  on 24/08/2014.
 */
public class InfoListInc extends Activity {


    private IncidenciaVO inc;
    private WeakReference<Activity> context;
    private String message;
    private SeguimientoAdapter adptSeg;

    /**
     *
     * @param savedInstanceState
     */
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

    /**
     *
     * @param view
     */
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