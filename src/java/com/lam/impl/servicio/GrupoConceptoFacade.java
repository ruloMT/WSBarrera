/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.GrupoConcepto;
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
@Stateless(name = "controladorGrupoConcepto")
public class GrupoConceptoFacade extends AbstractFacade<GrupoConcepto> implements ProcesoFacadeLocal<GrupoConcepto> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public GrupoConceptoFacade() {
        super(GrupoConcepto.class);
    }

    @Override
    public GrupoConcepto find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoConcepto find(GrupoConcepto grupoConcepto) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("GrupoConcepto.findByGrupoConcepto");
            q.setParameter("grupoconcepto", grupoConcepto.getGrupoconcepto());
            return (GrupoConcepto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<GrupoConcepto> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoConcepto> findEntities(GrupoConcepto grupoConcepto) {
        String query = getQuery(grupoConcepto);
        System.out.println("Query... " + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (grupoConcepto.getGrupoconcepto() != null && !grupoConcepto.getGrupoconcepto().equals("")) {
                q.setParameter("grupoconcepto", grupoConcepto.getGrupoconcepto());
            }
            if (grupoConcepto.getNombre() != null && !grupoConcepto.getNombre().equals("")) {
                q.setParameter("nombre", grupoConcepto.getNombre());
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(GrupoConcepto grupoConcepto) {
        String query = "SELECT g FROM GrupoConcepto g";
        boolean bandera = false;
        if (grupoConcepto.getGrupoconcepto() != null && !grupoConcepto.getGrupoconcepto().equals("")) {
            query += " WHERE g.grupoconcepto = :grupoconcepto";
            bandera = true;
        }
        if (grupoConcepto.getNombre() != null && !grupoConcepto.getNombre().equals("")) {
            if (!bandera) {
                query += " WHERE g.nombre = :nombre";
            } else {
                query += " AND g.nombre = :nombre";
            }

        }
        return query + " ORDER BY g.nombre ASC";
    }

    @Override
    public List<GrupoConcepto> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoConcepto> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoConcepto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoConcepto findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
