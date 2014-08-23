package com.bsiprosoft.incidencia.myapplication5.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bsiprosoft.incidencia.myapplication5.app.InfoListInc;
import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.SeguimientoVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.bsiprosoft.incidencia.myapplication5.app.R.id.txtCategoria;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class ConsultarAsyncTask extends AsyncTask<String,String, String> {



    //private SeguimientoAdapter adptSeg;
    private WeakReference<Activity> context;
    private Context ctx;
    private ProgressDialog progressDialog;
    private InfoListInc info;

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


                 IncidenciaVO infolist = new IncidenciaVO();


                if(s != null) {

                    infolist.setCategoria(jsonObject.getString("nombreCategoria"));
                    infolist.setCliente(jsonObject.getString("usuarioReportaSinLogin"));
                    infolist.setEstado(jsonObject.getString("estadoNombre"));
                    infolist.setDescripcion(jsonObject.getString("descripcion"));
                    infolist.setPrioridad(jsonObject.getString("nombrePrioridad"));
                    infolist.setResponsable(jsonObject.getString("usuariResponsable"));
                    infolist.setFechaIni(jsonObject.getString("fechaInicio"));

                    TextView categoria = (TextView) context.get().findViewById(R.id.txtCategoria);
                    categoria.setText(infolist.getCategoria());
                    TextView asesor = (TextView) context.get().findViewById(R.id.txtAsesor);
                    asesor.setText(infolist.getResponsable());
                    TextView estado = (TextView) context.get().findViewById(R.id.txtEstado);
                    estado.setText(infolist.getEstado());
                    TextView prioridad = (TextView) context.get().findViewById(R.id.txtPrioridad);
                    prioridad.setText(infolist.getPrioridad());
                    TextView fecha = (TextView) context.get().findViewById(R.id.txtFecha);
                    fecha.setText(infolist.getFechaIni());
                    TextView descripcion = (TextView) context.get().findViewById(R.id.txtdescripcion);
                    descripcion.setText(infolist.getDescripcion());





                    if(s.contains("seguimiento")){

                        JSONArray jsonArray = new JSONArray(new JSONObject(s).getString("segumiento"));
                        SeguimientoVO seg = new SeguimientoVO();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObjectSeg = (JSONObject) jsonArray.get(i);
                            seg.setFecha(jsonObjectSeg.getString("fecha"));
                            seg.setCategoria(jsonObjectSeg.getString("categoriaNombre"));
                            seg.setResponsable(jsonObjectSeg.getString("asesor"));
                            seg.setDescripcion(jsonObjectSeg.getString("descripcion"));
                            seg.setPrioridad(jsonObjectSeg.getString("prioridadNombre"));
                            seg.setEstado(jsonObjectSeg.getString("estadoNombre"));
                            // seg.setSeguimientoId(jsonObject.getString("seguimientoId"));

                        }
                        seguimientos.add(seg);

                    }





                } // null

                     }
            catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Lo sentimos, su solicitud no se ha podido " +
                        "\n realizar . Por favor intente mas tarde. ", Toast.LENGTH_LONG).show();
            }
            catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Ha ocurrido un error durante" +
                        "\n el proceso. ", Toast.LENGTH_SHORT).show();

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
