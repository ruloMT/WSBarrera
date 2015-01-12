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
public interface ProcesoDAO<T> {

    public boolean create(T object);

    public boolean create(List<T> object);

    public boolean edit(T object);

    public boolean destroy(Integer id);

    public List<T> findEntities();

    public T find(String valorUno, String valorDos);

    public T find(T object);

    public T find(Integer id);

    public List<T> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos,
            String valorTres, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro);

    public List<T> findEntities(T object);

    public List<T> findEntities(Integer id);

    public List<T> findEntities(List<Integer> ids);
}
