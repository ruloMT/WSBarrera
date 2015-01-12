/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.ColumnaTabulador;
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
@Stateless(name = "controladorColumnaTabulador")
public class ColumnaTabuladorFacade extends AbstractFacade<ColumnaTabulador> implements ProcesoFacadeLocal<ColumnaTabulador> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ColumnaTabuladorFacade() {
        super(ColumnaTabulador.class);
    }

    @Override
    public List<ColumnaTabulador> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColumnaTabulador find(String valorUno, String valorDos) {
        Integer id = Integer.parseInt(valorUno);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("ColumnaTabulador.findByIdTabuladorAndDescripcion");
            q.setParameter("idtabulador", id);
            q.setParameter("descripcion", valorDos);
            return (ColumnaTabulador) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public ColumnaTabulador find(ColumnaTabulador entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ColumnaTabulador> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ColumnaTabulador> findEntities(ColumnaTabulador entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ColumnaTabulador> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("ColumnaTabulador.findByIdTabulador");
            q.setParameter("idtabulador", id);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<ColumnaTabulador> findEntities(List<Integer> ids) {
        return null;
    }

    @Override
    public ColumnaTabulador findEntity(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
