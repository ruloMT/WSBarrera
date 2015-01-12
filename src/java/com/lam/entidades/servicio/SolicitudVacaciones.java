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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "vacsolicitudestb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudVacaciones.findAll", query = "SELECT s FROM SolicitudVacaciones s ORDER BY s.fechaactualizacion ASC"),
    @NamedQuery(name = "SolicitudVacaciones.findByIdsolicitud", query = "SELECT s FROM SolicitudVacaciones s WHERE s.idsolicitud = :idsolicitud"),
    @NamedQuery(name = "SolicitudVacaciones.findByIdRelLabAndFInicio", query = "SELECT s FROM SolicitudVacaciones s WHERE s.idrellab.idrellab = :idrellab AND s.fechainicio > :fechainicio"),
    @NamedQuery(name = "SolicitudVacaciones.findByIdRelLabAndIdVacSaldo", query = "SELECT s FROM SolicitudVacaciones s WHERE s.idrellab.idrellab = :idrellab AND s.idvacsaldo.idvacsaldo = :idvacsaldo"),
    @NamedQuery(name = "SolicitudVacaciones.findByEstatus", query = "SELECT s FROM SolicitudVacaciones s WHERE s.estatus = :estatus"),
    @NamedQuery(name = "SolicitudVacaciones.findByFechaInicioAndFechaFin", query = "SELECT s FROM SolicitudVacaciones s WHERE s.fechainicio <= :fechaInicio AND s.fechafin >= :fechaFin AND s.estatus = :estatus"),
    @NamedQuery(name = "SolicitudVacaciones.findByObservaciones", query = "SELECT s FROM SolicitudVacaciones s WHERE s.observaciones = :observaciones"),
    @NamedQuery(name = "SolicitudVacaciones.findByDias", query = "SELECT s FROM SolicitudVacaciones s WHERE s.dias = :dias")})
public class SolicitudVacaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSOLICITUD")
    private Integer idsolicitud;
    @Size(max = 2)
    @Column(name = "ESTATUS")
    private String estatus;
    @Size(max = 100)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Column(name = "DIAS")
    private Integer dias;
    @Column(name = "FECHAACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaactualizacion;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @JoinColumn(name = "IDVACSALDO", referencedColumnName = "IDVACSALDO")
    @ManyToOne
    private SaldoVacaciones idvacsaldo;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @Transient
    private String fActualizacion;
    @Transient
    private String fInicio;
    @Transient
    private String fFin;
    @Transient
    private String fPago;
    @Transient
    private String strEstatus;

    public SolicitudVacaciones() {
    }

    public SolicitudVacaciones(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public Integer getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(Integer idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public SaldoVacaciones getIdvacsaldo() {
        return idvacsaldo;
    }

    public void setIdvacsaldo(SaldoVacaciones idvacsaldo) {
        this.idvacsaldo = idvacsaldo;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public String getfActualizacion() {
        return fActualizacion;
    }

    public void setfActualizacion(String fActualizacion) {
        this.fActualizacion = fActualizacion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getfInicio() {
        return fInicio;
    }

    public void setfInicio(String fInicio) {
        this.fInicio = fInicio;
    }

    public String getfFin() {
        return fFin;
    }

    public void setfFin(String fFin) {
        this.fFin = fFin;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getfPago() {
        return fPago;
    }

    public void setfPago(String fPago) {
        this.fPago = fPago;
    }

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
    }

    public String getStrEstatus() {
        return strEstatus;
    }

    public void setStrEstatus(String strEstatus) {
        this.strEstatus = strEstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsolicitud != null ? idsolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudVacaciones)) {
            return false;
        }
        SolicitudVacaciones other = (SolicitudVacaciones) object;
        if ((this.idsolicitud == null && other.idsolicitud != null) || (this.idsolicitud != null && !this.idsolicitud.equals(other.idsolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.SolicitudVacaciones[ idsolicitud=" + idsolicitud + " ]";
    }
}
