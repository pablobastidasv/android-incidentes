package com.bsiprosoft.incidencia.myapplication5.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.SeguimientoVO;

import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class SeguimientoAdapter extends ArrayAdapter<SeguimientoVO> {

    private List<SeguimientoVO> listItemsSeg;
    private Context ctx;

    public SeguimientoAdapter(Context context, int resource) {
        super(context, resource);
    }

    public SeguimientoAdapter(List<SeguimientoVO> infoSeg, Context ctx)
    {
        super(ctx, R.layout.infolist_seg, infoSeg);
        this.listItemsSeg = infoSeg;
        this.ctx = ctx;
    }
    public int getCount() {
        if (listItemsSeg != null)
            return listItemsSeg.size();
        return 0;
    }
    @Override
    public Context getContext() {
        return super.getContext();
    }

   /* public SeguimientoAdapter(List<SeguimientoVO> seguimiento, Context ctx)
    {
        super(ctx, R.layout.infolist_inc, seguimiento);
        this.listItems = seguimiento;
        this.ctx = ctx;
    }
    public int getCount() {
        if (listItems != null)
            return listItems.size();
        return 0;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.infolist_inc,parent,false);
        }

        SeguimientoVO u = listItemsSeg.get(position);
        //TextView text = (TextView) v.findViewById(R.id.lblNombre);
        //text.setText(String.format("%s %s",u.getNombre(), u.getApellido()));
        //TextView text1 = (TextView) v.findViewById(R.id.lblId);
        //text1.setText(u.getId());
        return v;


    }

    // lista info del seguimiento

    public List<SeguimientoVO> getListItemsSeg() {
        return listItemsSeg;
    }

    public void setListItemsSeg(List<SeguimientoVO> listItemsSeg) {
        this.listItemsSeg = listItemsSeg;
    }
}
