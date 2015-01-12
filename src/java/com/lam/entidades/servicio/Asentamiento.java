/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "catasentamientotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asentamiento.findAll", query = "SELECT a FROM Asentamiento a ORDER BY a.asentamiento ASC"),
    @NamedQuery(name = "Asentamiento.findByIdasentamiento", query = "SELECT a FROM Asentamiento a WHERE a.idasentamiento = :idasentamiento"),
    @NamedQuery(name = "Asentamiento.findByAsentamiento", query = "SELECT a FROM Asentamiento a WHERE a.asentamiento = :asentamiento"),
    @NamedQuery(name = "Asentamiento.findByCodigopostal", query = "SELECT a FROM Asentamiento a WHERE a.codigopostal = :codigopostal")})
public class Asentamiento implements Serializable {
    @OneToMany(mappedBy = "idasentamiento")
    private List<Domicilio> domicilioList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDASENTAMIENTO")
    private Integer idasentamiento;
    @Size(max = 255)
    @Column(name = "ASENTAMIENTO")
    private String asentamiento;
    @Size(max = 255)
    @Column(name = "CODIGOPOSTAL")
    private String codigopostal;
    @JoinColumn(name = "IDTIPOASENTAMIENTO", referencedColumnName = "IDTIPOASENTAMIENTO")
    @ManyToOne
    private TipoAsentamiento idtipoasentamiento;
    @JoinColumn(name = "IDCIUDAD", referencedColumnName = "IDCIUDAD")
    @ManyToOne
    private Ciudad idciudad;

    public Asentamiento() {
    }

    public Asentamiento(Integer idasentamiento) {
        this.idasentamiento = idasentamiento;
    }

    public Integer getIdasentamiento() {
        return idasentamiento;
    }

    public void setIdasentamiento(Integer idasentamiento) {
        this.idasentamiento = idasentamiento;
    }

    public String getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(String asentamiento) {
        this.asentamiento = asentamiento;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public TipoAsentamiento getIdtipoasentamiento() {
        return idtipoasentamiento;
    }

    public void setIdtipoasentamiento(TipoAsentamiento idtipoasentamiento) {
        this.idtipoasentamiento = idtipoasentamiento;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasentamiento != null ? idasentamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asentamiento)) {
            return false;
        }
        Asentamiento other = (Asentamiento) object;
        if ((this.idasentamiento == null && other.idasentamiento != null) || (this.idasentamiento != null && !this.idasentamiento.equals(other.idasentamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.Asentamiento[ idasentamiento=" + idasentamiento + " ]";
    }

    @XmlTransient
    public List<Domicilio> getDomicilioList() {
        return domicilioList;
    }

    public void setDomicilioList(List<Domicilio> domicilioList) {
        this.domicilioList = domicilioList;
    }
    
}
