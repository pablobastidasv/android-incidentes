package com.syshelp.app.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.syshelp.app.R;
import com.syshelp.app.adapters.SeguimientoAdapter;
import com.syshelp.app.asynctask.ConsultarAsyncTask;
import com.syshelp.app.pojos.SeguimientoVO;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Mitzy Valencia
 */
public class InfoListSeg extends Activity {


    private Context ctx;
    private SeguimientoAdapter adptSeg;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.infolist_seg);

        //adptSeg  = new SeguimientoAdapter(new ArrayList<SeguimientoVO>(), this);

//       if(!adptSeg.isEmpty()){
//             ListView lView = (ListView) findViewById(R.id.listInfoSeg);
//            lView.setAdapter(adptSeg);
//            lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view,
//                                        int position, long id) {
//
//                    int itemPosition     = position;
//                    String  itemValue    = (String) lView.getItemAtPosition(position);
//                    // Show Alert
//                    Toast.makeText(getApplicationContext(),
//                            "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG) .show();
//
//                }
//
//            });
//        }else{
//           TextView title = (TextView) this.findViewById(R.id.lblSeguimiento);
//                        title.setText("!Lo sentimos!...");
//                        TextView desc = (TextView) this.findViewById(R.id.txtDescSeg);
//                        desc.setText("La incidencia no registra seguimientos. " +
//                                "Por favor ponte en contacto para mayor información.");
//        }

    }


    public void onClickVolverMain(View view){

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }


}
