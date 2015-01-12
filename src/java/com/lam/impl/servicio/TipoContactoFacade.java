/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.TipoContacto;
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
@Stateless(name = "controladorTipoContacto")
public class TipoContactoFacade extends AbstractFacade<TipoContacto> implements ProcesoFacadeLocal<TipoContacto> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipoContactoFacade() {
        super(TipoContacto.class);
    }

    @Override
    public List<TipoContacto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoContacto find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoContacto find(TipoContacto tipoContacto) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("TipoContacto.findByNombre");
            q.setParameter("nombre", tipoContacto.getNombre());
            return (TipoContacto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<TipoContacto> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoContacto> findEntities(TipoContacto tipoContacto) {
        String query = this.getQuery(tipoContacto);
        System.out.println("Query....." + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (tipoContacto.getNombre() != null && !tipoContacto.getNombre().equals("")) {
                q.setParameter("nombre", tipoContacto.getNombre());
            }
            if (tipoContacto.getPersonal() != null && !tipoContacto.getPersonal().equals("")) {
                q.setParameter("personal", tipoContacto.getPersonal());
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(TipoContacto tipoContacto) {
        String query = "SELECT t FROM TipoContacto t";
        boolean bandera = false;
        if (tipoContacto.getNombre() != null && !tipoContacto.getNombre().equals("")) {
            query += " WHERE t.nombre = :nombre";
            bandera = true;
        }
        if (tipoContacto.getPersonal() != null && !tipoContacto.getPersonal().equals("")) {
            if (!bandera) {
                query += " WHERE t.personal = :personal";
            } else {
                query += " AND t.personal = :personal";
            }
        }
        return query + " ORDER BY t.nombre ASC";
    }

    @Override
    public List<TipoContacto> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoContacto> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoContacto findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
