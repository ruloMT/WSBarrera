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
@Table(name = "rhtipodoctotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t ORDER BY t.nombre ASC"),
    @NamedQuery(name = "TipoDocumento.findByIdtipodocto", query = "SELECT t FROM TipoDocumento t WHERE t.idtipodocto = :idtipodocto"),
    @NamedQuery(name = "TipoDocumento.findByNombre", query = "SELECT t FROM TipoDocumento t WHERE t.nombre = :nombre")})
public class TipoDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPODOCTO")
    private Integer idtipodocto;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idtipodocto")
    private List<Documento> documentoList;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idtipodocto) {
        this.idtipodocto = idtipodocto;
    }

    public Integer getIdtipodocto() {
        return idtipodocto;
    }

    public void setIdtipodocto(Integer idtipodocto) {
        this.idtipodocto = idtipodocto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipodocto != null ? idtipodocto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idtipodocto == null && other.idtipodocto != null) || (this.idtipodocto != null && !this.idtipodocto.equals(other.idtipodocto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.TipoDocumento[ idtipodocto=" + idtipodocto + " ]";
    }
    
}
