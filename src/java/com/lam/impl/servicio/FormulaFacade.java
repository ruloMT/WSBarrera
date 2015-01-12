/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Formula;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
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
@Stateless(name = "controladorFormula")
public class FormulaFacade extends AbstractFacade<Formula> implements ProcesoFacadeLocal<Formula> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public FormulaFacade() {
        super(Formula.class);
    }

    @Override
    public List<Formula> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      @Override
    public Formula find(String valorUno, String calculo) {
        Integer idCompania = Integer.parseInt(valorUno);
        System.out.println("idCompania..." + idCompania);
        System.out.println("calculo..." + calculo);
        EntityManager em = null; 
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Formula.findByCalculo");
            q.setParameter("idcompania", idCompania);
            q.setParameter("calculo", calculo);
            return (Formula) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public Formula find(Formula formula) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Formula.findByCalculo");
            q.setParameter("calculo", formula.getCalculo());
            return (Formula) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Formula> findEntities(String calculo, String formula, Integer idCompania, Integer prioridad, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        String query = this.getQuery(calculo, formula, idCompania, prioridad);
        System.out.println("Query... " + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (calculo != null && !calculo.equals("")) {
                q.setParameter("calculo", calculo);
            }
            if (formula != null && !formula.equals("")) {
                q.setParameter("formula", formula);
            }
            if (idCompania != null) {
                q.setParameter("idcompania", idCompania);
            }
            if (prioridad != null) {
                q.setParameter("prioridad", prioridad);
            }
            List<Formula> formulas = q.getResultList();
            for(Formula f : formulas) {
                String llave = Parametros.COLUMNA_CALCULO + " | " + Parametros.TABLA_FORMULASTB + " | " + f.getCalculo();
                f.setCalculoStr(Parametros.MAPA_CATALOGO.get(llave));
            }
            return formulas;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String calculo, String formula, Integer idCompania, Integer prioridad) {
        String query = "SELECT f FROM Formula f";
        boolean bandera = false;
        if (calculo != null && !calculo.equals("")) {
            query += " WHERE f.calculo = :calculo";
            bandera = true;
        }
        if (formula != null && !formula.equals("")) {
            if (!bandera) {
                query += " WHERE f.formula = :formula";
                bandera = true;
            } else {
                query += " AND f.formula = :formula";
            }
        }
        if (idCompania != null) {
            if (!bandera) {
                query += " WHERE f.idcompania.idcompania = :idcompania";
                bandera = true;
            } else {
                query += " AND f.idcompania.idcompania = :idcompania";
            }
        }
        if (prioridad != null) {
            if (!bandera) {
                query += " WHERE f.prioridad = :prioridad";
            } else {
                query += " AND f.prioridad = :prioridad";
            }
        }
        return query + " ORDER BY f.prioridad";
    }

    @Override
    public List<Formula> findEntities(Formula entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formula> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formula> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Formula findEntity(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Formula.findByIdformula");
            q.setParameter("idformula", id);
            return (Formula) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
