/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.entidades.servicio.RelacionLaboral;
import com.lam.entidades.servicio.SaldoVacaciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoséAntonio
 */
public class ResumenSaldoTO {

    private RelacionLaboral relacionLaboral;
//    
    private GranTotalSaldoTO total;
//    
    private List<SaldoVacaciones> detalle;
//    
    private String style;
//    
    private boolean disabled;

    public ResumenSaldoTO() {
        this.total = new GranTotalSaldoTO();
        this.detalle = new ArrayList<>();
    }

    public RelacionLaboral getRelacionLaboral() {
        return relacionLaboral;
    }

    public void setRelacionLaboral(RelacionLaboral relacionLaboral) {
        this.relacionLaboral = relacionLaboral;
    }

    public GranTotalSaldoTO getTotal() {
        return total;
    }

    public void setTotal(GranTotalSaldoTO total) {
        this.total = total;
    }

    public List<SaldoVacaciones> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<SaldoVacaciones> detalle) {
        this.detalle = detalle;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
        this.disabled = style.equals("background-color: #B40431; color: white") ? true : false;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
