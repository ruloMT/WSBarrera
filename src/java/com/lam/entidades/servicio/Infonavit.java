/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "fisinfonavittb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infonavit.findAll", query = "SELECT i FROM Infonavit i"),
    @NamedQuery(name = "Infonavit.findByIdinfonavit", query = "SELECT i FROM Infonavit i WHERE i.idinfonavit = :idinfonavit"),
    @NamedQuery(name = "Infonavit.findByIdRellab", query = "SELECT i FROM Infonavit i WHERE i.idrellab.idrellab = :idrellab"),
    @NamedQuery(name = "Infonavit.findByNumerocredito", query = "SELECT i FROM Infonavit i WHERE i.numerocredito = :numerocredito"),
    @NamedQuery(name = "Infonavit.findByEstatus", query = "SELECT i FROM Infonavit i WHERE i.estatus = :estatus"),
    @NamedQuery(name = "Infonavit.findByFechavigencia", query = "SELECT i FROM Infonavit i WHERE i.fechavigencia = :fechavigencia"),
    @NamedQuery(name = "Infonavit.findByFechaActualizacion", query = "SELECT i FROM Infonavit i WHERE i.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Infonavit.findByTipodescuento", query = "SELECT i FROM Infonavit i WHERE i.tipodescuento = :tipodescuento")})
public class Infonavit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINFONAVIT")
    private Integer idinfonavit;
    @Size(max = 45)
    @Column(name = "NUMEROCREDITO")
    private String numerocredito;
    @Size(max = 2)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHAVIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechavigencia;
    @Column(name = "FECHAACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Size(max = 45)
    @Column(name = "TIPODESCUENTO")
    private String tipodescuento;
    @Column(name = "DESCUENTO")
    private Double descuento;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @OneToMany(mappedBy = "idinfonavit")
    private List<InfonavitHistorico> infonavitHistoricoList;

    public Infonavit() {
    }

    public Infonavit(Integer idinfonavit) {
        this.idinfonavit = idinfonavit;
    }

    public Integer getIdinfonavit() {
        return idinfonavit;
    }

    public void setIdinfonavit(Integer idinfonavit) {
        this.idinfonavit = idinfonavit;
    }

    public String getNumerocredito() {
        return numerocredito;
    }

    public void setNumerocredito(String numerocredito) {
        this.numerocredito = numerocredito;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechavigencia() {
        return fechavigencia;
    }

    public void setFechavigencia(Date fechavigencia) {
        this.fechavigencia = fechavigencia;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getTipodescuento() {
        return tipodescuento;
    }

    public void setTipodescuento(String tipodescuento) {
        this.tipodescuento = tipodescuento;
    }

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
    }

    @XmlTransient
    public List<InfonavitHistorico> getInfonavitHistoricoList() {
        return infonavitHistoricoList;
    }

    public void setInfonavitHistoricoList(List<InfonavitHistorico> infonavitHistoricoList) {
        this.infonavitHistoricoList = infonavitHistoricoList;
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
        hash += (idinfonavit != null ? idinfonavit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infonavit)) {
            return false;
        }
        Infonavit other = (Infonavit) object;
        if ((this.idinfonavit == null && other.idinfonavit != null) || (this.idinfonavit != null && !this.idinfonavit.equals(other.idinfonavit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Infonavit[ idinfonavit=" + idinfonavit + " ]";
    }
}
