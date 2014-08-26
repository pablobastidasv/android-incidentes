package com.bsiprosoft.incidencia.myapplication5.app.pojos;

/**
 * Created by Mitzy Valencia
 */
public class UsuarioVO {

    private String nombre;
    private int documento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public UsuarioVO(String nombre, int documento) {
        super();
        this.nombre = nombre;
        this.documento = documento;
    }

    public UsuarioVO() {
    super();
    }
}
