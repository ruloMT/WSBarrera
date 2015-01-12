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
@Table(name = "rhtiporelacionlaboraltb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRelacionLaboral.findAll", query = "SELECT t FROM TipoRelacionLaboral t ORDER BY t.nombre ASC"),
    @NamedQuery(name = "TipoRelacionLaboral.findByIdtiporelacionlaboral", query = "SELECT t FROM TipoRelacionLaboral t WHERE t.idtiporelacionlaboral = :idtiporelacionlaboral"),
    @NamedQuery(name = "TipoRelacionLaboral.findByNombre", query = "SELECT t FROM TipoRelacionLaboral t WHERE t.nombre = :nombre")})
public class TipoRelacionLaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPORELACIONLABORAL")
    private Integer idtiporelacionlaboral;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idtiporellab")
    private List<RelacionLaboral> relacionLaboralList;

    public TipoRelacionLaboral() {
    }

    public TipoRelacionLaboral(Integer idtiporelacionlaboral) {
        this.idtiporelacionlaboral = idtiporelacionlaboral;
    }

    public Integer getIdtiporelacionlaboral() {
        return idtiporelacionlaboral;
    }

    public void setIdtiporelacionlaboral(Integer idtiporelacionlaboral) {
        this.idtiporelacionlaboral = idtiporelacionlaboral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiporelacionlaboral != null ? idtiporelacionlaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRelacionLaboral)) {
            return false;
        }
        TipoRelacionLaboral other = (TipoRelacionLaboral) object;
        if ((this.idtiporelacionlaboral == null && other.idtiporelacionlaboral != null) || (this.idtiporelacionlaboral != null && !this.idtiporelacionlaboral.equals(other.idtiporelacionlaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.TipoRelacionLaboral[ idtiporelacionlaboral=" + idtiporelacionlaboral + " ]";
    }
    
}
