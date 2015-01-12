/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.threads;

import com.lam.entidades.CfdiRecibo;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Antonio
 */
public class HiloObtenerRegistros extends Thread {

    public HiloObtenerRegistros() {
        this.emf = JpaUtil.getInstance().createEntityManagerRecibos().getEntityManagerFactory();
        this.bandera = false;
    }
//
    private EntityManagerFactory emf = null;
//    
    private List<CfdiRecibo> registros;
//    
    private List<String> cadenasErrores;
//    
    private List<String> cadenas;
//    
    private boolean bandera;
//    
    private Map<String, String> mapa;

    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void run() {
        this.mapa = new HashMap<>();
        this.cadenas = new ArrayList<>();
        this.cadenasErrores = new ArrayList<>();
        do {
            bandera = escribirArchivo();
            System.out.println("Se duerme... " + new Date());
            this.dormir();
            System.out.println("Despierta... " + new Date());
        } while (!bandera);
        System.out.println("Termina el hilo Amro");
    }
//

    @SuppressWarnings({"CallToThreadDumpStack", "BroadCatchBlock", "TooBroadCatch"})
    private void dormir() {
        try {
            Thread.sleep(Parametros.TIEMPO_HILO_ESPERA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//

    private boolean escribirArchivo() {
        int cont = 0;
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("CfdiRecibo.findByIdRegistro");
            for (CfdiRecibo r : registros) {
                if (this.mapa.get(r.getTrabajador()) == null) {
                    cont++;
                    q.setParameter("idRegistro", r.getIdRegistro());
                    String registro = ((CfdiRecibo) q.getSingleResult()).getRegistro();
                    if (registro != null) {
                        if (registro.length() == 1) {
                            return false;
                        } else {
                            System.out.println(cont + " | " + r.getTrabajador() + " | " + registro + " | " + registro.length());
                            this.mapa.put(r.getTrabajador(), registro);
                            this.cadenas.add(registro);
                        }
                    } else {
                        System.out.println("Error en registro: " + r.getTrabajador());
                        this.mapa.put(r.getTrabajador(), r.getTrabajador());
                        this.cadenasErrores.add(r.getTrabajador());
                    }
                }
            }
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
        return true;
    }

    public void setRegistros(List<CfdiRecibo> registros) {
        this.registros = registros;
    }

    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public boolean isBandera() {
        return bandera;
    }

    public List<String> getCadenas() {
        return cadenas;
    }

    public List<String> getCadenasErrores() {
        return cadenasErrores;
    }
}
