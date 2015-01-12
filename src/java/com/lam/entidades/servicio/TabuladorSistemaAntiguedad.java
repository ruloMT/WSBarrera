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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "nomtabuladorsistemaantiguedadtb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabuladorSistemaAntiguedad.findByCiclo", query = "SELECT t FROM TabuladorSistemaAntiguedad t WHERE t.idsistemaantiguedad.idsistemaantiguedad = :idsistemaantiguedad AND (t.limiteinferior <= :limiteinferior AND t.limitesuperior >= :limitesuperior)")})
public class TabuladorSistemaAntiguedad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTABULADOR")
    private Integer idtabulador;
    @Column(name = "LIMITEINFERIOR")
    private Double limiteinferior;
    @Column(name = "LIMITESUPERIOR")
    private Double limitesuperior;
    @Column(name = "FECHAACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaactualizacion;
    @Transient
    private String fActualizacion;
    @JoinColumn(name = "IDSISTEMAANTIGUEDAD", referencedColumnName = "IDSISTEMAANTIGUEDAD")
    @ManyToOne
    private SistemaAntiguedad idsistemaantiguedad;

    public Integer getIdtabulador() {
        return idtabulador;
    }

    public void setIdtabulador(Integer idtabulador) {
        this.idtabulador = idtabulador;
    }

    public Double getLimiteinferior() {
        return limiteinferior;
    }

    public void setLimiteinferior(Double limiteinferior) {
        this.limiteinferior = limiteinferior;
    }

    public Double getLimitesuperior() {
        return limitesuperior;
    }

    public void setLimitesuperior(Double limitesuperior) {
        this.limitesuperior = limitesuperior;
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

    public SistemaAntiguedad getIdsistemaantiguedad() {
        return idsistemaantiguedad;
    }

    public void setIdsistemaantiguedad(SistemaAntiguedad idsistemaantiguedad) {
        this.idsistemaantiguedad = idsistemaantiguedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtabulador != null ? idtabulador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabuladorSistemaAntiguedad)) {
            return false;
        }
        TabuladorSistemaAntiguedad other = (TabuladorSistemaAntiguedad) object;
        if ((this.idtabulador == null && other.idtabulador != null) || (this.idtabulador != null && !this.idtabulador.equals(other.idtabulador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.TabuladorSistemaAntiguedad[ idtabulador=" + idtabulador + " ]";
    }
}
