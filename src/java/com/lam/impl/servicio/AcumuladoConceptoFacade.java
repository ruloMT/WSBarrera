/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.AcumuladoConcepto;
import com.lam.impl.threads.HiloCifrasNominas;
import com.lam.impl.threads.HiloListadoNominas;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author iperez
 */
@Stateless(name = "controladorAcumuladoConcepto")
public class AcumuladoConceptoFacade extends AbstractFacade<AcumuladoConcepto> implements ProcesoFacadeLocal<AcumuladoConcepto> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    public AcumuladoConceptoFacade() {
        super(AcumuladoConcepto.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<AcumuladoConcepto> findAll() {
        return null;
    }

    @Override
    public AcumuladoConcepto find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AcumuladoConcepto find(AcumuladoConcepto entity) {


        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<AcumuladoConcepto> findByFilters(String tipoNomina, String grupoPago, Integer anio, Integer periodo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("AcumuladoConcepto.findAll");
            q.setParameter("tiponomina", tipoNomina);
            q.setParameter("grupopago", grupoPago);
            q.setParameter("anio", anio);
            q.setParameter("periodo", periodo);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<AcumuladoConcepto> findEntities(String tipoNomina, String numeroConcepto, Integer anio, Integer periodo, String grupoPago, String valorCuatro, String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
//
        Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO = new HashMap<>();
//        
        List<HiloCifrasNominas> hilos = Collections.synchronizedList(new ArrayList<HiloCifrasNominas>());
//        
        List<AcumuladoConcepto> acumulados = this.findByFilters(tipoNomina, grupoPago, anio, periodo);
//        
        System.out.println("Acumulados cifras nominas... " + acumulados.size());
//        
        while (acumulados.size() > 0) {
            int hilosXArrancar = acumulados.size() > Parametros.MAXIMO_HILOS_ACUMULADOS ? Parametros.MAXIMO_HILOS_ACUMULADOS : acumulados.size();
            List<AcumuladoConcepto> listTemp = new ArrayList<>(acumulados.subList(0, hilosXArrancar));
            HiloCifrasNominas hilo = new HiloCifrasNominas(listTemp);
            hilo.arrancar();
            hilos.add(hilo);
            acumulados.removeAll(listTemp);
        }
//        
        this.verificarHilosCifrasNominas(hilos);

//        
//        
        return acumulados;
    }

    private void verificarHilosCifrasNominas(List<HiloCifrasNominas> hilos) {
//        
        boolean verificar = false;
//        
        int cont;
//        
        while (!verificar) {
            cont = 0;
//            
            for (HiloCifrasNominas hilo : hilos) {
                if (hilo.isCorriendo()) {
                    cont++;
                } else {
                    if (!hilo.isVerificado()) {
                        hilo.setVerificado(true);
                    }
                }
            }
            verificar = cont > 0 ? false : true;
//            
        }
        System.out.println("Termina Proceso Hilo Cifras Nominas... " + new Date() + " | " + Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO.size());
    }

    @Override
    public List<AcumuladoConcepto> findEntities(AcumuladoConcepto entity) {

        Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR = new HashMap<>();
        List<AcumuladoConcepto> acumulados = this.findByFilters(entity.getTiponomina(), entity.getGrupopago(), entity.getAnio(), entity.getPeriodo());

        System.out.println("Acumulados lista netos... " + acumulados.size());
//        
        List<HiloListadoNominas> hilos = Collections.synchronizedList(new ArrayList<HiloListadoNominas>());
//        
        while (acumulados.size() > 0) {
            int hilosXArrancar = acumulados.size() > Parametros.MAXIMO_HILOS_ACUMULADOS ? Parametros.MAXIMO_HILOS_ACUMULADOS : acumulados.size();
            List<AcumuladoConcepto> listTemp = new ArrayList<>(acumulados.subList(0, hilosXArrancar));
            HiloListadoNominas hilo = new HiloListadoNominas(listTemp);
            hilo.arrancar();
            hilos.add(hilo);
            acumulados.removeAll(listTemp);
        }
//        
        this.verificarHilosListadoNominas(hilos);
//        
        return acumulados;
    }

    private void verificarHilosListadoNominas(List<HiloListadoNominas> hilos) {
//        
        boolean verificar = false;
//        
        int cont;
//        
        while (!verificar) {
            cont = 0;
//            
            for (HiloListadoNominas hilo : hilos) {
                if (hilo.isCorriendo()) {
                    cont++;
                } else {
                    if (!hilo.isVerificado()) {
                        hilo.setVerificado(true);
                    }
                }
            }
            verificar = cont > 0 ? false : true;
//            
        }
        System.out.println("Termina Proceso Hilo Listado Nominas... " + new Date() + " | " + Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR.size());
    }

    @Override
    public List<AcumuladoConcepto> findEntities(Integer numeroConcepto) {
        return null;
    }

    @Override
    public List<AcumuladoConcepto> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AcumuladoConcepto findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
