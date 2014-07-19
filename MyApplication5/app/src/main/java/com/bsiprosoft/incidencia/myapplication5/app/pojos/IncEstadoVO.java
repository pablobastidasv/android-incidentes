package com.bsiprosoft.incidencia.myapplication5.app.pojos;

import java.math.BigInteger;

/**
 * Created by Mitzy Valencia on 16/07/2014.
 */
public class IncEstadoVO {

    private BigInteger estadoId;
    private String nombre;

    public BigInteger getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(BigInteger estadoId) {
        this.estadoId = estadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public IncEstadoVO(BigInteger estadoId, String nombre) {
        super();
        this.estadoId = estadoId;
        this.nombre = nombre;
    }

    public IncEstadoVO() {
        super();
    }
}
