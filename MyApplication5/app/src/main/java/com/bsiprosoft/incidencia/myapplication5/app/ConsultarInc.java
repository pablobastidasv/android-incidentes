package com.bsiprosoft.incidencia.myapplication5.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.asynctask.ConsultarAsyncTask;

/**
 * Created by Mitzy Valencia
 */
public class ConsultarInc  extends ActionBarActivity{

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

		/*new ConsultarAsyncTask(this).execute("http://rest.bsiprosoft.com:7004/incidencias/",
                txtNumIncidencia.getText().toString());*/
            new ConsultarAsyncTask(this).execute("http://146.148.36.217:7004/incidencias/",
                    txtNumIncidencia.getText().toString());



            Intent i = new Intent(this, InfoListInc.class);
            TextView txtNumInc = (TextView) this.findViewById(R.id.txtNumIncConsul);
            // i.putExtra("Número de Incidencia: ",txtNumInc.getText().toString());
            this.startActivity(i);
		}
		catch(Exception ex)
		{
			Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
		}




    }

}
