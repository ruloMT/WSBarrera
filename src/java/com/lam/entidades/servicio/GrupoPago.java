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
@Table(name = "nomgrupopagotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoPago.findAll", query = "SELECT g FROM GrupoPago g ORDER BY g.nombre ASC"),
    @NamedQuery(name = "GrupoPago.findIdCompania", query = "SELECT g FROM GrupoPago g WHERE g.idcompania.idcompania = :idcompania ORDER BY g.nombre ASC"),
    @NamedQuery(name = "GrupoPago.findByIdgrupopago", query = "SELECT g FROM GrupoPago g WHERE g.idgrupopago = :idgrupopago"),
    @NamedQuery(name = "GrupoPago.findByGrupopago", query = "SELECT g FROM GrupoPago g WHERE g.grupopago = :grupopago"),
    @NamedQuery(name = "GrupoPago.findByNombre", query = "SELECT g FROM GrupoPago g WHERE g.nombre = :nombre")})
public class GrupoPago implements Serializable {
    @OneToMany(mappedBy = "idgrupopago")
    private List<ConfiguracionVacaciones> configuracionVacacionesList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDGRUPOPAGO")
    private Integer idgrupopago;
    @Size(max = 255)
    @Column(name = "GRUPOPAGO")
    private String grupopago;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idgrupopago")
    private List<RelacionLaboral> relacionLaboralList;
    @JoinColumn(name = "IDCOMPANIA", referencedColumnName = "IDCOMPANIA")
    @ManyToOne
    private Compania idcompania;

    public GrupoPago() {
    }

    public GrupoPago(Integer idgrupopago) {
        this.idgrupopago = idgrupopago;
    }

    public Integer getIdgrupopago() {
        return idgrupopago;
    }

    public void setIdgrupopago(Integer idgrupopago) {
        this.idgrupopago = idgrupopago;
    }

    public String getGrupopago() {
        return grupopago;
    }

    public void setGrupopago(String grupopago) {
        this.grupopago = grupopago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
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
        hash += (idgrupopago != null ? idgrupopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoPago)) {
            return false;
        }
        GrupoPago other = (GrupoPago) object;
        if ((this.idgrupopago == null && other.idgrupopago != null) || (this.idgrupopago != null && !this.idgrupopago.equals(other.idgrupopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.GrupoPago[ idgrupopago=" + idgrupopago + " ]";
    }

    @XmlTransient
    public List<ConfiguracionVacaciones> getConfiguracionVacacionesList() {
        return configuracionVacacionesList;
    }

    public void setConfiguracionVacacionesList(List<ConfiguracionVacaciones> configuracionVacacionesList) {
        this.configuracionVacacionesList = configuracionVacacionesList;
    }
    
}
