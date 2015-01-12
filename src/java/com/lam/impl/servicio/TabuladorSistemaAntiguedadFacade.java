/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.TabuladorSistemaAntiguedad;
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
@Stateless(name = "controladorTabuladorSistemaAntiguedad")
public class TabuladorSistemaAntiguedadFacade extends AbstractFacade<TabuladorSistemaAntiguedad> implements ProcesoFacadeLocal<TabuladorSistemaAntiguedad> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TabuladorSistemaAntiguedadFacade() {
        super(TabuladorSistemaAntiguedad.class);
    }

    @Override
    public List<TabuladorSistemaAntiguedad> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TabuladorSistemaAntiguedad find(String valorUno, String valorDos) {
        Integer idSistema = Integer.parseInt(valorUno);
        Double ciclo = Double.parseDouble(valorDos);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("TabuladorSistemaAntiguedad.findByCiclo");
            q.setParameter("idsistemaantiguedad", idSistema);
            q.setParameter("limiteinferior", ciclo);
            q.setParameter("limitesuperior", ciclo);
            return (TabuladorSistemaAntiguedad) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public TabuladorSistemaAntiguedad find(TabuladorSistemaAntiguedad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TabuladorSistemaAntiguedad> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TabuladorSistemaAntiguedad> findEntities(TabuladorSistemaAntiguedad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TabuladorSistemaAntiguedad> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TabuladorSistemaAntiguedad> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TabuladorSistemaAntiguedad findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
