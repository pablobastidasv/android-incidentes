package com.syshelp.app.pojos;

import java.math.BigInteger;

/**
 * Created by Mitzy Valencia
 */
public class IncidenciaVO {

    private BigInteger incidenteId;
    private String fechaIni;
    private String fechaFin;
    private String descripcion;
    private String responsable;
    private String estado;
    private String numIncidencia;
    private String categoria;
    private String prioridad;

    public IncidenciaVO() {
        super();
    }

    public IncidenciaVO(BigInteger incidenteId, String fechaIni, String fechaFin, String descripcion, String responsable,
                        String estado, String numIncidencia, String categoria, String prioridad) {
        super();
        this.incidenteId = incidenteId;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.responsable = responsable;

        this.estado = estado;
        this.numIncidencia = numIncidencia;
        this.categoria = categoria;
        this.prioridad = prioridad;
    }

    public BigInteger getIncidenteId() {
        return incidenteId;
    }

    public void setIncidenteId(BigInteger incidenteId) {
        this.incidenteId = incidenteId;
    }

    public String getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(String fechaIni) {
        this.fechaIni = fechaIni;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumIncidencia() {
        return numIncidencia;
    }

    public void setNumIncidencia(String numIncidencia) {
        this.numIncidencia = numIncidencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
