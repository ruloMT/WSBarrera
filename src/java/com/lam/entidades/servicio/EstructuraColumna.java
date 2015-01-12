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
@Table(name = "admestructurascolumnastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstructuraColumna.findAll", query = "SELECT e FROM EstructuraColumna e"),
    @NamedQuery(name = "EstructuraColumna.findByIdcolumna", query = "SELECT e FROM EstructuraColumna e WHERE e.idcolumna = :idcolumna"),
    @NamedQuery(name = "EstructuraColumna.findByColumna", query = "SELECT e FROM EstructuraColumna e WHERE e.columna = :columna"),
    @NamedQuery(name = "EstructuraColumna.findByNombre", query = "SELECT e FROM EstructuraColumna e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstructuraColumna.findByTipodato", query = "SELECT e FROM EstructuraColumna e WHERE e.tipodato = :tipodato"),
    @NamedQuery(name = "EstructuraColumna.findByLongitud", query = "SELECT e FROM EstructuraColumna e WHERE e.longitud = :longitud")})
public class EstructuraColumna implements Serializable {

    @Column(name = "NUMERODECIMAL")
    private Integer numeroDecimal;
    @OneToMany(mappedBy = "idcolumna")
    private List<EstructuraRelacion> estructuraRelacionList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOLUMNA")
    private Integer idcolumna;
    @Size(max = 45)
    @Column(name = "COLUMNA")
    private String columna;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "TIPODATO")
    private String tipodato;
    @Column(name = "LONGITUD")
    private Integer longitud;
    @OneToMany(mappedBy = "idcolumna")
    private List<EstructuraDatos> estructuraDatosList;
    @JoinColumn(name = "IDLISTA", referencedColumnName = "IDLISTA")
    @ManyToOne
    private EstructuraLista idlista;

    public EstructuraColumna() {
    }

    public EstructuraColumna(Integer idcolumna) {
        this.idcolumna = idcolumna;
    }

    public Integer getIdcolumna() {
        return idcolumna;
    }

    public void setIdcolumna(Integer idcolumna) {
        this.idcolumna = idcolumna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipodato() {
        return tipodato;
    }

    public void setTipodato(String tipodato) {
        this.tipodato = tipodato;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    @XmlTransient
    public List<EstructuraDatos> getEstructuraDatosList() {
        return estructuraDatosList;
    }

    public void setEstructuraDatosList(List<EstructuraDatos> estructuraDatosList) {
        this.estructuraDatosList = estructuraDatosList;
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
        hash += (idcolumna != null ? idcolumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstructuraColumna)) {
            return false;
        }
        EstructuraColumna other = (EstructuraColumna) object;
        if ((this.idcolumna == null && other.idcolumna != null) || (this.idcolumna != null && !this.idcolumna.equals(other.idcolumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.EstructuraColumna[ idcolumna=" + idcolumna + " ]";
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    @XmlTransient
    public List<EstructuraRelacion> getEstructuraRelacionList() {
        return estructuraRelacionList;
    }

    public void setEstructuraRelacionList(List<EstructuraRelacion> estructuraRelacionList) {
        this.estructuraRelacionList = estructuraRelacionList;
    }

    public Integer getNumeroDecimal() {
        return numeroDecimal;
    }

    public void setNumeroDecimal(Integer numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }
    
}
