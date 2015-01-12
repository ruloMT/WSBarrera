/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iperez
 */
@Entity
@Table(name = "acum_conceptotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcumuladoConcepto.findAll", query = "SELECT a FROM AcumuladoConcepto a WHERE a.tiponomina = :tiponomina  AND a.grupopago = :grupopago AND a.anio = :anio AND a.periodo = :periodo"),
    @NamedQuery(name = "AcumuladoConcepto.findByIdacumconcepto", query = "SELECT a FROM AcumuladoConcepto a WHERE a.idacumconcepto = :idacumconcepto"),
    @NamedQuery(name = "AcumuladoConcepto.findByCompa\u00f1ia", query = "SELECT a FROM AcumuladoConcepto a WHERE a.compa\u00f1ia = :compa\u00f1ia"),
    @NamedQuery(name = "AcumuladoConcepto.findByNumeroempleado", query = "SELECT a FROM AcumuladoConcepto a WHERE a.numeroempleado = :numeroempleado"),
    @NamedQuery(name = "AcumuladoConcepto.findByEmpleado", query = "SELECT a FROM AcumuladoConcepto a WHERE a.empleado = :empleado"),
    @NamedQuery(name = "AcumuladoConcepto.findByTiponomina", query = "SELECT a FROM AcumuladoConcepto a WHERE a.tiponomina = :tiponomina"),
    @NamedQuery(name = "AcumuladoConcepto.findByNumeroconcepto", query = "SELECT a FROM AcumuladoConcepto a WHERE a.numeroconcepto = :numeroconcepto ORDER BY a.numeroempleado"),
    @NamedQuery(name = "AcumuladoConcepto.findByConcepto", query = "SELECT a FROM AcumuladoConcepto a WHERE a.concepto = :concepto"),
    @NamedQuery(name = "AcumuladoConcepto.findByAnio", query = "SELECT a FROM AcumuladoConcepto a WHERE a.anio = :anio"),
    @NamedQuery(name = "AcumuladoConcepto.findByMesacumular", query = "SELECT a FROM AcumuladoConcepto a WHERE a.mesacumular = :mesacumular"),
    @NamedQuery(name = "AcumuladoConcepto.findByPeriodo", query = "SELECT a FROM AcumuladoConcepto a WHERE a.periodo = :periodo"),
    @NamedQuery(name = "AcumuladoConcepto.findByFecha", query = "SELECT a FROM AcumuladoConcepto a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AcumuladoConcepto.findByReferencia", query = "SELECT a FROM AcumuladoConcepto a WHERE a.referencia = :referencia"),
    @NamedQuery(name = "AcumuladoConcepto.findByTiempo", query = "SELECT a FROM AcumuladoConcepto a WHERE a.tiempo = :tiempo"),
    @NamedQuery(name = "AcumuladoConcepto.findByImporte", query = "SELECT a FROM AcumuladoConcepto a WHERE a.importe = :importe"),
    @NamedQuery(name = "AcumuladoConcepto.findByTipotransaccion", query = "SELECT a FROM AcumuladoConcepto a WHERE a.tipotransaccion = :tipotransaccion")})
public class AcumuladoConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDACUMCONCEPTO")
    private Integer idacumconcepto;
    @Size(max = 45)
    @Column(name = "COMPANIA")
    private String compañia;
    @Size(max = 45)
    @Column(name = "NUMEROEMPLEADO")
    private String numeroempleado;
    @Size(max = 100)
    @Column(name = "EMPLEADO")
    private String empleado;
    @Size(max = 45)
    @Column(name = "TIPONOMINA")
    private String tiponomina;
    @Size(max = 45)
    @Column(name = "GRUPOPAGO")
    private String grupopago;
    @Size(max = 45)
    @Column(name = "NUMEROCONCEPTO")
    private String numeroconcepto;
    @Size(max = 100)
    @Column(name = "CONCEPTO")
    private String concepto;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "MESACUMULAR")
    private Integer mesacumular;
    @Column(name = "PERIODO")
    private Integer periodo;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "TIEMPO")
    private Double tiempo;
    @Column(name = "IMPORTE")
    private Double importe;
    @Size(max = 100)
    @Column(name = "TIPOTRANSACCION")
    private String tipotransaccion;
    @Size(max = 100)
    @Column(name = "CUENTA")
    private String cuenta;
    @Size(max = 45)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Transient
    private String fechaStr;

    public AcumuladoConcepto() {
    }

    public AcumuladoConcepto(Integer idacumconcepto) {
        this.idacumconcepto = idacumconcepto;
    }

    public Integer getIdacumconcepto() {
        return idacumconcepto;
    }

    public void setIdacumconcepto(Integer idacumconcepto) {
        this.idacumconcepto = idacumconcepto;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public String getNumeroempleado() {
        return numeroempleado;
    }

    public void setNumeroempleado(String numeroempleado) {
        this.numeroempleado = numeroempleado;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getTiponomina() {
        return tiponomina;
    }

    public void setTiponomina(String tiponomina) {
        this.tiponomina = tiponomina;
    }

    public String getGrupopago() {
        return grupopago;
    }

    public void setGrupopago(String grupopago) {
        this.grupopago = grupopago;
    }

    public String getNumeroconcepto() {
        return numeroconcepto;
    }

    public void setNumeroconcepto(String numeroconcepto) {
        this.numeroconcepto = numeroconcepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMesacumular() {
        return mesacumular;
    }

    public void setMesacumular(Integer mesacumular) {
        this.mesacumular = mesacumular;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getTiempo() {
        return tiempo;
    }

    public void setTiempo(Double tiempo) {
        this.tiempo = tiempo;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(String tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getFechaStr() {
        return fechaStr;
    }

    public void setFechaStr(String fechaStr) {
        this.fechaStr = fechaStr;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacumconcepto != null ? idacumconcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcumuladoConcepto)) {
            return false;
        }
        AcumuladoConcepto other = (AcumuladoConcepto) object;
        if ((this.idacumconcepto == null && other.idacumconcepto != null) || (this.idacumconcepto != null && !this.idacumconcepto.equals(other.idacumconcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.AcumuladoConcepto[ idacumconcepto=" + idacumconcepto + " ]";
    }
}
