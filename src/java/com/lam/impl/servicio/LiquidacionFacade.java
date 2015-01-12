/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Liquidacion;
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
 * @author iperez
 */
@Stateless(name = "controladorLiquidacion")
public class LiquidacionFacade extends AbstractFacade<Liquidacion> implements ProcesoFacadeLocal<Liquidacion> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    public LiquidacionFacade() {
        super(Liquidacion.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Liquidacion> findAll() {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Liquidacion.findAll");
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public Liquidacion find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Liquidacion find(Liquidacion entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Liquidacion> findEntities(String tipoNomina, String numeroConcepto, Integer anio, Integer numeroLiquidacion, String grupoPago, String valorCuatro, String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        return null;
    }

    @Override
    public List<Liquidacion> findEntities(Liquidacion entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Liquidacion> findEntities(Integer numeroLiquidacion) {
        EntityManager em = null;
        String query = this.getQuery(numeroLiquidacion);
        System.out.println("Query ..." + query);
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (numeroLiquidacion != null) {
                q.setParameter("numeroliquidacion", numeroLiquidacion);
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }
    
    private String getQuery(Integer numeroLiquidacion) {
        String query = " SELECT l FROM Liquidacion l";
        if (numeroLiquidacion != null) {
            query += " WHERE l.numeroliquidacion = :numeroliquidacion";
        }
        return query += " ORDER BY l.numeroliquidacion";
    }

    @Override
    public List<Liquidacion> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Liquidacion findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
