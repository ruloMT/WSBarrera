/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.RelacionLaboral;
import com.lam.entidades.servicio.SaldoVacaciones;
import com.lam.entidades.servicio.SolicitudVacaciones;
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
@Stateless(name = "controladorSaldoVacaciones")
public class SaldoVacacionesFacade extends AbstractFacade<SaldoVacaciones> implements ProcesoFacadeLocal<SaldoVacaciones> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public SaldoVacacionesFacade() {
        super(SaldoVacaciones.class);
    }

    @Override
    public List<SaldoVacaciones> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("SaldoVacaciones.findAll");
            List< SaldoVacaciones> saldos = q.getResultList();
            for (SaldoVacaciones saldo : saldos) {
                String fInicio = Util.convertDateToString(saldo.getFechainicio());
                String fFin = Util.convertDateToString(saldo.getFechafin());
                saldo.setfInicio(fInicio);
                saldo.setfFin(fFin);
            }
            return saldos;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public SaldoVacaciones find(String idRelLab, String ciclo) {
        EntityManager em = null;
        try {
            System.out.println("Consultar... " + idRelLab + " | " + ciclo);
            em = this.getEntityManager();
            Integer id = Integer.parseInt(idRelLab);
            Integer c = Integer.parseInt(ciclo);
            Query q = em.createNamedQuery("SaldoVacaciones.findByIdRellabAndCiclo");
            q.setParameter("idrellab", id);
            q.setParameter("ciclo", c);
            return (SaldoVacaciones) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public SaldoVacaciones find(SaldoVacaciones entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SaldoVacaciones> findEntities(String numeroEmpleado, String nombre, Integer ciclo, Integer integerDos, String apellidoPaterno, String apellidoMaterno,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        EntityManager em = null;
        String query = this.getQuery(numeroEmpleado, nombre, ciclo, apellidoPaterno, apellidoMaterno);
        System.out.println("Query... " + query);
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (numeroEmpleado != null && !numeroEmpleado.equals("")) {
                q.setParameter("numeroempleado", numeroEmpleado.trim().toUpperCase());
            }
            if (nombre != null && !nombre.equals("")) {
                q.setParameter("nombre", nombre.trim().toUpperCase());
            }
            if (ciclo != null) {
                q.setParameter("ciclo", ciclo);
            }
            if (apellidoPaterno != null && !apellidoPaterno.equals("")) {
                q.setParameter("apellidopaterno", apellidoPaterno.trim().toUpperCase());
            }
            if (apellidoMaterno != null && !apellidoMaterno.equals("")) {
                q.setParameter("apellidomaterno", apellidoMaterno.trim().toUpperCase());
            }

            List< SaldoVacaciones> saldos = q.getResultList();
            for (SaldoVacaciones s : saldos) {
                String fInicio = Util.convertDateToString(s.getFechainicio());
                String fFin = Util.convertDateToString(s.getFechafin());
                s.setfInicio(fInicio);
                s.setfFin(fFin);
                Date fechaIngreso = s.getIdrellab().getFechaingreso();
                s.getIdrellab().setFechaIngresoStr(Util.convertDateToString(fechaIngreso));
                Date fechAntiguedad = s.getIdrellab().getFechaantiguedad1();
                s.getIdrellab().setFechaAntiguedadStr(Util.convertDateToString(fechAntiguedad));
            }
            return saldos;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String numeroEmpleado, String nombre, Integer ciclo, String apellidoPaterno, String apellidoMaterno) {
        String query = "SELECT s FROM SaldoVacaciones s";
        boolean bandera = false;
        if (numeroEmpleado != null && !numeroEmpleado.equals("")) {
            query += " WHERE s.idrellab.numeroempleado = :numeroempleado";
            bandera = true;
        }
        if (nombre != null && !nombre.equals("")) {
            if (!bandera) {
                query += " WHERE s.idrellab.idempleado.nombre = :nombre";
                bandera = true;
            } else {
                query += " AND s.idrellab.idempleado.nombre = :nombre";
            }
        }
        if (ciclo != null) {
            if (!bandera) {
                query += " WHERE s.ciclo = :ciclo";
                bandera = true;
            } else {
                query += " AND s.ciclo = :ciclo";
            }
        }
        if (apellidoPaterno != null && !apellidoPaterno.equals("")) {
            if (!bandera) {
                query += " WHERE s.idrellab.idempleado.apellidopaterno = :apellidopaterno";
                bandera = true;
            } else {
                query += " AND s.idrellab.idempleado.apellidopaterno = :apellidopaterno";
            }
        }
        if (apellidoMaterno != null && !apellidoMaterno.equals("")) {
            if (!bandera) {
                query += " WHERE s.idrellab.idempleado.apellidomaterno = :apellidomaterno";
            } else {
                query += " AND s.idrellab.idempleado.apellidomaterno = :apellidomaterno";
            }
        }
        return query;
    }

    @Override
    public List<SaldoVacaciones> findEntities(SaldoVacaciones entity) {
        return null;
    }

    @Override
    public List<SaldoVacaciones> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("SaldoVacaciones.findByIdRellab");
            q.setParameter("idrellab", id);
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<SaldoVacaciones> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SaldoVacaciones findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer idRellab) {
        List<SaldoVacaciones> saldos = this.findEntities(idRellab);
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            for (SaldoVacaciones s : saldos) {
                Integer id = s.getIdvacsaldo();
                SaldoVacaciones saldoVacaciones;
                try {
                    saldoVacaciones = em.getReference(SaldoVacaciones.class, id);
                    saldoVacaciones.getIdvacsaldo();
                } catch (Exception e) {
                    return false;
                }
                RelacionLaboral idrellab = saldoVacaciones.getIdrellab();
                if (idrellab != null) {
                    idrellab.getSaldoVacacionesList().remove(saldoVacaciones);
                    em.merge(idrellab);
                }
                List<SolicitudVacaciones> solicitudVacacionesList = saldoVacaciones.getSolicitudVacacionesList();
                for (SolicitudVacaciones solicitudVacacionesListSolicitudVacaciones : solicitudVacacionesList) {
                    solicitudVacacionesListSolicitudVacaciones.setIdvacsaldo(null);
                    solicitudVacacionesListSolicitudVacaciones = em.merge(solicitudVacacionesListSolicitudVacaciones);
                }
                em.remove(saldoVacaciones);
                em.flush();
                em.clear();
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }
}
