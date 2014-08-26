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
 * Created by Mitzy Valencia on 24/08/2014.
 */
public class SeguimientoAdapter extends ArrayAdapter<SeguimientoVO> {

    private List<SeguimientoVO> listItemsSeg;
    private Context ctx;

    /**
     *
     * @param infoSeg
     * @param ctx
     */
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

    public SeguimientoVO getItem(int position) {
        if (listItemsSeg != null)
            return listItemsSeg.get(position);
        return null;
    }

    public long getItemId(int position) {
        if (listItemsSeg != null)
            return listItemsSeg.get(position).hashCode();
        return 0;
    }

    public List<SeguimientoVO> getListItems() {
        return listItemsSeg;
    }
    public void setListItems(List<SeguimientoVO> listItems) {
        this.listItemsSeg = listItems;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.infolist_seg,parent,false);
        }

        SeguimientoVO u = listItemsSeg.get(position);
        //TextView text = (TextView) v.findViewById(R.id.lblNombre);
        //text.setText(String.format("%s %s",u.getNombre(), u.getApellido()));
        //TextView text1 = (TextView) v.findViewById(R.id.lblId);
        //text1.setText(u.getId());
        return v;


    }



}
