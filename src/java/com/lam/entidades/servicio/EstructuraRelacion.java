/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "catcolumnasestucturastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstructuraRelacion.findAll", query = "SELECT e FROM EstructuraRelacion e"),
    @NamedQuery(name = "EstructuraRelacion.findIdEstructura", query = "SELECT e FROM EstructuraRelacion e WHERE e.idestructura.idestructura = :idestructura"),
    @NamedQuery(name = "EstructuraRelacion.findByIdcatalogo", query = "SELECT e FROM EstructuraRelacion e WHERE e.idcatalogo = :idcatalogo")})
public class EstructuraRelacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCATALOGO")
    private Integer idcatalogo;
    @JoinColumn(name = "IDCOLUMNA", referencedColumnName = "IDCOLUMNA")
    @ManyToOne
    private EstructuraColumna idcolumna;
    @JoinColumn(name = "IDESTRUCTURA", referencedColumnName = "IDESTRUCTURA")
    @ManyToOne
    private Estructura idestructura;

    public EstructuraRelacion() {
    }

    public EstructuraRelacion(Integer idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public Integer getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(Integer idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public EstructuraColumna getIdcolumna() {
        return idcolumna;
    }

    public void setIdcolumna(EstructuraColumna idcolumna) {
        this.idcolumna = idcolumna;
    }

    public Estructura getIdestructura() {
        return idestructura;
    }

    public void setIdestructura(Estructura idestructura) {
        this.idestructura = idestructura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatalogo != null ? idcatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstructuraRelacion)) {
            return false;
        }
        EstructuraRelacion other = (EstructuraRelacion) object;
        if ((this.idcatalogo == null && other.idcatalogo != null) || (this.idcatalogo != null && !this.idcatalogo.equals(other.idcatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.EstructuraRelacion[ idcatalogo=" + idcatalogo + " ]";
    }
}
