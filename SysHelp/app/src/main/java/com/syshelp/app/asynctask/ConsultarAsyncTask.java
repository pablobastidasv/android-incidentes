package com.syshelp.app.asynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
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
import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class ConsultarAsyncTask extends AsyncTask<String,String, String> {



    //private ArrayList adapter ;
    private WeakReference<Activity> context1;
    private WeakReference<Activity> context2;
    private ProgressDialog progressDialog;
    private InfoListSeg infoListSeg;
    private SeguimientoAdapter adptSeg;


    public ConsultarAsyncTask(Activity ctx, SeguimientoAdapter adpt) {
        this.context1 = new WeakReference<Activity>(ctx);
        this.adptSeg = adpt;
        progressDialog = new ProgressDialog(context1.get());
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Consultando ... ");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
    }

//    public ConsultarAsyncTask(Activity ctx , SeguimientoAdapter adpt)
//    {
//        this.context2 = new WeakReference<Activity>(ctx);
//        this.adptSeg = adpt;
//    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                ConsultarAsyncTask.this.cancel(true);
            }
        });
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (s != null) {
            progressDialog.dismiss();
            try {

                JSONObject jsonObject = new JSONObject(s);
                IncidenciaVO infolist = new IncidenciaVO();
                SeguimientoVO seguimientoVO = new SeguimientoVO();
                ArrayList<SeguimientoVO> seg = new ArrayList<SeguimientoVO>();

                if (s != null) {

                    infolist.setCategoria(jsonObject.getString("nombreCategoria"));
                    infolist.setEstado(jsonObject.getString("estadoNombre"));
                    infolist.setDescripcion(jsonObject.getString("descripcion"));
                    infolist.setPrioridad(jsonObject.getString("nombrePrioridad"));
                    infolist.setResponsable(jsonObject.getString("usuariResponsable"));
                    infolist.setFechaIni(jsonObject.getString("fechaInicio"));

                    // Datos de Incidencia
                    TextView categoria = (TextView) context1.get().findViewById(R.id.txtCategoria);
                    categoria.setText(infolist.getCategoria());
                    TextView asesor = (TextView) context1.get().findViewById(R.id.txtAsesor);
                    asesor.setText(infolist.getResponsable());
                    TextView estado = (TextView) context1.get().findViewById(R.id.txtEstado);
                    estado.setText(infolist.getEstado());
                    TextView prioridad = (TextView) context1.get().findViewById(R.id.txtPrioridad);
                    prioridad.setText(infolist.getPrioridad());
                    TextView fecha = (TextView) context1.get().findViewById(R.id.txtFecha);
                    fecha.setText(infolist.getFechaIni());
                    TextView descripcion = (TextView) context1.get().findViewById(R.id.txtdescripcion);
                    descripcion.setText(infolist.getDescripcion());


                    if (s.contains("segumiento")) {

                        JSONArray jsonArray = new JSONArray(new JSONObject(s).getString("segumiento"));
                        //ArrayList adapter = new ArrayList();

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObjectSeg = (JSONObject) jsonArray.get(i);
                            seguimientoVO.setFecha(jsonObjectSeg.getString("fecha"));
                            seguimientoVO.setCategoria(jsonObjectSeg.getString("categoriaNombre"));
                            seguimientoVO.setResponsable(jsonObjectSeg.getString("asesor"));
                            seguimientoVO.setDescripcion(jsonObjectSeg.getString("descripcion"));
                            seguimientoVO.setPrioridad(jsonObjectSeg.getString("prioridadNombre"));
                            seguimientoVO.setEstado(jsonObjectSeg.getString("estadoNombre"));

                            seg.add(seguimientoVO);
                            adptSeg.add(seguimientoVO);

                        }
                        // adptSeg.setListItems(seg);
                        // adptSeg.notifyDataSetChanged();


                    }
//                     else {
//
//                        TextView title = (TextView) context2.get().findViewById(R.id.lblSeguimiento);
//                        title.setText("!Lo sentimos!...");
//                        TextView desc = (TextView) context2.get().findViewById(R.id.txtDescSeg);
//                        desc.setText("La incidencia no registra seguimientos. " +
//                                "Por favor ponte en contacto para mayor información.");
//                    }
                }


            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(context1.get(), "Lo sentimos, su solicitud no se ha podido " +
                        "\n realizar . Por favor intente mas tarde. ", Toast.LENGTH_LONG).show();

                Intent i = new Intent(context1.get(), ConsultarInc.class);
                context1.get().startActivity(i);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context1.get(), "Ha ocurrido un error durante" +
                        "\n el proceso. "+e, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(context1.get(), ConsultarInc.class);
                context1.get().startActivity(i);

            }
        } else {
            Toast.makeText(context1.get(), "Ha ocurrido un error durante" +
                    "\n el proceso", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    protected void onCancelled() {
        super.onCancelled(); Toast.makeText(context1.get(), "Tarea cancelada!", Toast.LENGTH_SHORT).show();
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

