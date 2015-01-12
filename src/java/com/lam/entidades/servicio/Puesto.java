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
@Table(name = "admpuestotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p ORDER BY p.nombre ASC"),
    @NamedQuery(name = "Puesto.findByIdpuesto", query = "SELECT p FROM Puesto p WHERE p.idpuesto = :idpuesto"),
    @NamedQuery(name = "Puesto.findByNombre", query = "SELECT p FROM Puesto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Puesto.findByPlazas", query = "SELECT p FROM Puesto p WHERE p.plazas = :plazas"),
    @NamedQuery(name = "Puesto.findByPlazasdisponibles", query = "SELECT p FROM Puesto p WHERE p.plazasdisponibles = :plazasdisponibles"),
    @NamedQuery(name = "Puesto.findByPlazasocupadas", query = "SELECT p FROM Puesto p WHERE p.plazasocupadas = :plazasocupadas"),
    @NamedQuery(name = "Puesto.findByPlazasreservadas", query = "SELECT p FROM Puesto p WHERE p.plazasreservadas = :plazasreservadas"),
    @NamedQuery(name = "Puesto.findByPuesto", query = "SELECT p FROM Puesto p WHERE p.puesto = :puesto")})
public class Puesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPUESTO")
    private Integer idpuesto;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PLAZAS")
    private Integer plazas;
    @Column(name = "PLAZASDISPONIBLES")
    private Integer plazasdisponibles;
    @Column(name = "PLAZASOCUPADAS")
    private Integer plazasocupadas;
    @Column(name = "PLAZASRESERVADAS")
    private Integer plazasreservadas;
    @Size(max = 255)
    @Column(name = "PUESTO")
    private String puesto;
    @OneToMany(mappedBy = "idpuesto")
    private List<RelacionLaboralPosicion> relacionLaboralPosicionList;
    @JoinColumn(name = "IDCOMPANIA", referencedColumnName = "IDCOMPANIA")
    @ManyToOne
    private Compania idcompania;

    public Puesto() {
    }

    public Puesto(Integer idpuesto) {
        this.idpuesto = idpuesto;
    }

    public Integer getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(Integer idpuesto) {
        this.idpuesto = idpuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPlazas() {
        return plazas;
    }

    public void setPlazas(Integer plazas) {
        this.plazas = plazas;
    }

    public Integer getPlazasdisponibles() {
        return plazasdisponibles;
    }

    public void setPlazasdisponibles(Integer plazasdisponibles) {
        this.plazasdisponibles = plazasdisponibles;
    }

    public Integer getPlazasocupadas() {
        return plazasocupadas;
    }

    public void setPlazasocupadas(Integer plazasocupadas) {
        this.plazasocupadas = plazasocupadas;
    }

    public Integer getPlazasreservadas() {
        return plazasreservadas;
    }

    public void setPlazasreservadas(Integer plazasreservadas) {
        this.plazasreservadas = plazasreservadas;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @XmlTransient
    public List<RelacionLaboralPosicion> getRelacionLaboralPosicionList() {
        return relacionLaboralPosicionList;
    }

    public void setRelacionLaboralPosicionList(List<RelacionLaboralPosicion> relacionLaboralPosicionList) {
        this.relacionLaboralPosicionList = relacionLaboralPosicionList;
    }

    public Compania getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(Compania idcompania) {
        this.idcompania = idcompania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpuesto != null ? idpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.idpuesto == null && other.idpuesto != null) || (this.idpuesto != null && !this.idpuesto.equals(other.idpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.Puesto[ idpuesto=" + idpuesto + " ]";
    }
    
}
