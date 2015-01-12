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
@Table(name = "rhtiposueldotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSueldo.findAll", query = "SELECT t FROM TipoSueldo t ORDER BY t.nombre ASC"),
    @NamedQuery(name = "TipoSueldo.findByIdtiposueldo", query = "SELECT t FROM TipoSueldo t WHERE t.idtiposueldo = :idtiposueldo"),
    @NamedQuery(name = "TipoSueldo.findByNombre", query = "SELECT t FROM TipoSueldo t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoSueldo.findByPeriodicidad", query = "SELECT t FROM TipoSueldo t WHERE t.periodicidad = :periodicidad"),
    @NamedQuery(name = "TipoSueldo.findByTiposueldo", query = "SELECT t FROM TipoSueldo t WHERE t.tiposueldo = :tiposueldo")})
public class TipoSueldo implements Serializable {
    @OneToMany(mappedBy = "idtiposueldo")
    private List<PosicionSueldoHistorico> posicionSueldoHistoricoList;
    @OneToMany(mappedBy = "idtiposueldo")
    private List<PosicionSueldo> posicionSueldoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPOSUELDO")
    private Integer idtiposueldo;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PERIODICIDAD")
    private Integer periodicidad;
    @Size(max = 255)
    @Column(name = "TIPOSUELDO")
    private String tiposueldo;
    @OneToMany(mappedBy = "idtiposueldo")
    private List<RelacionLaboralPosicion> relacionLaboralPosicionList;

    public TipoSueldo() {
    }

    public TipoSueldo(Integer idtiposueldo) {
        this.idtiposueldo = idtiposueldo;
    }

    public Integer getIdtiposueldo() {
        return idtiposueldo;
    }

    public void setIdtiposueldo(Integer idtiposueldo) {
        this.idtiposueldo = idtiposueldo;
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

    public String getTiposueldo() {
        return tiposueldo;
    }

    public void setTiposueldo(String tiposueldo) {
        this.tiposueldo = tiposueldo;
    }

    @XmlTransient
    public List<RelacionLaboralPosicion> getRelacionLaboralPosicionList() {
        return relacionLaboralPosicionList;
    }

    public void setRelacionLaboralPosicionList(List<RelacionLaboralPosicion> relacionLaboralPosicionList) {
        this.relacionLaboralPosicionList = relacionLaboralPosicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiposueldo != null ? idtiposueldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSueldo)) {
            return false;
        }
        TipoSueldo other = (TipoSueldo) object;
        if ((this.idtiposueldo == null && other.idtiposueldo != null) || (this.idtiposueldo != null && !this.idtiposueldo.equals(other.idtiposueldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.TipoSueldo[ idtiposueldo=" + idtiposueldo + " ]";
    }

    @XmlTransient
    public List<PosicionSueldo> getPosicionSueldoList() {
        return posicionSueldoList;
    }

    public void setPosicionSueldoList(List<PosicionSueldo> posicionSueldoList) {
        this.posicionSueldoList = posicionSueldoList;
    }

    @XmlTransient
    public List<PosicionSueldoHistorico> getPosicionSueldoHistoricoList() {
        return posicionSueldoHistoricoList;
    }

    public void setPosicionSueldoHistoricoList(List<PosicionSueldoHistorico> posicionSueldoHistoricoList) {
        this.posicionSueldoHistoricoList = posicionSueldoHistoricoList;
    }
    
}
