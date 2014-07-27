package com.bsiprosoft.incidencia.myapplication5.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.asynctask.ConsultarAsyncTask;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import java.util.ArrayList;

/**
 * Created by Mitzy Valencia
 */
public class InfoListInc extends Activity implements AdapterView.OnItemClickListener {

    private IncidenciaAdapter adptInc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*this.setContentView(R.layout.infolist_inc);
        adptInc  = new IncidenciaAdapter(new ArrayList<IncidenciaVO>(), this);
        ListView lView = (ListView) findViewById(R.id.listInfoInc);
        lView.setAdapter(adptInc);
        lView.setOnItemClickListener(this);
        new ConsultarAsyncTask(this, adptInc).execute("http://146.148.36.217:7004/incidencias/" );

    */
        this.setContentView(R.layout.infolist_inc);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



    }
}
