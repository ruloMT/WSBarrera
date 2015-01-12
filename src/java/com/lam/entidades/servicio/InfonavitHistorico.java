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
@Table(name = "fisinfonavithtb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfonavitHistorico.findAll", query = "SELECT i FROM InfonavitHistorico i"),
    @NamedQuery(name = "InfonavitHistorico.findByIdInfonavit", query = "SELECT i FROM InfonavitHistorico i WHERE i.idinfonavit.idinfonavit = :idinfonavit ORDER BY i.idinfonavith ASC"),
    @NamedQuery(name = "InfonavitHistorico.findByIdinfonavith", query = "SELECT i FROM InfonavitHistorico i WHERE i.idinfonavith = :idinfonavith"),
    @NamedQuery(name = "InfonavitHistorico.findByNumerocredito", query = "SELECT i FROM InfonavitHistorico i WHERE i.numerocredito = :numerocredito"),
    @NamedQuery(name = "InfonavitHistorico.findByTipodescuento", query = "SELECT i FROM InfonavitHistorico i WHERE i.tipodescuento = :tipodescuento"),
    @NamedQuery(name = "InfonavitHistorico.findByFechavigencia", query = "SELECT i FROM InfonavitHistorico i WHERE i.fechavigencia = :fechavigencia"),
    @NamedQuery(name = "InfonavitHistorico.findByEstatus", query = "SELECT i FROM InfonavitHistorico i WHERE i.estatus = :estatus"),
    @NamedQuery(name = "InfonavitHistorico.findByFechaactualizacion", query = "SELECT i FROM InfonavitHistorico i WHERE i.fechaactualizacion = :fechaactualizacion")})
public class InfonavitHistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINFONAVITH")
    private Integer idinfonavith;
    @Size(max = 10)
    @Column(name = "NUMEROCREDITO")
    private String numerocredito;
    @Size(max = 4)
    @Column(name = "TIPODESCUENTO")
    private String tipodescuento;
    @Column(name = "DESCUENTO")
    private Double descuento;
    @Column(name = "FECHAVIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechavigencia;
    @Size(max = 2)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHAACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaactualizacion;
    @JoinColumn(name = "IDINFONAVIT", referencedColumnName = "IDINFONAVIT")
    @ManyToOne
    private Infonavit idinfonavit;
    @Transient
    private String tipoDescStr;
    @Transient
    private String estatusStr;
    @Transient
    private String fVigenciaStr;
    @Transient
    private String fActualizaStr;

    public InfonavitHistorico() {
    }

    public InfonavitHistorico(Integer idinfonavith) {
        this.idinfonavith = idinfonavith;
    }

    public Integer getIdinfonavith() {
        return idinfonavith;
    }

    public void setIdinfonavith(Integer idinfonavith) {
        this.idinfonavith = idinfonavith;
    }

    public String getNumerocredito() {
        return numerocredito;
    }

    public void setNumerocredito(String numerocredito) {
        this.numerocredito = numerocredito;
    }

    public String getTipodescuento() {
        return tipodescuento;
    }

    public void setTipodescuento(String tipodescuento) {
        this.tipodescuento = tipodescuento;
    }

    public Date getFechavigencia() {
        return fechavigencia;
    }

    public void setFechavigencia(Date fechavigencia) {
        this.fechavigencia = fechavigencia;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public Infonavit getIdinfonavit() {
        return idinfonavit;
    }

    public void setIdinfonavit(Infonavit idinfonavit) {
        this.idinfonavit = idinfonavit;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinfonavith != null ? idinfonavith.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfonavitHistorico)) {
            return false;
        }
        InfonavitHistorico other = (InfonavitHistorico) object;
        if ((this.idinfonavith == null && other.idinfonavith != null) || (this.idinfonavith != null && !this.idinfonavith.equals(other.idinfonavith))) {
            return false;
        }
        return true;
    }

    public String getTipoDescStr() {
        return tipoDescStr;
    }

    public void setTipoDescStr(String tipoDescStr) {
        this.tipoDescStr = tipoDescStr;
    }

    public String getEstatusStr() {
        return estatusStr;
    }

    public void setEstatusStr(String estatusStr) {
        this.estatusStr = estatusStr;
    }

    public String getfVigenciaStr() {
        return fVigenciaStr;
    }

    public void setfVigenciaStr(String fVigenciaStr) {
        this.fVigenciaStr = fVigenciaStr;
    }

    public String getfActualizaStr() {
        return fActualizaStr;
    }

    public void setfActualizaStr(String fActualizaStr) {
        this.fActualizaStr = fActualizaStr;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.InfonavitHistorico[ idinfonavith=" + idinfonavith + " ]";
    }
}
