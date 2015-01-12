/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.cenicco;

import com.lam.dao.ProcesoDAO;
import com.lam.entidades.cenicco.TimbreRecibo;
import com.lam.entidades.cenicco.Usuario;
import com.lam.to.FacturaElectronicaTO;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
import com.lam.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
public class TimbreReciboImpl implements Serializable {

    public TimbreReciboImpl() {
        this.emf = JpaUtil.getInstance().createEntityManagerCenicco().getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public synchronized boolean create(List<FacturaElectronicaTO> facturas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            for (FacturaElectronicaTO f : facturas) {
                if (!f.isEdit()) {
                    TimbreRecibo t = new TimbreRecibo(f);
                    em.persist(t);
                    em.flush();
                    em.clear();
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public synchronized void edit(List<TimbreRecibo> timbres) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            for (TimbreRecibo t : timbres) {
                t = em.merge(t);
                em.flush();
                em.clear();
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            JpaUtil.getInstance().rollBackEntityManager(em);
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public synchronized List<TimbreRecibo> findTimbresRecibos(List<FacturaElectronicaTO> facturas) {
        EntityManager em = null;
        List<TimbreRecibo> timbres = new ArrayList<>();
//        
        ProcesoDAO controlUsuario = new UsuarioImpl();
//        
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("TimbreRecibo.findByUuid");
            for (FacturaElectronicaTO f : facturas) {
                q.setParameter("uuid", f.getTimbreFiscal().getUuid());
                try {
                    TimbreRecibo t = (TimbreRecibo) q.getSingleResult();
                    f.setEdit(true);
                    t.editTimbre(f);
                    timbres.add(t);
                } catch (Exception e) {
                    String llave = f.getReceptor().getRfc() + " | " + f.getNomina().getNumEmpleado();
                    System.out.println("Usuario: " + llave);
                    if (Parametros.MAPA_USUARIOS.get(llave) == null) {
                        Usuario usuario = new Usuario();
                        usuario.setCurp(f.getNomina().getCurp());
                        usuario.setIdcompania(f.getIdCompania());
                        usuario.setNumeroEmpleado(f.getNomina().getNumEmpleado());
                        usuario.setNss(f.getNomina().getNumSeguroSocial());
                        usuario.setNombre(f.getReceptor().getNombre());
                        usuario.setPassword(Util.generarPassword());
                        usuario.setPerfilAdmin(0);
                        usuario.setRfc(f.getReceptor().getRfc());
                        controlUsuario.create(usuario);
//
                        usuario = (Usuario) controlUsuario.find(usuario.getRfc(), usuario.getNumeroEmpleado());
//                        
                        f.setUsuario(usuario);
                        Parametros.MAPA_USUARIOS.put(llave, usuario);
                    } else {
                        f.setUsuario(Parametros.MAPA_USUARIOS.get(llave));
                    }
                    f.setEdit(false);
                }
            }
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
        return timbres;
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public List<TimbreRecibo> findAllTimbres() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("TimbreRecibo.findAll");
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }
}
