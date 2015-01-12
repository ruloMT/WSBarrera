/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Pension;
import com.lam.util.JpaUtil;
import com.lam.util.Util;
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
@Stateless(name = "controladorPension")
public class PensionFacade extends AbstractFacade<Pension> implements ProcesoFacadeLocal<Pension> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PensionFacade() {
        super(Pension.class);
    }

    @Override
    public Pension find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pension find(Pension pension) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Pension.findByOficioAndNumeroEmpleado");
            q.setParameter("oficio", pension.getOficio());
            q.setParameter("numeroempleado", pension.getIdrellab().getNumeroempleado());
            return (Pension) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Pension> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pension> findEntities(Pension pension) {
        String query = this.getQuery(pension);
        System.out.println("Query... " + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (pension.getOficio() != null && !pension.getOficio().equals("")) {
                q.setParameter("oficio", pension.getOficio());
            }
            if (pension.getCuenta() != null && !pension.getCuenta().equals("")) {
                q.setParameter("cuenta", pension.getCuenta());
            }
            if (pension.getApellidopaterno() != null && !pension.getApellidopaterno().equals("")) {
                q.setParameter("apellidopaterno", pension.getApellidopaterno());
            }
            if (pension.getApellidomaterno() != null && !pension.getApellidomaterno().equals("")) {
                q.setParameter("apellidomaterno", pension.getApellidomaterno());
            }
            if (pension.getNombre() != null && !pension.getNombre().equals("")) {
                q.setParameter("nombre", pension.getNombre());
            }
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(Pension pension) {
        String query = "SELECT p FROM Pension p";
        boolean bandera = false;
        if (pension.getOficio() != null && !pension.getOficio().equals("")) {
            query += " WHERE p.oficio = :oficio";
            bandera = true;
        }
        if (pension.getCuenta() != null && !pension.getCuenta().equals("")) {
            if (!bandera) {
                query += " WHERE p.cuenta = :cuenta";
            } else {
                query += " AND p.cuenta = :cuenta";
            }
        }
        if (pension.getApellidopaterno() != null && !pension.getApellidopaterno().equals("")) {
            if (!bandera) {
                query += " WHERE p.apellidopaterno = :apellidopaterno";
                bandera = true;
            } else {
                query += " AND p.apellidopaterno = :apellidopaterno";
            }
        }
        if (pension.getApellidomaterno() != null && !pension.getApellidomaterno().equals("")) {
            if (!bandera) {
                query += " WHERE p.apellidomaterno = :apellidomaterno";
                bandera = true;
            } else {
                query += " AND p.apellidomaterno = :apellidomaterno";
            }
        }
        if (pension.getNombre() != null && !pension.getNombre().equals("")) {
            if (!bandera) {
                query += " WHERE p.nombre = :nombre";
            } else {
                query += " AND p.nombre = :nombre";
            }
        }

        return query + " ORDER BY p.idrellab.idempleado.nombre ASC";
    }

    @Override
    public List<Pension> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Pension.findByIdRellab");
            q.setParameter("idrellab", id);
            List<Pension> lista = q.getResultList();
            for (Pension p : lista) {
                p.setFechaStr(Util.convertDateToString(p.getFecha()));
            }
            return lista;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Pension> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pension> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pension findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
