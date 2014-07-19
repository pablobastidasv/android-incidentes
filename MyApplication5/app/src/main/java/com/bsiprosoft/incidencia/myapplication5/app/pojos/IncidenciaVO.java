package com.bsiprosoft.incidencia.myapplication5.app.pojos;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class IncidenciaVO {

    private BigInteger incidenteId;
    private Date fechaIni;
    private Date fechaFin;
    private String descripcion;
    private BigInteger responsable;
    private BigInteger cliente;
    private BigInteger estado;
    private BigInteger empresaId;

    public BigInteger getIncidenteId() {
        return incidenteId;
    }

    public void setIncidenteId(BigInteger incidenteId) {
        this.incidenteId = incidenteId;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getResponsable() {
        return responsable;
    }

    public void setResponsable(BigInteger responsable) {
        this.responsable = responsable;
    }

    public BigInteger getCliente() {
        return cliente;
    }

    public void setCliente(BigInteger cliente) {
        this.cliente = cliente;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public BigInteger getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(BigInteger empresaId) {
        this.empresaId = empresaId;
    }

    public IncidenciaVO(BigInteger incidenteId, Date fechaIni, Date fechaFin, String descripcion, BigInteger responsable,
                        BigInteger cliente, BigInteger estado, BigInteger empresaId) {
        super();
        this.incidenteId = incidenteId;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.cliente = cliente;
        this.estado = estado;
        this.empresaId = empresaId;
    }

    public IncidenciaVO() {
        super();
    }
}
