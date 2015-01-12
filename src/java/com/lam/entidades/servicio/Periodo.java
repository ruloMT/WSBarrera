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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author iperez
 */
@Entity
@Table(name = "nomperiodostb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p ORDER BY p.anio,p.mes ASC"),
    @NamedQuery(name = "Periodo.findByIdTipoProceso", query = "SELECT p FROM Periodo p WHERE p.idtipoproceso.idtipoproceso = :idtipoproceso"),
    @NamedQuery(name = "Periodo.findByFechaInicioAndFechaFin", query = "SELECT p FROM Periodo p WHERE p.fechainicio = :fechainicio AND p.fechafin =:fechafin"),
    @NamedQuery(name = "Periodo.findByIdperiodo", query = "SELECT p FROM Periodo p WHERE p.idperiodo = :idperiodo")
})
public class Periodo implements Serializable {

    @OneToMany(mappedBy = "idperiodo")
    private List<Incidencia> incidenciaList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPERIODO")
    private Integer idperiodo;
    @Size(max = 11)
    @Column(name = "ANIO")
    private Integer anio;
    @Size(max = 11)
    @Column(name = "PERIODO")
    private Integer periodo;
    @Size(max = 11)
    @Column(name = "ANIOMES")
    private Integer aniomes;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Size(max = 11)
    @Column(name = "MES")
    private Integer mes;
    @Size(max = 11)
    @Column(name = "BIMESTRE")
    private Integer bimestre;
    @JoinColumn(name = "IDTIPOPROCESO", referencedColumnName = "IDTIPOPROCESO")
    @ManyToOne
    private TipoProceso idtipoproceso;
//    
    @Transient
    private String FechaInicioStr;
    @Transient
    private String FechaFinStr;
    @Transient
    private String FechaPagoStr;

    public Periodo() {
    }

    public Integer getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getAniomes() {
        return aniomes;
    }

    public void setAniomes(Integer aniomes) {
        this.aniomes = aniomes;
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

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getBimestre() {
        return bimestre;
    }

    public void setBimestre(Integer bimestre) {
        this.bimestre = bimestre;
    }

    public TipoProceso getIdtipoproceso() {
        return idtipoproceso;
    }

    public void setIdtipoproceso(TipoProceso idtipoproceso) {
        this.idtipoproceso = idtipoproceso;
    }

    public String getFechaPagoStr() {
        return FechaPagoStr;
    }

    public void setFechaPagoStr(String FechaPagoStr) {
        this.FechaPagoStr = FechaPagoStr;
    }

    public String getFechaInicioStr() {
        return FechaInicioStr;
    }

    public void setFechaInicioStr(String FechaInicioStr) {
        this.FechaInicioStr = FechaInicioStr;
    }

    public String getFechaFinStr() {
        return FechaFinStr;
    }

    public void setFechaFinStr(String FechaFinStr) {
        this.FechaFinStr = FechaFinStr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperiodo != null ? idperiodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.idperiodo == null && other.idperiodo != null) || (this.idperiodo != null && !this.idperiodo.equals(other.idperiodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Periodo[ idperiodo=" + idperiodo + " ]";
    }

    @XmlTransient
    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }
}
