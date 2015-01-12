/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.ConfiguracionVacaciones;
import com.lam.util.JpaUtil;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author JoséAntonio
 */
@Stateless(name = "controladorConfiguracionVacaciones")
public class ConfiguracionVacacionesFacade extends AbstractFacade<ConfiguracionVacaciones> implements ProcesoFacadeLocal<ConfiguracionVacaciones> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public ConfiguracionVacacionesFacade() {
        super(ConfiguracionVacaciones.class);
    }

    @Override
    public List<ConfiguracionVacaciones> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfiguracionVacaciones find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfiguracionVacaciones find(ConfiguracionVacaciones entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConfiguracionVacaciones> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConfiguracionVacaciones> findEntities(ConfiguracionVacaciones entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConfiguracionVacaciones> findEntities(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConfiguracionVacaciones> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConfiguracionVacaciones findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
