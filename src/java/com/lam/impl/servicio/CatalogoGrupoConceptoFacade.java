/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.CatalogoGrupoConcepto;
import com.lam.util.JpaUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
@Stateless(name = "controladorGrupoConcepto")
public class CatalogoGrupoConceptoFacade extends AbstractFacade<CatalogoGrupoConcepto> implements ProcesoFacadeLocal<CatalogoGrupoConcepto> {

    @EJB
    private ConceptoFacade controlConcepto;
//    
    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CatalogoGrupoConceptoFacade() {
        super(CatalogoGrupoConcepto.class);
    }

    @Override
    public CatalogoGrupoConcepto find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CatalogoGrupoConcepto find(CatalogoGrupoConcepto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGrupoConcepto> findEntities(String valorUno, String valorDos, Integer idGrupoConcepto, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("CatalogoGrupoConcepto.findByIdGrupoConcepto");
            q.setParameter("idgrupoconcepto", idGrupoConcepto);

            List<CatalogoGrupoConcepto> catalogo = q.getResultList();
            for (CatalogoGrupoConcepto cat : catalogo) {
                controlConcepto.getConceptosDescripcion(cat.getIdconcepto());
            }
            return catalogo;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<CatalogoGrupoConcepto> findEntities(CatalogoGrupoConcepto entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGrupoConcepto> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGrupoConcepto> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGrupoConcepto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CatalogoGrupoConcepto findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
