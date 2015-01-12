/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Incidencia;
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
@Stateless(name = "controladorIncidencia")
public class IncidenciaFacade extends AbstractFacade<Incidencia> implements ProcesoFacadeLocal<Incidencia> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public IncidenciaFacade() {
        super(Incidencia.class);
    }

    @Override
    public List<Incidencia> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Incidencia find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Incidencia find(Incidencia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> findEntities(String numeroEmpleado, String idTipoProceso, Integer idCompania, Integer idGrupoPago, String idPeriodo, String valorCuatro,
            String valorCinco, Date fechaInicio, Date fechaFin, Date fechaTres, Date fechaCuatro) {
        EntityManager em = null;
//        
        Integer idTP = idTipoProceso != null ? Integer.parseInt(idTipoProceso) : null;
        Integer idPer = idPeriodo != null ? Integer.parseInt(idPeriodo) : null;
        String query = this.getQuery(numeroEmpleado, idCompania, idGrupoPago, idTP, idPer, fechaInicio, fechaFin);
        System.out.println("Query Incidencias... " + query + " | " + numeroEmpleado);
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (fechaInicio != null) {
                q.setParameter("fechainicio", fechaInicio);
                q.setParameter("fechafin", fechaFin);
            } else {
                if (idCompania != null) {
                    q.setParameter("idcompania", idCompania);
                }
                if (idGrupoPago != null) {
                    q.setParameter("idgrupopago", idGrupoPago);
                }
                if (idTipoProceso != null) {
                    q.setParameter("idtipoproceso", idTP);
                }
                if (idPeriodo != null) {
                    q.setParameter("idperiodo", idPer);
                }
                if (numeroEmpleado != null && !numeroEmpleado.equals("")) {
                    q.setParameter("numeroempleado", numeroEmpleado);
                }
            }
            List<Incidencia> incidencias = q.getResultList();
            System.out.println("Incidencias size... " + incidencias.size());
            for (Incidencia i : incidencias) {
                String llave = Parametros.COLUMNA_ESTATUS + " | " + Parametros.TABLA_NOMINCIDENCIASTB + " | " + i.getEstatus();
                String nombre = Parametros.MAPA_CATALOGO.get(llave);
                i.setStatusStr(nombre);
//                
                i.getIdperiodo().setFechaInicioStr(Util.convertDateToString(i.getIdperiodo().getFechainicio()));
                i.getIdperiodo().setFechaFinStr(Util.convertDateToString(i.getIdperiodo().getFechafin()));
//                
                String fAux01 = i.getFechaaux01() != null ? Util.convertDateToString(i.getFechaaux01()) : "";
                String fAux02 = i.getFechaaux02() != null ? Util.convertDateToString(i.getFechaaux02()) : "";
                String fActualiza = i.getFechaact() != null ? Util.convertDateToString(i.getFechaact()) : "";
//                
                i.setfAux01(fAux01);
                i.setfAux02(fAux02);
                i.setfActualiza(fActualiza);
            }
            return incidencias;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(String numeroEmpleado, Integer idCompania, Integer idGrupoPago, Integer idTipoProceso, Integer idPeriodo, Date fechaInicio, Date fechaFin) {
        String query = "SELECT i FROM Incidencia i";
        boolean bandera = false;
//        
        if (fechaInicio != null) {
            query += " WHERE i.fechaact <= :fechafin AND i.fechaact >= :fechainicio";
        } else {
//            
            if (idCompania != null) {
                query += " WHERE i.idrellab.idcompania.idcompania = :idcompania";
                bandera = true;
            }
//        
            if (idGrupoPago != null) {
                if (!bandera) {
                    query += " WHERE i.idrellab.idgrupopago.idgrupopago = :idgrupopago";
                    bandera = true;
                } else {
                    query += " AND i.idrellab.idgrupopago.idgrupopago = :idgrupopago";
                }
            }
//       
            if (idTipoProceso != null) {
                if (!bandera) {
                    query += " WHERE i.idperiodo.idtipoproceso.idtipoproceso = :idtipoproceso";
                    bandera = true;
                } else {
                    query += " AND i.idperiodo.idtipoproceso.idtipoproceso = :idtipoproceso";
                }
            }
//        
            if (idPeriodo != null) {
                if (!bandera) {
                    query += " WHERE i.idperiodo.idperiodo = :idperiodo";
                    bandera = true;
                } else {
                    query += " AND i.idperiodo.idperiodo = :idperiodo";
                }
            }
//        
            if (numeroEmpleado != null && !numeroEmpleado.equals("")) {
                if (!bandera) {
                    query += " WHERE i.idrellab.numeroempleado = :numeroempleado";
                } else {
                    query += " AND i.idrellab.numeroempleado = :numeroempleado";
                }
            }
        }
//        

//        
        return query + " ORDER BY i.idrellab.numeroempleado,i.idperiodo.idperiodo ASC";
    }

    @Override
    public List<Incidencia> findEntities(Incidencia entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Incidencia> findEntities(List<Integer> ids) {
        return null;
    }

    @Override
    public Incidencia findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
