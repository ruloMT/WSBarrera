/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.ConceptoLista;
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
@Stateless(name = "controladorConceptoLista")
public class ConceptoListaFacade extends AbstractFacade<ConceptoLista> implements ProcesoFacadeLocal<ConceptoLista> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ConceptoListaFacade() {
        super(ConceptoLista.class);
    }

    @Override
    public List<ConceptoLista> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConceptoLista find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConceptoLista find(ConceptoLista entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConceptoLista> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConceptoLista> findEntities(ConceptoLista entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConceptoLista> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("ConceptoLista.findByIdLista");
            q.setParameter("idlista", id);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<ConceptoLista> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConceptoLista findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
