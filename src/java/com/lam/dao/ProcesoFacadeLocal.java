/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JoséAntonio
 */
@Local
public interface ProcesoFacadeLocal<T> {

    public boolean create(T entity);

    public boolean createEntities(List<T> entities);

    public boolean edit(T entity);

    public boolean editEntities(List<T> entities);

    public boolean destroy(T entity);
    
    public boolean delete(List<T> entities);

    public T find(Integer id);

    public List<T> findEntities();

    public List<T> findAll();

    public T find(String valorUno, String valorDos);

    public T find(T entity);

    public List<T> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos,
            String valorTres, String valorCuatro, String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro);

    public List<T> findEntities(T entity);

    public List<T> findEntities(Integer id);

    public List<T> findEntities(List<Integer> ids);

    public T findEntity(Integer id);

    public boolean delete(Integer id);
}
