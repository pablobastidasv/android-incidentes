package com.syshelp.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.syshelp.app.R;
import com.syshelp.app.pojos.SeguimientoVO;

import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class SeguimientoAdapter extends ArrayAdapter<SeguimientoVO> {

    private List<SeguimientoVO> listItems;
    private Context ctx;

    public SeguimientoAdapter(List<SeguimientoVO> seguimientoVOList, Context ctx)
    {
        super(ctx, R.layout.seguimiento_item, seguimientoVOList);
        this.listItems = seguimientoVOList;
        this.ctx = ctx;
    }
    public int getCount() {
        if (listItems != null)
            return listItems.size();
        else
            return 0;
    }

    public SeguimientoVO getItem(int position) {
        if (listItems != null)
            return listItems.get(position);
        else
            return null;
    }

    public long getItemId(int position) {
        if (listItems != null)
            return listItems.get(position).hashCode();
        else
            return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.seguimiento_item,parent,false);

        SeguimientoVO u = listItems.get(position);

        TextView txtFechaDll = (TextView) v.findViewById(R.id.txtFechaDll);
        TextView txtAsesorDll = (TextView) v.findViewById(R.id.txtAsesorDll);
        TextView txtEstadoDll = (TextView) v.findViewById(R.id.txtEstadoDll);
        TextView txtPrioridadDll = (TextView) v.findViewById(R.id.txtPrioridadDll);
        TextView txtObservacionDll = (TextView) v.findViewById(R.id.txtObervacionDll);

        txtFechaDll.setText(u.getFecha().substring(0,10));
        txtAsesorDll.setText(u.getResponsable());
        txtEstadoDll.setText(u.getEstado());
        txtPrioridadDll.setText(u.getPrioridad());
        txtObservacionDll.setText(u.getDescripcion());

        return v;


    }
    public List<SeguimientoVO> getListItems() {
        return listItems;
    }
    public void setListItems(List<SeguimientoVO> listItems) {
        this.listItems = listItems;
    }
}
