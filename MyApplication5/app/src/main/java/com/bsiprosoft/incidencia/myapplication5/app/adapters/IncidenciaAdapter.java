package com.bsiprosoft.incidencia.myapplication5.app.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncSeguimientoVO;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncidenciaVO;

import java.util.List;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class IncidenciaAdapter extends ArrayAdapter<IncidenciaVO> {

    private List<IncidenciaVO> listItems;
    private Context ctx;

    public IncidenciaAdapter(Context context, int resource) {
        super(context, resource);
    }

    public IncidenciaAdapter(List<IncidenciaVO> infoInc, Context ctx)
    {
        super(ctx, R.layout.infolist_inc, infoInc);
        this.listItems = infoInc;
        this.ctx = ctx;
    }
    public int getCount() {
        if (listItems != null)
            return listItems.size();
        return 0;
    }
}
