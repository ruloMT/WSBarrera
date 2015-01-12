/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "vacconfiguraciontb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionVacaciones.findAll", query = "SELECT c FROM ConfiguracionVacaciones c"),
    @NamedQuery(name = "ConfiguracionVacaciones.findByIdconfiguracion", query = "SELECT c FROM ConfiguracionVacaciones c WHERE c.idconfiguracion = :idconfiguracion"),
    @NamedQuery(name = "ConfiguracionVacaciones.findByFechaactualizacion", query = "SELECT c FROM ConfiguracionVacaciones c WHERE c.fechaactualizacion = :fechaactualizacion"),
    @NamedQuery(name = "ConfiguracionVacaciones.findByDiasvigencia", query = "SELECT c FROM ConfiguracionVacaciones c WHERE c.diasvigencia = :diasvigencia"),
    @NamedQuery(name = "ConfiguracionVacaciones.findByAcumulable", query = "SELECT c FROM ConfiguracionVacaciones c WHERE c.acumulable = :acumulable")})
public class ConfiguracionVacaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONFIGURACION")
    private Integer idconfiguracion;
    @Column(name = "FECHAACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaactualizacion;
    @Column(name = "DIASVIGENCIA")
    private Integer diasvigencia;
    @Column(name = "ACUMULABLE")
    private Integer acumulable;
    @JoinColumn(name = "IDGRUPOPAGO", referencedColumnName = "IDGRUPOPAGO")
    @ManyToOne
    private GrupoPago idgrupopago;

    public ConfiguracionVacaciones() {
    }

    public ConfiguracionVacaciones(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public Integer getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public Integer getDiasvigencia() {
        return diasvigencia;
    }

    public void setDiasvigencia(Integer diasvigencia) {
        this.diasvigencia = diasvigencia;
    }

    public Integer getAcumulable() {
        return acumulable;
    }

    public void setAcumulable(Integer acumulable) {
        this.acumulable = acumulable;
    }

    public GrupoPago getIdgrupopago() {
        return idgrupopago;
    }

    public void setIdgrupopago(GrupoPago idgrupopago) {
        this.idgrupopago = idgrupopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconfiguracion != null ? idconfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionVacaciones)) {
            return false;
        }
        ConfiguracionVacaciones other = (ConfiguracionVacaciones) object;
        if ((this.idconfiguracion == null && other.idconfiguracion != null) || (this.idconfiguracion != null && !this.idconfiguracion.equals(other.idconfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.ConfiguracionVacaciones[ idconfiguracion=" + idconfiguracion + " ]";
    }
    
}
