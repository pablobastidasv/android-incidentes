package com.bsiprosoft.incidencia.myapplication5.app.pojos;

import java.math.BigInteger;

/**
 * Created by Mitzy Valencia on 16/07/2014.
 */
public class IncCategoriaVO {

    private BigInteger categoriaId;
    private String nombreCat;
    private BigInteger empresaId;

    public BigInteger getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(BigInteger categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public BigInteger getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(BigInteger empresaId) {
        this.empresaId = empresaId;
    }

    public IncCategoriaVO(BigInteger categoriaId, String nombreCat, BigInteger empresaId) {
        super();
        this.categoriaId = categoriaId;
        this.nombreCat = nombreCat;
        this.empresaId = empresaId;
    }

    public IncCategoriaVO() {
        super();
    }
}
