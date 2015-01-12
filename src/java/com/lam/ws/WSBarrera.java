/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.ws;

import com.lam.dao.ProcesoFacadeLocal;
import com.lam.util.Parametros;
import com.lam.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author JoséAntonio
 */
@WebService(serviceName = "WSBarrera")
@Stateless()
public class WSBarrera {

    @EJB
    private com.lam.dao.ProcesoCfdiDao controlProcesoCfdi;
//  CENICCO
    @EJB(beanName = "controladorEmpleado")
    private ProcesoFacadeLocal controladorEmpleado;
    @EJB(beanName = "controladorRelacionLaboral")
    private ProcesoFacadeLocal controladorRelacionLaboral;
    @EJB(beanName = "controladorCatalogoGeneral")
    private ProcesoFacadeLocal controladorCatalogo;
    @EJB(beanName = "controladorPais")
    private ProcesoFacadeLocal controladorPaises;
    @EJB(beanName = "controladorEstado")
    private ProcesoFacadeLocal controladorEstados;
    @EJB(beanName = "controladorMunicipio")
    private ProcesoFacadeLocal controladorMunicipio;
    @EJB(beanName = "controladorCiudad")
    private ProcesoFacadeLocal controladorCiudad;
    @EJB(beanName = "controladorCompania")
    private ProcesoFacadeLocal controladorCompania;
    @EJB(beanName = "controladorRegistroPatronal")
    private ProcesoFacadeLocal controladorRegistroPatronal;
    @EJB(beanName = "controladorTipoRelacionLaboral")
    private ProcesoFacadeLocal controladorTipoRelacionLaboral;
    @EJB(beanName = "controladorGrupoPago")
    private ProcesoFacadeLocal controladorGrupoPago;
    @EJB(beanName = "controladorAsentamiento")
    private ProcesoFacadeLocal controladorAsentamiento;
    @EJB(beanName = "controladorDomicilio")
    private ProcesoFacadeLocal controladorDomicilio;
    @EJB(beanName = "controladorDocumento")
    private ProcesoFacadeLocal controladorDocumento;
    @EJB(beanName = "controladorTipoDocumento")
    private ProcesoFacadeLocal controladorTipoDocumento;
    @EJB(beanName = "controladorConcepto")
    private ProcesoFacadeLocal controladorConcepto;
    @EJB(beanName = "controladorGrupoConcepto")
    private ProcesoFacadeLocal controladorGrupoConcepto;
    @EJB(beanName = "controladorGrupoConcepto")
    private ProcesoFacadeLocal controladorCatalogoGrupoConcepto;
    @EJB(beanName = "controladorGrupoPension")
    private ProcesoFacadeLocal controladorCatalogoGrupoPension;
    @EJB(beanName = "controladorPension")
    private ProcesoFacadeLocal controladorPension;
    @EJB(beanName = "controladorBanco")
    private ProcesoFacadeLocal controladorBanco;
    @EJB(beanName = "controladorTipoContacto")
    private ProcesoFacadeLocal controladorTipoContacto;
    @EJB(beanName = "controladorContacto")
    private ProcesoFacadeLocal controladorContacto;
    @EJB(beanName = "controladorCuentaBancaria")
    private ProcesoFacadeLocal controladorCuentaBancaria;
    @EJB(beanName = "controladorTipoProceso")
    private ProcesoFacadeLocal controladorTipoProceso;
    @EJB(beanName = "controladorPeriodo")
    private ProcesoFacadeLocal controladorPeriodo;
    @EJB(beanName = "controladorRelacionLaboralPosicion")
    private ProcesoFacadeLocal controladorPosicionLaboral;
    @EJB(beanName = "controladorDepartamento")
    private ProcesoFacadeLocal controladorDepartamento;
    @EJB(beanName = "controladorPuesto")
    private ProcesoFacadeLocal controladorPuesto;
    @EJB(beanName = "controladorTurno")
    private ProcesoFacadeLocal controladorTurno;
    @EJB(beanName = "controladorTipoSueldo")
    private ProcesoFacadeLocal controladorTipoSueldo;
    @EJB(beanName = "controladorInfonavit")
    private ProcesoFacadeLocal controladorInfonavit;
    @EJB(beanName = "controladorEstructura")
    private ProcesoFacadeLocal controladorEstructura;
    @EJB(beanName = "controladorEstructuraDatos")
    private ProcesoFacadeLocal controladorEstructuraDatos;
    @EJB(beanName = "controladorEstructuraRelacion")
    private ProcesoFacadeLocal controladorEstructuraRelacion;
    @EJB(beanName = "controladorConceptoLista")
    private ProcesoFacadeLocal controladorEstructuraConceptoLista;
    @EJB(beanName = "controladorPosicionSueldo")
    private ProcesoFacadeLocal controladorPosicionSueldo;
    @EJB(beanName = "controladorPosicionSueldoHistorico")
    private ProcesoFacadeLocal controladorPosicionSueldoHistorico;
    @EJB(beanName = "controladorIncidencia")
    private ProcesoFacadeLocal controladorIncidencia;
    @EJB(beanName = "controladorCatalogoConcepto")
    private ProcesoFacadeLocal controladorCatalogoConcepto;
    @EJB(beanName = "controladorInfonavitHistorico")
    private ProcesoFacadeLocal controladorInfonavitHistorico;
    @EJB(beanName = "controladorSaldoVacaciones")
    private ProcesoFacadeLocal controladorSaldoVacaciones;
    @EJB(beanName = "controladorSolicitudVacaciones")
    private ProcesoFacadeLocal controladorSolicitudVacaciones;
    @EJB(beanName = "controladorSistemaAntiguedad")
    private ProcesoFacadeLocal controladorSistemaAntiguedad;
    @EJB(beanName = "controladorTabuladorSistemaAntiguedad")
    private ProcesoFacadeLocal controladorTabuladorSistemaAntiguedad;
    @EJB(beanName = "controladorColumnaTabulador")
    private ProcesoFacadeLocal controladorColumnaTabulador;
    @EJB(beanName = "controladorAdelantoVacaciones")
    private ProcesoFacadeLocal controladorAdelantoVacaciones;
    @EJB(beanName = "controladorAcumuladoConcepto")
    private ProcesoFacadeLocal controladorAcumuladoConcepto;
    @EJB(beanName = "controladorPoliza")
    private ProcesoFacadeLocal controladorPoliza;
    @EJB(beanName = "controladorLiquidacion")
    private ProcesoFacadeLocal controladorLiquidacion;
    @EJB(beanName = "controladorFormula")
    private ProcesoFacadeLocal controladorFormula;
//    
    private com.lam.dao.ProcesoDAO controlUsuarios;

    public WSBarrera() {
        if (this.controlUsuarios == null) {
            this.controlUsuarios = new com.lam.impl.cenicco.UsuarioImpl();
            this.controlUsuarios.findEntities();
        }
    }

    @PostConstruct
    public void init() {
        if (Parametros.MAPA_CATALOGO == null) {
            this.controladorCatalogo.findAll();
        }

    }

    @WebMethod(operationName = "findClaseNomina")
    public com.lam.entidades.ClaseNomina findClaseNomina(@WebParam(name = "claseNomina") String claseNomina) {
        return this.controlProcesoCfdi.findClaseNomina(claseNomina);
    }

    @WebMethod(operationName = "findTipoNomina")
    public com.lam.entidades.TipoNomina findTipoNomina(@WebParam(name = "tipoNomina") String tipoNomina) {
        return this.controlProcesoCfdi.findTipoNomina(tipoNomina);
    }

    @WebMethod(operationName = "getCalendarioProceso")
    public com.lam.entidades.CalendarioProceso getCalendarioProceso(@WebParam(name = "parametro") com.lam.to.ParametroTO parametro) {
        return this.controlProcesoCfdi.getCalendarioProceso(parametro);
    }

    @WebMethod(operationName = "ejecutaProcedure")
    public boolean ejecutaProcedure(@WebParam(name = "parametro") com.lam.to.ParametroTO parametro) {
        return this.controlProcesoCfdi.ejecutaProcedure(parametro);
    }

    @WebMethod(operationName = "getRecibos")
    public List<com.lam.entidades.CfdiRecibo> getRecibos(@WebParam(name = "parametro") com.lam.to.ParametroTO parametro) {
        return this.controlProcesoCfdi.getRecibos(parametro);
    }

    @WebMethod(operationName = "obtenerRegistros")
    public List<String> obtenerRegistros(@WebParam(name = "registros") List<com.lam.entidades.CfdiRecibo> registros, @WebParam(name = "parametro") com.lam.to.ParametroTO parametro) {
        return this.controlProcesoCfdi.obtenerRegistros(registros, parametro);
    }

    @WebMethod(operationName = "getGranTotal")
    public com.lam.to.GranTotalTO getGranTotal(@WebParam(name = "registros") List<com.lam.entidades.CfdiRecibo> registros) {
        return this.controlProcesoCfdi.getGranTotal(registros);
    }

    @WebMethod(operationName = "getGranTotalVacaciones")
    public com.lam.to.GranTotalSaldoTO getGranTotalVacaciones(@WebParam(name = "registros") List<com.lam.to.ResumenSaldoTO> registros) {
        return Util.getGranTotal(registros);
    }

    @WebMethod(operationName = "findAllClaseNomina")
    public List<com.lam.entidades.ClaseNomina> findAllClaseNomina() {
        return this.controlProcesoCfdi.findAllClaseNomina();
    }

    @WebMethod(operationName = "findAllTipoNomina")
    public List<com.lam.entidades.TipoNomina> findAllTipoNomina() {
        return this.controlProcesoCfdi.findAllTipoNomina();
    }

    @WebMethod(operationName = "getErrores")
    public List<String> getErrores() {
        return this.controlProcesoCfdi.getErrores();
    }

    @WebMethod(operationName = "escribirArchivo")
    public boolean escribirArchivo(@WebParam(name = "registros") List<String> cadenas, @WebParam(name = "parametro") com.lam.to.ParametroTO parametro,
            @WebParam(name = "nombreEmpresa") String nombreEmpresa, @WebParam(name = "pathCarpetaTxt") String pathCarpetaTxt) {
        return this.controlProcesoCfdi.escribirArchivo(cadenas, parametro, nombreEmpresa, pathCarpetaTxt);
    }

    @WebMethod(operationName = "convertirArchivos")
    public List<com.lam.to.FacturaElectronicaTO> convertirArchivos(@WebParam(name = "idCompania") Integer idCompania, @WebParam(name = "pathCarpetaTimbre") String pathCarpetaTimbre,
            @WebParam(name = "pathCarpetaLogo") String pathCarpetaLogo) {
        return this.controlProcesoCfdi.leerArchivos(idCompania, pathCarpetaTimbre, pathCarpetaLogo);
    }

    @WebMethod(operationName = "descargarPdfs")
    public void descargarArchivosPdfs(@WebParam(name = "facturas") List<com.lam.to.FacturaElectronicaTO> facturas, @WebParam(name = "pathCarpetaProcesados") String pathCarpetaProcesados) {
        this.controlProcesoCfdi.descargarArchivosPdfs(facturas, pathCarpetaProcesados);
    }

// MODULO RELACION LABORAL
    @WebMethod(operationName = "findRelacionesLaborales")
    public List<com.lam.entidades.servicio.RelacionLaboral> findRelacionesLaborales() {
        return this.controladorRelacionLaboral.findEntities();
    }

    @WebMethod(operationName = "getRelacionesLaborales")
    public List<com.lam.entidades.servicio.RelacionLaboral> getRelacionesLaborales(
            @WebParam(name = "expediente") String expediente, @WebParam(name = "rfc") String rfc, @WebParam(name = "idCompania") Integer idCompania,
            @WebParam(name = "idRegistroPatronal") Integer idRegistroPatronal, @WebParam(name = "estatus") String estatus,
            @WebParam(name = "fechaInicioAlta") Date fechaInicioAlta, @WebParam(name = "fechaFinAlta") Date fechaFinAlta,
            @WebParam(name = "fechaInicioBaja") Date fechaInicioBaja, @WebParam(name = "fechaFinBaja") Date fechaFinBaja) {
        return this.controladorRelacionLaboral.findEntities(expediente, rfc, idCompania, idRegistroPatronal,
                estatus, null, null, fechaInicioAlta, fechaFinAlta, fechaInicioBaja, fechaFinBaja);
    }

    @WebMethod(operationName = "getRelacionLaboralByExpediente")
    public com.lam.entidades.servicio.RelacionLaboral getRelacionLaboralByExpediente(@WebParam(name = "Expediente") String expediente) {
        return (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(expediente, null);
    }

    @WebMethod(operationName = "findRelacionLaboralById")
    public com.lam.entidades.servicio.RelacionLaboral findRelacionLaboralById(@WebParam(name = "IdRellab") Integer idRellab) {
        return (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRellab);
    }

    @WebMethod(operationName = "findEmpleadoByRfc")
    public com.lam.entidades.servicio.Empleado findEmpleadoByRfc(@WebParam(name = "RFC") String rfc) {
        return (com.lam.entidades.servicio.Empleado) this.controladorEmpleado.find(rfc, null);
    }

    @WebMethod(operationName = "createRelacionLaboral")
    public boolean createRelacionLaboral(@WebParam(name = "Expediente") String expediente, @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "ApellidoPaterno") String apellidoPaterno, @WebParam(name = "ApellidoMaterno") String apellidoMaterno,
            @WebParam(name = "IdEstado") Integer idEstado, @WebParam(name = "Ciudad") String ciudad, @WebParam(name = "Sexo") String sexo,
            @WebParam(name = "EstadoCivil") String estadoCivil, @WebParam(name = "rfc") String rfc, @WebParam(name = "curp") String curp,
            @WebParam(name = "Afiliacion") String afiliacion, @WebParam(name = "FechaNacimiento") Date fechaNacimiento,
            @WebParam(name = "isValidate") boolean isValidate) {
//        
        com.lam.entidades.servicio.Empleado emp = (com.lam.entidades.servicio.Empleado) this.controladorEmpleado.find(rfc, null);

        if (emp == null) {
            com.lam.entidades.servicio.Estado estado = (com.lam.entidades.servicio.Estado) this.controladorEstados.find(idEstado);
            emp = new com.lam.entidades.servicio.Empleado();
//            
            emp.setExpediente(expediente);
            emp.setNombre(nombre);
            emp.setApellidopaterno(apellidoPaterno);
            emp.setApellidomaterno(apellidoMaterno);
            emp.setIdestadonacimiento(estado);
            emp.setLugarnacimiento(ciudad);
            emp.setSexo(sexo);
            emp.setEstadocivil(estadoCivil);
            emp.setRfc(rfc);
            emp.setCurp(curp);
            emp.setFechanacimiento(fechaNacimiento);
            emp.setAfiliacion(afiliacion);
            isValidate = this.controladorEmpleado.create(emp);
        }
//        
        if (!isValidate) {
            return false;
        }

        com.lam.entidades.servicio.RelacionLaboral relacionLaboral = new com.lam.entidades.servicio.RelacionLaboral();
//        
        relacionLaboral.setIdempleado(emp);
        relacionLaboral.setFechaingreso(new Date());
//        
        return this.controladorRelacionLaboral.create(relacionLaboral);
    }
//

