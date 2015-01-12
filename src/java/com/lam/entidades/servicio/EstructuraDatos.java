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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "admestructurasdatostb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstructuraDatos.findAll", query = "SELECT e FROM EstructuraDatos e"),
    @NamedQuery(name = "EstructuraDatos.findByIdestructuradatos", query = "SELECT e FROM EstructuraDatos e WHERE e.idestructuradatos = :idestructuradatos"),
    @NamedQuery(name = "EstructuraDatos.findIdRellabAndIdEstructura", query = "SELECT e FROM EstructuraDatos e WHERE e.idrellab.idrellab = :idrellab AND e.idestructura.idestructura = :idestructura"),
    @NamedQuery(name = "EstructuraDatos.findIdColumna", query = "SELECT e FROM EstructuraDatos e WHERE e.idcolumna.idcolumna = :idcolumna"),
    @NamedQuery(name = "EstructuraDatos.findByValor", query = "SELECT e FROM EstructuraDatos e WHERE e.valor = :valor")})
public class EstructuraDatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDESTRUCTURADATOS")
    private Integer idestructuradatos;
    @Size(max = 45)
    @Column(name = "VALOR")
    private String valor;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @JoinColumn(name = "IDCOLUMNA", referencedColumnName = "IDCOLUMNA")
    @ManyToOne
    private EstructuraColumna idcolumna;
    @JoinColumn(name = "IDESTRUCTURA", referencedColumnName = "IDESTRUCTURA")
    @ManyToOne
    private Estructura idestructura;
    @Transient
    private List<ConceptoLista> conceptosLista;

    public EstructuraDatos() {
    }

    public EstructuraDatos(Integer idestructuradatos) {
        this.idestructuradatos = idestructuradatos;
    }

    public Integer getIdestructuradatos() {
        return idestructuradatos;
    }

    public void setIdestructuradatos(Integer idestructuradatos) {
        this.idestructuradatos = idestructuradatos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
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
        hash += (idestructuradatos != null ? idestructuradatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstructuraDatos)) {
            return false;
        }
        EstructuraDatos other = (EstructuraDatos) object;
        if ((this.idestructuradatos == null && other.idestructuradatos != null) || (this.idestructuradatos != null && !this.idestructuradatos.equals(other.idestructuradatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.EstructuraDatos[ idestructuradatos=" + idestructuradatos + " ]";
    }

    @Transient
    public List<ConceptoLista> getConceptosLista() {
        return conceptosLista;
    }

    @Transient
    public void setConceptosLista(List<ConceptoLista> conceptosLista) {
        this.conceptosLista = conceptosLista;
    }
}
