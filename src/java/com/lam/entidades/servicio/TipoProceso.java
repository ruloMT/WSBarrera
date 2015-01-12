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
 * @author iperez
 */
@Entity
@Table(name = "nomtiposprocesostb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProceso.findAll", query = "SELECT t FROM TipoProceso t"),
    @NamedQuery(name = "TipoProceso.findByNombre", query = "SELECT t FROM TipoProceso t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoProceso.findById", query = "SELECT t FROM TipoProceso t WHERE t.idtipoproceso = :idtipoproceso")
})
public class TipoProceso implements Serializable {

    @OneToMany(mappedBy = "idtipoproceso")
    private List<Periodo> periodoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPOPROCESO")
    private Integer idtipoproceso;
    @Size(max = 45)
    @Column(name = "TIPOPROCESO")
    private String tipoproceso;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 11)
    @Column(name = "PERIODICIDAD")
    private Integer periodicidad;

    public TipoProceso() {
    }

    public Integer getIdtipoproceso() {
        return idtipoproceso;
    }

    public void setIdtipoproceso(Integer idtipoproceso) {
        this.idtipoproceso = idtipoproceso;
    }

    public String getTipoproceso() {
        return tipoproceso;
    }

    public void setTipoproceso(String tipoproceso) {
        this.tipoproceso = tipoproceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Integer periodicidad) {
        this.periodicidad = periodicidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoproceso != null ? idtipoproceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoProceso)) {
            return false;
        }
        TipoProceso other = (TipoProceso) object;
        if ((this.idtipoproceso == null && other.idtipoproceso != null) || (this.idtipoproceso != null && !this.idtipoproceso.equals(other.idtipoproceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.TipoProceso[ idtipoproceso=" + idtipoproceso + " ]";
    }

    @XmlTransient
    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }
}
