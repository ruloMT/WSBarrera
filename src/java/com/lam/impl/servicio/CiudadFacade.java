/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Ciudad;
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
@Stateless(name = "controladorCiudad")
public class CiudadFacade extends AbstractFacade<Ciudad> implements ProcesoFacadeLocal<Ciudad> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }

    @Override
    public Ciudad find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ciudad find(Ciudad ciudad) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Ciudad.findByNombre");
            q.setParameter("nombre", ciudad.getNombre());
            return (Ciudad) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Ciudad> findEntities(String nombre, String valorDos, Integer idPais, Integer idEstado, String idMunicipio, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        String query = this.getQuery(nombre, idPais, idEstado, idMunicipio);
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
            if (idMunicipio != null) {
                Integer id = Integer.parseInt(idMunicipio);
                q.setParameter("idmunicipio", id);
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

    private String getQuery(String nombre, Integer idPais, Integer idEstado, String idMunicipio) {
        String query = "SELECT c FROM Ciudad c";
        boolean bandera = false;
        if (idPais != null) {
            query += " WHERE c.idmunicipio.idestado.idpais.idpais = :idpais";
            bandera = true;
        }
        if (idEstado != null) {
            if (!bandera) {
                query += " WHERE c.idmunicipio.idestado.idestado = :idestado";
                bandera = true;
            } else {
                query += " AND c.idmunicipio.idestado.idestado = :idestado";
            }
        }
        if (idMunicipio != null) {
            if (!bandera) {
                query += " WHERE c.idmunicipio.idmunicipio = :idmunicipio";
                bandera = true;
            } else {
                query += " AND c.idmunicipio.idmunicipio = :idmunicipio";
            }
        }
        if (nombre != null && !nombre.equals("")) {
            if (!bandera) {
                query += " WHERE c.nombre = :nombre";
            } else {
                query += " AND c.nombre = :nombre";
            }
        }
        return query + " ORDER BY c.nombre ASC";
    }

    @Override
    public List<Ciudad> findEntities(Ciudad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudad> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudad> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ciudad> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ciudad findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
