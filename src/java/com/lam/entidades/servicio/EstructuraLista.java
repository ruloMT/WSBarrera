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
@Table(name = "catlistastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstructuraLista.findAll", query = "SELECT e FROM EstructuraLista e"),
    @NamedQuery(name = "EstructuraLista.findByIdlista", query = "SELECT e FROM EstructuraLista e WHERE e.idlista = :idlista"),
    @NamedQuery(name = "EstructuraLista.findByLista", query = "SELECT e FROM EstructuraLista e WHERE e.lista = :lista"),
    @NamedQuery(name = "EstructuraLista.findByNombre", query = "SELECT e FROM EstructuraLista e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstructuraLista.findByNivel", query = "SELECT e FROM EstructuraLista e WHERE e.nivel = :nivel")})
public class EstructuraLista implements Serializable {

    @OneToMany(mappedBy = "idlista")
    private List<ConceptoLista> conceptoListaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLISTA")
    private Integer idlista;
    @Size(max = 45)
    @Column(name = "LISTA")
    private String lista;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "NIVEL")
    private String nivel;
    @OneToMany(mappedBy = "idlista")
    private List<EstructuraColumna> estructuraColumnaList;

    public EstructuraLista() {
    }

    public EstructuraLista(Integer idlista) {
        this.idlista = idlista;
    }

    public Integer getIdlista() {
        return idlista;
    }

    public void setIdlista(Integer idlista) {
        this.idlista = idlista;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<EstructuraColumna> getEstructuraColumnaList() {
        return estructuraColumnaList;
    }

    public void setEstructuraColumnaList(List<EstructuraColumna> estructuraColumnaList) {
        this.estructuraColumnaList = estructuraColumnaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlista != null ? idlista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstructuraLista)) {
            return false;
        }
        EstructuraLista other = (EstructuraLista) object;
        if ((this.idlista == null && other.idlista != null) || (this.idlista != null && !this.idlista.equals(other.idlista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.EstructuraLista[ idlista=" + idlista + " ]";
    }

    @XmlTransient
    public List<ConceptoLista> getConceptoListaList() {
        return conceptoListaList;
    }

    public void setConceptoListaList(List<ConceptoLista> conceptoListaList) {
        this.conceptoListaList = conceptoListaList;
    }
}
