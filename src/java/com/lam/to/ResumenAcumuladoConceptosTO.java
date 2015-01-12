/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.entidades.servicio.AcumuladoConcepto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iperez
 */
public class ResumenAcumuladoConceptosTO {
    
    private String compania;
    private String numeroConcepto;
    private String concepto;
    private String numeroEmpleado;
    private String empleado;
    
    private List<AcumuladoConcepto> detalle;
    
    private GranTotalAcumuladoConceptosTO total;

    public ResumenAcumuladoConceptosTO() {
        this.detalle = new ArrayList<>();
        this.total = new GranTotalAcumuladoConceptosTO();
    }

    public List<AcumuladoConcepto> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<AcumuladoConcepto> detalle) {
        this.detalle = detalle;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getNumeroConcepto() {
        return numeroConcepto;
    }

    public void setNumeroConcepto(String numeroConcepto) {
        this.numeroConcepto = numeroConcepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public GranTotalAcumuladoConceptosTO getTotal() {
        return total;
    }

    public void setTotal(GranTotalAcumuladoConceptosTO total) {
        this.total = total;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
}
