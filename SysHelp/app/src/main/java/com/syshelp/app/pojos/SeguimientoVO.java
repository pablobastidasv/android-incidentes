package com.syshelp.app.pojos;

/**
 * Created by mikillo on 24/08/2014.
 */
public class SeguimientoVO {

    private String seguimientoId;
    private String fecha;
    private String descripcion;
    private String estado;
    private String responsable;
    private String categoria;
    private String prioridad;

    public SeguimientoVO() {
        super();
    }

    public SeguimientoVO(String seguimientoId, String fecha, String descripcion, String estado, String responsable, String categoria, String prioridad) {
        super();
        this.seguimientoId = seguimientoId;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
        this.responsable = responsable;
        this.categoria = categoria;
        this.prioridad = prioridad;
    }

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
