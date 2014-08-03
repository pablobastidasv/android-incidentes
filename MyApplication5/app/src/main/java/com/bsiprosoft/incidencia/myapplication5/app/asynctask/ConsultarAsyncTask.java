package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if(s != null)
        {

            try {
                 //JSONArray jsonArray = new JSONArray(s);

                JSONObject jsonObject = new JSONObject(s.toString());
                ArrayList<IncidenciaVO>  infolist = new ArrayList<IncidenciaVO>();


                if(s != null){

                    for(int i =0; i < jsonObject.length(); i++)
                    {
                        //JSONObject jsonObject= (JSONObject) jsonArray.get(i);
                        IncidenciaVO inc = new IncidenciaVO();
                        inc.setCategoria(jsonObject.getString("nombreCategoria"));
                        inc.setCliente(jsonObject.getString("usuarioReportaSinLogin"));
                        inc.setEstado(jsonObject.getString("estadoNombre"));
                        inc.setDescripcion(jsonObject.getString("descripcion"));
                        inc.setPrioridad(jsonObject.getString("nombrePrioridad"));
                        inc.setResponsable(jsonObject.getString("usuariResponsable"));
                        inc.setFechaIni(jsonObject.getString("fechaInicio"));


                        infolist.add(inc);

                    }
                    Intent i = new Intent(context.get(), InfoListInc.class);
                    TextView txtcategoria = (TextView) this.context.get().findViewById(R.id.txtCategoria);
                    //i.putExtra("Categoria:",inc.getCategoria());
                   // TextView txtestado = (TextView) this.context.get().findViewById(R.id.);


                    context.get().startActivity(i);
                }else {
                    Toast.makeText(context.get(), "NO EXISTE "+s, Toast.LENGTH_LONG).show();
                }



            }
            catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Lo sentimos, su solicitud no se ha podido " +
                        "\n realizar . Por favor intente mas tarde. "+s, Toast.LENGTH_LONG).show();
            }
            catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Ha ocurrido un error durante" +
                        "\n el proceso."+s, Toast.LENGTH_SHORT).show();

            }
        }else{
            Toast.makeText(context.get(), "Ha ocurrido un error durante" +
                    "\n el proceso"+s, Toast.LENGTH_SHORT).show();
        }






    }


    @Override
    protected String doInBackground(String... args) {

        return com.bsiprosoft.incidencia.myapplication5.app.helpers.RequestManagerHelper.startGetRequest(args[0]);


    }


}
