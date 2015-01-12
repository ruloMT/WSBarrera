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
@Table(name = "rhcatconceptostb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoConcepto.findAll", query = "SELECT c FROM CatalogoConcepto c"),
    @NamedQuery(name = "CatalogoConcepto.findByTipo", query = "SELECT c FROM CatalogoConcepto c WHERE c.tipo = :tipo ORDER BY c.idconcepto.nombre ASC"),
    @NamedQuery(name = "CatalogoConcepto.findByTipoAndIdConcepto", query = "SELECT c FROM CatalogoConcepto c WHERE c.tipo = :tipo AND c.idconcepto.concepto = :concepto"),
    @NamedQuery(name = "CatalogoConcepto.findByIdcatconcepto", query = "SELECT c FROM CatalogoConcepto c WHERE c.idcatconcepto = :idcatconcepto")})
public class CatalogoConcepto implements Serializable {
    @OneToMany(mappedBy = "idcatconcepto")
    private List<Incidencia> incidenciaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATCONCEPTO")
    private Integer idcatconcepto;
    @Size(max = 45)
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumn(name = "IDCONCEPTO", referencedColumnName = "IDCONCEPTO")
    @ManyToOne
    private Concepto idconcepto;

    public CatalogoConcepto() {
    }

    public CatalogoConcepto(Integer idcatconcepto) {
        this.idcatconcepto = idcatconcepto;
    }

    public Integer getIdcatconcepto() {
        return idcatconcepto;
    }

    public void setIdcatconcepto(Integer idcatconcepto) {
        this.idcatconcepto = idcatconcepto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Concepto getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Concepto idconcepto) {
        this.idconcepto = idconcepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatconcepto != null ? idcatconcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoConcepto)) {
            return false;
        }
        CatalogoConcepto other = (CatalogoConcepto) object;
        if ((this.idcatconcepto == null && other.idcatconcepto != null) || (this.idcatconcepto != null && !this.idcatconcepto.equals(other.idcatconcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.CatalogoConcepto[ idcatconcepto=" + idcatconcepto + " ]";
    }

    @XmlTransient
    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }
    
}
