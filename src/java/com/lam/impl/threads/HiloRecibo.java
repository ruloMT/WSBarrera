/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.threads;

import com.lam.entidades.cenicco.TimbreRecibo;
import com.lam.impl.cenicco.TimbreReciboImpl;
import com.lam.to.FacturaElectronicaTO;
import java.util.List;

/**
 *
 * @author JoséAntonio
 */
public class HiloRecibo implements Runnable {

    private final TimbreReciboImpl controlTimbre;
    private final List<FacturaElectronicaTO> facturas;
    private boolean corriendo;
    private boolean verificado;
    private Thread hilo;

    public HiloRecibo(List<FacturaElectronicaTO> facturas) {
        this.facturas = facturas;
        this.controlTimbre = new TimbreReciboImpl();
        this.verificado = false;
    }

    @Override
    public void run() {
        this.iniciarProceso();
    }

    private void iniciarProceso() {
        List<TimbreRecibo> timbres = controlTimbre.findTimbresRecibos(this.facturas);
        controlTimbre.create(this.facturas);
        controlTimbre.edit(timbres);
        this.corriendo = false;
    }

    public void arrancar() {
        this.corriendo = true;
        hilo = new Thread(this);
        hilo.start();
        System.out.println("Arrancando hilo...");
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public List<FacturaElectronicaTO> getFacturas() {
        return facturas;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
}
