/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.TipoRelacionLaboral;
import com.lam.util.JpaUtil;
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
@Stateless(name = "controladorTipoRelacionLaboral")
public class TipoRelacionLaboralFacade extends AbstractFacade<TipoRelacionLaboral> implements ProcesoFacadeLocal<TipoRelacionLaboral> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TipoRelacionLaboralFacade() {
        super(TipoRelacionLaboral.class);
    }

    @Override
    public TipoRelacionLaboral find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoRelacionLaboral find(TipoRelacionLaboral tipoRelacionLaboral) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("TipoRelacionLaboral.findByNombre");
            q.setParameter("nombre", tipoRelacionLaboral.getNombre());
            return (TipoRelacionLaboral) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<TipoRelacionLaboral> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres,
            String valorCuatro, String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoRelacionLaboral> findEntities(TipoRelacionLaboral tipoRelacionLaboral) {
        String query = this.getQuery(tipoRelacionLaboral);
        System.out.println("Query Tipo Relacion Laboral... " + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (tipoRelacionLaboral.getNombre() != null && !tipoRelacionLaboral.getNombre().equals("")) {
                q.setParameter("nombre", tipoRelacionLaboral.getNombre());
            }
            return q.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(TipoRelacionLaboral tipoRelacionLaboral) {
        String query = "SELECT t FROM TipoRelacionLaboral t ";
        if (tipoRelacionLaboral.getNombre() != null && !tipoRelacionLaboral.getNombre().equals("")) {
            query += " WHERE t.nombre = :nombre";
        }
        return query += " ORDER BY t.nombre ASC";
    }

    @Override
    public List<TipoRelacionLaboral> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoRelacionLaboral> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoRelacionLaboral> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoRelacionLaboral findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
