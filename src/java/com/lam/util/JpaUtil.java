/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class JpaUtil {

    private JpaUtil() {
    }

    public static JpaUtil getInstance() {
        return JpaUtilHolder.INSTANCE;
    }

    private static class JpaUtilHolder {

        private static final JpaUtil INSTANCE = new JpaUtil();
    }

    public EntityManager createEntityManagerRecibos() {
        return Persistence.createEntityManagerFactory("BarreraPU").createEntityManager();
    }

    public EntityManager createEntityManagerCenicco() {
        return Persistence.createEntityManagerFactory("CeniccoPU").createEntityManager();
    }

    public EntityManager createEntityManagerServicio() {
        return Persistence.createEntityManagerFactory("BarreraCeniccoPU").createEntityManager();
    }

    public void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    public void rollBackEntityManager(EntityManager em) {
        if (em != null) {
            em.getTransaction().rollback();
        }
    }
}
