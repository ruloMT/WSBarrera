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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "vacsaldostb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaldoVacaciones.findAll", query = "SELECT s FROM SaldoVacaciones s ORDER BY s.anio ASC"),
    @NamedQuery(name = "SaldoVacaciones.findAllDistinctRellab", query = "SELECT DISTINCT(s.idrellab) FROM SaldoVacaciones s ORDER BY s.ciclo ASC"),
    @NamedQuery(name = "SaldoVacaciones.findByIdRellab", query = "SELECT s FROM SaldoVacaciones s WHERE s.idrellab.idrellab = :idrellab AND s.saldo > 0.0 ORDER BY s.ciclo ASC"),
    @NamedQuery(name = "SaldoVacaciones.findByIdRellabAndCiclo", query = "SELECT s FROM SaldoVacaciones s WHERE s.idrellab.idrellab = :idrellab AND s.ciclo = :ciclo"),
    @NamedQuery(name = "SaldoVacaciones.findByIdvacsaldo", query = "SELECT s FROM SaldoVacaciones s WHERE s.idvacsaldo = :idvacsaldo"),
    @NamedQuery(name = "SaldoVacaciones.findByCiclo", query = "SELECT s FROM SaldoVacaciones s WHERE s.ciclo = :ciclo"),
    @NamedQuery(name = "SaldoVacaciones.findByAnio", query = "SELECT s FROM SaldoVacaciones s WHERE s.anio = :anio"),
    @NamedQuery(name = "SaldoVacaciones.findByFechainicio", query = "SELECT s FROM SaldoVacaciones s WHERE s.fechainicio = :fechainicio"),
    @NamedQuery(name = "SaldoVacaciones.findByFechafin", query = "SELECT s FROM SaldoVacaciones s WHERE s.fechafin = :fechafin")})
public class SaldoVacaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVACSALDO")
    private Integer idvacsaldo;
    @Column(name = "CICLO")
    private Integer ciclo;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "DEVENGADAS")
    private Double devengadas;
    @Column(name = "CERRADA")
    private Integer cerrada;
    @Column(name = "SOLICITADAS")
    private Integer solicitadas;
    @Column(name = "AUTORIZADAS")
    private Integer autorizadas;
    @Column(name = "PORDERECHO")
    private Integer porderecho;
    @Column(name = "DISFRUTADAS")
    private Integer disfrutadas;
    @Column(name = "VENCIDAS")
    private Integer vencidas;
    @Column(name = "SALDO")
    private Double saldo;
    @OneToMany(mappedBy = "idvacsaldo")
    private List<SolicitudVacaciones> solicitudVacacionesList;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @Transient
    private String fInicio;
    @Transient
    private String fFin;

    public SaldoVacaciones() {
    }

    public SaldoVacaciones(Integer idvacsaldo) {
        this.idvacsaldo = idvacsaldo;
    }

    public Integer getIdvacsaldo() {
        return idvacsaldo;
    }

    public void setIdvacsaldo(Integer idvacsaldo) {
        this.idvacsaldo = idvacsaldo;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
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

    public Integer getSolicitadas() {
        return solicitadas;
    }

    public void setSolicitadas(Integer solicitadas) {
        this.solicitadas = solicitadas;
    }

    public Integer getDisfrutadas() {
        return disfrutadas;
    }

    public void setDisfrutadas(Integer disfrutadas) {
        this.disfrutadas = disfrutadas;
    }

    public Integer getVencidas() {
        return vencidas;
    }

    public void setVencidas(Integer vencidas) {
        this.vencidas = vencidas;
    }

    public Double getDevengadas() {
        return devengadas;
    }

    public void setDevengadas(Double devengadas) {
        this.devengadas = devengadas;
    }

    public Integer getAutorizadas() {
        return autorizadas;
    }

    public void setAutorizadas(Integer autorizadas) {
        this.autorizadas = autorizadas;
    }

    public Integer getPorderecho() {
        return porderecho;
    }

    public void setPorderecho(Integer porderecho) {
        this.porderecho = porderecho;
    }

    @XmlTransient
    public List<SolicitudVacaciones> getSolicitudVacacionesList() {
        return solicitudVacacionesList;
    }

    public void setSolicitudVacacionesList(List<SolicitudVacaciones> solicitudVacacionesList) {
        this.solicitudVacacionesList = solicitudVacacionesList;
    }

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvacsaldo != null ? idvacsaldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaldoVacaciones)) {
            return false;
        }
        SaldoVacaciones other = (SaldoVacaciones) object;
        if ((this.idvacsaldo == null && other.idvacsaldo != null) || (this.idvacsaldo != null && !this.idvacsaldo.equals(other.idvacsaldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.SaldoVacaciones[ idvacsaldo=" + idvacsaldo + " ]";
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getCerrada() {
        return cerrada;
    }

    public void setCerrada(Integer cerrada) {
        this.cerrada = cerrada;
    }
}
