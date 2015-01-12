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
public class RegistroTO {

    private String clave;
    private String tipo;
    private String concepto;
    private String percepcionDeduccion;
    private double importePercepcion;
    private double importeDeduccion;
    private double importeTotal;

    public RegistroTO() {
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getPercepcionDeduccion() {
        return percepcionDeduccion;
    }

    public double getImportePercepcion() {
        return importePercepcion;
    }

    public void setImportePercepcion(double importePercepcion) {
        this.importePercepcion = importePercepcion;
    }

    public double getImporteDeduccion() {
        return importeDeduccion;
    }

    public void setImporteDeduccion(double importeDeduccion) {
        this.importeDeduccion = importeDeduccion;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public void setPercepcionDeduccion(String percepcionDeduccion) {
        this.percepcionDeduccion = percepcionDeduccion;
    }
}
