package com.bsiprosoft.incidencia.myapplication5.app.pojos;

import java.math.BigInteger;

/**
 * Created by Mitzy Valencia on 16/07/2014.
 */
public class IncPrioridadVO {

    private BigInteger prioridadId;
    private String nombre;

    public BigInteger getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(BigInteger prioridadId) {
        this.prioridadId = prioridadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
