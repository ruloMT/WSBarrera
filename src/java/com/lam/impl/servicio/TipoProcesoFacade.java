/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.TipoProceso;
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
@Stateless(name = "controladorTipoProceso")
public class TipoProcesoFacade extends AbstractFacade<TipoProceso> implements ProcesoFacadeLocal<TipoProceso> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipoProcesoFacade() {
        super(TipoProceso.class);
    }

    @Override
    public List<TipoProceso> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoProceso find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoProceso find(TipoProceso tipoProceso) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("TipoProceso.findByNombre");
            q.setParameter("nombre", tipoProceso.getNombre());
            return (TipoProceso) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<TipoProceso> findEntities(String tipoProceso, String nombre, Integer periodicidad, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        EntityManager em = null;
        String query = getQuery(tipoProceso, nombre, periodicidad);
        System.out.println("Query ..." + query);
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (tipoProceso != null && !tipoProceso.equals("")) {
                q.setParameter("tipoproceso", tipoProceso);
            }
            if (nombre != null && !nombre.equals("")) {
                q.setParameter("nombre", nombre);
            }
            if (periodicidad != null) {
                q.setParameter("periodicidad", periodicidad);
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String tipoProceso, String nombre, Integer periodicidad) {
        String query = "SELECT t FROM TipoProceso t";
        boolean bandera = true;
        if (tipoProceso != null && !tipoProceso.equals("")) {
            query += " WHERE t.tipoproceso = :tipoproceso";
            bandera = false;
        }
        if (nombre != null && !nombre.equals("")) {
            if (bandera) {
                query += " WHERE t.nombre = :nombre";
                bandera = false;
            } else {
                query += " AND t.nombre = :nombre";
            }
        }
        if (periodicidad != null) {
            if (bandera) {
                query += " WHERE t.periodicidad = :periodicidad";
            } else {
                query += " AND t.periodicidad = :periodicidad";
            }
        }
        return query + " ORDER BY t.nombre ASC";
    }

    @Override
    public List<TipoProceso> findEntities(TipoProceso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoProceso> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoProceso> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoProceso findEntity(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
