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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhempleadodomiciliotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d"),
    @NamedQuery(name = "Domicilio.findByIdEmpleado", query = "SELECT d FROM Domicilio d WHERE d.idempleado.idempleado = :idempleado"),
    @NamedQuery(name = "Domicilio.findEmpleado", query = "SELECT d FROM Domicilio d WHERE d.idempleado.idempleado = :idempleado"),
    @NamedQuery(name = "Domicilio.findByIddomicilio", query = "SELECT d FROM Domicilio d WHERE d.iddomicilio = :iddomicilio"),
    @NamedQuery(name = "Domicilio.findByCalle", query = "SELECT d FROM Domicilio d WHERE d.calle = :calle"),
    @NamedQuery(name = "Domicilio.findByCoordenadax", query = "SELECT d FROM Domicilio d WHERE d.coordenadax = :coordenadax"),
    @NamedQuery(name = "Domicilio.findByCoordenaday", query = "SELECT d FROM Domicilio d WHERE d.coordenaday = :coordenaday"),
    @NamedQuery(name = "Domicilio.findByEstatus", query = "SELECT d FROM Domicilio d WHERE d.estatus = :estatus"),
    @NamedQuery(name = "Domicilio.findByFecha", query = "SELECT d FROM Domicilio d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Domicilio.findByNumeroexterior", query = "SELECT d FROM Domicilio d WHERE d.numeroexterior = :numeroexterior"),
    @NamedQuery(name = "Domicilio.findByNumerointerior", query = "SELECT d FROM Domicilio d WHERE d.numerointerior = :numerointerior"),
    @NamedQuery(name = "Domicilio.findByTipodomicilio", query = "SELECT d FROM Domicilio d WHERE d.tipodomicilio = :tipodomicilio")})
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDOMICILIO")
    private Integer iddomicilio;
    @Size(max = 255)
    @Column(name = "CALLE")
    private String calle;
    @Size(max = 255)
    @Column(name = "COORDENADAX")
    private String coordenadax;
    @Size(max = 255)
    @Column(name = "COORDENADAY")
    private String coordenaday;
    @Size(max = 255)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "NUMEROEXTERIOR")
    private String numeroexterior;
    @Size(max = 255)
    @Column(name = "NUMEROINTERIOR")
    private String numerointerior;
    @Size(max = 255)
    @Column(name = "TIPODOMICILIO")
    private String tipodomicilio;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne
    private Empleado idempleado;
    @JoinColumn(name = "IDASENTAMIENTO", referencedColumnName = "IDASENTAMIENTO")
    @ManyToOne
    private Asentamiento idasentamiento;

    public Domicilio() {
    }

    public Domicilio(Integer iddomicilio) {
        this.iddomicilio = iddomicilio;
    }

    public Integer getIddomicilio() {
        return iddomicilio;
    }

    public void setIddomicilio(Integer iddomicilio) {
        this.iddomicilio = iddomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCoordenadax() {
        return coordenadax;
    }

    public void setCoordenadax(String coordenadax) {
        this.coordenadax = coordenadax;
    }

    public String getCoordenaday() {
        return coordenaday;
    }

    public void setCoordenaday(String coordenaday) {
        this.coordenaday = coordenaday;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroexterior() {
        return numeroexterior;
    }

    public void setNumeroexterior(String numeroexterior) {
        this.numeroexterior = numeroexterior != null ? numeroexterior.trim().toUpperCase() : null;
    }

    public String getNumerointerior() {
        return numerointerior;
    }

    public void setNumerointerior(String numerointerior) {
        this.numerointerior = numerointerior != null ? numerointerior.trim().toUpperCase() : null;
    }

    public String getTipodomicilio() {
        return tipodomicilio;
    }

    public void setTipodomicilio(String tipodomicilio) {
        this.tipodomicilio = tipodomicilio;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    public Asentamiento getIdasentamiento() {
        return idasentamiento;
    }

    public void setIdasentamiento(Asentamiento idasentamiento) {
        this.idasentamiento = idasentamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddomicilio != null ? iddomicilio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.iddomicilio == null && other.iddomicilio != null) || (this.iddomicilio != null && !this.iddomicilio.equals(other.iddomicilio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.Domicilio[ iddomicilio=" + iddomicilio + " ]";
    }
}
