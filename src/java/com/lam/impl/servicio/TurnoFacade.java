/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Turno;
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
@Stateless(name = "controladorTurno")
public class TurnoFacade extends AbstractFacade<Turno> implements ProcesoFacadeLocal<Turno> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TurnoFacade() {
        super(Turno.class);
    }

    @Override
    public List<Turno> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turno find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turno find(Turno turno) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Turno.findByNombre");
            q.setParameter("nombre", turno.getNombre());
            return (Turno) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Turno> findEntities(String nombre, String turno, Integer idCompania, Integer integerDos, String valorTres, String valorCuatro, String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        String query = this.getQuery(nombre, turno, idCompania);
        System.out.println("Query...." + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (idCompania != null) {
                q.setParameter("idcompania", idCompania);
            }
            if (nombre != null && !nombre.equals("")) {
                q.setParameter("nombre", nombre);
            }
            if (turno != null && !turno.equals("")) {
                q.setParameter("turno", turno);
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String nombre, String turno, Integer idCompania) {
        String query = "SELECT t FROM Turno t";
        boolean bandera = false;
        if (idCompania != null) {
            query += " WHERE t.idcompania.idcompania = :idcompania";
            bandera = true;
        }
        if (nombre != null && !nombre.equals("")) {
            if (!bandera) {
                query += " WHERE t.nombre = :nombre";
                bandera = true;
            } else {
                query += " AND t.nombre = :nombre";
            }
        }
        if (turno != null && !turno.equals("")) {
            if (!bandera) {
                query += " WHERE t.turno = :turno";
            } else {
                query += " AND t.turno = :turno";
            }
        }
        return query += " ORDER BY t.nombre ASC";
    }

    @Override
    public List<Turno> findEntities(Turno entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turno> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turno> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Turno findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
