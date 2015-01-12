/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Periodo;
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
@Stateless(name = "controladorPeriodo")
public class PeriodoFacade extends AbstractFacade<Periodo> implements ProcesoFacadeLocal<Periodo> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PeriodoFacade() {
        super(Periodo.class);
    }

    @Override
    public Periodo find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Periodo find(Periodo periodo) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Periodo.findByFechaInicioAndFechaFin");
            q.setParameter("fechainicio", periodo.getFechainicio());
            q.setParameter("fechafin", periodo.getFechafin());
            return (Periodo) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Periodo> findEntities(String periodo, String anioMes, Integer idTipoProceso, Integer anio, String mes, String bimestre,
            String valorCinco, Date fechaInicio, Date fechaFin, Date fechaPago, Date fechaCuatro) {
        EntityManager em = null;
        String query = getQuery(idTipoProceso, anio, periodo, anioMes, fechaInicio, fechaFin, fechaPago, mes, bimestre);
        System.out.println("Query ..." + query);
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (idTipoProceso != null) {
                q.setParameter("idtipoproceso", idTipoProceso);
            }
            if (anio != null) {
                q.setParameter("anio", anio);
            }
            if (periodo != null && !periodo.equals("")) {
                q.setParameter("periodo", periodo);
            }
            if (anioMes != null && !anioMes.equals("")) {
                q.setParameter("aniomes", anioMes);
            }
            if (fechaInicio != null) {
                q.setParameter("fechainicio", fechaInicio);
            }
            if (fechaFin != null) {
                q.setParameter("fechafin", fechaFin);
            }
            if (fechaPago != null) {
                q.setParameter("fechapago", fechaPago);
            }
            if (mes != null && !mes.equals("")) {
                q.setParameter("mes", mes);
            }
            if (bimestre != null && !bimestre.equals("")) {
                q.setParameter("bimestre", bimestre);
            }
            List<Periodo> periodos = q.getResultList();
            for (Periodo p : periodos) {
                String fInicio = Util.convertDateToString(p.getFechainicio());
                String fFin = Util.convertDateToString(p.getFechafin());
                String fPago = Util.convertDateToString(p.getFechapago());
                p.setFechaInicioStr(fInicio);
                p.setFechaFinStr(fFin);
                p.setFechaPagoStr(fPago);
            }
            return periodos;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(Integer idTipoProceso, Integer anio, String periodo, String anioMes, Date fechaInicio,
            Date fechaFin, Date fechaPago, String mes, String bimestre) {
        String query = "SELECT p FROM Periodo p";
        boolean bandera = true;
        if (idTipoProceso != null) {
            query += " WHERE p.idtipoproceso.idtipoproceso = :idtipoproceso";
            bandera = false;
        }
        if (anio != null) {
            if (bandera) {
                query += " WHERE p.anio = :anio";
                bandera = false;
            } else {
                query += " AND p.anio = :anio";
            }
        }
        if (periodo != null && !periodo.equals("")) {
            if (bandera) {
                query += " WHERE p.periodo = :periodo";
                bandera = false;
            } else {
                query += " AND p.periodo = :periodo";
            }
        }
        if (anioMes != null && !anioMes.equals("")) {
            if (bandera) {
                query += " WHERE p.aniomes = :aniomes";
                bandera = false;
            } else {
                query += " AND p.aniomes = :aniomes";
            }
        }
        if (fechaInicio != null) {
            if (bandera) {
                query += " WHERE p.fechainicio = :fechainicio";
                bandera = false;
            } else {
                query += " AND p.fechainicio = :fechainicio";
            }
        }
        if (fechaFin != null) {
            if (bandera) {
                query += " WHERE p.fechafin = :fechafin";
                bandera = false;
            } else {
                query += " AND p.fechafin = :fechafin";
            }
        }
        if (fechaPago != null) {
            if (bandera) {
                query += " WHERE p.fechapago = :fechapago";
                bandera = false;
            } else {
                query += " AND p.fechapago = :fechapago";
            }
        }
        if (mes != null && !mes.equals("")) {
            if (bandera) {
                query += " WHERE p.mes = :mes";
                bandera = false;
            } else {
                query += " AND p.mes = :mes";
            }
        }
        if (bimestre != null && !bimestre.equals("")) {
            if (bandera) {
                query += " WHERE p.bimestre = :bimestre";
            } else {
                query += " AND p.bimestre = :bimestre";
            }
        }
        return query + " ORDER BY p.periodo ASC";
    }

    @Override
    public List<Periodo> findEntities(Periodo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periodo> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periodo> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Periodo> findAll() {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Periodo.findAll");
            List<Periodo> periodos = q.getResultList();
            for (Periodo p : periodos) {
                p.setFechaInicioStr(Util.convertDateToString(p.getFechainicio()));
                p.setFechaFinStr(Util.convertDateToString(p.getFechafin()));
            }
            System.out.println("Periodos size... " + periodos.size());
            return periodos;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public Periodo findEntity(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Periodo.findByIdperiodo");
            q.setParameter("idperiodo", id);
            Periodo periodo = (Periodo) q.getSingleResult();
            periodo.setFechaInicioStr(Util.convertDateToString(periodo.getFechainicio()));
            periodo.setFechaFinStr(Util.convertDateToString(periodo.getFechafin()));
            return (Periodo) periodo;
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
