/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Banco;
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
@Stateless(name = "controladorBanco")
public class BancoFacade extends AbstractFacade<Banco> implements ProcesoFacadeLocal<Banco> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BancoFacade() {
        super(Banco.class);
    }

    @Override
    public Banco find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banco find(Banco banco) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Banco.findByNombre");
            q.setParameter("nombre", banco.getNombre());
            return (Banco) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Banco> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Banco> findEntities(Banco banco) {
        String query = this.getQuery(banco);
        System.out.println("Query... " + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (banco.getBanco() != null && !banco.getBanco().equals("")) {
                q.setParameter("banco", banco.getBanco());
            }
            if (banco.getNombre() != null && !banco.getNombre().equals("")) {
                q.setParameter("nombre", banco.getNombre());
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(Banco banco) {
        String query = "SELECT b FROM Banco b";
        boolean bandera = false;
        if (banco.getBanco() != null && !banco.getBanco().equals("")) {
            query += " WHERE b.banco = :banco";
            bandera = true;
        }
        if (banco.getNombre() != null && !banco.getNombre().equals("")) {
            if (!bandera) {
                query += " WHERE b.nombre = :nombre";
            } else {
                query += " AND b.nombre = :nombre";
            }
        }
        return query + " ORDER BY b.nombre ASC";
    }

    @Override
    public List<Banco> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Banco> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Banco> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banco findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