    @WebMethod(operationName = "editRelacionLaboral")
    public boolean editRelacionLaboral(@WebParam(name = "IdRelacionLaboral") Integer idRelacionLaboral,
            @WebParam(name = "IdTipoRelLab") Integer idTipoRellab, @WebParam(name = "IdSistemaAntiguedad") Integer idsSistemaAntiguedad,
            @WebParam(name = "IdCompania") Integer idCompania, @WebParam(name = "IdRegistroPatronal") Integer idRegistroPatronal,
            @WebParam(name = "IdGrupoPago") Integer idGrupoPago, @WebParam(name = "FechaIngreso") Date fechaIngreso,
            @WebParam(name = "NumeroEmpleado") String numeroEmpleado, @WebParam(name = "FechaAntiguedad1") Date fechaAntiguedad1,
            @WebParam(name = "FechaAntiguedad2") Date fechaAntiguedad2, @WebParam(name = "FechaAntiguedad3") Date fechaAntiguedad3,
            @WebParam(name = "TipoContrato") String tipoContrato, @WebParam(name = "Estatus") String estatus,
            @WebParam(name = "FechaInicioContrato") Date fechaInicioContrato, @WebParam(name = "FechaVencimiento") Date FechaVencimiento,
            @WebParam(name = "Duracion") Integer duracion, @WebParam(name = "CausaBajaImss") String causaBajaImss,
            @WebParam(name = "CausaBajaEmpresa") String causaBajaEmpresa, @WebParam(name = "FechaBaja") Date fechaBaja) {

        com.lam.entidades.servicio.RelacionLaboral rl = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRelacionLaboral);
        com.lam.entidades.servicio.TipoRelacionLaboral tipoRel = (com.lam.entidades.servicio.TipoRelacionLaboral) this.controladorTipoRelacionLaboral.find(idTipoRellab);
        com.lam.entidades.servicio.RegistroPatronal resgitroPatronal = (com.lam.entidades.servicio.RegistroPatronal) this.controladorRegistroPatronal.find(idRegistroPatronal);
        com.lam.entidades.servicio.Compania compania = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
        com.lam.entidades.servicio.GrupoPago grupoPago = (com.lam.entidades.servicio.GrupoPago) this.controladorGrupoPago.find(idGrupoPago);
        com.lam.entidades.servicio.SistemaAntiguedad sistemaAntiguedad = (com.lam.entidades.servicio.SistemaAntiguedad) this.controladorSistemaAntiguedad.find(idsSistemaAntiguedad);
//        
        rl.setIdtiporellab(tipoRel);
        rl.setIdregistropatronal(resgitroPatronal);
        rl.setIdcompania(compania);
        rl.setIdgrupopago(grupoPago);
        rl.setIdsistemaantiguedad(sistemaAntiguedad);
//        
        rl.setFechaingreso(fechaIngreso);
        rl.setNumeroempleado(numeroEmpleado);
        rl.setFechaantiguedad1(fechaAntiguedad1);
        rl.setFechaantiguedad2(fechaAntiguedad2);
        rl.setFechaantiguedad3(fechaAntiguedad3);
//        
        rl.setTipocontrato(tipoContrato);
        rl.setEstatus(estatus);
        rl.setFechainiciocontrato(fechaInicioContrato);
        rl.setFechaeventocontrato(FechaVencimiento);
        rl.setDuracion(duracion);
        rl.setCausabajaimss(causaBajaImss);
        rl.setCausabaja(causaBajaEmpresa);
        rl.setFechabaja(fechaBaja);
//        
        return this.controladorRelacionLaboral.edit(rl);
    }

    @WebMethod(operationName = "editEmpleado")
    public boolean editEmpleado(@WebParam(name = "IdEmpleado") Integer idEmpleado, @WebParam(name = "Expediente") String expediente,
            @WebParam(name = "Nombre") String nombre, @WebParam(name = "ApellidoPaterno") String apellidoPaterno,
            @WebParam(name = "ApellidoMaterno") String apellidoMaterno, @WebParam(name = "IdEstado") Integer idEstado,
            @WebParam(name = "Ciudad") String ciudad, @WebParam(name = "Sexo") String sexo, @WebParam(name = "EstadoCivil") String estadoCivil,
            @WebParam(name = "rfc") String rfc, @WebParam(name = "curp") String curp, @WebParam(name = "Afiliacion") String afiliacion,
            @WebParam(name = "Status") String status, @WebParam(name = "FechaNacimiietno") Date fechaNacimiento) {
//        
        com.lam.entidades.servicio.Estado estado = (com.lam.entidades.servicio.Estado) this.controladorEstados.find(idEstado);
        com.lam.entidades.servicio.Empleado emp = (com.lam.entidades.servicio.Empleado) this.controladorEmpleado.find(idEmpleado);
//        
        emp.setExpediente(expediente);
        emp.setNombre(nombre);
        emp.setApellidopaterno(apellidoPaterno);
        emp.setApellidomaterno(apellidoMaterno);
        emp.setIdestadonacimiento(estado);
        emp.setLugarnacimiento(ciudad);
        emp.setSexo(sexo);
        emp.setEstadocivil(estadoCivil);
        emp.setRfc(rfc);
        emp.setCurp(curp);
        emp.setAfiliacion(afiliacion);
        emp.setEstatus(status);
        emp.setFechanacimiento(fechaNacimiento);
//        
        return this.controladorEmpleado.edit(emp);
    }
//    

    @WebMethod(operationName = "getTiposRelacionesLaborales")
    public List<com.lam.entidades.servicio.TipoRelacionLaboral> getTiposRelacionesLaborales() {
        return this.controladorTipoRelacionLaboral.findEntities();
    }

    @WebMethod(operationName = "findTiposRelacionesLaborales")
    public List<com.lam.entidades.servicio.TipoRelacionLaboral> findTiposRelacionesLaborales(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoRelacionLaboral tipoRelLab = new com.lam.entidades.servicio.TipoRelacionLaboral();
        tipoRelLab.setNombre(nombre);
        return this.controladorTipoRelacionLaboral.findEntities(tipoRelLab);
    }

    @WebMethod(operationName = "findTipoRelacionLaboralByTipoRelacionLaboral")
    public com.lam.entidades.servicio.TipoRelacionLaboral findTipoRelacionLaboralByTipoRelacionLaboral(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoRelacionLaboral tipoRelLab = new com.lam.entidades.servicio.TipoRelacionLaboral();
        tipoRelLab.setNombre(nombre);
        return (com.lam.entidades.servicio.TipoRelacionLaboral) this.controladorTipoRelacionLaboral.find(tipoRelLab);
    }

    @WebMethod(operationName = "createTipoRelacionLaboral")
    public boolean createTipoRelacionLaboral(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoRelacionLaboral tipoRelLab = new com.lam.entidades.servicio.TipoRelacionLaboral();
        tipoRelLab.setNombre(nombre);
        return this.controladorTipoRelacionLaboral.create(tipoRelLab);
    }

    @WebMethod(operationName = "editTipoRelacionLaboral")
    public boolean editTipoRelacionLaboral(@WebParam(name = "IdTipoRelacionLaboral") Integer idTipoRelacionLaboral,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoRelacionLaboral tipoRelLab = (com.lam.entidades.servicio.TipoRelacionLaboral) this.controladorTipoRelacionLaboral.find(idTipoRelacionLaboral);
        tipoRelLab.setNombre(nombre);
        return this.controladorTipoRelacionLaboral.edit(tipoRelLab);
    }

