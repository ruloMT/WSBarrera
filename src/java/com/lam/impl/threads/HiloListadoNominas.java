/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.threads;

import com.lam.entidades.servicio.AcumuladoConcepto;
import com.lam.to.ResumenAcumuladoConceptosTO;
import com.lam.util.Parametros;
import com.lam.util.Util;
import java.util.List;

/**
 *
 * @author JoséAntonio
 */
public class HiloListadoNominas implements Runnable {

    private final List<AcumuladoConcepto> acumulados;
    private boolean corriendo;
    private boolean verificado;
    private Thread hilo;

    public HiloListadoNominas(List<AcumuladoConcepto> acumulados) {
        this.acumulados = acumulados;
    }

    @Override
    public void run() {
        this.inciarProceso();
    }

    private void inciarProceso() {
        for (com.lam.entidades.servicio.AcumuladoConcepto a : acumulados) {
            if (a.getTipotransaccion().equals("Deduccion") || a.getTipotransaccion().equals("Percepcion")) {
                String llave = a.getNumeroempleado();
                if (Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR.get(llave) == null) {
                    ResumenAcumuladoConceptosTO resumen = new ResumenAcumuladoConceptosTO();
                    resumen.setNumeroEmpleado(a.getNumeroempleado());
                    resumen.setEmpleado(a.getEmpleado());
                    Util.sumarResumenListadoNominas(resumen, a, a.getTipotransaccion());
                    resumen.getDetalle().add(a);
                    Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR.put(llave, resumen);
                } else {
                    ResumenAcumuladoConceptosTO resumen =  Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR.get(llave);
                    Util.sumarResumenListadoNominas(resumen, a, a.getTipotransaccion());
                    resumen.getDetalle().add(a);
                }
            }
        }
        this.corriendo = false;
    }

    public void arrancar() {
        this.corriendo = true;
        this.hilo = new Thread(this);
        this.hilo.start();
        System.out.println("Arrancando hilo Listado nominas... " + this.acumulados.size());
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
}
