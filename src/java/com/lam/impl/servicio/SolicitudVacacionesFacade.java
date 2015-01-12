/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.SolicitudVacaciones;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
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
@Stateless(name = "controladorSolicitudVacaciones")
public class SolicitudVacacionesFacade extends AbstractFacade<SolicitudVacaciones> implements ProcesoFacadeLocal<SolicitudVacaciones> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public SolicitudVacacionesFacade() {
        super(SolicitudVacaciones.class);
    }

    @Override
    public List<SolicitudVacaciones> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("SolicitudVacaciones.findAll");
            List<SolicitudVacaciones> solicitudes = q.getResultList();
            for (SolicitudVacaciones s : solicitudes) {
                String llave = Parametros.COLUMNA_ESTATUS + " | " + Parametros.TABLA_VACSOLICITUDESTB + " | " + s.getEstatus();
                s.setfInicio(Util.convertDateToString(s.getFechainicio()));
                s.setfFin(Util.convertDateToString(s.getFechafin()));
                s.setfActualizacion(Util.convertDateToString(s.getFechaactualizacion()));
                s.setStrEstatus(Parametros.MAPA_CATALOGO.get(llave));
            }
            return solicitudes;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public SolicitudVacaciones find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SolicitudVacaciones find(SolicitudVacaciones entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SolicitudVacaciones> findEntities(String numeroEmpleado, String nombre, Integer idRelLab, Integer integerDos,
            String apellidoPaterno, String apellidoMaterno, String estatus, Date fechaInicio, Date fechaFin, Date fechaRegistro, Date fechaCuatro) {
        EntityManager em = null;
        String query = this.getQuery(numeroEmpleado, nombre, apellidoPaterno, apellidoMaterno, estatus, fechaInicio, fechaFin, fechaRegistro);
        System.out.println("Query... " + query);
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (numeroEmpleado != null && !numeroEmpleado.equals("")) {
                q.setParameter("numeroempleado", numeroEmpleado.trim().toUpperCase());
            }
            if (nombre != null && !nombre.equals("")) {
                q.setParameter("nombre", nombre);
            }
            if (apellidoPaterno != null && !apellidoPaterno.equals("")) {
                q.setParameter("apellidopaterno", apellidoPaterno.trim().toUpperCase());
            }
            if (apellidoMaterno != null && !apellidoMaterno.equals("")) {
                q.setParameter("apellidomaterno", apellidoMaterno.trim().toUpperCase());
            }
            if (fechaInicio != null) {
                q.setParameter("fechainicio", fechaInicio);
            }
            if (fechaFin != null) {
                q.setParameter("fechafin", fechaFin);
            }
            if (fechaRegistro != null) {
                q.setParameter("fechaactualizacion", fechaRegistro);
            }
            if (estatus != null && !estatus.equals("")) {
                q.setParameter("estatus", estatus);
            }
            List<SolicitudVacaciones> solicitudes = q.getResultList();
            for (SolicitudVacaciones s : solicitudes) {
                String llave = Parametros.COLUMNA_ESTATUS + " | " + Parametros.TABLA_VACSOLICITUDESTB + " | " + s.getEstatus();
                s.setfInicio(Util.convertDateToString(s.getFechainicio()));
                s.setfFin(Util.convertDateToString(s.getFechafin()));
                s.setfActualizacion(Util.convertDateToString(s.getFechaactualizacion()));
                s.setStrEstatus(Parametros.MAPA_CATALOGO.get(llave));
            }
            return solicitudes;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String numeroEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String estatus, Date fechaInicio, Date fechaFin, Date fechaRegistro) {
        String query = "SELECT s FROM SolicitudVacaciones s";
        boolean bandera = true;
        if (numeroEmpleado != null && !numeroEmpleado.equals("")) {
            query += " WHERE s.idrellab.numeroempleado = :numeroempleado";
            bandera = false;
        }
        if (nombre != null && !nombre.equals("")) {
            if (bandera) {
                query += " WHERE s.idrellab.idempleado.nombre = :nombre";
                bandera = false;
            } else {
                query += " AND s.idrellab.idempleado.nombre = :nombre";
            }
        }
        if (apellidoPaterno != null && !apellidoPaterno.equals("")) {
            if (bandera) {
                query += " WHERE s.idrellab.idempleado.apellidopaterno = :apellidopaterno";
                bandera = false;
            } else {
                query += " AND s.idrellab.idempleado.apellidopaterno = :apellidopaterno";
            }
        }
        if (apellidoMaterno != null && !apellidoMaterno.equals("")) {
            if (bandera) {
                query += " WHERE s.idrellab.idempleado.apellidomaterno = :apellidomaterno";
                bandera = false;
            } else {
                query += " AND s.idrellab.idempleado.apellidomaterno = :apellidomaterno";
            }
        }
        if (fechaInicio != null) {
            if (bandera) {
                query += " WHERE s.fechainicio <= :fechafin";
                bandera = false;
            } else {
                query += " AND s.fechainicio <= :fechafin";
            }
        }
        if (fechaFin != null) {
            if (bandera) {
                query += " WHERE s.fechafin >= :fechainicio";
                bandera = false;
            } else {
                query += " AND s.fechafin >= :fechainicio";
            }
        }
        if (fechaRegistro != null) {
            if (bandera) {
                query += " WHERE s.fechaactualizacion = :fechaactualizacion";
                bandera = false;
            } else {
                query += " AND s.fechaactualizacion = :fechaactualizacion";
            }
        }
        if (estatus != null && !estatus.equals("")) {
            if (bandera) {
                query += " WHERE s.estatus = :estatus";
            } else {
                query += " AND s.estatus = :estatus";
            }
        }
        return query + " ORDER BY s.fechainicio ASC";
    }

    @Override
    public List<SolicitudVacaciones> findEntities(SolicitudVacaciones entity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("SolicitudVacaciones.findByFechaInicioAndFechaFin");
            q.setParameter("fechaInicio", entity.getFechainicio());
            q.setParameter("fechaFin", entity.getFechainicio());
            q.setParameter("estatus", entity.getEstatus());
            List<SolicitudVacaciones> solicitudes = q.getResultList();
            for (SolicitudVacaciones s : solicitudes) {
                s.setfInicio(Util.convertDateToString(s.getFechainicio()));
                s.setfFin(Util.convertDateToString(s.getFechafin()));
                s.setfActualizacion(Util.convertDateToString(s.getFechaactualizacion()));
            }
            return solicitudes;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<SolicitudVacaciones> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SolicitudVacaciones> findEntities(List<Integer> ids) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("SolicitudVacaciones.findByIdRelLabAndIdVacSaldo");
            q.setParameter("idrellab", ids.get(0));
            q.setParameter("idvacsaldo", ids.get(1));
            List<SolicitudVacaciones> solicitudes = q.getResultList();
            for (SolicitudVacaciones s : solicitudes) {
                String llave = Parametros.COLUMNA_ESTATUS + " | " + Parametros.TABLA_VACSOLICITUDESTB + " | " + s.getEstatus();
                s.setfInicio(Util.convertDateToString(s.getFechainicio()));
                s.setfFin(Util.convertDateToString(s.getFechafin()));
                s.setfActualizacion(Util.convertDateToString(s.getFechaactualizacion()));
                s.setStrEstatus(Parametros.MAPA_CATALOGO.get(llave));
            }
            return solicitudes;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public SolicitudVacaciones findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
