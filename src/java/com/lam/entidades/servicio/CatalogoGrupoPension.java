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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhrellabpenconceptostb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoGrupoPension.findAll", query = "SELECT c FROM CatalogoGrupoPension c ORDER BY c.idpension.nombre ASC"),
    @NamedQuery(name = "CatalogoGrupoPension.findIdPension", query = "SELECT c FROM CatalogoGrupoPension c WHERE c.idpension.idpension = :idpension"),
    @NamedQuery(name = "CatalogoGrupoPension.findByIdCatalogo", query = "SELECT c FROM CatalogoGrupoPension c WHERE c.idcatgrupo = :idcatgrupo"),
    @NamedQuery(name = "CatalogoGrupoPension.findByIdGrupo", query = "SELECT c FROM CatalogoGrupoPension c WHERE c.idpension.idpension = :idpension")
})
public class CatalogoGrupoPension implements Serializable {
//

    private static final long serialVersionUID = 1L;
//    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRELLABPENCONCEPTO")
    private Integer idcatgrupo;
    @Size(max = 1)
    @Column(name = "SIGNO")
    private String signo;
//    
    @JoinColumn(name = "IDCONCEPTO", referencedColumnName = "IDCONCEPTO")
    @ManyToOne
    private Concepto idconcepto;
    @JoinColumn(name = "IDRELLABPENSION", referencedColumnName = "IDRELLABPENSION")
    @ManyToOne
    private Pension idpension;

    public CatalogoGrupoPension() {
    }

    public Integer getIdcatgrupo() {
        return idcatgrupo;
    }

    public void setIdcatgrupo(Integer idcatgrupo) {
        this.idcatgrupo = idcatgrupo;
    }

    public Concepto getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Concepto idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Pension getIdpension() {
        return idpension;
    }

    public void setIdpension(Pension idpension) {
        this.idpension = idpension;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.CatalogoGrupoPension[ idcatgrupo=" + idcatgrupo + " ]";
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
        if (!(object instanceof CatalogoGrupoPension)) {
            return false;
        }
        CatalogoGrupoPension other = (CatalogoGrupoPension) object;
        if ((this.idcatgrupo == null && other.idcatgrupo != null) || (this.idcatgrupo != null && !this.idcatgrupo.equals(other.idcatgrupo))) {
            return false;
        }
        return true;
    }
}
