/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Municipio;
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
@Stateless(name = "controladorMunicipio")
public class MunicipioFacade extends AbstractFacade<Municipio> implements ProcesoFacadeLocal<Municipio> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }

    @Override
    public Municipio find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio find(Municipio municipio) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Municipio.findByNombre");
            q.setParameter("nombre", municipio.getNombre());
            return (Municipio) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Municipio> findEntities(String nombre, String valorDos, Integer idPais, Integer idEstado, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        String query = this.getQuery(idPais, idEstado, nombre);
        System.out.println("Query... " + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (idPais != null) {
                q.setParameter("idpais", idPais);
            }
            if (idEstado != null) {
                q.setParameter("idestado", idEstado);
            }
            if (nombre != null && !nombre.equals("")) {
                q.setParameter("nombre", nombre);
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(Integer idPais, Integer idEstado, String nombre) {
        String query = "SELECT m FROM Municipio m";
        boolean bandera = false;
        if (idPais != null) {
            query += " WHERE m.idestado.idpais.idpais = :idpais";
            bandera = true;
        }
        if (idEstado != null) {
            if (!bandera) {
                query += " WHERE m.idestado.idestado = :idestado";
                bandera = true;
            } else {
                query += " AND m.idestado.idestado = :idestado";
            }
        }
        if (nombre != null && !nombre.equals("")) {
            if (!bandera) {
                query += " WHERE m.nombre = :nombre";
            } else {
                query += " AND m.nombre = :nombre";
            }
        }
        return query + " ORDER BY m.nombre ASC";
    }

    @Override
    public List<Municipio> findEntities(Municipio entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Municipio> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Municipio.findByIdestado");
            q.setParameter("idestado", id);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Municipio> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Municipio> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Municipio findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
