/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.dao;

import com.lam.entidades.CalendarioProceso;
import com.lam.entidades.CfdiRecibo;
import com.lam.entidades.ClaseNomina;
import com.lam.entidades.TipoNomina;
import com.lam.to.FacturaElectronicaTO;
import com.lam.to.GranTotalTO;
import com.lam.to.ParametroTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JoséAntonio
 */
@Local
public interface ProcesoCfdiDao {

    public ClaseNomina findClaseNomina(String claseNomina);

    public TipoNomina findTipoNomina(String tipoNomina);

    public CalendarioProceso getCalendarioProceso(ParametroTO parametro);

    public boolean ejecutaProcedure(ParametroTO parametro);

    public List<CfdiRecibo> getRecibos(ParametroTO parametro);

    public List<String> obtenerRegistros(List<CfdiRecibo> registros, ParametroTO parametro);

    public GranTotalTO getGranTotal(List<CfdiRecibo> registros);

    public List<ClaseNomina> findAllClaseNomina();

    public List<TipoNomina> findAllTipoNomina();

    public List<String> getErrores();

    public boolean escribirArchivo(List<String> cadenas, ParametroTO parametro, String nombreEmpresa, String pathCarpetaTxt);

    public List<FacturaElectronicaTO> leerArchivos(Integer idCompania, String pathCarpetaTimbre, String pathCarpetaLogo);

    public void descargarArchivosPdfs(List<FacturaElectronicaTO> facturas, String pathCarpetaProcesados);
}
