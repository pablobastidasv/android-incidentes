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

import com.bsiprosoft.incidencia.myapplication5.app.ConsultarInc;
import com.bsiprosoft.incidencia.myapplication5.app.InfoListInc;
import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.IncidenciaAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.adapters.SeguimientoAdapter;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.SeguimientoVO;

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
    private SeguimientoAdapter adptSeg;
    private WeakReference<Activity> context;
    private ProgressDialog progressDialog;
    private String prueba;
    private InfoListInc info;




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
                ArrayList<SeguimientoVO> seguimientos = new ArrayList<SeguimientoVO>();

                //ArrayList<IncidenciaVO>  infolist = new ArrayList<IncidenciaVO>();
                 IncidenciaVO infolist = new IncidenciaVO();
                //adptInc = new IncidenciaAdapter();

                if(s != null){
                           // IncidenciaVO inc = new IncidenciaVO();
                            SeguimientoVO seg = new SeguimientoVO();
                    infolist.setCategoria(jsonObject.getString("nombreCategoria"));
                    infolist.setCliente(jsonObject.getString("usuarioReportaSinLogin"));
                    infolist.setEstado(jsonObject.getString("estadoNombre"));
                    infolist.setDescripcion(jsonObject.getString("descripcion"));
                    infolist.setPrioridad(jsonObject.getString("nombrePrioridad"));
                    infolist.setResponsable(jsonObject.getString("usuariResponsable"));
                    infolist.setFechaIni(jsonObject.getString("fechaInicio"));

                    info = new InfoListInc();
                    adptInc.setListItems(infolist);
                    info.datosInc(adptInc);
                        try{

                            JSONArray jsonArray = new JSONArray(new JSONObject(s).getString("segumiento"));
                            for(int i =0; i < jsonArray.length(); i++)
                            {
                                JSONObject jsonObjectSeg= (JSONObject) jsonArray.get(i);
                                seg.setFecha(jsonObjectSeg.getString("fecha"));
                                seg.setCategoria(jsonObjectSeg.getString("categoriaNombre"));
                                seg.setResponsable(jsonObjectSeg.getString("asesor"));
                                seg.setDescripcion(jsonObjectSeg.getString("descripcion"));
                                seg.setPrioridad(jsonObjectSeg.getString("prioridadNombre"));
                                seg.setEstado(jsonObjectSeg.getString("estadoNombre"));
                                // seg.setSeguimientoId(jsonObject.getString("seguimientoId"));


                                seguimientos.add(seg);

                            }

                        }catch (JSONException e ){


                            Intent i = new Intent(context.get(), InfoListInc.class);
                            context.get().startActivity(i);
                            Toast.makeText(context.get(), "Incidencia sin seguimientos ", Toast.LENGTH_LONG).show();


                        }


                   // adptSeg = new SeguimientoAdapter(seguimientos, context.get());
                   // adptSeg.setListItemsSeg(seguimientos); ESTE NO
                   // adptSeg.notifyDataSetChanged();



                    Intent i = new Intent(context.get(), InfoListInc.class);
                    //info.datosInc(adptInc);
                    context.get().startActivity(i);



                }else {
                    Toast.makeText(context.get(), "NO EXISTE ", Toast.LENGTH_LONG).show();
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
                        "\n el proceso. "+e, Toast.LENGTH_SHORT).show();

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
