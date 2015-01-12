/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.util.Util;

/**
 *
 * @author Antonio
 */
public class GranTotalTO {

    private double subtotal;
    private double descuento;
    private double impuesto;
    private double total;
    private double valorUnitario;
    private double netoNomina;
    private double importe;
    private double salarioIntegrado;
    private double salario;

    public GranTotalTO() {
        this.subtotal = 0;
        this.descuento = 0;
        this.impuesto = 0;
        this.total = 0;
        this.valorUnitario = 0;
        this.netoNomina = 0;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getNetoNomina() {
        return netoNomina;
    }

    public double getImporte() {
        return importe;
    }

    public double getSalarioIntegrado() {
        return salarioIntegrado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal += Util.redondear(subtotal);
    }

    public void setDescuento(double descuento) {
        this.descuento += Util.redondear(descuento);
    }

    public void setImpuesto(double impuesto) {
        this.impuesto += Util.redondear(impuesto);
    }

    public void setTotal(double total) {
        this.total += Util.redondear(total);
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario += Util.redondear(valorUnitario);
    }

    public void setNetoNomina(double netoNomina) {
        this.netoNomina += Util.redondear(netoNomina);
    }

    public void setImporte(double importe) {
        this.importe += Util.redondear(importe);
    }

    public void setSalarioIntegrado(double salarioIntegrado) {
        this.salarioIntegrado += Util.redondear(salarioIntegrado);
    }

    public void setSalario(double salario) {
        this.salario += Util.redondear(salario);
    }
}
