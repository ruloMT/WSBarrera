/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.util.Util;

/**
 *
 * @author JoséAntonio
 */
public class GranTotalSaldoTO {

    private Double totalDevengadas;
    private Double totalDerecho;
    private Double totalSolicitadas;
    private Double totalAutorizadas;
    private Double totalDisfrutadas;
    private Double totalVencidas;
    private Double totalSaldo;

    public GranTotalSaldoTO() {
        this.totalDevengadas = 0.0;
        this.totalDerecho = 0.0;
        this.totalSolicitadas = 0.0;
        this.totalAutorizadas = 0.0;
        this.totalDisfrutadas = 0.0;
        this.totalVencidas = 0.0;
        this.totalSaldo = 0.0;
    }

    public void redondear() {
        this.totalDevengadas = Util.redondear(this.totalDevengadas);
        this.totalDerecho = Util.redondear(this.totalDerecho);
        this.totalSolicitadas = Util.redondear(this.totalSolicitadas);
        this.totalAutorizadas = Util.redondear(this.totalAutorizadas);
        this.totalDisfrutadas = Util.redondear(this.totalDisfrutadas);
        this.totalVencidas = Util.redondear(this.totalVencidas);
        this.totalSaldo = Util.redondear(this.totalSaldo);
    }

    public Double getTotalDevengadas() {
        return totalDevengadas;
    }

    public void setTotalDevengadas(Double totalDevengadas) {
        this.totalDevengadas += Util.redondear(totalDevengadas);
    }

    public Double getTotalSolicitadas() {
        return totalSolicitadas;
    }

    public void setTotalSolicitadas(Double totalSolicitadas) {
        this.totalSolicitadas += Util.redondear(totalSolicitadas);
    }

    public Double getTotalAutorizadas() {
        return totalAutorizadas;
    }

    public void setTotalAutorizadas(Double totalAutorizadas) {
        this.totalAutorizadas += Util.redondear(totalAutorizadas);
    }

    public Double getTotalDisfrutadas() {
        return totalDisfrutadas;
    }

    public void setTotalDisfrutadas(Double totalDisfrutadas) {
        this.totalDisfrutadas += Util.redondear(totalDisfrutadas);
    }

    public Double getTotalVencidas() {
        return totalVencidas;
    }

    public void setTotalVencidas(Double totalVencidas) {
        this.totalVencidas += Util.redondear(totalVencidas);
    }

    public Double getTotalDerecho() {
        return totalDerecho;
    }

    public void setTotalDerecho(Double totalDerecho) {
        this.totalDerecho += Util.redondear(totalDerecho);
    }

    public Double getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(Double totalSaldo) {
        this.totalSaldo += Util.redondear(totalSaldo);
    }
}
