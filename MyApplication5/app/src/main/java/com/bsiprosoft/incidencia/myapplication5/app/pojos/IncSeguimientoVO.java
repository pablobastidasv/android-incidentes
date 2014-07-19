package com.bsiprosoft.incidencia.myapplication5.app.pojos;

import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class IncSeguimientoVO {

    private BigInteger seguimientoId;
    private Date fecha;
    private String descripcion;
    private BigInteger incidenteId;
    private BigInteger estado;
    private BigInteger responsable;

    public BigInteger getSeguimientoId() {
        return seguimientoId;
    }

    public void setSeguimientoId(BigInteger seguimientoId) {
        this.seguimientoId = seguimientoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getIncidenteId() {
        return incidenteId;
    }

    public void setIncidenteId(BigInteger incidenteId) {
        this.incidenteId = incidenteId;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigInteger getResponsable() {
        return responsable;
    }

    public void setResponsable(BigInteger responsable) {
        this.responsable = responsable;
    }


    public IncSeguimientoVO() {
        super();
    }

    public IncSeguimientoVO(BigInteger seguimientoId, Date fecha, String descripcion,
                            BigInteger incidenteId, BigInteger estado, BigInteger responsable) {
        super();
        this.seguimientoId = seguimientoId;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.incidenteId = incidenteId;
        this.estado = estado;
        this.responsable = responsable;
    }
}
