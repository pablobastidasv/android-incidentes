package com.bsiprosoft.incidencia.myapplication5.app.pojos;

import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by Mitzy Valencia on 14/07/2014.
 */
public class SeguimientoVO {

    private String seguimientoId;
    private String fecha;
    private String descripcion;
    private String estado;
    private String responsable;
    private String categoria;
    private String prioridad;

    public String getSeguimientoId() {
        return seguimientoId;
    }

    public void setSeguimientoId(String seguimientoId) {
        this.seguimientoId = seguimientoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public SeguimientoVO(String seguimientoId, String fecha, String descripcion, String estado, String responsable, String categoria, String prioridad) {
        this.seguimientoId = seguimientoId;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
        this.responsable = responsable;
        this.categoria = categoria;
        this.prioridad = prioridad;
    }

    public SeguimientoVO() {
        super();
    }
}
