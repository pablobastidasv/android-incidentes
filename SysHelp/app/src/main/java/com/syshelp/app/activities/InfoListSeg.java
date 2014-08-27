package com.syshelp.app.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.syshelp.app.R;
import com.syshelp.app.adapters.SeguimientoAdapter;
import com.syshelp.app.pojos.SeguimientoVO;

import java.util.ArrayList;

/**
 * Created by Mitzy Valencia
 */
public class InfoListSeg extends Activity implements AdapterView.OnItemClickListener {

    private SeguimientoAdapter adptSeg;
    private Context ctx;
    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

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

        if (adptSeg.isEmpty()){

            TextView title = (TextView) findViewById(R.id.lblSeguimiento);
            title.setText("!Lo sentimos!...");
            TextView desc = (TextView) findViewById(R.id.txtDescSeg);
            desc.setText("La incidencia no registra seguimientos. " +
                    "Por favor ponte en contacto para mayor información.");

           }
        else{

            ListView lView = (ListView) findViewById(R.id.listInfoSeg);
            lView.setAdapter(adptSeg);
            lView.setOnItemClickListener(this);
        }


    }


    public void onClickVolverMain(View view){

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }


}
