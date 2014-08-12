package com.bsiprosoft.incidencia.myapplication5.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.bsiprosoft.incidencia.myapplication5.app.InfoListInc;
import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitzy Valencia
 */
public class IncidenciaAdapter extends IncidenciaVO{

    private IncidenciaVO listItems;
    private InfoListInc infoListInc;
    private Context ctx;

    public IncidenciaVO getListItems() {
        return listItems;
    }

    public void setListItems(IncidenciaVO listItems) {
        this.listItems = listItems;
    }


    public View getView (View convertView, ViewGroup parent){

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.infolist_inc,parent,false);
        }

        IncidenciaVO inc = getListItems();
        TextView text = (TextView) v.findViewById(R.id.txtCategoria);
        text.setText(inc.getCategoria());

        return v;

    }
    public IncidenciaAdapter()
    {
        super();
        this.listItems = listItems;
        this.ctx = ctx;
    }






}
