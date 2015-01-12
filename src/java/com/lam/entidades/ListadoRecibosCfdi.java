/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "recibos_listado_cfdi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListadoRecibosCfdi.findByTrabajador", query = "SELECT l FROM ListadoRecibosCfdi l WHERE l.concepto = :concepto AND l.trabajador = :trabajador")
})
public class ListadoRecibosCfdi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "trabajador")
    private String trabajador;
    @Column(name = "compania")
    private String compania;
    @Column(name = "clase_nomina")
    private String claseNomina;
    @Column(name = "id_calendario")
    private Integer idCalendario;
    @Column(name = "concepto")
    private Integer concepto;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "referencia2")
    private String referencia2;
    @Column(name = "secuencia")
    private Integer secuencia;
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name = "fecha2")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha2;
    @Column(name = "tiempo")
    private BigDecimal tiempo;
    @Column(name = "factor_01")
    private BigDecimal factor01;
    @Column(name = "factor_02")
    private BigDecimal factor02;
    @Column(name = "factor_03")
    private BigDecimal factor03;
    @Column(name = "importe_reportado")
    private BigDecimal importeReportado;
    @Column(name = "importe")
    private BigDecimal importe;
    @Column(name = "turno_trn")
    private Integer turnoTrn;
    @Column(name = "puesto_trn")
    private String puestoTrn;
    @Column(name = "agrupacion_01_trn")
    private String agrupacion01trn;
    @Column(name = "dato_01_trn")
    private String dato01trn;
    @Column(name = "agrupacion_02_trn")
    private String agrupacion02trn;
    @Column(name = "dato_03_trn")
    private String dato03trn;
    @Column(name = "agrupacion_03_trn")
    private String agrupacion03trn;
    @Column(name = "dato_04_trn")
    private String dato04trn;
    @Column(name = "agrupacion_04_trn")
    private String agrupacion04trn;
    @Column(name = "origen_transaccion")
    private Integer origenTransaccion;
    @Column(name = "usuario_registro")
    private String usuarioRegistro;
    @Column(name = "fecha_registro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "usuario_proceso")
    private String usuarioProceso;
    @Column(name = "fecha_proceso")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaProceso;
    @Column(name = "usuario_cambio")
    private String usuarioCambio;
    @Column(name = "fecha_cambio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCambio;
    @Column(name = "sit_transaccion")
    private Integer sitTransaccion;

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getClaseNomina() {
        return claseNomina;
    }

    public void setClaseNomina(String claseNomina) {
        this.claseNomina = claseNomina;
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Integer getConcepto() {
        return concepto;
    }

    public void setConcepto(Integer concepto) {
        this.concepto = concepto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public BigDecimal getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigDecimal tiempo) {
        this.tiempo = tiempo;
    }

    public BigDecimal getFactor01() {
        return factor01;
    }

    public void setFactor01(BigDecimal factor01) {
        this.factor01 = factor01;
    }

    public BigDecimal getFactor02() {
        return factor02;
    }

    public void setFactor02(BigDecimal factor02) {
        this.factor02 = factor02;
    }

    public BigDecimal getFactor03() {
        return factor03;
    }

    public void setFactor03(BigDecimal factor03) {
        this.factor03 = factor03;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getPuestoTrn() {
        return puestoTrn;
    }

    public void setPuestoTrn(String puestoTrn) {
        this.puestoTrn = puestoTrn;
    }

    public String getAgrupacion01trn() {
        return agrupacion01trn;
    }

    public void setAgrupacion01trn(String agrupacion01trn) {
        this.agrupacion01trn = agrupacion01trn;
    }

    public String getDato01trn() {
        return dato01trn;
    }

    public void setDato01trn(String dato01trn) {
        this.dato01trn = dato01trn;
    }

    public String getAgrupacion02trn() {
        return agrupacion02trn;
    }

    public void setAgrupacion02trn(String agrupacion02trn) {
        this.agrupacion02trn = agrupacion02trn;
    }

    public String getDato03trn() {
        return dato03trn;
    }

    public void setDato03trn(String dato03trn) {
        this.dato03trn = dato03trn;
    }

    public String getAgrupacion03trn() {
        return agrupacion03trn;
    }

    public void setAgrupacion03trn(String agrupacion03trn) {
        this.agrupacion03trn = agrupacion03trn;
    }

    public String getDato04trn() {
        return dato04trn;
    }

    public void setDato04trn(String dato04trn) {
        this.dato04trn = dato04trn;
    }

    public String getAgrupacion04trn() {
        return agrupacion04trn;
    }

    public void setAgrupacion04trn(String agrupacion04trn) {
        this.agrupacion04trn = agrupacion04trn;
    }

    public Integer getOrigenTransaccion() {
        return origenTransaccion;
    }

    public void setOrigenTransaccion(Integer origenTransaccion) {
        this.origenTransaccion = origenTransaccion;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioProceso() {
        return usuarioProceso;
    }

    public void setUsuarioProceso(String usuarioProceso) {
        this.usuarioProceso = usuarioProceso;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getUsuarioCambio() {
        return usuarioCambio;
    }

    public void setUsuarioCambio(String usuarioCambio) {
        this.usuarioCambio = usuarioCambio;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public Integer getSitTransaccion() {
        return sitTransaccion;
    }

    public void setSitTransaccion(Integer sitTransaccion) {
        this.sitTransaccion = sitTransaccion;
    }

    public BigDecimal getImporteReportado() {
        return importeReportado;
    }

    public void setImporteReportado(BigDecimal importeReportado) {
        this.importeReportado = importeReportado;
    }

    public Integer getTurnoTrn() {
        return turnoTrn;
    }

    public void setTurnoTrn(Integer turnoTrn) {
        this.turnoTrn = turnoTrn;
    }
}
