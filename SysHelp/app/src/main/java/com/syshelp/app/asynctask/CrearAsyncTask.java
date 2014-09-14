package com.syshelp.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.syshelp.app.R;
import com.syshelp.app.pojos.IncidenciaVO;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * Created by Mitzy Valencia
 */
public class CrearAsyncTask extends AsyncTask<String,String, String> {



    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;



    public CrearAsyncTask(Activity ctx) {
        this.context = new WeakReference<Activity>(ctx);
        progressDialog = new ProgressDialog(context.get());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Creando Incidencia ... Por favor espere ");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {

            progressDialog.dismiss();

            try {


                JSONObject jsonObject = new JSONObject(s);
                Boolean process =  jsonObject.getBoolean("exitoso");

                if (process){
                    IncidenciaVO inc = new IncidenciaVO();
                    inc.setNumIncidencia(jsonObject.getString("numIncincia"));

                    TextView msg = (TextView) context.get().findViewById(R.id.lblMessage);
                    msg.setText("! Incidencia creada con Exito !");

                    TextView numIncidencia = (TextView) context.get().findViewById(R.id.lblCreated);
                    numIncidencia.setText("El número de su incidencia es : "+inc.getNumIncidencia());

                    TextView desc = (TextView) context.get().findViewById(R.id.txtCreated);
                    desc.setText("Recuerde guardar esta información para realizar consultas.");


                }else{

                    JSONObject error = new JSONObject(jsonObject.getString("mensajes"));
                    String mensaje = error.getString("mensaje");
                    String exception = error.getString("tipoMensaje");

                    TextView msg = (TextView) context.get().findViewById(R.id.lblMessage);
                    msg.setText("Lo Sentimos ");

                    TextView desc = (TextView) context.get().findViewById(R.id.lblCreated);
                    desc.setText("Su solicitud no pudo ser procesada :");

                    TextView exc = (TextView) context.get().findViewById(R.id.txtCreated);
                    exc.setText(mensaje);


                }

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Lo sentimos, su solicitud no se ha podido " +
                        "\n realizar . Por favor intente mas tarde. ", Toast.LENGTH_SHORT).show();

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


        String response = com.syshelp.app.helpers.RequestManagerHelper.startPostRequest(params[0],
                new BasicNameValuePair("descripcion", params[2]), new BasicNameValuePair("docPersona", params[1]));

        return response;
    }


}
