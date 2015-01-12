/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.Concepto;
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
@Stateless(name = "controladorConcepto")
public class ConceptoFacade extends AbstractFacade<Concepto> implements ProcesoFacadeLocal<Concepto> {

//  LLAVES  
    private String llaveConcepto = Parametros.COLUMNA_TIPOCONCEPTO + " | " + Parametros.TABLA_NOMCONCEPTOSTB + " | ";
    private String llaveUnidad = Parametros.COLUMNA_UNIDAD + " | " + Parametros.TABLA_NOMCONCEPTOSTB + " | ";
//    
    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ConceptoFacade() {
        super(Concepto.class);
    }

    @Override
    public Concepto find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concepto find(Concepto concepto) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Concepto.findByConcepto");
            q.setParameter("concepto", concepto.getConcepto());
            return (Concepto) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Concepto> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concepto> findEntities(Concepto concepto) {
        String query = this.getQuery(concepto);
        System.out.println("Query... " + query);
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createQuery(query);
            if (concepto.getConcepto() != null && !concepto.getConcepto().equals("")) {
                q.setParameter("concepto", concepto.getConcepto());
            }
            if (concepto.getNombre() != null && !concepto.getNombre().equals("")) {
                q.setParameter("nombre", concepto.getNombre());
            }
            if (concepto.getTipoconcepto() != null && !concepto.getTipoconcepto().equals("")) {
                q.setParameter("tipoconcepto", concepto.getTipoconcepto());
            }
            if (concepto.getUnidad() != null && !concepto.getUnidad().equals("")) {
                q.setParameter("unidad", concepto.getUnidad());
            }
            List<Concepto> conceptos = q.getResultList();
            return this.getConceptosDescripcion(conceptos);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    private String getQuery(Concepto concepto) {
        String query = "SELECT c FROM Concepto c";
        boolean bandera = false;
        if (concepto.getConcepto() != null && !concepto.getConcepto().equals("")) {
            query += " WHERE c.concepto = :concepto";
            bandera = true;
        }
        if (concepto.getNombre() != null && !concepto.getNombre().equals("")) {
            if (!bandera) {
                query += " WHERE c.nombre = :nombre";
                bandera = true;
            } else {
                query += " AND c.nombre = :nombre";
            }
        }
        if (concepto.getTipoconcepto() != null && !concepto.getTipoconcepto().equals("")) {
            if (!bandera) {
                query += " WHERE c.tipoconcepto = :tipoconcepto";
                bandera = true;
            } else {
                query += " AND c.tipoconcepto = :tipoconcepto";
            }
        }
        if (concepto.getUnidad() != null && !concepto.getUnidad().equals("")) {
            if (!bandera) {
                query += " WHERE c.unidad = :unidad";
            } else {
                query += " AND c.unidad = :unidad";
            }
        }
        return query + " ORDER BY c.nombre ASC";
    }

    @Override
    public List<Concepto> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Concepto> findEntities(List<Integer> ids) {
        List<Concepto> aux;
        List<Concepto> conceptos = new ArrayList<>();
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("Concepto.findAll");
            aux = q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
        boolean bandera;
        for (Concepto c : aux) {
            bandera = false;
            for (Integer id : ids) {
                if (id == c.getIdconcepto()) {
                    bandera = true;
                }
            }
            if (!bandera) {
                conceptos.add(c);
            }
        }
        return this.getConceptosDescripcion(conceptos);
    }

    private List<Concepto> getConceptosDescripcion(List<Concepto> conceptos) {

        for (Concepto c : conceptos) {
            c.setConceptoDescripcion(Parametros.MAPA_CATALOGO.get(llaveConcepto + c.getTipoconcepto()));
            c.setUnidadDescripcion(Parametros.MAPA_CATALOGO.get(llaveUnidad + c.getUnidad()));
        }
        return conceptos;
    }

    public void getConceptosDescripcion(Concepto concepto) {
        concepto.setConceptoDescripcion(Parametros.MAPA_CATALOGO.get(llaveConcepto + concepto.getTipoconcepto()));
        concepto.setUnidadDescripcion(Parametros.MAPA_CATALOGO.get(llaveUnidad + concepto.getUnidad()));
    }

    @Override
    public List<Concepto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concepto findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
