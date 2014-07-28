package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.SeguimientoAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncCategoriaVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncEstadoVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncPrioridadVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.UsuarioVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class ConsultarAsyncTask extends AsyncTask<String,String, String> {

    //private Activity context;
    //
    private IncidenciaAdapter adptInc;
    private SeguimientoAdapter adptSeg;
    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;



    public ConsultarAsyncTask(Activity ctx , IncidenciaAdapter adptInc)
    {
        this.context = new WeakReference<Activity>(ctx);
        this.adptInc = adptInc;
    }

    // separadas en caso que la incidencia no contenga seguimientos
    public ConsultarAsyncTask(Activity ctx , SeguimientoAdapter adptSeg)
    {
        this.context = new WeakReference<Activity>(ctx);
        this.adptSeg = adptSeg;
    }



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

            String  responseText = "";
            try {


                //Toast.makeText(context.get(), new JSONObject(s).getString("response"), Toast.LENGTH_SHORT).show();
                JSONArray jsonArray = new JSONArray(new JSONObject(s).getString("response"));
                ArrayList<IncidenciaVO> infolist = new ArrayList<IncidenciaVO>();
                for(int i =0; i < jsonArray.length(); i++)
                {
                    JSONObject jsonObject= (JSONObject) jsonArray.get(i);
                    IncidenciaVO inc = new IncidenciaVO();
                    inc.setCategoria(jsonObject.getString("nombreCategoria"));
                    inc.setCliente(jsonObject.getString("usuarioReportaSinLogin"));
                    inc.setEstado(jsonObject.getString("estadoNombre"));
                    inc.setDescripcion(jsonObject.getString("descripcion"));
                    inc.setPrioridad(jsonObject.getString("nombrePrioridad"));
                    inc.setResponsable(jsonObject.getString("nombrePrioridad"));
                    inc.setFechaIni(jsonObject.getString("nombrePrioridad"));


                    infolist.add(inc);

                }

                 adptInc.setListItemsInc(infolist);
                 adptInc.notifyDataSetChanged();


            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            catch (Exception e) {
                Toast.makeText(context.get(), responseText, Toast.LENGTH_SHORT).show();
            }
        }






    }


    @Override
    protected String doInBackground(String... params) {


        return null;
    }
}
