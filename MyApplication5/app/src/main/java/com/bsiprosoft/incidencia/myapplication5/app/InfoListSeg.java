package com.bsiprosoft.incidencia.myapplication5.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bsiprosoft.incidencia.myapplication5.app.adapters.SeguimientoAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.asynctask.ConsultarAsyncTask;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.SeguimientoVO;

import java.util.ArrayList;

/**
 * Created by Mitzy Valencia
 */
public class InfoListSeg extends Activity implements AdapterView.OnItemClickListener{

    private SeguimientoAdapter adptSeg;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            this.setContentView(R.layout.infolist_seg);
        adptSeg  = new SeguimientoAdapter(new ArrayList<SeguimientoVO>(), this);
        ListView lView = (ListView) findViewById(R.id.listInfoSeg);
        lView.setAdapter(adptSeg);
        lView.setOnItemClickListener(this);
        //new ConsultarAsyncTask(this, adptSeg).execute("http://146.148.36.217:7004/incidencias/"

        //);


        this.setContentView(R.layout.infolist_seg);
    }
}
