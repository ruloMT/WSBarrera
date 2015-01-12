/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.util.Parametros;
import java.util.Date;

/**
 *
 * @author Antonio
 */
public class ParametroTO {

    private String claveCompania;
    private String chcompania;
    private String chclase_nomina;
    private int nid_calendario;
    private int anio;
    private int periodo;
    private String chtipo_nomina;
    private String chagr_orden;
    private int inumero_recibo;
    private Date dfechaPago;
    private String chclave_recibo;
    private String claseNomina;
    private String tipoNomina;

    public ParametroTO() {
        this.chclave_recibo = Parametros.CLAVE_RECIBO;
    }

    public String getChcompania() {
        return chcompania;
    }

    public void setChcompania(String chcompania) {
        this.chcompania = chcompania.trim().toUpperCase();
    }

    public String getChclase_nomina() {
        return chclase_nomina;
    }

    public void setChclase_nomina(String chclase_nomina) {
        this.chclase_nomina = chclase_nomina.trim().toUpperCase();
    }

    public int getNid_calendario() {
        return nid_calendario;
    }

    public void setNid_calendario(int nid_calendario) {
        this.nid_calendario = nid_calendario;
    }

    public String getChtipo_nomina() {
        return chtipo_nomina;
    }

    public void setChtipo_nomina(String chtipo_nomina) {
        this.chtipo_nomina = chtipo_nomina;
    }

    public String getChagr_orden() {
        return chagr_orden;
    }

    public void setChagr_orden(String chagr_orden) {
        this.chagr_orden = chagr_orden;
    }

    public int getInumero_recibo() {
        return inumero_recibo;
    }

    public void setInumero_recibo(int inumero_recibo) {
        this.inumero_recibo = inumero_recibo;
    }

    public String getChclave_recibo() {
        return chclave_recibo;
    }

    public void setChclave_recibo(String chclave_recibo) {
        this.chclave_recibo = chclave_recibo;
    }

    public Date getDfechaPago() {
        return dfechaPago;
    }

    public void setDfechaPago(Date dfechaPago) {
        this.dfechaPago = dfechaPago;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getClaseNomina() {
        return claseNomina;
    }

    public void setClaseNomina(String claseNomina) {
        this.claseNomina = claseNomina;
    }

    public String getTipoNomina() {
        return tipoNomina;
    }

    public void setTipoNomina(String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    public String getClaveCompania() {
        return claveCompania;
    }

    public void setClaveCompania(String claveCompania) {
        this.claveCompania = claveCompania;
    }
}
