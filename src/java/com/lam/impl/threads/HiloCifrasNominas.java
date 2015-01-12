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
public class HiloCifrasNominas implements Runnable {

    private final List<AcumuladoConcepto> acumulados;
//    
    private boolean corriendo;
    private boolean verificado;
    private Thread hilo;

    public HiloCifrasNominas(List<AcumuladoConcepto> acumulados) {
        this.acumulados = acumulados;
    }

    @Override
    public void run() {
        this.iniciarProceso();
    }

    private void iniciarProceso() {
//        
        for (AcumuladoConcepto a : acumulados) {
            if (a.getTipotransaccion().equals("Deduccion") || a.getTipotransaccion().equals("Percepcion") || a.getTipotransaccion().equals("Provision")) {
                if (Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO.get(a.getNumeroconcepto()) == null) {
                    ResumenAcumuladoConceptosTO resumen = new com.lam.to.ResumenAcumuladoConceptosTO();
                    resumen.setCompania(a.getCompañia());
                    resumen.setNumeroConcepto(a.getNumeroconcepto());
                    resumen.setConcepto(a.getConcepto());
                    Util.sumarResumenCifrasNominas(resumen, a, a.getTipotransaccion());
                    Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO.put(a.getNumeroconcepto(), resumen);
                } else {
                    ResumenAcumuladoConceptosTO resumen = Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO.get(a.getNumeroconcepto());
                    Util.sumarResumenCifrasNominas(resumen, a, a.getTipotransaccion());
                }
            }
        }
//        
        this.corriendo = false;
//        
    }

    public void arrancar() {
        this.corriendo = true;
        hilo = new Thread(this);
        hilo.start();
        System.out.println("Arrancando hilo Cifras nomina... " + this.acumulados.size());

    }

    public List<AcumuladoConcepto> getAcumulados() {
        return acumulados;
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public Thread getHilo() {
        return hilo;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }
}
