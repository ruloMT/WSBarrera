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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhposicionsueldoestatustb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PosicionSueldoHistorico.findAll", query = "SELECT p FROM PosicionSueldoHistorico p"),
    @NamedQuery(name = "PosicionSueldoHistorico.findAllByIdPosicion", query = "SELECT p FROM PosicionSueldoHistorico p WHERE p.idposicionsueldo.idrellab.idrellab = :idrellab ORDER BY p.idposicionsueldoestatus ASC"),
    @NamedQuery(name = "PosicionSueldoHistorico.findByIdposicionsueldoestatus", query = "SELECT p FROM PosicionSueldoHistorico p WHERE p.idposicionsueldoestatus = :idposicionsueldoestatus"),
    @NamedQuery(name = "PosicionSueldoHistorico.findByEstatus", query = "SELECT p FROM PosicionSueldoHistorico p WHERE p.estatus = :estatus"),
    @NamedQuery(name = "PosicionSueldoHistorico.findByFechafin", query = "SELECT p FROM PosicionSueldoHistorico p WHERE p.fechafin = :fechafin"),
    @NamedQuery(name = "PosicionSueldoHistorico.findByFechainicio", query = "SELECT p FROM PosicionSueldoHistorico p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "PosicionSueldoHistorico.findBySueldo", query = "SELECT p FROM PosicionSueldoHistorico p WHERE p.sueldo = :sueldo"),
    @NamedQuery(name = "PosicionSueldoHistorico.findByFechaactualizacion", query = "SELECT p FROM PosicionSueldoHistorico p WHERE p.fechaactualizacion = :fechaactualizacion")})
public class PosicionSueldoHistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPOSICIONSUELDOESTATUS")
    private Integer idposicionsueldoestatus;
    @Size(max = 2)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SUELDO")
    private Double sueldo;
    @Column(name = "FECHAACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaactualizacion;
    @JoinColumn(name = "IDPOSICIONSUELDO", referencedColumnName = "IDPOSICIONSUELDO")
    @ManyToOne
    private PosicionSueldo idposicionsueldo;
    @JoinColumn(name = "IDTIPOSUELDO", referencedColumnName = "IDTIPOSUELDO")
    @ManyToOne
    private TipoSueldo idtiposueldo;
    @Transient
    private String fInicioStr;
    @Transient
    private String fFinStr;
    @Transient
    private String fActualizacionStr;
    @Transient
    private String estatusStr;

    public PosicionSueldoHistorico() {
    }

    public PosicionSueldoHistorico(Integer idposicionsueldoestatus) {
        this.idposicionsueldoestatus = idposicionsueldoestatus;
    }

    public Integer getIdposicionsueldoestatus() {
        return idposicionsueldoestatus;
    }

    public void setIdposicionsueldoestatus(Integer idposicionsueldoestatus) {
        this.idposicionsueldoestatus = idposicionsueldoestatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public PosicionSueldo getIdposicionsueldo() {
        return idposicionsueldo;
    }

    public void setIdposicionsueldo(PosicionSueldo idposicionsueldo) {
        this.idposicionsueldo = idposicionsueldo;
    }

    public TipoSueldo getIdtiposueldo() {
        return idtiposueldo;
    }

    public void setIdtiposueldo(TipoSueldo idtiposueldo) {
        this.idtiposueldo = idtiposueldo;
    }

    public String getfInicioStr() {
        return fInicioStr;
    }

    public void setfInicioStr(String fInicioStr) {
        this.fInicioStr = fInicioStr;
    }

    public String getfFinStr() {
        return fFinStr;
    }

    public void setfFinStr(String fFinStr) {
        this.fFinStr = fFinStr;
    }

    public String getfActualizacionStr() {
        return fActualizacionStr;
    }

    public void setfActualizacionStr(String fActualizacionStr) {
        this.fActualizacionStr = fActualizacionStr;
    }

    public String getEstatusStr() {
        return estatusStr;
    }

    public void setEstatusStr(String estatusStr) {
        this.estatusStr = estatusStr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposicionsueldoestatus != null ? idposicionsueldoestatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosicionSueldoHistorico)) {
            return false;
        }
        PosicionSueldoHistorico other = (PosicionSueldoHistorico) object;
        if ((this.idposicionsueldoestatus == null && other.idposicionsueldoestatus != null) || (this.idposicionsueldoestatus != null && !this.idposicionsueldoestatus.equals(other.idposicionsueldoestatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.PosicionSueldoHistorico[ idposicionsueldoestatus=" + idposicionsueldoestatus + " ]";
    }
}
