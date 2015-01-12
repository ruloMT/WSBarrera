/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.AdelantoVacaciones;
import com.lam.util.JpaUtil;
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
@Stateless(name = "controladorAdelantoVacaciones")
public class AdelantoVacacionesFacade extends AbstractFacade<AdelantoVacaciones> implements ProcesoFacadeLocal<AdelantoVacaciones> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    public AdelantoVacacionesFacade() {
        super(AdelantoVacaciones.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    @Override
    public List<AdelantoVacaciones> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdelantoVacaciones find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdelantoVacaciones find(AdelantoVacaciones entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AdelantoVacaciones> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro, String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AdelantoVacaciones> findEntities(AdelantoVacaciones entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AdelantoVacaciones> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("AdelantoVacaciones.findByIdRellab");
            q.setParameter("idrellab", id);
            List<AdelantoVacaciones> lista = q.getResultList();
            for (AdelantoVacaciones a : lista) {
                a.setFechaStr(Util.convertDateToString(a.getFecharegistro()));
            }
            return lista;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<AdelantoVacaciones> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdelantoVacaciones findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
