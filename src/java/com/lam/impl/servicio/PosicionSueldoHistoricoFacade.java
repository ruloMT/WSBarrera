/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.PosicionSueldoHistorico;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
import com.lam.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
@Stateless(name = "controladorPosicionSueldoHistorico")
public class PosicionSueldoHistoricoFacade extends AbstractFacade<PosicionSueldoHistorico> implements ProcesoFacadeLocal<PosicionSueldoHistorico> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PosicionSueldoHistoricoFacade() {
        super(PosicionSueldoHistorico.class);
    }

    @Override
    public List<PosicionSueldoHistorico> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PosicionSueldoHistorico find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PosicionSueldoHistorico find(PosicionSueldoHistorico entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PosicionSueldoHistorico> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PosicionSueldoHistorico> findEntities(PosicionSueldoHistorico entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PosicionSueldoHistorico> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("PosicionSueldoHistorico.findAllByIdPosicion");
            q.setParameter("idrellab", id);
            List<PosicionSueldoHistorico> historico = q.getResultList();
            for (PosicionSueldoHistorico h : historico) {
                String llave = Parametros.COLUMNA_ESTATUS + " | " + Parametros.TABLA_RHPOSICIONESSUELDOSTB + " | " + h.getEstatus();
                h.setEstatusStr(Parametros.MAPA_CATALOGO.get(llave));
                h.setfActualizacionStr(Util.convertDateToString(h.getFechaactualizacion()));
                h.setfFinStr(Util.convertDateToString(h.getFechafin()));
                h.setfInicioStr(Util.convertDateToString(h.getFechainicio()));
            }
            return historico;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<PosicionSueldoHistorico> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PosicionSueldoHistorico findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
