/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.impl;

import com.lam.impl.threads.HiloObtenerRegistros;
import com.lam.conversorXml.ConversorXmlToEntity;
import com.lam.dao.ProcesoCfdiDao;
import com.lam.entidades.CalendarioProceso;
import com.lam.entidades.CfdiRecibo;
import com.lam.entidades.ClaseNomina;
import com.lam.entidades.ListadoRecibosCfdi;
import com.lam.entidades.TipoNomina;
import com.lam.impl.threads.HiloRecibo;
import com.lam.reporte.descarga.DescargarPdfs;
import com.lam.to.FacturaElectronicaTO;
import com.lam.to.GranTotalTO;
import com.lam.to.ParametroTO;
import com.lam.util.JpaUtil;
import com.lam.util.Parametros;
import com.lam.util.Util;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author JoséAntonio
 */
@Stateless
@SuppressWarnings("CallToThreadDumpStack")
public class ProcesoCfdiImpl implements ProcesoCfdiDao {

    private HiloObtenerRegistros hilo;

    public ProcesoCfdiImpl() {
        this.emf = JpaUtil.getInstance().createEntityManagerRecibos().getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    @Override
    public ClaseNomina findClaseNomina(String claseNomina) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("ClaseNomina.findByClaseNomina");
            q.setParameter("claseNomina", claseNomina);
            return (ClaseNomina) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public TipoNomina findTipoNomina(String tipoNomina) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("TipoNomina.findByTipoNomina");
            q.setParameter("tipoNomina", tipoNomina);
            return (TipoNomina) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public CalendarioProceso getCalendarioProceso(ParametroTO parametro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("CalendarioProceso.find");
            q.setParameter("tipoNomina", parametro.getTipoNomina());
            q.setParameter("anio", parametro.getAnio());
            q.setParameter("periodo", parametro.getPeriodo());
            return (CalendarioProceso) q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public boolean ejecutaProcedure(ParametroTO parametro) {
        EntityManager em = null;
        System.out.println(parametro.getClaveCompania() + " | " + parametro.getChclase_nomina()
                + " | " + parametro.getNid_calendario() + " | " + parametro.getChtipo_nomina() + " | " + parametro.getChagr_orden() + ""
                + " | " + parametro.getInumero_recibo() + " | " + parametro.getChclave_recibo());
        try {
            em = getEntityManager();
            StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("ProcedureNomina");
            sp.setParameter("chcompania", parametro.getClaveCompania());
            sp.setParameter("chclase_nomina", parametro.getChclase_nomina());
            sp.setParameter("nid_calendario", parametro.getNid_calendario());
            sp.setParameter("chtipo_nomina", parametro.getChtipo_nomina());
            sp.setParameter("chagr_orden", parametro.getChagr_orden());
            sp.setParameter("iNumero_recibo", parametro.getInumero_recibo());
            sp.setParameter("dFechaPago", Util.getFechaTimeStamp(parametro.getDfechaPago()));
            sp.setParameter("chClave_recibo", parametro.getChclave_recibo());
            sp.execute();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<CfdiRecibo> getRecibos(ParametroTO parametro) {
        EntityManager em = null;
        List<CfdiRecibo> recibos;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("CfdiRecibo.findAll");
            q.setParameter("compania", parametro.getClaveCompania());
            recibos = q.getResultList();
        } catch (Exception e) {
            recibos = null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
        if (recibos != null) {
            return this.consultarConceptos(recibos, parametro);
        }
        return null;
    }

    @Override
    public List<String> obtenerRegistros(List<CfdiRecibo> registros, ParametroTO parametro) {
        hilo = new HiloObtenerRegistros();
        hilo.setRegistros(registros);
        hilo.start();
        do {
        } while (!hilo.isBandera());
        System.out.println("Termina Proceso....");
        return hilo.getCadenas();
    }

    @Override
    public List<String> getErrores() {
        return this.hilo.getCadenasErrores();
    }

    @Override
    public boolean escribirArchivo(List<String> cadenas, ParametroTO parametro, String nombreEmpresa, String pathCarpetaTxt) {
        FileWriter fichero = null;
        PrintWriter pw;
//        
        String fileName = Util.getFileName(parametro, nombreEmpresa);
        String archivo = pathCarpetaTxt + fileName;

        System.out.println("FileNAme:: " + fileName + " | " + cadenas.size() + " | " + archivo);
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            int cont = 0;
            for (String cadena : cadenas) {
                cont++;
                System.out.println(cont + " | " + cadena);
                pw.println(cadena);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    private List<CfdiRecibo> consultarConceptos(List<CfdiRecibo> recibos, ParametroTO parametro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("ListadoRecibosCfdi.findByTrabajador");
            q.setParameter("concepto", 9999);
            for (CfdiRecibo r : recibos) {
                ListadoRecibosCfdi listado = null;
                try {
                    q.setParameter("trabajador", r.getTrabajador());
                    listado = (ListadoRecibosCfdi) q.getSingleResult();
                } catch (Exception e) {
                }
                r.setParametro(parametro);
                r.setListadoReciboCfdi(listado);
            }
            return recibos;
        } catch (Exception e) {
            return null;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public GranTotalTO getGranTotal(List<CfdiRecibo> registros) {
        GranTotalTO gt = new GranTotalTO();
        int cont = 0;
        for (CfdiRecibo r : registros) {
            cont++;
            System.out.println(cont + " | " + r.getTrabajador() + " | " + r.getNombre());
            gt.setSubtotal(r.getSubTotal().doubleValue());
            gt.setDescuento(r.getDescuento().doubleValue());
            gt.setImpuesto(r.getTotalImpuestosRetenidos().doubleValue());
            gt.setTotal(r.getTotal().doubleValue());
            gt.setValorUnitario(r.getValorUnitario().doubleValue());
            if (r.getListadoReciboCfdi() != null) {
                gt.setNetoNomina(r.getListadoReciboCfdi().getImporte().doubleValue());
            }
        }
        return gt;
    }

    @Override
    public List<ClaseNomina> findAllClaseNomina() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("ClaseNomina.findAll");
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<TipoNomina> findAllTipoNomina() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("TipoNomina.findAll");
            return q.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    @Override
    public List<FacturaElectronicaTO> leerArchivos(Integer idCompania, String pathCarpetaTimbre, String pathCarpetaLogo) {
        System.out.println("Inicia Proceso Hilo... " + new Date());
//        
        ConversorXmlToEntity conversor = new ConversorXmlToEntity();

        List<FacturaElectronicaTO> facturas = conversor.iniciarProceso(pathCarpetaTimbre, pathCarpetaLogo, idCompania);
//      
        List<HiloRecibo> hilos = Collections.synchronizedList(new ArrayList<HiloRecibo>());
//        
//        
        while (facturas.size() > 0) {
            int hilosXArrancar = facturas.size() > Parametros.MAXIMO_HILOS_RECIBOS ? Parametros.MAXIMO_HILOS_RECIBOS : facturas.size();
            List<FacturaElectronicaTO> listTemp = new ArrayList<>(facturas.subList(0, hilosXArrancar));
            HiloRecibo hiloRecibo = new HiloRecibo(listTemp);
            hiloRecibo.arrancar();
            hilos.add(hiloRecibo);
//            
            facturas.removeAll(listTemp);
        }
        System.out.println("Numero de hilos... " + hilos.size());
        return this.verificarHilos(hilos);
    }

    private List<FacturaElectronicaTO> verificarHilos(List<HiloRecibo> hilos) {
        List<FacturaElectronicaTO> facturas = new ArrayList<>();
//        
        boolean verificar = false;
//        
        int cont;
//        
        while (!verificar) {
            cont = 0;
//            
            for (HiloRecibo hiloRecibo : hilos) {
                if (hiloRecibo.isCorriendo()) {
                    cont++;
                } else {
                    if (!hiloRecibo.isVerificado()) {
                        facturas.addAll(hiloRecibo.getFacturas());
                        hiloRecibo.setVerificado(true);
                    }
                }
            }
            verificar = cont > 0 ? false : true;
//            
        }
        System.out.println("Termina Proceso Hilo... " + new Date());
        return facturas;

    }

    @Override
    public void descargarArchivosPdfs(List<FacturaElectronicaTO> facturas, String pathCarpetaProcesados) {
        DescargarPdfs descargar = new DescargarPdfs();
        descargar.setFacturas(facturas, pathCarpetaProcesados);
    }
}
