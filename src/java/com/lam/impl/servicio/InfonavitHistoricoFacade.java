/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl.servicio;

import com.lam.dao.AbstractFacade;
import com.lam.dao.ProcesoFacadeLocal;
import com.lam.entidades.servicio.InfonavitHistorico;
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
@Stateless(name = "controladorInfonavitHistorico")
public class InfonavitHistoricoFacade extends AbstractFacade<InfonavitHistorico> implements ProcesoFacadeLocal<InfonavitHistorico> {

    private EntityManagerFactory emf = JpaUtil.getInstance().createEntityManagerServicio().getEntityManagerFactory();

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public InfonavitHistoricoFacade() {
        super(InfonavitHistorico.class);
    }

    @Override
    public List<InfonavitHistorico> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InfonavitHistorico find(String valorUno, String valorDos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InfonavitHistorico find(InfonavitHistorico entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InfonavitHistorico> findEntities(String valorUno, String valorDos, Integer integerUno, Integer integerDos, String valorTres, String valorCuatro,
            String valorCinco, Date fechaUno, Date fechaDos, Date fechaTres, Date fechaCuatro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InfonavitHistorico> findEntities(InfonavitHistorico entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InfonavitHistorico> findEntities(Integer id) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            Query q = em.createNamedQuery("InfonavitHistorico.findByIdInfonavit");
            q.setParameter("idinfonavit", id);
            List<InfonavitHistorico> historico = q.getResultList();
            for (InfonavitHistorico i : historico) {
                String llaveTipo = Parametros.COLUMNA_TIPODESCUENTO + " | " + Parametros.TABLA_FISINFONAVITTB + " | " + i.getTipodescuento();
                String llaveEstatus = Parametros.COLUMNA_ESTATUS + " | " + Parametros.TABLA_FISINFONAVITTB + " | " + i.getEstatus();
//                
                i.setTipoDescStr(Parametros.MAPA_CATALOGO.get(llaveTipo));
                i.setEstatusStr(Parametros.MAPA_CATALOGO.get(llaveEstatus));
//                
                i.setfActualizaStr(Util.convertDateToString(i.getFechaactualizacion()));
                i.setfVigenciaStr(Util.convertDateToString(i.getFechavigencia()));
            }
            return historico;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<InfonavitHistorico> findEntities(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InfonavitHistorico findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
