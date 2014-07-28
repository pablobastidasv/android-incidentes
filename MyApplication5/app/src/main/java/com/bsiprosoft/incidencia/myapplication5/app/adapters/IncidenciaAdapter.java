package com.bsiprosoft.incidencia.myapplication5.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncSeguimientoVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class IncidenciaAdapter extends ArrayAdapter<IncidenciaVO> {

    private List<IncidenciaVO> listItemsInc;
    //private List<IncidenciaVO> responseInc;
    private Context ctx;

    public IncidenciaAdapter(Context context, int resource) {
        super(context, resource);
    }

    public IncidenciaAdapter(List<IncidenciaVO> infoInc, Context ctx)
    {
        super(ctx, R.layout.infolist_inc, infoInc);
        this.listItemsInc = infoInc;
        this.ctx = ctx;
    }



    public int getCount() {
        if (listItemsInc != null)
            return listItemsInc.size();
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.infolist_inc,parent,false);
        }

        IncidenciaVO u = listItemsInc.get(position);
        //
        EditText text = (EditText) v.findViewById(R.id.txtNumIncConsul);
        text.setText(String.format("%s %s",u.getNumIncidencia()));
        //TextView text1 = (TextView) v.findViewById(R.id.lblId);
        //text1.setText(u.getId());
        return v;


    }

    // lista info de la Incidencia

    public List<IncidenciaVO> getListItemsInc() {
        return listItemsInc;
    }

    public void setListItemsInc(List<IncidenciaVO> listItemsInc) {
        this.listItemsInc = listItemsInc;
    }

    // lista que trae el numero de la incidencia creada

    /*public List<IncidenciaVO> getResponseInc() {
        return responseInc;
    }

    public void setResponseInc(List<IncidenciaVO> responseInc) {
        this.responseInc = responseInc;
    }*/
}
