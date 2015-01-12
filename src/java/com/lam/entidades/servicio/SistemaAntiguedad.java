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
@Table(name = "nomsistemaantiguedadtb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaAntiguedad.findAll", query = "SELECT s FROM SistemaAntiguedad s ORDER BY s.nombre ASC"),
    @NamedQuery(name = "SistemaAntiguedad.findById", query = "SELECT s FROM SistemaAntiguedad s WHERE s.idsistemaantiguedad = :idsistemaantiguedad")
})
public class SistemaAntiguedad implements Serializable {
    @OneToMany(mappedBy = "idsistemaantiguedad")
    private List<RelacionLaboral> relacionLaboralList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSISTEMAANTIGUEDAD")
    private Integer idsistemaantiguedad;
    @Size(max = 45)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;

    public Integer getIdsistemaantiguedad() {
        return idsistemaantiguedad;
    }

    public void setIdsistemaantiguedad(Integer idsistemaantiguedad) {
        this.idsistemaantiguedad = idsistemaantiguedad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsistemaantiguedad != null ? idsistemaantiguedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaAntiguedad)) {
            return false;
        }
        SistemaAntiguedad other = (SistemaAntiguedad) object;
        if ((this.idsistemaantiguedad == null && other.idsistemaantiguedad != null) || (this.idsistemaantiguedad != null && !this.idsistemaantiguedad.equals(other.idsistemaantiguedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.SistemaAntiguedad[ idsistemaantiguedad=" + idsistemaantiguedad + " ]";
    }

    public SistemaAntiguedad() {
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }
}
