package com.bsiprosoft.incidencia.myapplication5.app.pojos;

import java.math.BigInteger;

/**
 * Created by Mitzy Valencia on 16/07/2014.
 */
public class IncSegEstVO {

    private BigInteger incidenteId;
    private BigInteger categoriaId;
    private BigInteger prioridadId;

    public BigInteger getIncidenteId() {
        return incidenteId;
    }

    public void setIncidenteId(BigInteger incidenteId) {
        this.incidenteId = incidenteId;
    }

    public BigInteger getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(BigInteger categoriaId) {
        this.categoriaId = categoriaId;
    }

    public BigInteger getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(BigInteger prioridadId) {
        this.prioridadId = prioridadId;
    }

    public IncSegEstVO(BigInteger incidenteId, BigInteger categoriaId, BigInteger prioridadId) {
        super();
        this.incidenteId = incidenteId;
        this.categoriaId = categoriaId;
        this.prioridadId = prioridadId;
    }

    public IncSegEstVO() {
        super();
    }
}
