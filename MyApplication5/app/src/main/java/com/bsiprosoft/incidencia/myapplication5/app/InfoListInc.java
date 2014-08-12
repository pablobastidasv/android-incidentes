package com.bsiprosoft.incidencia.myapplication5.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.asynctask.ConsultarAsyncTask;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import java.util.ArrayList;

/**
 * Created by Mitzy Valencia
 */
public class InfoListInc extends Activity {

    private IncidenciaAdapter adptInc;
    private IncidenciaVO inc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.infolist_inc);
        adptInc = new IncidenciaAdapter();


       TextView categoria = (TextView)this.findViewById(R.id.txtCategoria);
       categoria.setText(inc.getCategoria());



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    public  void datosInc (IncidenciaAdapter adpt){
        inc = new IncidenciaVO();
        inc.setCategoria(adpt.getCategoria());

    }
}


