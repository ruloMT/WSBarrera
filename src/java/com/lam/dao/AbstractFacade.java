/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.dao;

import com.lam.util.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author JoséAntonio
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public boolean create(T entity) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public boolean createEntities(List<T> entities) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            for (T e : entities) {
                em.persist(e);
                em.flush();
                em.clear();
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public boolean edit(T entity) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public boolean editEntities(List<T> entities) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            for (T e : entities) {
                em.merge(e);
                em.flush();
                em.clear();
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public boolean destroy(T entity) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public boolean delete(List<T> entities) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            for (T t : entities) {
                T k = em.merge(t);
                em.remove(k);
                em.flush();
                em.clear();
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public T find(Integer id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findEntities() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
