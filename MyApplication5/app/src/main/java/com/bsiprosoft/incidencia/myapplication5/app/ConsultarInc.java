package com.bsiprosoft.incidencia.myapplication5.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by mikillo on 09/07/2014.
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

    public void onClickConsultarIncidencia (){
        /*try{
		EditText txtLogin = (EditText) this.findViewById(R.id.txtLogin);

		EditText txtPassword = (EditText) this.findViewById(R.id.txtPassword);

		new AutenticateAsyncTask(this).execute("http://10.0.2.2:8888/_ah/api/usuariovoendpoint/v1/auth",
												txtLogin.getText().toString(),
												txtPassword.getText().toString());
		}
		catch(Exception ex)
		{
			Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
		}*/

    }

}
