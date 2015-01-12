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
@Table(name = "formulastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formula.findAll", query = "SELECT f FROM Formula f"),
    @NamedQuery(name = "Formula.findByIdformula", query = "SELECT f FROM Formula f WHERE f.idformula = :idformula"),
    @NamedQuery(name = "Formula.findByCalculo", query = "SELECT f FROM Formula f WHERE f.idcompania.idcompania = :idcompania AND f.calculo = :calculo"),
    @NamedQuery(name = "Formula.findByFormula", query = "SELECT f FROM Formula f WHERE f.formula = :formula"),
    @NamedQuery(name = "Formula.findByFechaactualizacion", query = "SELECT f FROM Formula f WHERE f.fechaactualizacion = :fechaactualizacion")})
public class Formula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFORMULA")
    private Integer idformula;
    @Size(max = 45)
    @Column(name = "CALCULO")
    private String calculo;
    @Size(max = 500)
    @Column(name = "FORMULA")
    private String formula;
    @Column(name = "FECHAACTUALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaactualizacion;
    @JoinColumn(name = "IDCOMPANIA", referencedColumnName = "IDCOMPANIA")
    @ManyToOne
    private Compania idcompania;
    @Column(name = "PRIORIDAD")
    private Integer prioridad;
    @Transient
    private String calculoStr;

    public Formula() {
    }

    public Formula(Integer idformula) {
        this.idformula = idformula;
    }

    public Integer getIdformula() {
        return idformula;
    }

    public void setIdformula(Integer idformula) {
        this.idformula = idformula;
    }

    public String getCalculo() {
        return calculo;
    }

    public void setCalculo(String calculo) {
        this.calculo = calculo;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public Compania getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(Compania idcompania) {
        this.idcompania = idcompania;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getCalculoStr() {
        return calculoStr;
    }

    public void setCalculoStr(String calculoStr) {
        this.calculoStr = calculoStr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformula != null ? idformula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formula)) {
            return false;
        }
        Formula other = (Formula) object;
        if ((this.idformula == null && other.idformula != null) || (this.idformula != null && !this.idformula.equals(other.idformula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Formulastb[ idformula=" + idformula + " ]";
    }
    
}
