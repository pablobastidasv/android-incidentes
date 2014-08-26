package com.syshelp.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.syshelp.app.R;
import com.syshelp.app.activities.ConsultarInc;
import com.syshelp.app.activities.InfoListInc;
import com.syshelp.app.activities.InfoListSeg;
import com.syshelp.app.activities.MainActivity;
import com.syshelp.app.adapters.SeguimientoAdapter;
import com.syshelp.app.pojos.IncidenciaVO;
import com.syshelp.app.pojos.SeguimientoVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by mikillo on 24/08/2014.
 */
public class ConsultarAsyncTask extends AsyncTask<String,String, String> {



    private SeguimientoAdapter adptSeg;
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

    public ConsultarAsyncTask(Activity ctx , SeguimientoAdapter adptSeg)
    {
        this.context = new WeakReference<Activity>(ctx);
        this.adptSeg = adptSeg;
    }

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
                IncidenciaVO infolist = new IncidenciaVO();
                SeguimientoVO seguimientoVO = new SeguimientoVO();
                ArrayList<SeguimientoVO> seg = new ArrayList<SeguimientoVO>();

                if(s != null) {

                    infolist.setCategoria(jsonObject.getString("nombreCategoria"));
                    infolist.setCliente(jsonObject.getString("usuarioReportaSinLogin"));
                    infolist.setEstado(jsonObject.getString("estadoNombre"));
                    infolist.setDescripcion(jsonObject.getString("descripcion"));
                    infolist.setPrioridad(jsonObject.getString("nombrePrioridad"));
                    infolist.setResponsable(jsonObject.getString("usuariResponsable"));
                    infolist.setFechaIni(jsonObject.getString("fechaInicio"));



                    if(s.contains("seguimiento")){

                        JSONArray jsonArray = new JSONArray(new JSONObject(s).getString("segumiento"));


                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObjectSeg = (JSONObject) jsonArray.get(i);


                            seguimientoVO.setFecha(jsonObjectSeg.getString("fecha"));
                            seguimientoVO.setCategoria(jsonObjectSeg.getString("categoriaNombre"));
                            seguimientoVO.setResponsable(jsonObjectSeg.getString("asesor"));
                            seguimientoVO.setDescripcion(jsonObjectSeg.getString("descripcion"));
                            seguimientoVO.setPrioridad(jsonObjectSeg.getString("prioridadNombre"));
                            seguimientoVO.setEstado(jsonObjectSeg.getString("estadoNombre"));

                            seg.add(seguimientoVO);
                        }


                       // adptSeg.setListItems(seg);
                        //adptSeg.notifyDataSetChanged();


                    }
                }

                // Datos de Incidencia
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

                adptSeg.setListItems(seg);
                adptSeg.notifyDataSetChanged();

            }
            catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Lo sentimos, su solicitud no se ha podido " +
                        "\n realizar . Por favor intente mas tarde. ", Toast.LENGTH_LONG).show();

                Intent i = new Intent(context.get(), ConsultarInc.class);
                context.get().startActivity(i);

            }
            catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context.get(), "Ha ocurrido un error durante" +
                        "\n el proceso. ", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(context.get(), ConsultarInc.class);
                context.get().startActivity(i);

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

    /**
     *
     * @param args
     * @return
     */
    @Override
    protected String doInBackground(String... args) {

        return com.syshelp.app.helpers.RequestManagerHelper.startGetRequest(args[0]);


    }






}

