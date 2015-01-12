/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.EstructuraRelacion;
import com.lam.util.JpaUtil;
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
@Stateless(name = "controladorEstructuraRelacion")
public class EstructuraRelacionFacade extends AbstractFacade<EstructuraRelacion> implements ProcesoFacadeLocal<EstructuraRelacion> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public EstructuraRelacionFacade() {
        super(EstructuraRelacion.class);
    }

    @Override
    public EstructuraRelacion find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstructuraRelacion find(EstructuraRelacion entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstructuraRelacion> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstructuraRelacion> findEntities(EstructuraRelacion entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstructuraRelacion> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("EstructuraRelacion.findIdEstructura");
            q.setParameter("idestructura", id);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<EstructuraRelacion> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EstructuraRelacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstructuraRelacion findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
