/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.entidades.servicio.Liquidacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iperez
 */
public class ResumenLiquidacionTO {
    
    private Integer numeroLiquidacion;
    private String numeroEmpleado;
    private String empleado;
    
    private List<Liquidacion> detalle;
//
    private GranTotalCargosAbonosTO total;

    public ResumenLiquidacionTO() {
        this.detalle = new ArrayList<>();
        this.total = new GranTotalCargosAbonosTO();
    }

    public List<Liquidacion> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Liquidacion> detalle) {
        this.detalle = detalle;
    }

    public GranTotalCargosAbonosTO getTotal() {
        return total;
    }

    public void setTotal(GranTotalCargosAbonosTO total) {
        this.total = total;
    }

    public Integer getNumeroLiquidacion() {
        return numeroLiquidacion;
    }

    public void setNumeroLiquidacion(Integer numeroLiquidacion) {
        this.numeroLiquidacion = numeroLiquidacion;
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
