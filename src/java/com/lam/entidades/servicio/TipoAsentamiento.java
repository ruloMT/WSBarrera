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
@Table(name = "cattipoasentamientotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAsentamiento.findAll", query = "SELECT t FROM TipoAsentamiento t ORDER BY t.nombre ASC"),
    @NamedQuery(name = "TipoAsentamiento.findByIdtipoasentamiento", query = "SELECT t FROM TipoAsentamiento t WHERE t.idtipoasentamiento = :idtipoasentamiento"),
    @NamedQuery(name = "TipoAsentamiento.findByNombre", query = "SELECT t FROM TipoAsentamiento t WHERE t.nombre = :nombre")})
public class TipoAsentamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPOASENTAMIENTO")
    private Integer idtipoasentamiento;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idtipoasentamiento")
    private List<Asentamiento> asentamientoList;

    public TipoAsentamiento() {
    }

    public TipoAsentamiento(Integer idtipoasentamiento) {
        this.idtipoasentamiento = idtipoasentamiento;
    }

    public Integer getIdtipoasentamiento() {
        return idtipoasentamiento;
    }

    public void setIdtipoasentamiento(Integer idtipoasentamiento) {
        this.idtipoasentamiento = idtipoasentamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Asentamiento> getAsentamientoList() {
        return asentamientoList;
    }

    public void setAsentamientoList(List<Asentamiento> asentamientoList) {
        this.asentamientoList = asentamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoasentamiento != null ? idtipoasentamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAsentamiento)) {
            return false;
        }
        TipoAsentamiento other = (TipoAsentamiento) object;
        if ((this.idtipoasentamiento == null && other.idtipoasentamiento != null) || (this.idtipoasentamiento != null && !this.idtipoasentamiento.equals(other.idtipoasentamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.TipoAsentamiento[ idtipoasentamiento=" + idtipoasentamiento + " ]";
    }
    
}
