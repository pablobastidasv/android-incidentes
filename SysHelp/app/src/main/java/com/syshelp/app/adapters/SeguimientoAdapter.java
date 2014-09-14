package com.syshelp.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.syshelp.app.R;
import com.syshelp.app.pojos.SeguimientoVO;

import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class SeguimientoAdapter extends ArrayAdapter<SeguimientoVO> {

    private List<SeguimientoVO> listItems;
    private Context ctx;

    public SeguimientoAdapter(List<SeguimientoVO> users, Context ctx)
    {
        super(ctx, R.layout.infolist_seg, users);
        this.listItems = users;
        this.ctx = ctx;
    }
    public int getCount() {
        if (listItems != null)
            return listItems.size();
        return 0;
    }

    public SeguimientoVO getItem(int position) {
        if (listItems != null)
            return listItems.get(position);
        return null;
    }

    public long getItemId(int position) {
        if (listItems != null)
            return listItems.get(position).hashCode();
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.infolist_seg,parent,false);
        }

        SeguimientoVO u = listItems.get(position);
        return v;


    }
    public List<SeguimientoVO> getListItems() {
        return listItems;
    }
    public void setListItems(List<SeguimientoVO> listItems) {
        this.listItems = listItems;
    }
}
