/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.cenicco;

import com.lam.dao.ProcesoDAO;
import com.lam.entidades.cenicco.Usuario;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author JoséAntonio
 */
public class UsuarioImpl implements ProcesoDAO<Usuario>, Serializable {

    public UsuarioImpl() {
        this.emf = JpaUtil.getInstance().createEntityManagerCenicco().getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public boolean create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public boolean edit(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Usuario> findEntities() {
        EntityManager em = null;
        Parametros.MAPA_USUARIOS = new HashMap<>();
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Usuario.findAll");
            List<Usuario> usuarios = q.getResultList();
            for (Usuario u : usuarios) {
                String llave = u.getRfc() + " | " + u.getNumeroEmpleado();
//                System.out.println("Usuario: " + llave);
                Parametros.MAPA_USUARIOS.put(llave, u);
            }
        } catch (Exception e) {
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
        return null;
    }

    @Override
    public Usuario find(String rfc, String numeroEmpleado) {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Usuario.findByRfcAndNumeroEmpleado");
            q.setParameter("rfc", rfc);
            q.setParameter("numeroEmpleado", numeroEmpleado);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<Usuario> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findEntities(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario find(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean destroy(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(List<Usuario> object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
