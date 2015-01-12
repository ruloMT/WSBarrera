/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.ProcesoFacadeLocal;
import com.lam.dao.AbstractFacade;
import com.lam.entidades.servicio.RelacionLaboral;
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
@Stateless(name = "controladorRelacionLaboral")
public class RelacionLaboralFacade extends AbstractFacade<RelacionLaboral> implements ProcesoFacadeLocal<RelacionLaboral> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public RelacionLaboralFacade() {
        super(RelacionLaboral.class);
    }

    @Override
    public RelacionLaboral find(String expediente, String valorDos) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("RelacionLaboral.findByExpediente");
            q.setParameter("expediente", expediente);
            return (RelacionLaboral) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public RelacionLaboral find(RelacionLaboral entity) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("RelacionLaboral.findByRfc");
            q.setMaxResults(1);
            q.setParameter("rfc", entity.getIdempleado().getRfc());
            return (RelacionLaboral) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<RelacionLaboral> findEntities(String expediente, String rfc, Integer idCompania, Integer idRegistroPatronal,
            String estatus, String valorCuatro, String valorCinco, Date fechaInicioAlta, Date fechaFinAlta, Date fechaInicioBaja, Date fechaFinBaja) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            String query = this.getQuery(expediente, rfc, idCompania, idRegistroPatronal, estatus,
                    fechaInicioAlta, fechaFinAlta, fechaInicioBaja, fechaFinBaja);
            System.out.println("Query: " + query + " | " + estatus);
            Query q = em.createQuery(query);
            if (expediente != null && !expediente.equals("")) {
                q.setParameter("expediente", expediente);
            }
            if (rfc != null && !rfc.equals("")) {
                q.setParameter("rfc", rfc);
            }
            if (idCompania != null) {
                q.setParameter("idCompania", idCompania);
            }
            if (idRegistroPatronal != null) {
                q.setParameter("idregistropatronal", idRegistroPatronal);
            }
            if (estatus != null && !estatus.equals("")) {
                q.setParameter("estatus", estatus);
            }
            if (fechaInicioAlta != null) {
                q.setParameter("fechaInicioAlta", fechaInicioAlta);
            }
            if (fechaFinAlta != null) {
                q.setParameter("fechaFinAlta", fechaFinAlta);
            }
            if (fechaInicioBaja != null) {
                q.setParameter("fechaInicioBaja", fechaInicioBaja);
            }
            if (fechaFinBaja != null) {
                q.setParameter("fechaFinBaja", fechaFinBaja);
            }
            List<RelacionLaboral> lista = q.getResultList();
            for (RelacionLaboral r : lista) {
                r.setFechaIngresoStr(Util.convertDateToString(r.getFechaingreso()));
                r.setFechaBajaStr(Util.convertDateToString(r.getFechabaja()));
            }
            return lista;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String expediente, String rfc, Integer idCompania, Integer idRegistroPatronal,
            String estatus, Date fechaInicioAlta, Date fechaFinAlta, Date fechaInicioBaja, Date fechaFinBaja) {
        String query = "SELECT r FROM RelacionLaboral r";
        boolean bandera = false;
        if (expediente != null && !expediente.equals("")) {
            query += " WHERE r.idempleado.expediente = :expediente";
            bandera = true;
        }
        if (rfc != null && !rfc.equals("")) {
            if (bandera) {
                query += " AND r.idempleado.rfc = :rfc";
            } else {
                query += " WHERE r.idempleado.rfc = :rfc";
                bandera = true;
            }
        }
        if (idCompania != null) {
            if (bandera) {
                query += " AND r.idcompania.idcompania = :idCompania";
            } else {
                query += " WHERE r.idcompania.idcompania = :idCompania";
                bandera = true;
            }
        }
        if (idRegistroPatronal != null) {
            if (bandera) {
                query += " AND r.idregistropatronal.idregistropatronal = :idregistropatronal";
            } else {
                query += " WHERE r.idregistropatronal.idregistropatronal = :idregistropatronal";
                bandera = true;
            }
        }
        if (estatus != null && !estatus.equals("")) {
            if (bandera) {
                query += " AND r.estatus = :estatus";
            } else {
                query += " WHERE r.estatus = :estatus";
                bandera = true;
            }
        }
        if (fechaInicioAlta != null) {
            if (bandera) {
                query += " AND r.fechaingreso >= :fechaInicioAlta";
            } else {
                query += " WHERE r.fechaingreso >= :fechaInicioAlta";
                bandera = true;
            }
        }
        if (fechaFinAlta != null) {
            if (bandera) {
                query += " AND r.fechaingreso <= :fechaFinAlta";
            } else {
                query += " WHERE r.fechaingreso <= :fechaFinAlta";
                bandera = true;
            }
        }
        if (fechaInicioBaja != null) {
            if (bandera) {
                query += " AND r.fechabaja >= :fechaInicioBaja";
            } else {
                query += " WHERE r.fechabaja >= :fechaInicioBaja";
                bandera = true;
            }
        }
        if (fechaFinBaja != null) {
            if (bandera) {
                query += " AND r.fechabaja <= :fechaFinBaja";
            } else {
                query += " WHERE r.fechabaja <= :fechaFinBaja";
            }
        }
        return query + " ORDER BY r.numeroempleado ASC";
    }

    @Override
    public List<RelacionLaboral> findEntities(RelacionLaboral rl) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("RelacionLaboral.findByNumeroempleado");
            q.setParameter("numeroempleado", rl.getNumeroempleado());
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<RelacionLaboral> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RelacionLaboral> findEntities(List<Integer> ids) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("RelacionLaboral.findByIdCompaniaAndIdGrupoPago");
            q.setParameter("idcompania", ids.get(0));
            q.setParameter("idgrupopago", ids.get(1));
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<RelacionLaboral> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("SaldoVacaciones.findAllDistinctRellab");
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public RelacionLaboral findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
