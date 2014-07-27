package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.SeguimientoAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

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
        progressDialog.setMessage("si paso por aqui pa consultar ");
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

                Toast.makeText(context.get(), new JSONObject(s).getString("response"), Toast.LENGTH_SHORT).show();
                JSONArray jsonArray = new JSONArray(new JSONObject(s).getString("response"));
                ArrayList<IncidenciaVO> infolist = new ArrayList<IncidenciaVO>();
                for(int i =0; i < jsonArray.length(); i++)
                {
                    JSONObject jsonObject= (JSONObject) jsonArray.get(i);
                    IncidenciaVO p = new IncidenciaVO();
                    //p.setId(jsonObject.getString("id"));
                    //p.setNombre(jsonObject.getString("nombre"));
                    //p.setApellido(jsonObject.getString("apellido"));
                    infolist.add(p);

                }

                // adptInc.setListItems(userslist);
                //adpt.notifyDataSetChanged();

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
