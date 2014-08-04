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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.infolist_inc);
  /*      adptInc  = new IncidenciaAdapter(new ArrayList<IncidenciaVO>(), this);
        EditText txtNumIncidencia = (EditText) this.findViewById(R.id.txtNumIncidencia);
        String  url = "http://146.148.36.217:7004/incidencias/"+txtNumIncidencia.getText().toString();
        new ConsultarAsyncTask(this).execute(url);
        TextView categoria = (TextView) findViewById(R.id.txtCategoria);
        categoria.setText((CharSequence) adptInc.getItem(1).getCategoria());*/

      /*  ListView lView = (ListView) findViewById(R.id.lvUsers);
        lView.setAdapter(adptInc);
        lView.setOnItemClickListener(this);*/


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}
