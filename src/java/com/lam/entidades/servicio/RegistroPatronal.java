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
@Table(name = "admregistropatronaltb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroPatronal.findAll", query = "SELECT r FROM RegistroPatronal r ORDER BY r.registropatronal ASC"),
    @NamedQuery(name = "RegistroPatronal.findByIdregistropatronal", query = "SELECT r FROM RegistroPatronal r WHERE r.idregistropatronal = :idregistropatronal"),
    @NamedQuery(name = "RegistroPatronal.findByComentarios", query = "SELECT r FROM RegistroPatronal r WHERE r.comentarios = :comentarios"),
    @NamedQuery(name = "RegistroPatronal.findByPrincipal", query = "SELECT r FROM RegistroPatronal r WHERE r.principal = :principal"),
    @NamedQuery(name = "RegistroPatronal.findByRegistropatronal", query = "SELECT r FROM RegistroPatronal r WHERE r.registropatronal = :registropatronal")})
public class RegistroPatronal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDREGISTROPATRONAL")
    private Integer idregistropatronal;
    @Size(max = 255)
    @Column(name = "COMENTARIOS")
    private String comentarios;
    @Column(name = "PRINCIPAL")
    private Integer principal;
    @Size(max = 255)
    @Column(name = "REGISTROPATRONAL")
    private String registropatronal;
    @JoinColumn(name = "IDCOMPANIA", referencedColumnName = "IDCOMPANIA")
    @ManyToOne
    private Compania idcompania;
    @OneToMany(mappedBy = "idregistropatronal")
    private List<RelacionLaboral> relacionLaboralList;

    public RegistroPatronal() {
    }

    public RegistroPatronal(Integer idregistropatronal) {
        this.idregistropatronal = idregistropatronal;
    }

    public Integer getIdregistropatronal() {
        return idregistropatronal;
    }

    public void setIdregistropatronal(Integer idregistropatronal) {
        this.idregistropatronal = idregistropatronal;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    public String getRegistropatronal() {
        return registropatronal;
    }

    public void setRegistropatronal(String registropatronal) {
        this.registropatronal = registropatronal;
    }

    public Compania getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(Compania idcompania) {
        this.idcompania = idcompania;
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
        hash += (idregistropatronal != null ? idregistropatronal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroPatronal)) {
            return false;
        }
        RegistroPatronal other = (RegistroPatronal) object;
        if ((this.idregistropatronal == null && other.idregistropatronal != null) || (this.idregistropatronal != null && !this.idregistropatronal.equals(other.idregistropatronal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.RegistroPatronal[ idregistropatronal=" + idregistropatronal + " ]";
    }
    
}
