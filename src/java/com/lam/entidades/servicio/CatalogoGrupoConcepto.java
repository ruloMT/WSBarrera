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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhcatgrupoconceptos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoGrupoConcepto.findAll", query = "SELECT c FROM CatalogoGrupoConcepto c"),
    @NamedQuery(name = "CatalogoGrupoConcepto.findByIdGrupoConcepto", query = "SELECT c FROM CatalogoGrupoConcepto c WHERE c.idgrupoconcepto.idgrupoconcepto = :idgrupoconcepto"),
    @NamedQuery(name = "CatalogoGrupoConcepto.findByIdCatalogoGrupo", query = "SELECT c FROM CatalogoGrupoConcepto c WHERE c.idcatgrupo = :idcatgrupo"),
    @NamedQuery(name = "CatalogoGrupoConcepto.findBySigno", query = "SELECT c FROM CatalogoGrupoConcepto c WHERE c.signo = :signo")})
public class CatalogoGrupoConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATGRUPO")
    private Integer idcatgrupo;
    @Size(max = 2)
    @Column(name = "SIGNO")
    private String signo;
    @JoinColumn(name = "IDGRUPOCONCEPTO", referencedColumnName = "IDGRUPOCONCEPTO")
    @ManyToOne
    private GrupoConcepto idgrupoconcepto;
    @JoinColumn(name = "IDCONCEPTO", referencedColumnName = "IDCONCEPTO")
    @ManyToOne
    private Concepto idconcepto;
    @Transient
    private String estatus;

    public CatalogoGrupoConcepto() {
    }

    public CatalogoGrupoConcepto(Integer idcatgrupo) {
        this.idcatgrupo = idcatgrupo;
    }

    public Integer getIdcatgrupo() {
        return idcatgrupo;
    }

    public void setIdcatgrupo(Integer idcatgrupo) {
        this.idcatgrupo = idcatgrupo;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public GrupoConcepto getIdgrupoconcepto() {
        return idgrupoconcepto;
    }

    public void setIdgrupoconcepto(GrupoConcepto idgrupoconcepto) {
        this.idgrupoconcepto = idgrupoconcepto;
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
        hash += (idcatgrupo != null ? idcatgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoGrupoConcepto)) {
            return false;
        }
        CatalogoGrupoConcepto other = (CatalogoGrupoConcepto) object;
        if ((this.idcatgrupo == null && other.idcatgrupo != null) || (this.idcatgrupo != null && !this.idcatgrupo.equals(other.idcatgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.CatalogoGrupoConcepto[ idcatgrupo=" + idcatgrupo + " ]";
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
