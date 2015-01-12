/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.CatalogoGeneral;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
@Stateless(name = "controladorCatalogoGeneral")
public class CatalogoGeneralFacade extends AbstractFacade<CatalogoGeneral> implements ProcesoFacadeLocal<CatalogoGeneral> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CatalogoGeneralFacade() {
        super(CatalogoGeneral.class);
    }

    @Override
    public CatalogoGeneral find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CatalogoGeneral find(CatalogoGeneral catalogo) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("CatalogoGeneral.findByNombreAndTabla");
            q.setParameter("nombre", catalogo.getNombre());
            q.setParameter("tabla", catalogo.getTabla());
            q.setParameter("columna", catalogo.getColumna());
            return (CatalogoGeneral) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<CatalogoGeneral> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("CatalogoGeneral.findByTablaAndColumna");
            q.setParameter("tabla", valorUno);
            q.setParameter("columna", valorDos);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<CatalogoGeneral> findEntities(CatalogoGeneral catalogoGeneral) {
        String query = this.getQuery(catalogoGeneral);
        System.out.println("query::::" + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (catalogoGeneral.getColumna() != null && !catalogoGeneral.getColumna().equals("")) {
                q.setParameter("columna", catalogoGeneral.getColumna());
            }
            if (catalogoGeneral.getNombre() != null && !catalogoGeneral.getNombre().equals("")) {
                q.setParameter("nombre", catalogoGeneral.getNombre());
            }
            if (catalogoGeneral.getTabla() != null && !catalogoGeneral.getTabla().equals("")) {
                q.setParameter("tabla", catalogoGeneral.getTabla());
            }
            if (catalogoGeneral.getValor() != null && !catalogoGeneral.getValor().equals("")) {
                q.setParameter("valor", catalogoGeneral.getValor());
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(CatalogoGeneral catalogoGeneral) {
        String query = "SELECT c FROM CatalogoGeneral c";

        boolean bandera = true;

        if (catalogoGeneral.getColumna() != null && !catalogoGeneral.getColumna().equals("")) {
            query += " WHERE c.columna = :columna";
            bandera = false;
        }
        if (catalogoGeneral.getNombre() != null && !catalogoGeneral.getNombre().equals("")) {
            if (bandera) {
                query += " WHERE c.nombre = :nombre";
                bandera = false;
            } else {
                query += " AND c.nombre = :nombre";
            }
        }
        if (catalogoGeneral.getTabla() != null && !catalogoGeneral.getTabla().equals("")) {
            if (bandera) {
                query += " WHERE c.tabla = :tabla";
                bandera = false;
            } else {
                query += " AND c.tabla = :tabla";
            }
        }
        if (catalogoGeneral.getValor() != null && !catalogoGeneral.getValor().equals("")) {
            if (bandera) {
                query += " WHERE  c.valor = :valor";
            } else {
                query += " AND c.valor = :valor";
            }
        }
        return query + " ORDER BY c.tabla,c.columna ASC";
    }

    @Override
    public List<CatalogoGeneral> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGeneral> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CatalogoGeneral> findAll() {
        EntityManager em = null;
        Parametros.MAPA_CATALOGO = new HashMap<>();
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("CatalogoGeneral.findAll");
            List<CatalogoGeneral> catalogo = q.getResultList();
            for (CatalogoGeneral c : catalogo) {
                String llave = c.getColumna() + " | " + c.getTabla() + " | " + c.getValor();
                Parametros.MAPA_CATALOGO.put(llave, c.getNombre());
            }
            return catalogo;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public CatalogoGeneral findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
