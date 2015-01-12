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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "vacsadelantadastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdelantoVacaciones.findAll", query = "SELECT a FROM AdelantoVacaciones a"),
    @NamedQuery(name = "AdelantoVacaciones.findByIdRellab", query = "SELECT a FROM AdelantoVacaciones a WHERE a.idrellab.idrellab = :idrellab"),
    @NamedQuery(name = "AdelantoVacaciones.findByDiasadelantados", query = "SELECT a FROM AdelantoVacaciones a WHERE a.diasadelantados = :diasadelantados"),
    @NamedQuery(name = "AdelantoVacaciones.findBySaldo", query = "SELECT a FROM AdelantoVacaciones a WHERE a.saldo = :saldo"),
    @NamedQuery(name = "AdelantoVacaciones.findByFecharegistro", query = "SELECT a FROM AdelantoVacaciones a WHERE a.fecharegistro = :fecharegistro")})
public class AdelantoVacaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDADELANTADA")
    private Integer idadelantada;
    @Column(name = "DIASADELANTADOS")
    private Integer diasadelantados;
    @Column(name = "SALDO")
    private Integer saldo;
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @Transient
    private String fechaStr;

    public AdelantoVacaciones() {
    }

    public AdelantoVacaciones(Integer idadelantada) {
        this.idadelantada = idadelantada;
    }

    public Integer getIdadelantada() {
        return idadelantada;
    }

    public void setIdadelantada(Integer idadelantada) {
        this.idadelantada = idadelantada;
    }

    public Integer getDiasadelantados() {
        return diasadelantados;
    }

    public void setDiasadelantados(Integer diasadelantados) {
        this.diasadelantados = diasadelantados;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadelantada != null ? idadelantada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdelantoVacaciones)) {
            return false;
        }
        AdelantoVacaciones other = (AdelantoVacaciones) object;
        if ((this.idadelantada == null && other.idadelantada != null) || (this.idadelantada != null && !this.idadelantada.equals(other.idadelantada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.AdelantoVacaciones[ idadelantada=" + idadelantada + " ]";
    }

    public String getFechaStr() {
        return fechaStr;
    }

    public void setFechaStr(String fechaStr) {
        this.fechaStr = fechaStr;
    }
}
