package com.bsiprosoft.incidencia.myapplication5.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class IncidenciaAdapter extends ArrayAdapter<IncidenciaVO>{

    private List<IncidenciaVO> listItems;
    private Context ctx;

    public List<IncidenciaVO> getListItems() {
        return listItems;
    }

    public void setListItems(List<IncidenciaVO> listItems) {
        this.listItems = listItems;
    }

    public IncidenciaAdapter(List<IncidenciaVO> users, Context ctx)
    {
        super(ctx,R.layout.infolist_inc, users);
        this.listItems = users;
        this.ctx = ctx;
    }
    public int getCount() {
        if (listItems != null)
            return listItems.size();
        return 0;
    }

    public IncidenciaVO getItem(int position) {
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
            v = inflater.inflate(R.layout.infolist_inc,parent,false);
        }

        IncidenciaVO u = listItems.get(position);
        TextView text = (TextView) v.findViewById(R.id.txtCategoria);
        text.setText(String.format("%s %s",u.getCategoria()));
        //TextView text1 = (TextView) v.findViewById(R.id.txtCategoria);
        //text1.setText(u.getId());
        return v;

    }

    public IncidenciaAdapter(Context context, int resource) {
        super(context, resource);
    }

    public IncidenciaAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public IncidenciaAdapter(Context context, int resource, IncidenciaVO[] objects) {
        super(context, resource, objects);
    }

    public IncidenciaAdapter(Context context, int resource, int textViewResourceId, IncidenciaVO[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public IncidenciaAdapter(Context context, int resource, List<IncidenciaVO> objects) {
        super(context, resource, objects);
    }

    public IncidenciaAdapter(Context context, int resource, int textViewResourceId, List<IncidenciaVO> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