//
    @WebMethod(operationName = "getCatalogoByParametros")
    public List<com.lam.entidades.servicio.CatalogoGeneral> getCatalogo(@WebParam(name = "tabla") String tabla, @WebParam(name = "columna") String columna) {
        return this.controladorCatalogo.findEntities(tabla, columna, null, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "getCompanias")
    public List<com.lam.entidades.servicio.Compania> getCompanias() {
        return this.controladorCompania.findEntities();
    }

    @WebMethod(operationName = "getAsentamientos")
    public List<com.lam.entidades.servicio.Asentamiento> getAsentamientos(@WebParam(name = "codigoPostal") String codigoPostal) {
        return this.controladorAsentamiento.findEntities(codigoPostal, null, null, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "getDomicilios")
    public List<com.lam.entidades.servicio.Domicilio> getDomicilios(@WebParam(name = "idEmpleado") Integer idEmpleado) {
        return this.controladorDomicilio.findEntities(null, null, idEmpleado, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "getDocumentos")
    public List<com.lam.entidades.servicio.Documento> getDocumentos(@WebParam(name = "idEmpleado") Integer idEmpleado) {
        return this.controladorDocumento.findEntities(null, null, idEmpleado, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "getTipoDocumentos")
    public List<com.lam.entidades.servicio.TipoDocumento> getTipoDocumentos() {
        return this.controladorTipoDocumento.findEntities();
    }
//  MODULO DE CONCEPTOS

    @WebMethod(operationName = "findConceptos")
    public List<com.lam.entidades.servicio.Concepto> findConceptos(@WebParam(name = "Concepto") String concepto, @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "TipoConcepto") String tipoConcepto, @WebParam(name = "Unidad") String unidad) {
        com.lam.entidades.servicio.Concepto c = new com.lam.entidades.servicio.Concepto();
        c.setConcepto(concepto);
        c.setNombre(nombre);
        c.setUnidad(unidad);
        c.setTipoconcepto(tipoConcepto);

        return this.controladorConcepto.findEntities(c);
    }

    @WebMethod(operationName = "findConceptoByConcepto")
    public com.lam.entidades.servicio.Concepto findConceptoByConcepto(@WebParam(name = "Concepto") String concepto) {
        com.lam.entidades.servicio.Concepto c = new com.lam.entidades.servicio.Concepto();
        c.setConcepto(concepto);
        return (com.lam.entidades.servicio.Concepto) this.controladorConcepto.find(c);
    }

    @WebMethod(operationName = "getConceptos")
    public List<com.lam.entidades.servicio.Concepto> getConceptos() {
        return this.controladorConcepto.findEntities();
    }

    @WebMethod(operationName = "getConceptosByIds")
    public List<com.lam.entidades.servicio.Concepto> getConceptosByIds(@WebParam(name = "Ids") List<Integer> ids) {
        return this.controladorConcepto.findEntities(ids);
    }

    @WebMethod(operationName = "getConceptosByGrupo")
    public List<com.lam.entidades.servicio.Concepto> getConceptosByGrupo(List<Integer> catalogo) {
        return this.controladorConcepto.findEntities();
    }

    @WebMethod(operationName = "createConcepto")
    public boolean createConcepto(@WebParam(name = "Concepto") String concepto, @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "TipoConcepto") String tipoConcepto, @WebParam(name = "Unidad") String unidad) {
        com.lam.entidades.servicio.Concepto c = new com.lam.entidades.servicio.Concepto();
        c.setConcepto(concepto);
        c.setNombre(nombre);
        c.setUnidad(unidad);
        c.setTipoconcepto(tipoConcepto);
        return this.controladorConcepto.create(c);

    }

    @WebMethod(operationName = "editConcepto")
    public boolean editConcepto(@WebParam(name = "IdConcepto") Integer idConcepto, @WebParam(name = "Concepto") String concepto, @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "TipoConcepto") String tipoConcepto, @WebParam(name = "Unidad") String unidad) {
        com.lam.entidades.servicio.Concepto c = (com.lam.entidades.servicio.Concepto) this.controladorConcepto.find(idConcepto);
        c.setConcepto(concepto);
        c.setNombre(nombre);
        c.setUnidad(unidad);
        c.setTipoconcepto(tipoConcepto);
        return this.controladorConcepto.edit(c);
    }
//  MODULO DE CATALOGO GENERAL

    @WebMethod(operationName = "getCatalogoGeneral")
    public List<com.lam.entidades.servicio.CatalogoGeneral> getCatalogoGeneral() {
        return controladorCatalogo.findEntities();
    }

    @WebMethod(operationName = "findCatalogoGeneral")
    public List<com.lam.entidades.servicio.CatalogoGeneral> findCatalogoGeneral(@WebParam(name = "Columna") String columna, @WebParam(name = "Nombre") String nombre, @WebParam(name = "Tabla") String tabla,
            @WebParam(name = "Valor") String valor) {
        com.lam.entidades.servicio.CatalogoGeneral catG = new com.lam.entidades.servicio.CatalogoGeneral();
        catG.setColumna(columna);
        catG.setNombre(nombre);
        catG.setTabla(tabla);
        catG.setValor(valor);
        return controladorCatalogo.findEntities(catG);
    }

    @WebMethod(operationName = "findCatalogoGeneralByNombreTablaColumna")
    public com.lam.entidades.servicio.CatalogoGeneral findCatalogoGeneralByNombreTablaColumna(@WebParam(name = "Columna") String columna, @WebParam(name = "Nombre") String nombre, @WebParam(name = "Tabla") String tabla) {
        com.lam.entidades.servicio.CatalogoGeneral catalogo = new com.lam.entidades.servicio.CatalogoGeneral();
        catalogo.setColumna(columna);
        catalogo.setNombre(nombre);
        catalogo.setTabla(tabla);
        return (com.lam.entidades.servicio.CatalogoGeneral) controladorCatalogo.find(catalogo);
    }

    @WebMethod(operationName = "createCatalogoGeneral")
    public boolean createCatalogoGeneral(@WebParam(name = "Columna") String columna, @WebParam(name = "Nombre") String nombre, @WebParam(name = "Tabla") String tabla,
            @WebParam(name = "Valor") String valor) {
        com.lam.entidades.servicio.CatalogoGeneral catG = new com.lam.entidades.servicio.CatalogoGeneral();
        catG.setColumna(columna);
        catG.setNombre(nombre);
        catG.setTabla(tabla);
        catG.setValor(valor);
        return controladorCatalogo.create(catG);
    }

    @WebMethod(operationName = "editCatalogoGeneral")
    public boolean editCatalogoGeneral(@WebParam(name = "IdCatalogoGeneral") Integer idCatalogoGeneral, @WebParam(name = "Columna") String columna, @WebParam(name = "Nombre") String nombre, @WebParam(name = "Tabla") String tabla,
            @WebParam(name = "Valor") String valor) {
        com.lam.entidades.servicio.CatalogoGeneral catG = (com.lam.entidades.servicio.CatalogoGeneral) this.controladorCatalogo.find(idCatalogoGeneral);
        catG.setColumna(columna);
        catG.setNombre(nombre);
        catG.setTabla(tabla);
        catG.setValor(valor);
        return controladorCatalogo.create(catG);
    }
//  MODULO CATALOGO GRUPO CONCEPTOS

    @WebMethod(operationName = "findCatGrupoByIdGrupo")
    public List<com.lam.entidades.servicio.CatalogoGrupoConcepto> findCatGrupoByIdGrupo(@WebParam(name = "IdGrupoConcepto") Integer id) {
        return this.controladorCatalogoGrupoConcepto.findEntities(null, null, id, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findGruposConceptos")
    public List<com.lam.entidades.servicio.GrupoConcepto> findGruposConceptos(@WebParam(name = "GrupoConcepto") String grupo, @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.GrupoConcepto grupoConcepto = new com.lam.entidades.servicio.GrupoConcepto();
        grupoConcepto.setNombre(nombre);
        grupoConcepto.setGrupoconcepto(grupo);
        return controladorGrupoConcepto.findEntities(grupoConcepto);
    }

//
    @WebMethod(operationName = "findGrupoConceptoByGrupoConcepto")
    public com.lam.entidades.servicio.GrupoConcepto findGrupoConceptoByGrupoConcepto(@WebParam(name = "GrupoConcepto") String grupo) {
        com.lam.entidades.servicio.GrupoConcepto grupoConcepto = new com.lam.entidades.servicio.GrupoConcepto();
        grupoConcepto.setGrupoconcepto(grupo);
        return (com.lam.entidades.servicio.GrupoConcepto) this.controladorGrupoConcepto.find(grupoConcepto);
    }

    @WebMethod(operationName = "addCatalogoGrupoConcepto")
    public boolean addCatalogoGrupoConcepto(@WebParam(name = "IdGrupoConcepto") Integer idGrupoConcepto, @WebParam(name = "IdConcepto") Integer idConcepto,
            @WebParam(name = "Signo") String signo) {
//        
        com.lam.entidades.servicio.GrupoConcepto grupoConcepto = (com.lam.entidades.servicio.GrupoConcepto) this.controladorGrupoConcepto.find(idGrupoConcepto);
        com.lam.entidades.servicio.Concepto concepto = (com.lam.entidades.servicio.Concepto) this.controladorConcepto.find(idConcepto);
        com.lam.entidades.servicio.CatalogoGrupoConcepto cat = new com.lam.entidades.servicio.CatalogoGrupoConcepto();
//        
        cat.setIdconcepto(concepto);
        cat.setIdgrupoconcepto(grupoConcepto);
        cat.setSigno(signo);
        return this.controladorCatalogoGrupoConcepto.create(cat);

    }

    @WebMethod(operationName = "editCatalogoGrupoConcepto")
    public boolean editCatalogoGrupoConcepto(@WebParam(name = "IdCatalogoGrupo") Integer idCatalogoGrupo, @WebParam(name = "Signo") String signo) {
        com.lam.entidades.servicio.CatalogoGrupoConcepto cat = (com.lam.entidades.servicio.CatalogoGrupoConcepto) this.controladorCatalogoGrupoConcepto.find(idCatalogoGrupo);
        cat.setSigno(signo);
        return this.controladorCatalogoGrupoConcepto.edit(cat);
    }

    @WebMethod(operationName = "deleteCatalogoGrupoConcepto")
    public boolean deleteCatalogoGrupoConcepto(@WebParam(name = "IdCatalogoGrupo") Integer idCatalogoGrupo) {
        com.lam.entidades.servicio.CatalogoGrupoConcepto gc = (com.lam.entidades.servicio.CatalogoGrupoConcepto) this.controladorCatalogoGrupoConcepto.find(idCatalogoGrupo);
        return this.controladorCatalogoGrupoConcepto.destroy(gc);
    }

    @WebMethod(operationName = "createGrupoConcepto")
    public boolean createGrupoConcepto(@WebParam(name = "GrupoConcepto") String grupo, @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Conceptos") List<com.lam.entidades.servicio.Concepto> conceptos) {
        com.lam.entidades.servicio.GrupoConcepto grupoConcepto = new com.lam.entidades.servicio.GrupoConcepto();
        grupoConcepto.setGrupoconcepto(grupo);
        grupoConcepto.setNombre(nombre);
        grupoConcepto.setFecha(new Date());
        boolean isValidate = this.controladorGrupoConcepto.create(grupoConcepto);
        if (!isValidate) {
            return false;
        }
//        
        grupoConcepto = (com.lam.entidades.servicio.GrupoConcepto) this.controladorGrupoConcepto.find(grupoConcepto);
//        
        for (com.lam.entidades.servicio.Concepto c : conceptos) {
            com.lam.entidades.servicio.CatalogoGrupoConcepto catalogo = new com.lam.entidades.servicio.CatalogoGrupoConcepto();
            catalogo.setIdconcepto(c);
            catalogo.setSigno(c.getSigno());
            catalogo.setIdgrupoconcepto(grupoConcepto);
            if (!this.controladorCatalogoGrupoConcepto.create(catalogo)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    @WebMethod(operationName = "editGrupoConcepto")
    public boolean editGrupoConcepto(@WebParam(name = "IdGrupoConcepto") Integer idGrupoConcepto, @WebParam(name = "GrupoConcepto") String grupoConcepto,
            @WebParam(name = "nombre") String nombre) {
        com.lam.entidades.servicio.GrupoConcepto gc = (com.lam.entidades.servicio.GrupoConcepto) this.controladorGrupoConcepto.find(idGrupoConcepto);
        gc.setGrupoconcepto(grupoConcepto);
        gc.setNombre(nombre);
        return this.controladorGrupoConcepto.edit(gc);
    }
//    
//MODULO PENSIONES

    @WebMethod(operationName = "findPensionByIdRellab")
    public List<com.lam.entidades.servicio.Pension> findPensionByIdRellab(@WebParam(name = "IdRellab") Integer IdRellab) {
        return this.controladorPension.findEntities(IdRellab);
    }

    @WebMethod(operationName = "deletePension")
    public boolean deletePension(@WebParam(name = "IdPension") Integer idPension) {
        com.lam.entidades.servicio.Pension pension = (com.lam.entidades.servicio.Pension) this.controladorPension.find(idPension);
        return this.controladorPension.destroy(pension);
    }

    @WebMethod(operationName = "findGruposPensiones")
    public List<com.lam.entidades.servicio.Pension> findGruposPensiones(@WebParam(name = "Oficio") String oficio,
            @WebParam(name = "Cuenta") String cuenta, @WebParam(name = "ApellidoPaterno") String apellidoPaterno,
            @WebParam(name = "ApellidoMaterno") String apellidoMaterno, @WebParam(name = "nombre") String nombre) {
        com.lam.entidades.servicio.Pension pension = new com.lam.entidades.servicio.Pension();
        pension.setOficio(oficio);
        pension.setCuenta(cuenta);
        pension.setApellidopaterno(apellidoPaterno);
        pension.setApellidomaterno(apellidoMaterno);
        pension.setNombre(nombre);
        return this.controladorPension.findEntities(pension);
    }

    @WebMethod(operationName = "createPension")
    public boolean createPension(@WebParam(name = "IdRelacionLaboral") Integer idRelacionLaboral, @WebParam(name = "IdBanco") Integer idBanco,
            @WebParam(name = "ApellidoPaterno") String apellidoPaterno, @WebParam(name = "ApellidoMaterno") String apellidoMaterno,
            @WebParam(name = "Nombre") String nombre, @WebParam(name = "TipoCalculo") String tipoCalculo,
            @WebParam(name = "Cantidad") Double cantidad, @WebParam(name = "Oficio") String oficio, @WebParam(name = "Juez") String juez,
            @WebParam(name = "FormaPago") String formaPago, @WebParam(name = "Cuenta") String cuenta, @WebParam(name = "Clabe") String clabe,
            @WebParam(name = "Conceptos") List<com.lam.entidades.servicio.Concepto> conceptos) {
        com.lam.entidades.servicio.Pension pension = new com.lam.entidades.servicio.Pension();
        com.lam.entidades.servicio.RelacionLaboral rellab = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRelacionLaboral);
        com.lam.entidades.servicio.Banco banco = (com.lam.entidades.servicio.Banco) this.controladorBanco.find(idBanco);
        pension.setIdrellab(rellab);
        pension.setIdbanco(banco);
        pension.setApellidopaterno(apellidoPaterno);
        pension.setApellidomaterno(apellidoMaterno);
        pension.setNombre(nombre);
        pension.setTipocalculo(tipoCalculo);
        pension.setCantidad(cantidad);
        pension.setOficio(oficio);
        pension.setJuez(juez);
        pension.setFormadepago(formaPago);
        pension.setCuenta(cuenta);
        pension.setClabe(clabe);
        pension.setFecha(new Date());
//        
        boolean isValidate = this.controladorPension.create(pension);
//        
        if (!isValidate) {
            return false;
        }
//
        pension = (com.lam.entidades.servicio.Pension) this.controladorPension.find(pension);
//
        for (com.lam.entidades.servicio.Concepto c : conceptos) {
            com.lam.entidades.servicio.CatalogoGrupoPension catalogo = new com.lam.entidades.servicio.CatalogoGrupoPension();
            catalogo.setIdconcepto(c);
            catalogo.setSigno(c.getSigno());
            catalogo.setIdpension(pension);
            if (!this.controladorCatalogoGrupoPension.create(catalogo)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    @WebMethod(operationName = "findPensionByIdGrupo")
    public List<com.lam.entidades.servicio.CatalogoGrupoPension> findPensionByIdGrupo(@WebParam(name = "IdPension") Integer id) {
        return this.controladorCatalogoGrupoPension.findEntities(null, null, id, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "editPension")
    public boolean editPension(@WebParam(name = "IdPension") Integer idPension, @WebParam(name = "IdRelacionLaboral") Integer idRelacionLaboral, @WebParam(name = "IdBanco") Integer idBanco,
            @WebParam(name = "ApellidoPaterno") String apellidoPaterno, @WebParam(name = "ApellidoMaterno") String apellidoMaterno,
            @WebParam(name = "Nombre") String nombre, @WebParam(name = "TipoCalculo") String tipoCalculo,
            @WebParam(name = "Cantidad") Double cantidad, @WebParam(name = "Oficio") String oficio, @WebParam(name = "Juez") String juez,
            @WebParam(name = "FormaPago") String formaPago, @WebParam(name = "Cuenta") String cuenta, @WebParam(name = "Clabe") String clabe) {
        com.lam.entidades.servicio.RelacionLaboral rellab = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRelacionLaboral);
        com.lam.entidades.servicio.Banco banco = (com.lam.entidades.servicio.Banco) this.controladorBanco.find(idBanco);
        com.lam.entidades.servicio.Pension pension = (com.lam.entidades.servicio.Pension) this.controladorPension.find(idPension);
        pension.setIdrellab(rellab);
        pension.setIdbanco(banco);
        pension.setApellidopaterno(apellidoPaterno);
        pension.setApellidomaterno(apellidoMaterno);
        pension.setNombre(nombre);
        pension.setTipocalculo(tipoCalculo);
        pension.setCantidad(cantidad);
        pension.setOficio(oficio);
        pension.setJuez(juez);
        pension.setFormadepago(formaPago);
        pension.setCuenta(cuenta);
        pension.setClabe(clabe);
        pension.setFecha(new Date());
//        
        return this.controladorPension.edit(pension);
    }

    @WebMethod(operationName = "editCatalogoGrupoPension")
    public boolean editCatalogoGrupoPension(@WebParam(name = "IdCatalogoPension") Integer idCatalogopension, @WebParam(name = "Signo") String signo) {
        System.out.println("IdCatalogoGrupoPension: " + idCatalogopension);
        com.lam.entidades.servicio.CatalogoGrupoPension cat = (com.lam.entidades.servicio.CatalogoGrupoPension) this.controladorCatalogoGrupoPension.find(idCatalogopension);
        cat.setSigno(signo);
        return this.controladorCatalogoGrupoPension.edit(cat);
    }

    @WebMethod(operationName = "findPensionConceptosByIdPension")
    public List<com.lam.entidades.servicio.CatalogoGrupoPension> findPensionConceptosByIdPension(@WebParam(name = "IdPension") Integer idPension) {
        return this.controladorCatalogoGrupoPension.findEntities(idPension);
    }
//    

    @WebMethod(operationName = "deleteCatalogoGrupoPension")
    public boolean deleteCatalogoGrupoPension(@WebParam(name = "IdCatalogoGrupo") Integer idCatalogoGrupo) {
        com.lam.entidades.servicio.CatalogoGrupoPension gp = (com.lam.entidades.servicio.CatalogoGrupoPension) this.controladorCatalogoGrupoPension.find(idCatalogoGrupo);
        return this.controladorCatalogoGrupoPension.destroy(gp);
    }

    @WebMethod(operationName = "addCatalogoGrupoPension")
    public boolean addCatalogoGrupoPension(@WebParam(name = "IdPension") Integer idPension, @WebParam(name = "IdConcepto") Integer idConcepto,
            @WebParam(name = "Signo") String signo) {
//        
        com.lam.entidades.servicio.Pension pension = (com.lam.entidades.servicio.Pension) this.controladorPension.find(idPension);
        com.lam.entidades.servicio.Concepto concepto = (com.lam.entidades.servicio.Concepto) this.controladorConcepto.find(idConcepto);
        com.lam.entidades.servicio.CatalogoGrupoPension cat = new com.lam.entidades.servicio.CatalogoGrupoPension();
//        
        cat.setIdconcepto(concepto);
        cat.setIdpension(pension);
        cat.setSigno(signo);
        return this.controladorCatalogoGrupoPension.create(cat);

    }

// MODULO PAISES
    @WebMethod(operationName = "getPaises")
    public List<com.lam.entidades.servicio.Pais> getPaises() {
        return this.controladorPaises.findEntities();
    }

    @WebMethod(operationName = "findPaises")
    public List<com.lam.entidades.servicio.Pais> findPaises(@WebParam(name = "Pais") String pais,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Pais p = new com.lam.entidades.servicio.Pais();
        p.setPais(pais);
        p.setNombre(nombre);
        return this.controladorPaises.findEntities(p);
    }

    @WebMethod(operationName = "findPaisByPais")
    public com.lam.entidades.servicio.Pais findPaisByPais(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Pais p = new com.lam.entidades.servicio.Pais();
        p.setNombre(nombre);
        return (com.lam.entidades.servicio.Pais) this.controladorPaises.find(p);
    }

    @WebMethod(operationName = "createPais")
    public boolean createPais(@WebParam(name = "Pais") String pais,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Pais p = new com.lam.entidades.servicio.Pais();
        p.setPais(pais);
        p.setNombre(nombre);
        return this.controladorPaises.create(p);
    }

    @WebMethod(operationName = "editPais")
    public boolean editPais(@WebParam(name = "IdPais") Integer idPais,
            @WebParam(name = "Pais") String pais,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Pais p = (com.lam.entidades.servicio.Pais) this.controladorPaises.find(idPais);
        p.setPais(pais);
        p.setNombre(nombre);
        return this.controladorPaises.edit(p);
    }
//    MODULO ESTADOS

    @WebMethod(operationName = "getEstados")
    public List<com.lam.entidades.servicio.Estado> getEstados() {
        return this.controladorEstados.findEntities();
    }

    @WebMethod(operationName = "findEstados")
    public List<com.lam.entidades.servicio.Estado> findEstados(@WebParam(name = "IdPais") Integer idPais,
            @WebParam(name = "Nombre") String nombre) {
        return this.controladorEstados.findEntities(nombre, null, idPais, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findEstadosByIdPais")
    public List<com.lam.entidades.servicio.Estado> findEstadosByIdPais(@WebParam(name = "IdPais") Integer idPais) {
        return this.controladorEstados.findEntities(idPais);
    }

    @WebMethod(operationName = "findEstadoByEstado")
    public com.lam.entidades.servicio.Estado findEstadoByEstado(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Estado e = new com.lam.entidades.servicio.Estado();
        e.setNombre(nombre);
        return (com.lam.entidades.servicio.Estado) this.controladorEstados.find(e);
    }

    @WebMethod(operationName = "createEstado")
    public boolean createEstado(@WebParam(name = "IdPais") Integer idPais,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Estado e = new com.lam.entidades.servicio.Estado();
        com.lam.entidades.servicio.Pais p = (com.lam.entidades.servicio.Pais) this.controladorPaises.find(idPais);
        e.setIdpais(p);
        e.setNombre(nombre);
        return this.controladorEstados.create(e);
    }

    @WebMethod(operationName = "editEstado")
    public boolean editEstado(@WebParam(name = "IdEstado") Integer idEstado,
            @WebParam(name = "IdPais") Integer idPais,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Estado e = (com.lam.entidades.servicio.Estado) this.controladorEstados.find(idEstado);
        com.lam.entidades.servicio.Pais p = (com.lam.entidades.servicio.Pais) this.controladorPaises.find(idPais);
        e.setIdpais(p);
        e.setNombre(nombre);
        return this.controladorEstados.edit(e);
    }
//   MODULO MUNICIPIOS 

    @WebMethod(operationName = "getMunicipios")
    public List<com.lam.entidades.servicio.Municipio> getMunicipios() {
        return this.controladorMunicipio.findEntities();
    }

    @WebMethod(operationName = "findMunicipios")
    public List<com.lam.entidades.servicio.Municipio> findMunicipios(@WebParam(name = "IdPais") Integer idPais,
            @WebParam(name = "IdEstado") Integer idEstado,
            @WebParam(name = "Nombre") String nombre) {
        return this.controladorMunicipio.findEntities(nombre, null, idPais, idEstado, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findMunicipioByIdEstado")
    public List<com.lam.entidades.servicio.Municipio> findMunicipioByIdEstado(@WebParam(name = "IdEstado") Integer idEstado) {
        return this.controladorMunicipio.findEntities(idEstado);
    }

    @WebMethod(operationName = "findMuncipioByMunicipio")
    public com.lam.entidades.servicio.Municipio findMuncipioByMunicipio(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Municipio m = new com.lam.entidades.servicio.Municipio();
        m.setNombre(nombre);
        return (com.lam.entidades.servicio.Municipio) this.controladorMunicipio.find(m);
    }

    @WebMethod(operationName = "createMunicipio")
    public boolean createMunicipio(@WebParam(name = "IdEstado") Integer idEstado,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Municipio m = new com.lam.entidades.servicio.Municipio();
        com.lam.entidades.servicio.Estado e = (com.lam.entidades.servicio.Estado) this.controladorEstados.find(idEstado);
        m.setIdestado(e);
        m.setNombre(nombre);
        return this.controladorMunicipio.create(m);
    }

    @WebMethod(operationName = "editMunicipio")
    public boolean editMunicipio(@WebParam(name = "IdMunicipio") Integer idMunicipio,
            @WebParam(name = "IdEstado") Integer idEstado,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Municipio m = (com.lam.entidades.servicio.Municipio) this.controladorMunicipio.find(idMunicipio);
        com.lam.entidades.servicio.Estado e = (com.lam.entidades.servicio.Estado) this.controladorEstados.find(idEstado);
        m.setIdestado(e);
        m.setNombre(nombre);
        return this.controladorMunicipio.edit(m);
    }
//    MODULO CIUDADES

    @WebMethod(operationName = "getCiudades")
    public List<com.lam.entidades.servicio.Ciudad> getCiudades() {
        return this.controladorCiudad.findEntities();
    }

    @WebMethod(operationName = "findCiduades")
    public List<com.lam.entidades.servicio.Ciudad> findCiudades(@WebParam(name = "IdPais") Integer idPais, @WebParam(name = "IdEstado") Integer idEstado,
            @WebParam(name = "IdMunicipio") Integer idMunicipio, @WebParam(name = "Nombre") String nombre) {
        String id = idMunicipio != null ? idMunicipio.toString() : null;
        return this.controladorCiudad.findEntities(nombre, null, idPais, idEstado, id, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findCiudadByCiudad")
    public com.lam.entidades.servicio.Ciudad findCiudadByCiudad(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Ciudad c = new com.lam.entidades.servicio.Ciudad();
        c.setNombre(nombre);
        return (com.lam.entidades.servicio.Ciudad) this.controladorCiudad.find(c);
    }

    @WebMethod(operationName = "createCiudad")
    public boolean createCiudad(@WebParam(name = "IdMunicipio") Integer idMunicipio,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Ciudad c = new com.lam.entidades.servicio.Ciudad();
        com.lam.entidades.servicio.Municipio m = (com.lam.entidades.servicio.Municipio) this.controladorMunicipio.find(idMunicipio);
        c.setIdmunicipio(m);
        c.setNombre(nombre);
        return this.controladorCiudad.create(c);
    }

    @WebMethod(operationName = "editCiudad")
    public boolean editCiudad(@WebParam(name = "IdCiudad") Integer idCiudad,
            @WebParam(name = "IdMunicipio") Integer idMunicipio,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Ciudad c = (com.lam.entidades.servicio.Ciudad) this.controladorCiudad.find(idCiudad);
        com.lam.entidades.servicio.Municipio m = (com.lam.entidades.servicio.Municipio) this.controladorMunicipio.find(idMunicipio);
        c.setIdmunicipio(m);
        c.setNombre(nombre);
        return this.controladorCiudad.edit(c);
    }
    //  MODULO BANCOS

    @WebMethod(operationName = "getBancos")
    public List<com.lam.entidades.servicio.Banco> getBancos() {
        return this.controladorBanco.findEntities();
    }

    @WebMethod(operationName = "findBancos")
    public List<com.lam.entidades.servicio.Banco> findBancos(@WebParam(name = "Banco") String banco,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Banco b = new com.lam.entidades.servicio.Banco();
        b.setBanco(banco);
        b.setNombre(nombre);
        return this.controladorBanco.findEntities(b);
    }

    @WebMethod(operationName = "findBancoByBanco")
    public com.lam.entidades.servicio.Banco findBancoByBanco(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Banco b = new com.lam.entidades.servicio.Banco();
        b.setNombre(nombre);
        return (com.lam.entidades.servicio.Banco) this.controladorBanco.find(b);
    }

    @WebMethod(operationName = "createBanco")
    public boolean createBanco(@WebParam(name = "Banco") String banco,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Banco b = new com.lam.entidades.servicio.Banco();
        b.setBanco(banco);
        b.setNombre(nombre);
        return this.controladorBanco.create(b);
    }

    @WebMethod(operationName = "editBanco")
    public boolean editBanco(@WebParam(name = "IdBanco") Integer idBanco,
            @WebParam(name = "Banco") String banco,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Banco b = (com.lam.entidades.servicio.Banco) this.controladorBanco.find(idBanco);
        b.setBanco(banco);
        b.setNombre(nombre);
        return this.controladorBanco.edit(b);
    }

//  MODULO CONTACTOS
    @WebMethod(operationName = "findContactoByIdEmpleado")
    public List<com.lam.entidades.servicio.Contacto> findContactoByIdEmpleado(@WebParam(name = "IdEmpleado") Integer idEmpleado) {
        return this.controladorContacto.findEntities(idEmpleado);
    }

    @WebMethod(operationName = "createContacto")
    public boolean createContacto(@WebParam(name = "IdEmpleado") Integer idEmpleado, @WebParam(name = "IdTipoContacto") Integer idTipoContacto,
            @WebParam(name = "Valor") String valor) {
        com.lam.entidades.servicio.Empleado emp = (com.lam.entidades.servicio.Empleado) this.controladorEmpleado.find(idEmpleado);
        com.lam.entidades.servicio.TipoContacto tipo = (com.lam.entidades.servicio.TipoContacto) this.controladorTipoContacto.find(idTipoContacto);
        com.lam.entidades.servicio.Contacto contacto = new com.lam.entidades.servicio.Contacto();
        contacto.setIdempleado(emp);
        contacto.setIdtipocontacto(tipo);
        contacto.setValor(valor);
        return this.controladorContacto.create(contacto);
    }

    @WebMethod(operationName = "editContacto")
    public boolean editContacto(@WebParam(name = "IdContacto") Integer idContacto, @WebParam(name = "IdTipoContacto") Integer idTipoContacto,
            @WebParam(name = "Valor") String valor) {
        com.lam.entidades.servicio.TipoContacto tipo = (com.lam.entidades.servicio.TipoContacto) this.controladorTipoContacto.find(idTipoContacto);
        com.lam.entidades.servicio.Contacto contacto = (com.lam.entidades.servicio.Contacto) this.controladorContacto.find(idContacto);
        contacto.setIdtipocontacto(tipo);
        contacto.setValor(valor);
        return this.controladorContacto.edit(contacto);
    }

    @WebMethod(operationName = "deleteContacto")
    public boolean deleteContacto(@WebParam(name = "IdContacto") Integer idContacto) {
        com.lam.entidades.servicio.Contacto c = (com.lam.entidades.servicio.Contacto) this.controladorContacto.find(idContacto);
        return this.controladorContacto.destroy(c);
    }
//  MODULO DOMICILIO

    @WebMethod(operationName = "findDomicilioByIdEmpleado")
    public List<com.lam.entidades.servicio.Domicilio> findDomicilioByIdEmpleado(@WebParam(name = "IdEmpleado") Integer idEmpleado) {
        return this.controladorDomicilio.findEntities(idEmpleado);
    }

    @WebMethod(operationName = "createDomicilio")
    public boolean createDomicilio(@WebParam(name = "IdEmpleado") Integer idEmpleado, @WebParam(name = "IdAsentamiento") Integer idAsentamiento,
            @WebParam(name = "Calle") String calle,
            @WebParam(name = "NumeroExterior") String numeroExterior, @WebParam(name = "NumeroInterior") String numeroInterior) {
        com.lam.entidades.servicio.Empleado empleado = (com.lam.entidades.servicio.Empleado) this.controladorEmpleado.find(idEmpleado);
        com.lam.entidades.servicio.Asentamiento asentamiento = (com.lam.entidades.servicio.Asentamiento) this.controladorAsentamiento.find(idAsentamiento);
//        
        com.lam.entidades.servicio.Domicilio domicilio = new com.lam.entidades.servicio.Domicilio();
        domicilio.setCalle(calle);
        domicilio.setIdasentamiento(asentamiento);
        domicilio.setIdempleado(empleado);
        domicilio.setNumeroexterior(numeroExterior);
        domicilio.setNumerointerior(numeroInterior);
        return this.controladorDomicilio.create(domicilio);
    }

    @WebMethod(operationName = "editDomicilio")
    public boolean editDomicilio(@WebParam(name = "IdDomicilio") Integer idDomicilio, @WebParam(name = "IdAsentamiento") Integer idAsentamiento,
            @WebParam(name = "Calle") String calle,
            @WebParam(name = "NumeroExterior") String numeroExterior, @WebParam(name = "NumeroInterior") String numeroInterior) {
        com.lam.entidades.servicio.Domicilio domicilio = (com.lam.entidades.servicio.Domicilio) this.controladorDomicilio.find(idDomicilio);
        com.lam.entidades.servicio.Asentamiento asentamiento = (com.lam.entidades.servicio.Asentamiento) this.controladorAsentamiento.find(idAsentamiento);
        domicilio.setIdasentamiento(asentamiento);
        domicilio.setNumeroexterior(numeroExterior);
        domicilio.setNumerointerior(numeroInterior);
        domicilio.setCalle(calle);
//        
        return this.controladorDomicilio.edit(domicilio);
    }

    @WebMethod(operationName = "deleteDomicilio")
    public boolean deleteDomicilio(@WebParam(name = "IdDomicilio") Integer idDomicilio) {
        com.lam.entidades.servicio.Domicilio domicilio = (com.lam.entidades.servicio.Domicilio) this.controladorDomicilio.find(idDomicilio);
        return this.controladorDomicilio.destroy(domicilio);
    }
//  MODULO DOCUMENTOS

    @WebMethod(operationName = "findDocumentoByIdEmpleado")
    public List<com.lam.entidades.servicio.Documento> findDocumentoByIdEmpleado(@WebParam(name = "IdEmpleado") Integer idEmpleado) {
        return this.controladorDocumento.findEntities(idEmpleado);
    }

    @WebMethod(operationName = "createDocumento")
    public boolean createDocumento(@WebParam(name = "IdEmpleado") Integer idEmpleado, @WebParam(name = "IdTipoDocumento") Integer idTipoDocumento,
            @WebParam(name = "Observaciones") String observaciones,
            @WebParam(name = "Archivo") byte[] archivo) {
        com.lam.entidades.servicio.Documento documento = new com.lam.entidades.servicio.Documento();
//        
        com.lam.entidades.servicio.TipoDocumento tipo = (com.lam.entidades.servicio.TipoDocumento) this.controladorTipoDocumento.find(idTipoDocumento);
        com.lam.entidades.servicio.Empleado emp = (com.lam.entidades.servicio.Empleado) this.controladorEmpleado.find(idEmpleado);
//        
        documento.setIdtipodocto(tipo);
        documento.setObservaciones(observaciones);
        documento.setArchivo(archivo);
        documento.setIdempleado(emp);
//        
        return this.controladorDocumento.create(documento);
    }

    @WebMethod(operationName = "deleteDocumento")
    public boolean deleteDocumento(@WebParam(name = "IdDocumento") Integer idDocumento) {
        com.lam.entidades.servicio.Documento documento = (com.lam.entidades.servicio.Documento) this.controladorDocumento.find(idDocumento);
        return this.controladorDocumento.destroy(documento);

    }
//  MODULO DE BANCO POR RELACION LABORAL

    @WebMethod(operationName = "findCuentaBancariasByIdRellab")
    public List<com.lam.entidades.servicio.CuentaBancaria> findCuentaBancariasByIdRellab(@WebParam(name = "IdRellab") Integer idRellab) {
        return this.controladorCuentaBancaria.findEntities(idRellab);
    }

    @WebMethod(operationName = "createCuentaBancaria")
    public boolean createCuentaBancaria(@WebParam(name = "IdRellab") Integer idRellab, @WebParam(name = "IdBanco") Integer idBanco,
            @WebParam(name = "Clabe") String clabe, @WebParam(name = "Cuenta") String cuenta, @WebParam(name = "Porcentaje") Integer porcentaje,
            @WebParam(name = "Prorrrateo") Integer prorrateo, @WebParam(name = "TipoCuenta") String tipoCuenta) {
        com.lam.entidades.servicio.RelacionLaboral rl = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRellab);
        com.lam.entidades.servicio.Banco banco = (com.lam.entidades.servicio.Banco) this.controladorBanco.find(idBanco);
        com.lam.entidades.servicio.CuentaBancaria cuentaBancaria = new com.lam.entidades.servicio.CuentaBancaria();
//        
        cuentaBancaria.setIdrellab(rl);
        cuentaBancaria.setIdbanco(banco);
        cuentaBancaria.setClabe(clabe);
        cuentaBancaria.setCuenta(cuenta);
        cuentaBancaria.setPorcentaje(porcentaje);
        cuentaBancaria.setProrrateo(prorrateo);
        cuentaBancaria.setTipocuenta(tipoCuenta);
//        
        return this.controladorCuentaBancaria.create(cuentaBancaria);

    }

    @WebMethod(operationName = "deleteCuentaBancaria")
    public boolean deleteCuentaBancaria(@WebParam(name = "IdCuentaBancaria") Integer idCuentaBancaria) {
        com.lam.entidades.servicio.Banco banco = (com.lam.entidades.servicio.Banco) this.controladorBanco.find(idCuentaBancaria);
        return this.controladorCuentaBancaria.destroy(banco);
    }
//    MODULO GRUPO PAGO

    @WebMethod(operationName = "createGrupoPago")
    public boolean createGrupoPago(@WebParam(name = "IdCompañia") Integer idCompañia,
            @WebParam(name = "GrupoPago") String grupoPago,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.GrupoPago grupoP = new com.lam.entidades.servicio.GrupoPago();
        com.lam.entidades.servicio.Compania c = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompañia);
        grupoP.setIdcompania(c);
        grupoP.setGrupopago(grupoPago);
        grupoP.setNombre(nombre);
        return this.controladorGrupoPago.create(grupoP);
    }

    @WebMethod(operationName = "editGrupoPago")
    public boolean editGrupoPago(@WebParam(name = "IdGrupoPago") Integer idGrupoPago,
            @WebParam(name = "IdCompañia") Integer idCompañia,
            @WebParam(name = "GrupoPago") String grupoPago,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.GrupoPago grupoP = (com.lam.entidades.servicio.GrupoPago) this.controladorGrupoPago.find(idGrupoPago);
        com.lam.entidades.servicio.Compania c = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompañia);
        grupoP.setIdcompania(c);
        grupoP.setGrupopago(grupoPago);
        grupoP.setNombre(nombre);
//        
        return this.controladorGrupoPago.edit(grupoP);
    }

    @WebMethod(operationName = "findGrupoPagobyGrupoPago")
    public com.lam.entidades.servicio.GrupoPago findGrupoPagobyGrupoPago(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.GrupoPago grupoP = new com.lam.entidades.servicio.GrupoPago();
        grupoP.setNombre(nombre);
        return (com.lam.entidades.servicio.GrupoPago) this.controladorGrupoPago.find(grupoP);
    }

    @WebMethod(operationName = "findGruposPago")
    public List<com.lam.entidades.servicio.GrupoPago> findGruposPago(@WebParam(name = "IdCompañia") Integer idCompañia,
            @WebParam(name = "GrupoPago") String grupoPago,
            @WebParam(name = "Nombre") String nombre) {
        return this.controladorGrupoPago.findEntities(grupoPago, nombre, idCompañia, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "getGruposPago")
    public List<com.lam.entidades.servicio.GrupoPago> getGruposPago() {
        return this.controladorGrupoPago.findEntities();
    }

    @WebMethod(operationName = "findGrupoPagoById")
    public com.lam.entidades.servicio.GrupoPago findGrupoPagoById(@WebParam(name = "IdGrupoPago") Integer idGrupoPago) {
        return (com.lam.entidades.servicio.GrupoPago) this.controladorGrupoPago.find(idGrupoPago);
    }

    @WebMethod(operationName = "findGrupoPagoByIdCompania")
    public List<com.lam.entidades.servicio.GrupoPago> findGrupoPagoByIdCompania(@WebParam(name = "IdCompañia") Integer idCompania) {
        return this.controladorGrupoPago.findEntities(idCompania);
    }
//    
//  MODULO TIPO CONTACTOS

    @WebMethod(operationName = "createTipoContacto")
    public boolean createTipoContacto(@WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Personal") String personal) {
        com.lam.entidades.servicio.TipoContacto tipoContacto = new com.lam.entidades.servicio.TipoContacto();
        tipoContacto.setNombre(nombre);
        tipoContacto.setPersonal(personal);
        return this.controladorTipoContacto.create(tipoContacto);
    }

    @WebMethod(operationName = "editTipoContacto")
    public boolean editTipoContacto(@WebParam(name = "IdTipoContacto") Integer idTipoContacto,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Personal") String personal) {
        com.lam.entidades.servicio.TipoContacto tipoContacto = (com.lam.entidades.servicio.TipoContacto) this.controladorTipoContacto.find(idTipoContacto);
        tipoContacto.setNombre(nombre);
        tipoContacto.setPersonal(personal);
        return this.controladorTipoContacto.edit(tipoContacto);
    }

    @WebMethod(operationName = "findTipoContactoByTipoContacto")
    public com.lam.entidades.servicio.TipoContacto findTipoContactoByTipoContacto(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoContacto tipoContacto = new com.lam.entidades.servicio.TipoContacto();
        tipoContacto.setNombre(nombre);
        return (com.lam.entidades.servicio.TipoContacto) this.controladorTipoContacto.find(tipoContacto);
    }

    @WebMethod(operationName = "findTipoContactos")
    public List<com.lam.entidades.servicio.TipoContacto> findTipoContactos(@WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Personal") String personal) {
        com.lam.entidades.servicio.TipoContacto tipoContacto = new com.lam.entidades.servicio.TipoContacto();
        tipoContacto.setNombre(nombre);
        tipoContacto.setPersonal(personal);
        return this.controladorTipoContacto.findEntities(tipoContacto);
    }

    @WebMethod(operationName = "getTipoContactos")
    public List<com.lam.entidades.servicio.TipoContacto> getTipoContactos() {
        return this.controladorTipoContacto.findEntities();
    }
// MODULO TIPO DOCUMENTO

    public boolean createTipoDocumento(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoDocumento tipoDoc = new com.lam.entidades.servicio.TipoDocumento();
        tipoDoc.setNombre(nombre);
        return this.controladorTipoDocumento.create(tipoDoc);
    }

    @WebMethod(operationName = "editTipoDocumento")
    public boolean editTipoDocumento(@WebParam(name = "IdTipoDocumento") Integer idTipoDocumento,
            @WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoDocumento tipoDoc = (com.lam.entidades.servicio.TipoDocumento) this.controladorTipoDocumento.find(idTipoDocumento);
        tipoDoc.setNombre(nombre);
        return this.controladorTipoDocumento.edit(tipoDoc);
    }

    @WebMethod(operationName = "findTipoDocumentoByTipoDocumento")
    public com.lam.entidades.servicio.TipoDocumento findTipoDocumentoByTipoDocumento(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoDocumento tipoDoc = new com.lam.entidades.servicio.TipoDocumento();
        tipoDoc.setNombre(nombre);
        return (com.lam.entidades.servicio.TipoDocumento) this.controladorTipoDocumento.find(tipoDoc);
    }

    @WebMethod(operationName = "findTipoDocumentos")
    public List<com.lam.entidades.servicio.TipoDocumento> findTipoDocumentos(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoDocumento tipoDoc = new com.lam.entidades.servicio.TipoDocumento();
        tipoDoc.setNombre(nombre);
        return this.controladorTipoDocumento.findEntities(tipoDoc);
    }
//  MODULO CATALOGO CONCEPTOSban

    @WebMethod(operationName = "findCatalogoConceptoByTipoConcepto")
    public List<com.lam.entidades.servicio.CatalogoConcepto> findCatalogoConceptoByTipoConcepto(@WebParam(name = "TipoCatalogoConcepto") String tipoCatalogoConcepto) {
        return this.controladorCatalogoConcepto.findEntities(tipoCatalogoConcepto, null, null, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findCatalogoConceptoById")
    public com.lam.entidades.servicio.CatalogoConcepto findCatalogoConceptoById(@WebParam(name = "IdCatalogoConcepto") Integer idCatalogoConcepto) {
        return (com.lam.entidades.servicio.CatalogoConcepto) this.controladorCatalogoConcepto.find(idCatalogoConcepto);
    }

    //  MODULO TIPO PROCESOS
    @WebMethod(operationName = "getTipoProcesos")
    public List<com.lam.entidades.servicio.TipoProceso> getTipoProcesos() {
        return this.controladorTipoProceso.findEntities();
    }

    @WebMethod(operationName = "createTipoProceso")
    public boolean createTipoProceso(@WebParam(name = "TipoProceso") String tipoProceso,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Periodicidad") Integer periodicidad) {
        com.lam.entidades.servicio.TipoProceso tipoP = new com.lam.entidades.servicio.TipoProceso();
        tipoP.setTipoproceso(tipoProceso);
        tipoP.setNombre(nombre);
        tipoP.setPeriodicidad(periodicidad);
        return this.controladorTipoProceso.create(tipoP);
    }

    @WebMethod(operationName = "editTipoProceso")
    public boolean editTipoProceso(@WebParam(name = "IdTipoProceso") Integer idTipoProceso,
            @WebParam(name = "TipoProceso") String tipoProceso,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Peridicidad") Integer periodicidad) {
        com.lam.entidades.servicio.TipoProceso tipoP = (com.lam.entidades.servicio.TipoProceso) this.controladorTipoProceso.find(idTipoProceso);
        tipoP.setTipoproceso(tipoProceso);
        tipoP.setNombre(nombre);
        tipoP.setPeriodicidad(periodicidad);
        return this.controladorTipoProceso.edit(tipoP);
    }

    @WebMethod(operationName = "findTipoProcesoById")
    public com.lam.entidades.servicio.TipoProceso findTipoProcesoById(@WebParam(name = "IdTipoProceso") Integer idTipoProceso) {
        return (com.lam.entidades.servicio.TipoProceso) this.controladorTipoProceso.find(idTipoProceso);
    }

    @WebMethod(operationName = "findTiposProceso")
    public List<com.lam.entidades.servicio.TipoProceso> findTiposProceso(@WebParam(name = "TipoProceso") String tipoProceso,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Periodicidad") Integer periodicidad) {
        return this.controladorTipoProceso.findEntities(tipoProceso, nombre, periodicidad, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findTipoProcesoByTipoProceso")
    public com.lam.entidades.servicio.TipoProceso findTipoProcesoByTipoProceso(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.TipoProceso tipoProceso = new com.lam.entidades.servicio.TipoProceso();
        tipoProceso.setNombre(nombre);
        return (com.lam.entidades.servicio.TipoProceso) this.controladorTipoProceso.find(tipoProceso);
    }

//  MODULO PERIODO
    @WebMethod(operationName = "getPeriodos")
    public List<com.lam.entidades.servicio.Periodo> getPeriodos() {
        return this.controladorPeriodo.findAll();
    }

    @WebMethod(operationName = "createPeriodo")
    public boolean createPeriodo(@WebParam(name = "IdTipoProceso") Integer idTipoProceso,
            @WebParam(name = "Anio") Integer anio,
            @WebParam(name = "Periodo") Integer periodo,
            @WebParam(name = "AnioMes") Integer anioMes,
            @WebParam(name = "FechaIncio") Date fechaInicio,
            @WebParam(name = "FechaFin") Date fechaFin,
            @WebParam(name = "FechaPago") Date fechaPago,
            @WebParam(name = "Mes") Integer mes,
            @WebParam(name = "Bimestre") Integer bimestre) {

        com.lam.entidades.servicio.Periodo p = new com.lam.entidades.servicio.Periodo();
        com.lam.entidades.servicio.TipoProceso tipoProceso = (com.lam.entidades.servicio.TipoProceso) this.controladorTipoProceso.find(idTipoProceso);
//
        p.setIdtipoproceso(tipoProceso);
        p.setAnio(anio);
        p.setPeriodo(periodo);
        p.setAniomes(anioMes);
        p.setFechainicio(fechaInicio);
        p.setFechafin(fechaFin);
        p.setFechapago(fechaPago);
        p.setMes(mes);
        p.setBimestre(bimestre);
//
        return this.controladorPeriodo.create(p);
    }

    @WebMethod(operationName = "editPeriodo")
    public boolean editPeriodo(@WebParam(name = "IdPeriodo") Integer idPeriodo,
            @WebParam(name = "IdTipoProceso") Integer idTipoProceso,
            @WebParam(name = "Anio") Integer anio,
            @WebParam(name = "Periodo") Integer periodo,
            @WebParam(name = "AnioMes") Integer anioMes,
            @WebParam(name = "FechaIncio") Date fechaInicio,
            @WebParam(name = "FechaFin") Date fechaFin,
            @WebParam(name = "FechaPago") Date fechaPago,
            @WebParam(name = "Mes") Integer mes,
            @WebParam(name = "Bimestre") Integer bimestre) {
//
        com.lam.entidades.servicio.Periodo p = (com.lam.entidades.servicio.Periodo) this.controladorPeriodo.find(idPeriodo);
        com.lam.entidades.servicio.TipoProceso tipoProceso = (com.lam.entidades.servicio.TipoProceso) this.controladorTipoProceso.find(idTipoProceso);
//
        p.setIdtipoproceso(tipoProceso);
        p.setAnio(anio);
        p.setPeriodo(periodo);
        p.setAniomes(anioMes);
        p.setFechainicio(fechaInicio);
        p.setFechafin(fechaFin);
        p.setFechapago(fechaPago);
        p.setMes(mes);
        p.setBimestre(bimestre);
//
        return this.controladorPeriodo.edit(p);
    }

    @WebMethod(operationName = "getPeriodosByIdTipoProceso")
    public List<com.lam.entidades.servicio.Periodo> getPeriodosByIdTipoProceso(@WebParam(name = "IdTipoProceso") Integer idTipoProceso) {
        return this.controladorPeriodo.findEntities(idTipoProceso);
    }

    @WebMethod(operationName = "findPeriodoById")
    public com.lam.entidades.servicio.Periodo findPeriodoById(@WebParam(name = "IdPeriodo") Integer idPeriodo) {
        return (com.lam.entidades.servicio.Periodo) this.controladorPeriodo.findEntity(idPeriodo);
    }

    @WebMethod(operationName = "findPeriodos")
    public List<com.lam.entidades.servicio.Periodo> findPeriodos(@WebParam(name = "IdTipoProceso") Integer idTipoProceso,
            @WebParam(name = "Anio") Integer anio,
            @WebParam(name = "Periodo") Integer periodo,
            @WebParam(name = "AnioMes") Integer anioMes,
            @WebParam(name = "FechaIncio") Date fechaInicio,
            @WebParam(name = "FechaFin") Date fechaFin,
            @WebParam(name = "FechaPago") Date fechaPago,
            @WebParam(name = "Mes") Integer mes,
            @WebParam(name = "Bimestre") Integer bimestre) {
        //
        String periodoAux = String.valueOf(periodo);
        String anioMesAux = String.valueOf(anioMes);
        String mesAux = String.valueOf(mes);
        String bimestreAux = String.valueOf(bimestre);
        //
        return this.controladorPeriodo.findEntities(periodoAux, anioMesAux, idTipoProceso, anio, mesAux, bimestreAux, null, fechaInicio, fechaFin, fechaPago, null);
    }

    @WebMethod(operationName = "findPeriodoByFechaInicioAndFechaFin")
    public com.lam.entidades.servicio.Periodo findPeriodoByFechaInicioAndFechaFin(@WebParam(name = "FechaInicio") Date fechaInicio,
            @WebParam(name = "FechaFin") Date fechaFin) {
        com.lam.entidades.servicio.Periodo periodo = new com.lam.entidades.servicio.Periodo();
        periodo.setFechainicio(fechaInicio);
        periodo.setFechafin(fechaFin);
        return (com.lam.entidades.servicio.Periodo) this.controladorPeriodo.find(periodo);
    }

//  MODULO DEPARTAMENTO  
    @WebMethod(operationName = "getDepartamentos")
    public List<com.lam.entidades.servicio.Departamento> getDepartamentos() {
        return this.controladorDepartamento.findEntities();
    }
//  MODULO PUESTO

    @WebMethod(operationName = "getPuestos")
    public List<com.lam.entidades.servicio.Puesto> getPuestos() {
        return this.controladorPuesto.findEntities();
    }
//  MODULO TURNO

    @WebMethod(operationName = "getTurnos")
    public List<com.lam.entidades.servicio.Turno> getTurnos() {
        return this.controladorTurno.findEntities();
    }

    @WebMethod(operationName = "findTurnos")
    public List<com.lam.entidades.servicio.Turno> findTurnos(@WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Turno") String turno) {
        return this.controladorTurno.findEntities(nombre, turno, idCompania, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findTurnoByTurno")
    public com.lam.entidades.servicio.Turno findTurnoByTurno(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Turno t = new com.lam.entidades.servicio.Turno();
        t.setNombre(nombre);
        return (com.lam.entidades.servicio.Turno) this.controladorTurno.find(t);
    }

    @WebMethod(operationName = "createTurno")
    public boolean createTurno(@WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Turno") String turno) {
        com.lam.entidades.servicio.Turno t = new com.lam.entidades.servicio.Turno();
        com.lam.entidades.servicio.Compania c = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
        t.setIdcompania(c);
        t.setNombre(nombre);
        t.setTurno(turno);
        return this.controladorTurno.create(t);
    }

    @WebMethod(operationName = "editTurno")
    public boolean editTurno(@WebParam(name = "IdTurno") Integer idTurno,
            @WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Turno") String turno) {
        com.lam.entidades.servicio.Turno t = (com.lam.entidades.servicio.Turno) this.controladorTurno.find(idTurno);
        com.lam.entidades.servicio.Compania c = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
        t.setIdcompania(c);
        t.setNombre(nombre);
        t.setTurno(turno);
        return this.controladorTurno.edit(t);
    }

    //  MODULO BANCOS
//  MODULO TIPO SUELDO
    @WebMethod(operationName = "getTiposSueldo")
    public List<com.lam.entidades.servicio.TipoSueldo> getTiposSueldo() {
        return this.controladorTipoSueldo.findEntities();
    }

//  MODULO POSICION LABORAL
    @WebMethod(operationName = "createPosicionLaboral")
    public boolean createPosicionLaboral(@WebParam(name = "IdRellab") Integer idRellab, @WebParam(name = "IdTipoSueldo") Integer idTipoSueldo,
            @WebParam(name = "IdDepartamento") Integer idDepartamento, @WebParam(name = "IdPuesto") Integer idPuesto,
            @WebParam(name = "IdTurno") Integer idTurno, @WebParam(name = "Estatus") String status, @WebParam(name = "FechaInicio") Date fechaInicio,
            @WebParam(name = "FechaFin") Date fechaFin, @WebParam(name = "FormaPago") String formaPago, @WebParam(name = "JornadaLaboral") String jornadaLaboral,
            @WebParam(name = "Nivel") String nivel, @WebParam(name = "Sindicalizado") String sindicalizado, @WebParam(name = "SistemaHorario") String sistemaHorario) {
        com.lam.entidades.servicio.TipoSueldo tipoSueldo = (com.lam.entidades.servicio.TipoSueldo) this.controladorTipoSueldo.find(idTipoSueldo);
        com.lam.entidades.servicio.Departamento depto = (com.lam.entidades.servicio.Departamento) this.controladorDepartamento.find(idDepartamento);
        com.lam.entidades.servicio.Puesto puesto = (com.lam.entidades.servicio.Puesto) this.controladorPuesto.find(idPuesto);
        com.lam.entidades.servicio.Turno turno = (com.lam.entidades.servicio.Turno) this.controladorTurno.find(idTurno);
        com.lam.entidades.servicio.RelacionLaboral rl = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRellab);
        com.lam.entidades.servicio.RelacionLaboralPosicion posicion;
        if (rl.getIdrelacionlaboralposicion() != null) {
            posicion = (com.lam.entidades.servicio.RelacionLaboralPosicion) this.controladorPosicionLaboral.find(rl.getIdrelacionlaboralposicion().getIdrelacionlaboralposicion());
        } else {
            posicion = new com.lam.entidades.servicio.RelacionLaboralPosicion();
        }
        posicion.setIddepartamento(depto);
        posicion.setIdpuesto(puesto);
        posicion.setIdtiposueldo(tipoSueldo);
        posicion.setIdturno(turno);
        posicion.setEstatus(status);
        posicion.setFechainicio(fechaInicio);
        posicion.setFechafin(fechaFin);
        posicion.setFormapago(formaPago);
        posicion.setJornadalaboral(jornadaLaboral);
        posicion.setNivel(nivel);
        posicion.setSindicalizado(sindicalizado);
        posicion.setSistemahorario(sistemaHorario);
        if (rl.getIdrelacionlaboralposicion() != null) {
            return this.controladorPosicionLaboral.edit(posicion);
        }
        boolean isValidate = this.controladorPosicionLaboral.create(posicion);
        if (isValidate) {
            rl.setIdrelacionlaboralposicion(posicion);
            this.controladorRelacionLaboral.edit(rl);
            return true;
        }
        return false;
    }
//    

    @WebMethod(operationName = "findPosicionLaboralByIdRellab")
    public com.lam.entidades.servicio.RelacionLaboralPosicion findPosicionLaboralByIdRellab(@WebParam(name = "IdPosicionLaboral") Integer idPosicionLaboral) {
        return (com.lam.entidades.servicio.RelacionLaboralPosicion) this.controladorPosicionLaboral.find(idPosicionLaboral);

    }

    @WebMethod(operationName = "findInfonavitByIdRellab")
    public com.lam.entidades.servicio.Infonavit findInfonavitByIdRellab(@WebParam(name = "IdRellab") Integer idRellab) {
        return (com.lam.entidades.servicio.Infonavit) this.controladorInfonavit.find(idRellab.toString(), null);
    }

    @WebMethod(operationName = "findInfonavitHistoricoByIdInfonavit")
    public List<com.lam.entidades.servicio.InfonavitHistorico> findInfonavitHistoricoByIdInfonavit(@WebParam(name = "InfonavitHistorico") Integer idInfonavit) {
        return this.controladorInfonavitHistorico.findEntities(idInfonavit);
    }

    @WebMethod(operationName = "createInfonavit")
    public boolean createInfonavit(@WebParam(name = "IdRellab") Integer idRellab, @WebParam(name = "numeroCredito") String numeroCredito,
            @WebParam(name = "Status") String status, @WebParam(name = "FechaVigencia") Date fechaVigencia, @WebParam(name = "TipoDescuento") String tipoDescuento,
            @WebParam(name = "Descuento") Double descuento) {
        com.lam.entidades.servicio.Infonavit infonavit = (com.lam.entidades.servicio.Infonavit) this.controladorInfonavit.find(idRellab);
//        
        boolean bandera = true;
//        
        if (infonavit == null) {
            infonavit = new com.lam.entidades.servicio.Infonavit();
            com.lam.entidades.servicio.RelacionLaboral rl = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRellab);
            infonavit.setIdrellab(rl);
            bandera = false;
        }
//        
        infonavit.setNumerocredito(numeroCredito);
        infonavit.setEstatus(status);
        infonavit.setFechavigencia(fechaVigencia);
        infonavit.setFechaActualizacion(new Date());
        infonavit.setTipodescuento(tipoDescuento);
        infonavit.setDescuento(descuento);
//      

        boolean isValidate;
        if (bandera) {
            isValidate = this.controladorInfonavit.edit(infonavit);
        } else {
            isValidate = this.controladorInfonavit.create(infonavit);

        }
        if (isValidate) {
            com.lam.entidades.servicio.InfonavitHistorico iHistorico = new com.lam.entidades.servicio.InfonavitHistorico();
            iHistorico.setNumerocredito(numeroCredito);
            iHistorico.setEstatus(status);
            iHistorico.setFechavigencia(fechaVigencia);
            iHistorico.setFechaactualizacion(new Date());
            iHistorico.setTipodescuento(tipoDescuento);
            iHistorico.setDescuento(descuento);
            iHistorico.setIdinfonavit(infonavit);
            return this.controladorInfonavitHistorico.create(iHistorico);
        }
        return false;
    }
//    MODULO ESTRUCTURAS

    @WebMethod(operationName = "findEstructuraByNivel")
    public List<com.lam.entidades.servicio.Estructura> findEstructuraByNivel(@WebParam(name = "Nivel") String nivel) {
        com.lam.entidades.servicio.Estructura estructura = new com.lam.entidades.servicio.Estructura();
        estructura.setNivel(nivel);
        return this.controladorEstructura.findEntities(estructura);
    }

    @WebMethod(operationName = "findEstructuraDatosByIdRellabAndIdEstructura")
    public List<com.lam.entidades.servicio.EstructuraDatos> findEstructuraDatosByIdRellabAndIdEstructura(@WebParam(name = "IdRellab") Integer idRellab,
            @WebParam(name = "IdEstructura") Integer idEstructura) {
//        
        List<com.lam.entidades.servicio.EstructuraRelacion> relaciones = this.controladorEstructuraRelacion.findEntities(idEstructura);
//        
        com.lam.entidades.servicio.RelacionLaboral rl = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRellab);
//        
        for (com.lam.entidades.servicio.EstructuraRelacion r : relaciones) {
            com.lam.entidades.servicio.EstructuraDatos datos = (com.lam.entidades.servicio.EstructuraDatos) this.controladorEstructuraDatos.find(r.getIdcolumna().getIdcolumna().toString(), null);
            if (datos == null) {
                datos = new com.lam.entidades.servicio.EstructuraDatos();
                datos.setIdcolumna(r.getIdcolumna());
                datos.setIdestructura(r.getIdestructura());
                datos.setIdrellab(rl);
                this.controladorEstructuraDatos.create(datos);
            }
        }
//        
        List<Integer> ids = new ArrayList<>();
        ids.add(idRellab);
        ids.add(idEstructura);
        List<com.lam.entidades.servicio.EstructuraDatos> datos = this.controladorEstructuraDatos.findEntities(ids);
        for (com.lam.entidades.servicio.EstructuraDatos d : datos) {
            if (d.getIdcolumna().getIdlista() != null) {
                List<com.lam.entidades.servicio.ConceptoLista> lista = this.controladorEstructuraConceptoLista.findEntities(d.getIdcolumna().getIdlista().getIdlista());
                d.setConceptosLista(lista);
            }
        }
        return datos;
    }

    @WebMethod(operationName = "editEstructuraByEmpleado")
    public boolean editEstructuraByEmpleado(@WebParam(name = "EstructurasDatos") List<com.lam.entidades.servicio.EstructuraDatos> estructurasDatos) {
        return this.controladorEstructuraDatos.editEntities(estructurasDatos);
    }

//  MODULO POSICION SUELDO
    @WebMethod(operationName = "findPosicionSueldoByIdRellab")
    public com.lam.entidades.servicio.PosicionSueldo findPosicionSueldoByIdRellab(@WebParam(name = "IdRellab") Integer idRellab, @WebParam(name = "IdTipoSueldo") Integer idTipoSueldo) {
        return (com.lam.entidades.servicio.PosicionSueldo) this.controladorPosicionSueldo.find(idRellab.toString(), idTipoSueldo.toString());

    }

    @WebMethod(operationName = "findPosicionesSueldoHistoricoByIdPosicion")
    public List<com.lam.entidades.servicio.PosicionSueldoHistorico> findPosicionesSueldoHistoricoByIdPosicion(@WebParam(name = "IdPosicionSueldo") Integer idPosicionSueldo) {
        return this.controladorPosicionSueldoHistorico.findEntities(idPosicionSueldo);
    }

    @WebMethod(operationName = "createPosicionSueldo")
    public boolean createPosicionSueldo(@WebParam(name = "IdRellab") Integer idRellab, @WebParam(name = "IdTipoSueldo") Integer idTipoSueldo,
            @WebParam(name = "Status") String status, @WebParam(name = "FechaInicio") Date fechaInicio, @WebParam(name = "FechaFin") Date fechaFin,
            @WebParam(name = "Importe") Double importe) {

//        
        boolean bandera = true;
//        
        List<com.lam.entidades.servicio.PosicionSueldo> posiciones = this.controladorPosicionSueldo.findEntities(idRellab);
//        
        com.lam.entidades.servicio.RelacionLaboral rl = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRellab);
//        
        com.lam.entidades.servicio.TipoSueldo tsn = (com.lam.entidades.servicio.TipoSueldo) this.controladorTipoSueldo.find(1);
        com.lam.entidades.servicio.TipoSueldo tsi = (com.lam.entidades.servicio.TipoSueldo) this.controladorTipoSueldo.find(2);
//
        com.lam.entidades.servicio.PosicionSueldo psn = null;
        com.lam.entidades.servicio.PosicionSueldo psi = null;
//        

        for (com.lam.entidades.servicio.PosicionSueldo p : posiciones) {
            System.out.println("Tipo Sueldo... " + p.getIdtiposueldo().getTiposueldo());
            switch (p.getIdtiposueldo().getTiposueldo()) {
                case Parametros.TIPO_CALCULO_SDN:
                    psn = p;
                    break;
                case Parametros.TIPO_CALCULO_SDI:
                    psi = p;
                    break;
            }
        }
        if (psn == null) {
            psn = new com.lam.entidades.servicio.PosicionSueldo();
            bandera = false;
        }
//        
        psn.setFechainicio(fechaInicio);
        psn.setFechafin(fechaFin);
        psn.setSueldo(importe);
        psn.setIdrellab(rl);
        psn.setIdtiposueldo(tsn);
        psn.setEstatus(status);
//
//        
        boolean isValidate;
//        
        if (bandera) {
            isValidate = this.controladorPosicionSueldo.edit(psn);
        } else {
            isValidate = this.controladorPosicionSueldo.create(psn);
        }
//        
        if (isValidate) {
            com.lam.entidades.servicio.PosicionSueldoHistorico historico = new com.lam.entidades.servicio.PosicionSueldoHistorico();
            historico.setEstatus(status);
            historico.setFechaactualizacion(new Date());
            historico.setFechafin(fechaFin);
            historico.setFechainicio(fechaInicio);
            historico.setIdposicionsueldo(psn);
            historico.setIdtiposueldo(tsn);
            historico.setSueldo(importe);
            isValidate = this.controladorPosicionSueldoHistorico.create(historico);
        }
        if (isValidate) {
            bandera = true;
            if (psi == null) {
                psi = new com.lam.entidades.servicio.PosicionSueldo();
                bandera = false;
            }
            psi.setFechainicio(fechaInicio);
            psi.setFechafin(fechaFin);
            psi.setSueldo(importe);
            psi.setIdrellab(rl);
            psi.setIdtiposueldo(tsi);
            psi.setEstatus(status);
            this.createPosicionSueldoIntegrado(psi, bandera);
        }
        return isValidate;
    }

    private boolean createPosicionSueldoIntegrado(com.lam.entidades.servicio.PosicionSueldo psi, boolean bandera) {
        double sdi = new com.lam.motor.Motor().calcularSDI(psi.getIdrellab(), psi.getSueldo());
        psi.setSueldo(sdi);
        boolean isValidate;
        if (bandera) {
            isValidate = this.controladorPosicionSueldo.edit(psi);
        } else {
            isValidate = this.controladorPosicionSueldo.create(psi);
        }
//        
        if (isValidate) {
            com.lam.entidades.servicio.PosicionSueldoHistorico historico = new com.lam.entidades.servicio.PosicionSueldoHistorico();
            historico.setEstatus(psi.getEstatus());
            historico.setFechaactualizacion(new Date());
            historico.setFechafin(psi.getFechafin());
            historico.setFechainicio(psi.getFechainicio());
            historico.setIdposicionsueldo(psi);
            historico.setIdtiposueldo(psi.getIdtiposueldo());
            historico.setSueldo(sdi);
            return this.controladorPosicionSueldoHistorico.create(historico);
        }
        return false;
    }

//  MODULO REGISTROS PATRONALES
    @WebMethod(operationName = "getRegistrosPatronales")
    public List<com.lam.entidades.servicio.RegistroPatronal> getRegistrosPatronales() {
        return this.controladorRegistroPatronal.findEntities();
    }

    @WebMethod(operationName = "findRegistrosPatronales")
    public List<com.lam.entidades.servicio.RegistroPatronal> findRegistrosPatronales(@WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "RegistroPatronal") String registroPatronal,
            @WebParam(name = "Pricipal") Integer principal,
            @WebParam(name = "Comentarios") String comentarios) {
        return this.controladorRegistroPatronal.findEntities(registroPatronal, comentarios, idCompania, principal, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findRegistroPatronalByRegistroPatronal")
    public com.lam.entidades.servicio.RegistroPatronal findRegistroPatronalByRegistroPatronal(@WebParam(name = "RegistroPatronal") String registroPatronal) {
        com.lam.entidades.servicio.RegistroPatronal registroP = new com.lam.entidades.servicio.RegistroPatronal();
        registroP.setRegistropatronal(registroPatronal);
        return (com.lam.entidades.servicio.RegistroPatronal) this.controladorRegistroPatronal.find(registroP);
    }

    @WebMethod(operationName = "createRegistroPatronal")
    public boolean createRegistroPatronal(@WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "RegistroPatronal") String registroPatronal,
            @WebParam(name = "Pricipal") Integer principal,
            @WebParam(name = "Comentarios") String comentarios) {
//
        com.lam.entidades.servicio.RegistroPatronal registroP = new com.lam.entidades.servicio.RegistroPatronal();
//
        com.lam.entidades.servicio.Compania compania = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
        registroP.setIdcompania(compania);
        registroP.setRegistropatronal(registroPatronal);
        registroP.setPrincipal(principal);
        registroP.setComentarios(comentarios);
//
        return this.controladorRegistroPatronal.create(registroP);
    }

    @WebMethod(operationName = "editRegistroPatronal")
    public boolean editRegistroPatronal(@WebParam(name = "IdRegistroPatronal") Integer idRegistroPatronal,
            @WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "RegistroPatronal") String registroPatronal,
            @WebParam(name = "Pricipal") Integer principal,
            @WebParam(name = "Comentarios") String comentarios) {

        com.lam.entidades.servicio.RegistroPatronal registroP = (com.lam.entidades.servicio.RegistroPatronal) this.controladorRegistroPatronal.find(idRegistroPatronal);

        com.lam.entidades.servicio.Compania compania = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);

        registroP.setIdcompania(compania);
        registroP.setRegistropatronal(registroPatronal);
        registroP.setPrincipal(principal);
        registroP.setComentarios(comentarios);

        return this.controladorRegistroPatronal.edit(registroP);
    }

//    MODULO COMPANIAS
    @WebMethod(operationName = "findCompaniaById")
    public com.lam.entidades.servicio.Compania findCompaniaById(@WebParam(name = "IdCompania") Integer idCompania) {
        return (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
    }

    @WebMethod(operationName = "findCompanias")
    public List<com.lam.entidades.servicio.Compania> findCompanias(@WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Clave") String clave,
            @WebParam(name = "RFC") String rfc) {
        return this.controladorCompania.findEntities(nombre, clave, null, null, rfc, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findCompaniaByCompania")
    public com.lam.entidades.servicio.Compania findCompaniaByCompania(@WebParam(name = "Nombre") String nombre) {
        com.lam.entidades.servicio.Compania c = new com.lam.entidades.servicio.Compania();
        c.setNombre(nombre);
        return (com.lam.entidades.servicio.Compania) this.controladorCompania.find(c);
    }

    @WebMethod(operationName = "createCompania")
    public boolean createCompania(@WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Clave") String clave,
            @WebParam(name = "RFC") String rfc,
            @WebParam(name = "Logo") String logo,
            @WebParam(name = "Timbre") String timbre,
            @WebParam(name = "Procesados") String procesados) {
        com.lam.entidades.servicio.Compania c = new com.lam.entidades.servicio.Compania();
        c.setNombre(nombre);
        c.setClave(clave);
        c.setRfc(rfc);
        c.setPathCarpetaLogo(logo);
        c.setPathCarpetaTimbre(timbre);
        c.setPathCarpetaProcesados(procesados);
        return this.controladorCompania.create(c);
    }

    @WebMethod(operationName = "editCompania")
    public boolean editCompania(@WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "Clave") String clave,
            @WebParam(name = "RFC") String rfc,
            @WebParam(name = "Logo") String logo,
            @WebParam(name = "Timbre") String timbre,
            @WebParam(name = "Procesados") String procesados) {
        com.lam.entidades.servicio.Compania compania = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
        compania.setNombre(nombre);
        compania.setClave(clave);
        compania.setRfc(rfc);
        compania.setPathCarpetaLogo(logo);
        compania.setPathCarpetaTimbre(timbre);
        compania.setPathCarpetaProcesados(procesados);
        return this.controladorCompania.edit(compania);
    }

//    MODULO INCIDENCIAS
    @WebMethod(operationName = "findRelacionLaboralByIdCompaniaAndIdGrupoPago")
    public List<com.lam.entidades.servicio.RelacionLaboral> findRelacionLaboralByIdCompaniaAndIdGrupoPago(
            @WebParam(name = "IdCompania") Integer idCompania, @WebParam(name = "IdGrupoPago") Integer idGrupoPago) {
        List<Integer> ids = new ArrayList<>();
//      //
        ids.add(idCompania);
        ids.add(idGrupoPago);
        //
        return this.controladorRelacionLaboral.findEntities(ids);
    }

    @WebMethod(operationName = "deleteIncidencias")
    public boolean deleteIncidencias(@WebParam(name = "Incidencias") List<com.lam.entidades.servicio.Incidencia> incidencias) {
        System.out.println("Incidencias Size... " + incidencias.size());
        return this.controladorIncidencia.delete(incidencias);
    }

    @WebMethod(operationName = "findIncidencias")
    public List<com.lam.entidades.servicio.Incidencia> findIncidencias(
            @WebParam(name = "NumeroEmpleado") String numeroEmpleado, @WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "IdGrupoPago") Integer idGrupoPago, @WebParam(name = "IdTipoProceso") Integer idTipoProceso,
            @WebParam(name = "IdPeriodo") Integer idPeriodo, @WebParam(name = "FechaInicio") Date fechaInicio,
            @WebParam(name = "FechaFin") Date fechaFin) {
        String idTP = idTipoProceso != null ? idTipoProceso.toString() : null;
        String idPer = idPeriodo != null ? idPeriodo.toString() : null;
        return this.controladorIncidencia.findEntities(numeroEmpleado, idTP, idCompania, idGrupoPago, idPer, null, null, fechaInicio, fechaFin, null, null);
    }

    @WebMethod(operationName = "createIncidencias")
    public boolean createIncidencias(@WebParam(name = "Incidencias") List<com.lam.entidades.servicio.Incidencia> incidencias) {
        for (com.lam.entidades.servicio.Incidencia i : incidencias) {
            i.toUpperCaseTrim();
        }
        return this.controladorIncidencia.createEntities(incidencias);
    }

    @WebMethod(operationName = "findCatalogoConceptoByTipoAndIdConcepto")
    public com.lam.entidades.servicio.CatalogoConcepto findCatalogoConceptoByTipoAndIdConcepto(@WebParam(name = "IdConcepto") Integer idConcepto,
            @WebParam(name = "Tipo") String tipo) {
        return (com.lam.entidades.servicio.CatalogoConcepto) this.controladorCatalogoConcepto.find(tipo, idConcepto.toString());
    }

    @WebMethod(operationName = "findRelacionLaboralByNumeroEmpleado")
    public com.lam.entidades.servicio.RelacionLaboral findRelacionLaboralByNumeroEmpleado(@WebParam(name = "NumeroEmpleado") String numeroEmpleado) {
        com.lam.entidades.servicio.RelacionLaboral rl = new com.lam.entidades.servicio.RelacionLaboral();
        rl.setNumeroempleado(numeroEmpleado);
        List<com.lam.entidades.servicio.RelacionLaboral> rls = this.controladorRelacionLaboral.findEntities(rl);
        if (rls.isEmpty()) {
            return null;
        }
        return rls.get(0);
    }
//  MODULO VACACIONES

    @WebMethod(operationName = "createSaldoVacaciones")
    public boolean createSaldoVacaciones(@WebParam(name = "Saldo") com.lam.entidades.servicio.SaldoVacaciones saldo) {
        return this.controladorSaldoVacaciones.create(saldo);
    }

    @WebMethod(operationName = "editSaldoVacaciones")
    public boolean editSaldoVacaciones(@WebParam(name = "Saldo") com.lam.entidades.servicio.SaldoVacaciones saldo) {
        return this.controladorSaldoVacaciones.edit(saldo);
    }

    @WebMethod(operationName = "findSaldosVacaciones")
    public List<com.lam.to.ResumenSaldoTO> findSaldosVacaciones(@WebParam(name = "NumeroEmpleado") String numeroEmpleado,
            @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "ApellidoPaterno") String apellidoPaterno,
            @WebParam(name = "ApellidoMaterno") String apellidoMaterno,
            @WebParam(name = "Ciclo") Integer ciclo) {

        List<com.lam.entidades.servicio.SaldoVacaciones> saldoVacaciones = this.controladorSaldoVacaciones.findEntities(numeroEmpleado, nombre, ciclo, null,
                apellidoPaterno, apellidoMaterno, null, null, null, null, null);

        Map<String, com.lam.to.ResumenSaldoTO> mapa = new HashMap<>();

        for (com.lam.entidades.servicio.SaldoVacaciones s : saldoVacaciones) {
            String llave = s.getIdrellab().getIdrellab().toString();
            if (mapa.get(llave) == null) {
                com.lam.to.ResumenSaldoTO resumen = new com.lam.to.ResumenSaldoTO();
                resumen.setRelacionLaboral(s.getIdrellab());
                Util.sumarResumenVacaciones(resumen, s);
                resumen.getDetalle().add(s);
                mapa.put(llave, resumen);
            } else {
                com.lam.to.ResumenSaldoTO resumen = mapa.get(llave);
                Util.sumarResumenVacaciones(resumen, s);
                resumen.getDetalle().add(s);
            }
        }
        if (mapa.isEmpty()) {
            return new ArrayList<>();
        }
//        
        Iterator<com.lam.to.ResumenSaldoTO> iter = mapa.values().iterator();
        List<com.lam.to.ResumenSaldoTO> resumen = new ArrayList<>();
//        
        while (iter.hasNext()) {
            com.lam.to.ResumenSaldoTO r = iter.next();
            String style = r.getTotal().getTotalSaldo() < 0 ? "background-color: #B40431; color: white" : "background-color: white; color: black";
            r.setStyle(style);
            resumen.add(r);
        }
        return resumen;
    }

    @WebMethod(operationName = "findSaldoVacacionesByIdRellab")
    public List<com.lam.entidades.servicio.SaldoVacaciones> findSaldoVacacionesByIdRellab(@WebParam(name = "IdRellab") Integer idRellab) {
        return this.controladorSaldoVacaciones.findEntities(idRellab);
    }

    @WebMethod(operationName = "findSaldoVacacionesByIdRelLabAndCiclo")
    public com.lam.entidades.servicio.SaldoVacaciones findSaldoVacacionesByIdRelLabAndCiclo(@WebParam(name = "IdRellab") Integer idRellab,
            @WebParam(name = "ciclo") Integer ciclo) {
        return (com.lam.entidades.servicio.SaldoVacaciones) this.controladorSaldoVacaciones.find(idRellab.toString(), ciclo.toString());
    }

    @WebMethod(operationName = "findSaldoVacacionesDistinctRellab")
    public List<com.lam.entidades.servicio.RelacionLaboral> findSaldoVacacionesDistinctRellab() {
        return this.controladorRelacionLaboral.findAll();
    }

//  SOLICITUD VACACIONES
    @WebMethod(operationName = "findSolicitudVacacionesByFechaInicioAndFechaFin")
    public List<com.lam.entidades.servicio.SolicitudVacaciones> findSolicitudVacacionesByFechaInicioAndFechaFin(@WebParam(name = "Fecha") Date fecha,
            @WebParam(name = "Estatus") String estatus) {
        com.lam.entidades.servicio.SolicitudVacaciones solicitud = new com.lam.entidades.servicio.SolicitudVacaciones();
        solicitud.setFechainicio(fecha);
        solicitud.setEstatus(estatus);
        return this.controladorSolicitudVacaciones.findEntities(solicitud);
    }

    @WebMethod(operationName = "getSolicitudesVacaciones")
    public List<com.lam.entidades.servicio.SolicitudVacaciones> getSolicitudesVacaciones() {
        return this.controladorSolicitudVacaciones.findAll();
    }

    @WebMethod(operationName = "findSolicitudesVacaciones")
    public List<com.lam.entidades.servicio.SolicitudVacaciones> findSolicitudesVacaciones(
            @WebParam(name = "NumeroEmpleado") String numeroEmpleado, @WebParam(name = "Nombre") String nombre,
            @WebParam(name = "ApellidoPaterno") String apellidoPaterno, @WebParam(name = "ApellidoMaterno") String apellidoMaterno,
            @WebParam(name = "FechaInicio") Date fechaInicio, @WebParam(name = "fechaFin") Date fechaFin,
            @WebParam(name = "FechaRegistro") Date fechaRegistro, @WebParam(name = "Estatus") String estatus) {
        return this.controladorSolicitudVacaciones.findEntities(numeroEmpleado, nombre, null, null, apellidoPaterno, apellidoMaterno, estatus, fechaInicio, fechaFin, fechaRegistro, null);
    }

    @WebMethod(operationName = "findSolicitudesByIdRelLabAndIdVacSaldo")
    public List<com.lam.entidades.servicio.SolicitudVacaciones> findSolicitudesByIdRelLabAndIdVacSaldo(@WebParam(name = "IdRelLab") Integer idRelLab,
            @WebParam(name = "IdVacSaldo") Integer idVacSaldo) {
        List<Integer> ids = new ArrayList<>();
        ids.add(idRelLab);
        ids.add(idVacSaldo);
        return this.controladorSolicitudVacaciones.findEntities(ids);
    }

    @WebMethod(operationName = "editSolicitudVacaciones")
    public boolean editSolicitudVacaciones(@WebParam(name = "Solicitudes") List<com.lam.entidades.servicio.SolicitudVacaciones> solicitudes) {
        for (com.lam.entidades.servicio.SolicitudVacaciones s : solicitudes) {
//
            com.lam.entidades.servicio.SaldoVacaciones saldo = (com.lam.entidades.servicio.SaldoVacaciones) this.controladorSaldoVacaciones.find(s.getIdvacsaldo().getIdvacsaldo());
            com.lam.entidades.servicio.SolicitudVacaciones solicitud = (com.lam.entidades.servicio.SolicitudVacaciones) this.controladorSolicitudVacaciones.find(s.getIdsolicitud());
//            
            Integer saldoAutorizadas;
            Integer saldoSolicitadas;
            Double saldoTotal;
//            
            switch (solicitud.getEstatus()) {
                case "01":
                    switch (s.getEstatus()) {
                        case "02":
                            saldoAutorizadas = saldo.getAutorizadas() + s.getDias();
                            saldo.setAutorizadas(saldoAutorizadas);
                            break;
                        case "99":
                            saldoTotal = saldo.getSaldo() + s.getDias().doubleValue();
                            saldo.setSaldo(saldoTotal);
                            saldoSolicitadas = saldo.getSolicitadas() - s.getDias();
                            saldo.setSolicitadas(saldoSolicitadas);
                            break;
                    }
                    break;
                case "02":
//                    
                    if (!s.getEstatus().equals("02")) {
                        saldoAutorizadas = saldo.getAutorizadas() - s.getDias();
                        saldo.setAutorizadas(saldoAutorizadas);
                    }
//
                    switch (s.getEstatus()) {
                        case "01":
                            break;
                        case "99":
                            saldoSolicitadas = saldo.getSolicitadas() - s.getDias();
                            saldo.setSolicitadas(saldoSolicitadas);
                            saldoTotal = saldo.getSaldo() + s.getDias().doubleValue();
                            saldo.setSaldo(saldoTotal);
                            break;
                    }
                    break;
                case "99":
                    if (!s.getEstatus().equals("99")) {
                        saldoSolicitadas = saldo.getSolicitadas() + s.getDias();
                        saldo.setSolicitadas(saldoSolicitadas);
                        saldoTotal = saldo.getSaldo() - s.getDias().doubleValue();
                        saldo.setSaldo(saldoTotal);
                    }
                    switch (s.getEstatus()) {
                        case "01":
                            break;
                        case "02":
                            saldoAutorizadas = saldo.getAutorizadas() + s.getDias();
                            saldo.setAutorizadas(saldoAutorizadas);
                            break;
                    }
                    break;
            }
//            
            if (this.controladorSaldoVacaciones.edit(saldo)) {
                this.controladorSolicitudVacaciones.edit(s);
            }
//            
        }
        return true;
    }

    @WebMethod(operationName = "createSolicitudVacaciones")
    public boolean createSolicitudVacaciones(@WebParam(name = "IdVacSaldo") Integer idVacSaldo,
            @WebParam(name = "IdRellab") Integer idRellab, @WebParam(name = "Dias") Integer dias,
            @WebParam(name = "FechaInicio") Date fechaInicio, @WebParam(name = "FechaFin") Date fechaFin,
            @WebParam(name = "FechaPago") Date fechaPago) {
//        
        com.lam.entidades.servicio.RelacionLaboral rl = (com.lam.entidades.servicio.RelacionLaboral) this.controladorRelacionLaboral.find(idRellab);
//        
        com.lam.entidades.servicio.SaldoVacaciones sv = (com.lam.entidades.servicio.SaldoVacaciones) this.controladorSaldoVacaciones.find(idVacSaldo);
//        
        com.lam.entidades.servicio.SolicitudVacaciones solicitud = new com.lam.entidades.servicio.SolicitudVacaciones();
        solicitud.setIdrellab(rl);
        solicitud.setIdvacsaldo(sv);
        solicitud.setDias(dias);
        solicitud.setEstatus("01");
        solicitud.setFechaactualizacion(new Date());
        solicitud.setFechainicio(fechaInicio);
        solicitud.setFechafin(fechaFin);
        solicitud.setFechapago(fechaPago);
//        
        boolean isValidate = this.controladorSolicitudVacaciones.create(solicitud);
//        
        if (!isValidate) {
            return isValidate;
        }
        Integer registradas = sv.getSolicitadas() + dias;
        sv.setSolicitadas(registradas);
        sv.setSaldo(sv.getSaldo() - dias);
//        
        return this.controladorSaldoVacaciones.edit(sv);
    }

    @WebMethod(operationName = "deleteSaldoVacacionesByIdRellab")
    public boolean deleteSaldoVacacionesByIdRellab(@WebParam(name = "IdRellab") Integer idRellab) {
        return this.controladorSaldoVacaciones.delete(idRellab);
    }

    @WebMethod(operationName = "getSistemasAntiguedad")
    public List<com.lam.entidades.servicio.SistemaAntiguedad> getSistemasAntiguedad() {
        return this.controladorSistemaAntiguedad.findEntities();
    }

    @WebMethod(operationName = "findTabuladorByIdSistemaAntiguedadAndCiclo")
    public com.lam.entidades.servicio.TabuladorSistemaAntiguedad findTabuladorByIdSistemaAntiguedadAndCiclo(@WebParam(name = "IdSistemaAntiguedad") Integer idSistemaAntiguedad, @WebParam(name = "Ciclo") Double ciclo) {
        return (com.lam.entidades.servicio.TabuladorSistemaAntiguedad) this.controladorTabuladorSistemaAntiguedad.find(idSistemaAntiguedad.toString(), ciclo.toString());

    }

    @WebMethod(operationName = "findColumnaTabuladorByIdTabuladorAndDescripcion")
    public com.lam.entidades.servicio.ColumnaTabulador findColumnaTabuladorByIdTabuladorAndDescripcion(@WebParam(name = "IdTabulador") Integer idTabulador, @WebParam(name = "Descripcion") String descrpcion) {
        return (com.lam.entidades.servicio.ColumnaTabulador) this.controladorColumnaTabulador.find(idTabulador.toString(), descrpcion);
    }

    @WebMethod(operationName = "findAdelantoVacacionesByIdRellan")
    public List<com.lam.entidades.servicio.AdelantoVacaciones> findAdelantoVacacionesByIdRellan(@WebParam(name = "IdRellab") Integer idRellab) {
        return this.controladorAdelantoVacaciones.findEntities(idRellab);
    }

    @WebMethod(operationName = "createAdelantoVacaciones")
    public boolean createAdelantoVacaciones(@WebParam(name = "ListaAdelantoVacaciones") List<com.lam.entidades.servicio.AdelantoVacaciones> listaAdelantoVacaciones) {
        return this.controladorAdelantoVacaciones.createEntities(listaAdelantoVacaciones);
    }

    @WebMethod(operationName = "findListadosNetos")
    public List<com.lam.entidades.servicio.AcumuladoConcepto> findListadosNetos(@WebParam(name = "TipoNomina") String tipoNomina,
            @WebParam(name = "NumeroConcepto") String numeroConcepto,
            @WebParam(name = "Anio") Integer anio,
            @WebParam(name = "Periodo") Integer periodo,
            @WebParam(name = "GrupoPago") String grupoPago) {

        String llave = tipoNomina + " | " + grupoPago + " | " + anio + " | " + periodo;
        System.out.println("Consulta... " + llave);

//        List<com.lam.entidades.servicio.AcumuladoConcepto> acumulados = Parametros.MAPA_ACUMULADOS_CONCEPTOS_LISTADO.get(llave) == null ? new ArrayList<com.lam.entidades.servicio.AcumuladoConcepto>()
//                : Parametros.MAPA_ACUMULADOS_CONCEPTOS_LISTADO.get(llave);
//        System.out.println("Size. acumulados... " + acumulados.size());

        return null;
    }

    @WebMethod(operationName = "findPolizas")
    public List<com.lam.entidades.servicio.Poliza> findPolizas(@WebParam(name = "Poliza") String poliza) {
        System.out.println("Poliza WS... " + poliza);
        return this.controladorPoliza.findEntities(poliza, null, null, null, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "getLiquidaciones")
    public List<com.lam.entidades.servicio.Liquidacion> getLiquidaciones() {
        return this.controladorLiquidacion.findAll();
    }

    @WebMethod(operationName = "getGranTotalLiquidaciones")
    public com.lam.to.GranTotalCargosAbonosTO getGranTotalLiquidaciones(@WebParam(name = "registros") List<com.lam.to.ResumenLiquidacionTO> registros) {
        return Util.getTotalLiquidacion(registros);
    }

    @WebMethod(operationName = "findListadoNominas")
    public List<com.lam.to.ResumenAcumuladoConceptosTO> findListadoNominas(@WebParam(name = "TipoNomina") String tipoNomina,
            @WebParam(name = "NumeroConcepto") String numeroConcepto,
            @WebParam(name = "Anio") Integer anio,
            @WebParam(name = "Periodo") Integer periodo,
            @WebParam(name = "GrupoPago") String grupoPago) {
        com.lam.entidades.servicio.AcumuladoConcepto acum = new com.lam.entidades.servicio.AcumuladoConcepto();
        acum.setTiponomina(tipoNomina);
        acum.setGrupopago(grupoPago);
        acum.setAnio(anio);
        acum.setPeriodo(periodo);

//        
        this.controladorAcumuladoConcepto.findEntities(acum);
//
        if (Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR.isEmpty()) {
            return new ArrayList<>();
        }

        Iterator<com.lam.to.ResumenAcumuladoConceptosTO> iter = Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR.values().iterator();
        List<com.lam.to.ResumenAcumuladoConceptosTO> resumen = new ArrayList<>();

        while (iter.hasNext()) {
            com.lam.to.ResumenAcumuladoConceptosTO r = iter.next();
            resumen.add(r);
        }

        return resumen;
    }

    @WebMethod(operationName = "findCifrasNominas")
    public List<com.lam.to.ResumenAcumuladoConceptosTO> findCifrasNominas(@WebParam(name = "TipoNomina") String tipoNomina,
            @WebParam(name = "NumeroConcepto") String numeroConcepto,
            @WebParam(name = "Anio") Integer anio,
            @WebParam(name = "Periodo") Integer periodo,
            @WebParam(name = "GrupoPago") String grupoPago) {
//        
        this.controladorAcumuladoConcepto.findEntities(tipoNomina, null, anio, periodo, grupoPago, null, null, null, null, null, null);
//        
        if (Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO.isEmpty()) {
            return new ArrayList<>();
        }

        Iterator<com.lam.to.ResumenAcumuladoConceptosTO> iter = Parametros.MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO.values().iterator();
        List<com.lam.to.ResumenAcumuladoConceptosTO> resumen = new ArrayList<>();

        while (iter.hasNext()) {
            com.lam.to.ResumenAcumuladoConceptosTO r = iter.next();
            resumen.add(r);
        }
//
        System.out.println("Resumen... ." + resumen.size());
//        
        return resumen;
    }

    @WebMethod(operationName = "findLiquidaciones")
    public List<com.lam.to.ResumenLiquidacionTO> findLiquidaciones(@WebParam(name = "NumeroLiquidacion") Integer numeroLiquidacion) {
//
        List<com.lam.entidades.servicio.Liquidacion> liquidaciones = this.controladorLiquidacion.findEntities(numeroLiquidacion);
//
        Map<String, com.lam.to.ResumenLiquidacionTO> mapa = new HashMap<>();
//

        for (com.lam.entidades.servicio.Liquidacion l : liquidaciones) {
            if (l.getTipotransaccion().equals("Deduccion") || l.getTipotransaccion().equals("Percepcion")) {
                String llave = l.getNumeroliquidacion().toString();
                if (mapa.get(llave) == null) {
                    com.lam.to.ResumenLiquidacionTO resumen = new com.lam.to.ResumenLiquidacionTO();
                    resumen.setNumeroLiquidacion(l.getNumeroliquidacion());
                    resumen.setNumeroEmpleado(l.getNumeroempleado());
                    resumen.setEmpleado(l.getEmpleado());
                    Util.sumarResumenLiquidaciones(resumen, l, l.getTipotransaccion());
                    resumen.getDetalle().add(l);
                    mapa.put(llave, resumen);
                } else {
                    com.lam.to.ResumenLiquidacionTO resumen = mapa.get(llave);
                    resumen.setNumeroLiquidacion(l.getNumeroliquidacion());
                    resumen.setNumeroEmpleado(l.getNumeroempleado());
                    resumen.setEmpleado(l.getEmpleado());
                    Util.sumarResumenLiquidaciones(resumen, l, l.getTipotransaccion());
                    resumen.getDetalle().add(l);
                }
            }
        }
        if (mapa.isEmpty()) {
            return new ArrayList<>();
        }

        Iterator<com.lam.to.ResumenLiquidacionTO> iter = mapa.values().iterator();
        List<com.lam.to.ResumenLiquidacionTO> resumen = new ArrayList<>();

        while (iter.hasNext()) {
            com.lam.to.ResumenLiquidacionTO r = iter.next();
            resumen.add(r);
        }
        return resumen;
    }

    // MODULO FÓRMULAS
    @WebMethod(operationName = "getFormulas")
    public List<com.lam.entidades.servicio.Formula> getFormulas() {
        return this.controladorFormula.findAll();
    }

    @WebMethod(operationName = "createFormula")
    public boolean createFormula(@WebParam(name = "Calculo") String calculo,
            @WebParam(name = "Formula") String formula,
            @WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "Prioridad") Integer prioridad) {
//
        com.lam.entidades.servicio.Formula f = new com.lam.entidades.servicio.Formula();
//
        com.lam.entidades.servicio.Compania compania = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
//
        f.setCalculo(calculo);
        f.setFormula(formula);
        f.setIdcompania(compania);
        f.setPrioridad(prioridad);
        f.setFechaactualizacion(new Date());
//
        return this.controladorFormula.create(f);
    }

    @WebMethod(operationName = "editFormula")
    public boolean editFormula(@WebParam(name = "IdFormula") Integer idFormula,
            @WebParam(name = "Calculo") String calculo,
            @WebParam(name = "Formula") String formula,
            @WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "Prioridad") Integer prioridad) {
//
        com.lam.entidades.servicio.Formula f = (com.lam.entidades.servicio.Formula) this.controladorFormula.find(idFormula);
//
        com.lam.entidades.servicio.Compania compania = (com.lam.entidades.servicio.Compania) this.controladorCompania.find(idCompania);
//
        f.setCalculo(calculo);
        f.setFormula(formula);
        f.setIdcompania(compania);
        f.setPrioridad(prioridad);
        f.setFechaactualizacion(new Date());
//
        return this.controladorFormula.edit(f);
    }

    @WebMethod(operationName = "findFormulas")
    public List<com.lam.entidades.servicio.Formula> findFormulas(@WebParam(name = "Calculo") String calculo,
            @WebParam(name = "Formula") String formula,
            @WebParam(name = "IdCompania") Integer idCompania,
            @WebParam(name = "Prioridad") Integer prioridad) {
//
        return this.controladorFormula.findEntities(calculo, formula, idCompania, prioridad, null, null, null, null, null, null, null);
    }

    @WebMethod(operationName = "findFormulaByFormula")
    public com.lam.entidades.servicio.Formula findFormulaByFormula(@WebParam(name = "Calculo") String calculo) {
//
        com.lam.entidades.servicio.Formula formula = new com.lam.entidades.servicio.Formula();
//
        formula.setCalculo(calculo);
//
        return (com.lam.entidades.servicio.Formula) this.controladorFormula.find(formula);
    }
}
