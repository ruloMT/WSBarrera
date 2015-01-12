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
@Table(name = "catconceptoslistastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConceptoLista.findAll", query = "SELECT c FROM ConceptoLista c"),
    @NamedQuery(name = "ConceptoLista.findByIdcatlista", query = "SELECT c FROM ConceptoLista c WHERE c.idcatlista = :idcatlista"),
    @NamedQuery(name = "ConceptoLista.findByIdLista", query = "SELECT c FROM ConceptoLista c WHERE c.idlista.idlista = :idlista"),
    @NamedQuery(name = "ConceptoLista.findByClave", query = "SELECT c FROM ConceptoLista c WHERE c.clave = :clave")})
public class ConceptoLista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATLISTA")
    private Integer idcatlista;
    @Size(max = 45)
    @Column(name = "CLAVE")
    private String clave;
    @JoinColumn(name = "IDLISTA", referencedColumnName = "IDLISTA")
    @ManyToOne
    private EstructuraLista idlista;

    public ConceptoLista() {
    }

    public ConceptoLista(Integer idcatlista) {
        this.idcatlista = idcatlista;
    }

    public Integer getIdcatlista() {
        return idcatlista;
    }

    public void setIdcatlista(Integer idcatlista) {
        this.idcatlista = idcatlista;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public EstructuraLista getIdlista() {
        return idlista;
    }

    public void setIdlista(EstructuraLista idlista) {
        this.idlista = idlista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatlista != null ? idcatlista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConceptoLista)) {
            return false;
        }
        ConceptoLista other = (ConceptoLista) object;
        if ((this.idcatlista == null && other.idcatlista != null) || (this.idcatlista != null && !this.idcatlista.equals(other.idcatlista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.ConceptoLista[ idcatlista=" + idcatlista + " ]";
    }
}
