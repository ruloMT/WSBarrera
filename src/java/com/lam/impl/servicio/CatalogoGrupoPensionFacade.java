/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.CatalogoGrupoPension;
import com.lam.util.JpaUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
@Stateless(name = "controladorGrupoPension")
public class CatalogoGrupoPensionFacade extends AbstractFacade<CatalogoGrupoPension> implements ProcesoFacadeLocal<CatalogoGrupoPension> {

    private ConceptoFacade controladorConcepto = lookupcontroladorConceptoBean();
//    
    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CatalogoGrupoPensionFacade() {
        super(CatalogoGrupoPension.class);
    }

    @Override
    public List<CatalogoGrupoPension> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CatalogoGrupoPension find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CatalogoGrupoPension find(CatalogoGrupoPension entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGrupoPension> findEntities(String valorUno, String valorDos, Integer idPension, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("CatalogoGrupoPension.findByIdGrupo");
            q.setParameter("idpension", idPension);
            List<CatalogoGrupoPension> catalogo = q.getResultList();
            for (CatalogoGrupoPension c : catalogo) {
                controladorConcepto.getConceptosDescripcion(c.getIdconcepto());
            }
            return catalogo;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<CatalogoGrupoPension> findEntities(CatalogoGrupoPension entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGrupoPension> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("CatalogoGrupoPension.findIdPension");
            q.setParameter("idpension", id);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<CatalogoGrupoPension> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CatalogoGrupoPension findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ConceptoFacade lookupcontroladorConceptoBean() {
        try {
            Context c = new InitialContext();
            return (ConceptoFacade) c.lookup("java:global/WSRexam/controladorConcepto!com.lam.impl.servicio.ConceptoFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
