/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

/**
 *
 * @author Diego
 */
public class ImpuestoTO {

    private String impuesto;
    private String tipo;
    private double importe;
    private double tasa;

    public ImpuestoTO() {
    }

    public ImpuestoTO(String tipo) {
        this.tipo = tipo;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public String getTipo() {
        return tipo;
    }
}
