
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.GrupoPago;
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
@Stateless(name = "controladorGrupoPago")
public class GrupoPagoFacade extends AbstractFacade<GrupoPago> implements ProcesoFacadeLocal<GrupoPago> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public GrupoPagoFacade() {
        super(GrupoPago.class);
    }

    @Override
    public GrupoPago find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoPago find(GrupoPago grupoPago) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("GrupoPago.findByNombre");
            q.setParameter("nombre", grupoPago.getNombre());
            return (GrupoPago) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<GrupoPago> findEntities(String grupoPago, String nombre, Integer idCompañia, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        String query = this.getQuery(grupoPago, nombre, idCompañia);
        System.out.println("Query ..." + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (idCompañia != null) {
                q.setParameter("idcompania", idCompañia);
            }
            if (grupoPago != null && !grupoPago.equals("")) {
                q.setParameter("grupopago", grupoPago);
            }
            if (nombre != null && !nombre.equals("")) {
                q.setParameter("nombre", nombre);
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String grupoPago, String nombre, Integer idCompañia) {
        String query = "SELECT g FROM GrupoPago g";
        boolean bandera = false;
        if (idCompañia != null) {
            query += " WHERE g.idcompania.idcompania = :idcompania";
            bandera = true;
        }
        if (grupoPago != null && !grupoPago.equals("")) {
            if (!bandera) {
                query += " WHERE g.grupopago = :grupopago";
                bandera = true;
            } else {
                query += " AND g.grupopago = :grupopago";
            }
        }
        if (nombre != null && !nombre.equals("")) {
            if (!bandera) {
                query += " WHERE g.nombre = :nombre";
            } else {
                query += " AND g.nombre = :nombre";
            }
        }
        return query + " ORDER BY g.nombre ASC";
    }

    @Override
    public List<GrupoPago> findEntities(GrupoPago entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoPago> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("GrupoPago.findIdCompania");
            q.setParameter("idcompania", id);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<GrupoPago> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoPago> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoPago findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
