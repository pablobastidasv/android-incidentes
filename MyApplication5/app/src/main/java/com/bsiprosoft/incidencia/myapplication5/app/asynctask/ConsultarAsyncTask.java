package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.EventLog.Event;
import android.util.JsonReader;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.InfoListInc;
import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.SeguimientoAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class ConsultarAsyncTask extends AsyncTask<String,String, String> {

    //private Activity context;
    //
    private IncidenciaAdapter adptInc;
    //private SeguimientoAdapter adptSeg;
    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;




    public ConsultarAsyncTask(Activity ctx , IncidenciaAdapter adptInc)
    {
        this.context = new WeakReference<Activity>(ctx);
        this.adptInc = adptInc;
    }

    // separadas en caso que la incidencia no contenga seguimientos
   /* public ConsultarAsyncTask(Activity ctx , SeguimientoAdapter adptSeg)
    {
        this.context = new WeakReference<Activity>(ctx);
        this.adptSeg = adptSeg;
    }*/



    public ConsultarAsyncTask(Activity ctx)
    {
        this.context = new WeakReference<Activity>(ctx);
        progressDialog = new ProgressDialog(context.get());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Consultando ... ");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
    }

//

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialog){
                ConsultarAsyncTask.this.cancel(true);
            }
        });
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if(s != null)
        {
            progressDialog.dismiss();
            try {

                JSONObject jsonObject = new JSONObject(s);
                ArrayList<IncidenciaVO>  infolist = new ArrayList<IncidenciaVO>();
                //JSONArray jsonArray = new JSONArray(jsonObject.toString());

                if(s != null){

                        for (int i=0 ; i<jsonObject.length(); i++){

                            IncidenciaVO inc = new IncidenciaVO();
                            //JSONObject jsonObject2= (JSONObject) jsonArray.get(i);
                            inc.setCategoria(jsonObject.getString("nombreCategoria"));
                            inc.setCliente(jsonObject.getString("usuarioReportaSinLogin"));
                            inc.setEstado(jsonObject.getString("estadoNombre"));
                            inc.setDescripcion(jsonObject.getString("descripcion"));
                            inc.setPrioridad(jsonObject.getString("nombrePrioridad"));
                            inc.setResponsable(jsonObject.getString("usuariResponsable"));
                            inc.setFechaIni(jsonObject.getString("fechaInicio"));
                            infolist.add(inc);
                        }
                        //JSONObject jsonObject= (JSONObject) jsonArray.get(i);



                 	adptInc.setListItems(infolist);
            	    adptInc.notifyDataSetChanged();

                    Toast.makeText(context.get(), " "+infolist.get(1), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(context.get(), InfoListInc.class);
                    TextView txtcategoria = (TextView) this.context.get().findViewById(R.id.txtCategoria);
                    context.get().startActivity(i);


                }else {
                    Toast.makeText(context.get(), "NO EXISTE "+adptInc.getItem(1), Toast.LENGTH_LONG).show();
                }



            }
            catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Lo sentimos, su solicitud no se ha podido " +
                        "\n realizar . Por favor intente mas tarde. ", Toast.LENGTH_LONG).show();
            }
            catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Ha ocurrido un error durante" +
                        "\n el proceso. "+ e, Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(context.get(), "Ha ocurrido un error durante" +
                    "\n el proceso", Toast.LENGTH_SHORT).show();
        }






    }


    @Override
    protected void onCancelled() {
        super.onCancelled(); Toast.makeText(context.get(), "Tarea cancelada!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... args) {

        return com.bsiprosoft.incidencia.myapplication5.app.helpers.RequestManagerHelper.startGetRequest(args[0]);


    }






}
