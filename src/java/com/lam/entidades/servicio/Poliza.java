/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author iperez
 */
@Entity
@Table(name = "polizatb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poliza.findAll", query = "SELECT p FROM Poliza p"),
    @NamedQuery(name = "Poliza.findByIdpoliza", query = "SELECT p FROM Poliza p WHERE p.idpoliza = :idpoliza"),
    @NamedQuery(name = "Poliza.findByPoliza", query = "SELECT p FROM Poliza p WHERE p.poliza = :poliza"),
    @NamedQuery(name = "Poliza.findBySecuencia", query = "SELECT p FROM Poliza p WHERE p.secuencia = :secuencia"),
    @NamedQuery(name = "Poliza.findByCodificacion", query = "SELECT p FROM Poliza p WHERE p.codificacion = :codificacion"),
    @NamedQuery(name = "Poliza.findByNumeroconcepto", query = "SELECT p FROM Poliza p WHERE p.numeroconcepto = :numeroconcepto"),
    @NamedQuery(name = "Poliza.findByConcepto", query = "SELECT p FROM Poliza p WHERE p.concepto = :concepto"),
    @NamedQuery(name = "Poliza.findByCargo", query = "SELECT p FROM Poliza p WHERE p.cargo = :cargo"),
    @NamedQuery(name = "Poliza.findByAbono", query = "SELECT p FROM Poliza p WHERE p.abono = :abono")})
public class Poliza implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPOLIZA")
    private Integer idpoliza;
    @Size(max = 45)
    @Column(name = "POLIZA")
    private String poliza;
    @Column(name = "SECUENCIA")
    private Integer secuencia;
    @Size(max = 1000)
    @Column(name = "CODIFICACION")
    private String codificacion;
    @Size(max = 45)
    @Column(name = "NUMEROCONCEPTO")
    private String numeroconcepto;
    @Size(max = 100)
    @Column(name = "CONCEPTO")
    private String concepto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CARGO")
    private Double cargo;
    @Column(name = "ABONO")
    private Double abono;

    public Poliza() {
    }

    public Poliza(Integer idpoliza) {
        this.idpoliza = idpoliza;
    }

    public Integer getIdpoliza() {
        return idpoliza;
    }

    public void setIdpoliza(Integer idpoliza) {
        this.idpoliza = idpoliza;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getCodificacion() {
        return codificacion;
    }

    public void setCodificacion(String codificacion) {
        this.codificacion = codificacion;
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

    public Double getCargo() {
        return cargo;
    }

    public void setCargo(Double cargo) {
        this.cargo = cargo;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpoliza != null ? idpoliza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poliza)) {
            return false;
        }
        Poliza other = (Poliza) object;
        if ((this.idpoliza == null && other.idpoliza != null) || (this.idpoliza != null && !this.idpoliza.equals(other.idpoliza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Poliza[ idpoliza=" + idpoliza + " ]";
    }
    
}
