/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.util.Util;

/**
 *
 * @author iperez
 */
public class GranTotalAcumuladoConceptosTO {
    
    private Double tiempo;
    private Double percepcion;
    private Double deduccion;
    private Double provision;
    private Integer trabajadores;

    public GranTotalAcumuladoConceptosTO() {
        this.tiempo = 0.0;
        this.percepcion = 0.0;
        this.deduccion = 0.0;
        this.provision = 0.0;
        this.trabajadores = 0;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo += Util.redondear(tiempo);
    }

    public Double getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(Double percepcion) {
        this.percepcion += Util.redondear(percepcion);
    }

    public Double getDeduccion() {
        return deduccion;
    }

    public void setDeduccion(Double deduccion) {
        this.deduccion += Util.redondear(deduccion);
    }

    public Double getProvision() {
        return provision;
    }

    public void setProvision(Double provision) {
        this.provision += Util.redondear(provision);
    }

    public Integer getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Integer trabajadores) {
        this.trabajadores += 1;
    }
    
}
