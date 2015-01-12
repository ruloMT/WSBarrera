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
@Table(name = "rhposicionsueldotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PosicionSueldo.findAll", query = "SELECT p FROM PosicionSueldo p"),
    @NamedQuery(name = "PosicionSueldo.findByIdposicionsueldo", query = "SELECT p FROM PosicionSueldo p WHERE p.idposicionsueldo = :idposicionsueldo"),
    @NamedQuery(name = "PosicionSueldo.findByEstatus", query = "SELECT p FROM PosicionSueldo p WHERE p.estatus = :estatus"),
    @NamedQuery(name = "PosicionSueldo.findByFechafin", query = "SELECT p FROM PosicionSueldo p WHERE p.fechafin = :fechafin"),
    @NamedQuery(name = "PosicionSueldo.findByIdRellabAndTipoSueldo", query = "SELECT p FROM PosicionSueldo p WHERE p.idrellab.idrellab = :idrellab AND p.idtiposueldo.idtiposueldo = :idtiposueldo"),
    @NamedQuery(name = "PosicionSueldo.findByIdRellab", query = "SELECT p FROM PosicionSueldo p WHERE p.idrellab.idrellab = :idrellab"),
    @NamedQuery(name = "PosicionSueldo.findByFechainicio", query = "SELECT p FROM PosicionSueldo p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "PosicionSueldo.findBySueldo", query = "SELECT p FROM PosicionSueldo p WHERE p.sueldo = :sueldo")})
public class PosicionSueldo implements Serializable {

    @OneToMany(mappedBy = "idposicionsueldo")
    private List<PosicionSueldoHistorico> posicionSueldoHistoricoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPOSICIONSUELDO")
    private Integer idposicionsueldo;
    @Size(max = 255)
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
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @JoinColumn(name = "IDTIPOSUELDO", referencedColumnName = "IDTIPOSUELDO")
    @ManyToOne
    private TipoSueldo idtiposueldo;

    public PosicionSueldo() {
    }

    public PosicionSueldo(Integer idposicionsueldo) {
        this.idposicionsueldo = idposicionsueldo;
    }

    public Integer getIdposicionsueldo() {
        return idposicionsueldo;
    }

    public void setIdposicionsueldo(Integer idposicionsueldo) {
        this.idposicionsueldo = idposicionsueldo;
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

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
    }

    public TipoSueldo getIdtiposueldo() {
        return idtiposueldo;
    }

    public void setIdtiposueldo(TipoSueldo idtiposueldo) {
        this.idtiposueldo = idtiposueldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposicionsueldo != null ? idposicionsueldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosicionSueldo)) {
            return false;
        }
        PosicionSueldo other = (PosicionSueldo) object;
        if ((this.idposicionsueldo == null && other.idposicionsueldo != null) || (this.idposicionsueldo != null && !this.idposicionsueldo.equals(other.idposicionsueldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.PosicionSueldo[ idposicionsueldo=" + idposicionsueldo + " ]";
    }

    @XmlTransient
    public List<PosicionSueldoHistorico> getPosicionSueldoHistoricoList() {
        return posicionSueldoHistoricoList;
    }

    public void setPosicionSueldoHistoricoList(List<PosicionSueldoHistorico> posicionSueldoHistoricoList) {
        this.posicionSueldoHistoricoList = posicionSueldoHistoricoList;
    }
}
