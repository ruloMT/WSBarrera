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
@Table(name = "admestructurastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estructura.findAll", query = "SELECT e FROM Estructura e"),
    @NamedQuery(name = "Estructura.findByIdestructura", query = "SELECT e FROM Estructura e WHERE e.idestructura = :idestructura"),
    @NamedQuery(name = "Estructura.findByEstructura", query = "SELECT e FROM Estructura e WHERE e.estructura = :estructura"),
    @NamedQuery(name = "Estructura.findByNombre", query = "SELECT e FROM Estructura e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estructura.findByNivel", query = "SELECT e FROM Estructura e WHERE e.nivel = :nivel")})
public class Estructura implements Serializable {
    @OneToMany(mappedBy = "idestructura")
    private List<EstructuraRelacion> estructuraRelacionList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESTRUCTURA")
    private Integer idestructura;
    @Size(max = 45)
    @Column(name = "ESTRUCTURA")
    private String estructura;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "NIVEL")
    private String nivel;
    @OneToMany(mappedBy = "idestructura")
    private List<EstructuraDatos> estructuraDatosList;

    public Estructura() {
    }

    public Estructura(Integer idestructura) {
        this.idestructura = idestructura;
    }

    public Integer getIdestructura() {
        return idestructura;
    }

    public void setIdestructura(Integer idestructura) {
        this.idestructura = idestructura;
    }

    public String getEstructura() {
        return estructura;
    }

    public void setEstructura(String estructura) {
        this.estructura = estructura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<EstructuraDatos> getEstructuraDatosList() {
        return estructuraDatosList;
    }

    public void setEstructuraDatosList(List<EstructuraDatos> estructuraDatosList) {
        this.estructuraDatosList = estructuraDatosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestructura != null ? idestructura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estructura)) {
            return false;
        }
        Estructura other = (Estructura) object;
        if ((this.idestructura == null && other.idestructura != null) || (this.idestructura != null && !this.idestructura.equals(other.idestructura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Estructura[ idestructura=" + idestructura + " ]";
    }

    @XmlTransient
    public List<EstructuraRelacion> getEstructuraRelacionList() {
        return estructuraRelacionList;
    }

    public void setEstructuraRelacionList(List<EstructuraRelacion> estructuraRelacionList) {
        this.estructuraRelacionList = estructuraRelacionList;
    }
    
}
