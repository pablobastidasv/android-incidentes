package com.bsiprosoft.incidencia.myapplication5.app.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.bsiprosoft.incidencia.myapplication5.app.R;
import com.bsiprosoft.incidencia.myapplication5.app.pojos.IncSeguimientoVO;

import java.util.List;

/**
 * Created by Mitzy Valencia on 20/07/2014.
 */
public class SeguimientoAdapter extends ArrayAdapter<IncSeguimientoVO> {

    private List<IncSeguimientoVO> listItems;
    private Context ctx;

    public SeguimientoAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

   /* public SeguimientoAdapter(List<IncSeguimientoVO> seguimiento, Context ctx)
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
}
