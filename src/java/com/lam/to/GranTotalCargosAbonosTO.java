/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

/**
 *
 * @author iperez
 */
public class GranTotalCargosAbonosTO {

    private Double tiempo;
    private Double percepcion;
    private Double deduccion;

    public GranTotalCargosAbonosTO() {
        this.tiempo = 0.0;
        this.percepcion = 0.0;
        this.deduccion = 0.0;
    }
    
    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo += tiempo;
    }

    public Double getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(Double percepcion) {
        this.percepcion += percepcion;
    }

    public Double getDeduccion() {
        return deduccion;
    }

    public void setDeduccion(Double deduccion) {
        this.deduccion += deduccion;
    }
}
