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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iperez
 */
@Entity
@Table(name = "liquidacionestb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liquidacion.findAll", query = "SELECT l FROM Liquidacion l ORDER BY l.numeroempleado"),
    @NamedQuery(name = "Liquidacion.findByIdliquidacion", query = "SELECT l FROM Liquidacion l WHERE l.idliquidacion = :idliquidacion"),
    @NamedQuery(name = "Liquidacion.findByCompania", query = "SELECT l FROM Liquidacion l WHERE l.compania = :compania"),
    @NamedQuery(name = "Liquidacion.findByNumeroempleado", query = "SELECT l FROM Liquidacion l WHERE l.numeroempleado = :numeroempleado"),
    @NamedQuery(name = "Liquidacion.findByEmpleado", query = "SELECT l FROM Liquidacion l WHERE l.empleado = :empleado"),
    @NamedQuery(name = "Liquidacion.findByTiponomina", query = "SELECT l FROM Liquidacion l WHERE l.tiponomina = :tiponomina"),
    @NamedQuery(name = "Liquidacion.findByGrupopago", query = "SELECT l FROM Liquidacion l WHERE l.grupopago = :grupopago"),
    @NamedQuery(name = "Liquidacion.findByDepartamento", query = "SELECT l FROM Liquidacion l WHERE l.departamento = :departamento"),
    @NamedQuery(name = "Liquidacion.findByAnio", query = "SELECT l FROM Liquidacion l WHERE l.anio = :anio"),
    @NamedQuery(name = "Liquidacion.findByMesacumular", query = "SELECT l FROM Liquidacion l WHERE l.mesacumular = :mesacumular"),
    @NamedQuery(name = "Liquidacion.findByNumeroliquidacion", query = "SELECT l FROM Liquidacion l WHERE l.numeroliquidacion = :numeroliquidacion"),
    @NamedQuery(name = "Liquidacion.findByNumeroconcepto", query = "SELECT l FROM Liquidacion l WHERE l.numeroconcepto = :numeroconcepto"),
    @NamedQuery(name = "Liquidacion.findByConcepto", query = "SELECT l FROM Liquidacion l WHERE l.concepto = :concepto"),
    @NamedQuery(name = "Liquidacion.findByFechaliquidacion", query = "SELECT l FROM Liquidacion l WHERE l.fechaliquidacion = :fechaliquidacion"),
    @NamedQuery(name = "Liquidacion.findByReferencia", query = "SELECT l FROM Liquidacion l WHERE l.referencia = :referencia"),
    @NamedQuery(name = "Liquidacion.findBySecuencia", query = "SELECT l FROM Liquidacion l WHERE l.secuencia = :secuencia"),
    @NamedQuery(name = "Liquidacion.findByTiempo", query = "SELECT l FROM Liquidacion l WHERE l.tiempo = :tiempo"),
    @NamedQuery(name = "Liquidacion.findByImporte", query = "SELECT l FROM Liquidacion l WHERE l.importe = :importe"),
    @NamedQuery(name = "Liquidacion.findByCuenta", query = "SELECT l FROM Liquidacion l WHERE l.cuenta = :cuenta"),
    @NamedQuery(name = "Liquidacion.findByTipotransaccion", query = "SELECT l FROM Liquidacion l WHERE l.tipotransaccion = :tipotransaccion"),
    @NamedQuery(name = "Liquidacion.findByFechaact", query = "SELECT l FROM Liquidacion l WHERE l.fechaact = :fechaact")})
public class Liquidacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLIQUIDACION")
    private Integer idliquidacion;
    @Size(max = 45)
    @Column(name = "COMPANIA")
    private String compania;
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
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "MESACUMULAR")
    private Integer mesacumular;
    @Column(name = "NUMEROLIQUIDACION")
    private Integer numeroliquidacion;
    @Size(max = 45)
    @Column(name = "NUMEROCONCEPTO")
    private String numeroconcepto;
    @Size(max = 100)
    @Column(name = "CONCEPTO")
    private String concepto;
    @Column(name = "FECHALIQUIDACION")
    @Temporal(TemporalType.DATE)
    private Date fechaliquidacion;
    @Size(max = 100)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "SECUENCIA")
    private Integer secuencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TIEMPO")
    private Double tiempo;
    @Column(name = "IMPORTE")
    private Double importe;
    @Size(max = 100)
    @Column(name = "CUENTA")
    private String cuenta;
    @Size(max = 45)
    @Column(name = "TIPOTRANSACCION")
    private String tipotransaccion;
    @Column(name = "FECHAACT")
    @Temporal(TemporalType.DATE)
    private Date fechaact;

    public Liquidacion() {
    }

    public Liquidacion(Integer idliquidacion) {
        this.idliquidacion = idliquidacion;
    }

    public Integer getIdliquidacion() {
        return idliquidacion;
    }

    public void setIdliquidacion(Integer idliquidacion) {
        this.idliquidacion = idliquidacion;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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

    public Integer getNumeroliquidacion() {
        return numeroliquidacion;
    }

    public void setNumeroliquidacion(Integer numeroliquidacion) {
        this.numeroliquidacion = numeroliquidacion;
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

    public Date getFechaliquidacion() {
        return fechaliquidacion;
    }

    public void setFechaliquidacion(Date fechaliquidacion) {
        this.fechaliquidacion = fechaliquidacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
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

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(String tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public Date getFechaact() {
        return fechaact;
    }

    public void setFechaact(Date fechaact) {
        this.fechaact = fechaact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idliquidacion != null ? idliquidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liquidacion)) {
            return false;
        }
        Liquidacion other = (Liquidacion) object;
        if ((this.idliquidacion == null && other.idliquidacion != null) || (this.idliquidacion != null && !this.idliquidacion.equals(other.idliquidacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Liquidacion[ idliquidacion=" + idliquidacion + " ]";
    }
    
}
