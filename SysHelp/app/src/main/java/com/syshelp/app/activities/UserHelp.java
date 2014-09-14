package com.syshelp.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.syshelp.app.R;

/**
 * Created by Mitzy Valencia
 */
public class UserHelp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_help);

        TextView crear = (TextView) this.findViewById(R.id.txthelpcrear);
        crear.setText("Para crear una incidencia debes ingresar el número de tu" +
                " documento y la descripción de la incidencia, ten en cuenta que" +
                " al crear tu incidencia de forma exitosa debes guardar el número " +
                "que identifica la incidencia .");

        TextView consultar = (TextView) this.findViewById(R.id.txthelpconsul);
        consultar.setText("Para consultar la información básica y seguimientos " +
                "de la incidencia deberás ingresar el número de la incidencia" +
                " con el que se identifica.");

        TextView contact = (TextView) this.findViewById(R.id.txtcontact);
        contact.setText("Para mayor información comunícate a través de nuestras redes sociales.");

    }


    public void onClickVolverMain(View view){

        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);


    }

}
