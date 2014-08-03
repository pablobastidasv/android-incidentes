package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.CrearInc;
import com.bsiprosoft.incidencia.myapplication5.app.InfoListInc;
import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.infoCreated;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Mitzy Valencia
 */
public class CrearAsyncTask extends AsyncTask<String,String, String> {


    private IncidenciaAdapter adpt;
    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;



    public CrearAsyncTask(Activity ctx) {
        this.context = new WeakReference<Activity>(ctx);
        progressDialog = new ProgressDialog(context.get());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Creando Incidencia ... ");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            String responseText = "";
            progressDialog.dismiss();
            Boolean response = null;
            try {

                JSONObject jsonObject = new JSONObject(s);
                //responseText =  new JSONObject(s).getString("exitoso");
                StringTokenizer stringTokenizer = new StringTokenizer(s, ":");

                while(stringTokenizer.hasMoreTokens()){


                }
                responseText = s.trim().toString();
                JSONTokener tokener = new JSONTokener(s);
                responseText = tokener.nextString('"');

               while(tokener.more()){

                   responseText = tokener.toString();
                   System.out.print(responseText);
                   if (responseText.equalsIgnoreCase("true")){
                       response = true;
                       //if (responseText.equalsIgnoreCase("numIncidencia"))
                   }else if (responseText.equalsIgnoreCase("false")){
                       response = false;
                   }
               }

                //JSONArray jsonArray = new JSONArray(s);
                if (response){
                    IncidenciaVO inc = new IncidenciaVO();
                    inc.setNumIncidencia(responseText =  new JSONObject(s).getString("numIncidencia"));

                    Intent i = new Intent(context.get(), infoCreated.class);
                    TextView numIncidencia = (TextView) this.context.get().findViewById(R.id.txtnumcreated);
                    i.putExtra("numero",numIncidencia.getText().toString());
                    context.get().startActivity(i);

                }else{
                    Toast.makeText(context.get(), "El número de documento ingresado" +
                            "\n no existe. Por favor verifique. "+responseText, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(context.get(), CrearInc.class);
                    context.get().startActivity(i);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Lo sentimos, su solicitud no se ha podido " +
                        "\n realizar . Por favor intente mas tarde. " +responseText, Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Ha ocurrido un error durante" +
                        "\n el proceso.", Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialog){
                CrearAsyncTask.this.cancel(true);
            }
        });
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Toast.makeText(context.get(),"Cancelado" , Toast.LENGTH_LONG).show();
    }

    @Override
    protected String doInBackground(String... params) {

        return com.bsiprosoft.incidencia.myapplication5.app.helpers.RequestManagerHelper.startPostRequest(params[0],
                new BasicNameValuePair("descripcion", params[2]), new BasicNameValuePair("docPersona", params[1]));
    }


}