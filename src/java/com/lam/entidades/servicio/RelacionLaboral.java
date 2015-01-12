/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhrelacionlaboraltb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacionLaboral.findAll", query = "SELECT r FROM RelacionLaboral r"),
    @NamedQuery(name = "RelacionLaboral.findByIdCompaniaAndIdGrupoPago", query = "SELECT r FROM RelacionLaboral r WHERE r.idcompania.idcompania = :idcompania AND r.idgrupopago.idgrupopago = :idgrupopago ORDER BY r.numeroempleado ASC"),
    @NamedQuery(name = "RelacionLaboral.findByRfc", query = "SELECT r FROM RelacionLaboral r WHERE r.idempleado.rfc = :rfc AND r.idcompania IS NULL AND r.idtiporellab IS NULL"),
    @NamedQuery(name = "RelacionLaboral.findById", query = "SELECT r FROM RelacionLaboral r WHERE r.idrellab = :idrellab"),
    @NamedQuery(name = "RelacionLaboral.findByIdrellab", query = "SELECT r FROM RelacionLaboral r WHERE r.idrellab = :idrellab"),
    @NamedQuery(name = "RelacionLaboral.findByCausabaja", query = "SELECT r FROM RelacionLaboral r WHERE r.causabaja = :causabaja"),
    @NamedQuery(name = "RelacionLaboral.findByCausabajaimss", query = "SELECT r FROM RelacionLaboral r WHERE r.causabajaimss = :causabajaimss"),
    @NamedQuery(name = "RelacionLaboral.findByDuracion", query = "SELECT r FROM RelacionLaboral r WHERE r.duracion = :duracion"),
    @NamedQuery(name = "RelacionLaboral.findByEstatus", query = "SELECT r FROM RelacionLaboral r WHERE r.estatus = :estatus"),
    @NamedQuery(name = "RelacionLaboral.findByFechaantiguedad1", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaantiguedad1 = :fechaantiguedad1"),
    @NamedQuery(name = "RelacionLaboral.findByFechaantiguedad2", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaantiguedad2 = :fechaantiguedad2"),
    @NamedQuery(name = "RelacionLaboral.findByFechaantiguedad3", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaantiguedad3 = :fechaantiguedad3"),
    @NamedQuery(name = "RelacionLaboral.findByFechabaja", query = "SELECT r FROM RelacionLaboral r WHERE r.fechabaja = :fechabaja"),
    @NamedQuery(name = "RelacionLaboral.findByFechaeventocontrato", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaeventocontrato = :fechaeventocontrato"),
    @NamedQuery(name = "RelacionLaboral.findByFechaingreso", query = "SELECT r FROM RelacionLaboral r WHERE r.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "RelacionLaboral.findByFechainiciocontrato", query = "SELECT r FROM RelacionLaboral r WHERE r.fechainiciocontrato = :fechainiciocontrato"),
    @NamedQuery(name = "RelacionLaboral.findByNumeroempleado", query = "SELECT r FROM RelacionLaboral r WHERE r.numeroempleado = :numeroempleado"),
    @NamedQuery(name = "RelacionLaboral.findByExpediente", query = "SELECT r FROM RelacionLaboral r WHERE r.idempleado.expediente = :expediente"),
    @NamedQuery(name = "RelacionLaboral.findByTipocontrato", query = "SELECT r FROM RelacionLaboral r WHERE r.tipocontrato = :tipocontrato")})
public class RelacionLaboral implements Serializable {

    @OneToMany(mappedBy = "idrellab")
    private List<AdelantoVacaciones> adelantoVacacionesList;
    @OneToMany(mappedBy = "idrellab")
    private List<SaldoVacaciones> saldoVacacionesList;
    @OneToMany(mappedBy = "idrellab")
    private List<Incidencia> incidenciaList;
    @OneToMany(mappedBy = "idrellab")
    private List<PosicionSueldo> posicionSueldoList;
    @OneToMany(mappedBy = "idrellab")
    private List<EstructuraDatos> estructuraDatosList;
    @OneToMany(mappedBy = "idrellab")
    private List<Infonavit> infonavitList;
    @OneToMany(mappedBy = "idrellab")
    private List<CuentaBancaria> cuentaBancoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRELLAB")
    private Integer idrellab;
    @Size(max = 255)
    @Column(name = "CAUSABAJA")
    private String causabaja;
    @Size(max = 255)
    @Column(name = "CAUSABAJAIMSS")
    private String causabajaimss;
    @Column(name = "DURACION")
    private Integer duracion;
    @Size(max = 255)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHAANTIGUEDAD1")
    @Temporal(TemporalType.DATE)
    private Date fechaantiguedad1;
    @Column(name = "FECHAANTIGUEDAD2")
    @Temporal(TemporalType.DATE)
    private Date fechaantiguedad2;
    @Column(name = "FECHAANTIGUEDAD3")
    @Temporal(TemporalType.DATE)
    private Date fechaantiguedad3;
    @Column(name = "FECHABAJA")
    @Temporal(TemporalType.DATE)
    private Date fechabaja;
    @Column(name = "FECHAEVENTOCONTRATO")
    @Temporal(TemporalType.DATE)
    private Date fechaeventocontrato;
    @Column(name = "FECHAINGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Column(name = "FECHAINICIOCONTRATO")
    @Temporal(TemporalType.DATE)
    private Date fechainiciocontrato;
    @Size(max = 255)
    @Column(name = "NUMEROEMPLEADO")
    private String numeroempleado;
    @Size(max = 255)
    @Column(name = "TIPOCONTRATO")
    private String tipocontrato;
    @JoinColumn(name = "IDTIPORELLAB", referencedColumnName = "IDTIPORELACIONLABORAL")
    @ManyToOne
    private TipoRelacionLaboral idtiporellab;
    @JoinColumn(name = "IDSISTEMAANTIGUEDAD", referencedColumnName = "IDSISTEMAANTIGUEDAD")
    @ManyToOne
    private SistemaAntiguedad idsistemaantiguedad;
    @JoinColumn(name = "IDRELACIONLABORALPOSICION", referencedColumnName = "IDRELACIONLABORALPOSICION")
    @ManyToOne
    private RelacionLaboralPosicion idrelacionlaboralposicion;
    @JoinColumn(name = "IDREGISTROPATRONAL", referencedColumnName = "IDREGISTROPATRONAL")
    @ManyToOne
    private RegistroPatronal idregistropatronal;
    @JoinColumn(name = "IDGRUPOPAGO", referencedColumnName = "IDGRUPOPAGO")
    @ManyToOne
    private GrupoPago idgrupopago;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne
    private Empleado idempleado;
    @JoinColumn(name = "IDCOMPANIA", referencedColumnName = "IDCOMPANIA")
    @ManyToOne
    private Compania idcompania;
    @Transient
    private String seleccione;
    @Transient
    private String fechaIngresoStr;
    @Transient
    private String fechaBajaStr;
    @Transient
    private String fechaAntiguedadStr;

    public RelacionLaboral() {
    }

    public RelacionLaboral(Integer idrellab) {
        this.idrellab = idrellab;
    }

    public Integer getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(Integer idrellab) {
        this.idrellab = idrellab;
    }

    public String getCausabaja() {
        return causabaja;
    }

    public void setCausabaja(String causabaja) {
        this.causabaja = causabaja;
    }

    public String getCausabajaimss() {
        return causabajaimss;
    }

    public void setCausabajaimss(String causabajaimss) {
        this.causabajaimss = causabajaimss;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaantiguedad1() {
        return fechaantiguedad1;
    }

    public void setFechaantiguedad1(Date fechaantiguedad1) {
        this.fechaantiguedad1 = fechaantiguedad1;
    }

    public Date getFechaantiguedad2() {
        return fechaantiguedad2;
    }

    public void setFechaantiguedad2(Date fechaantiguedad2) {
        this.fechaantiguedad2 = fechaantiguedad2;
    }

    public Date getFechaantiguedad3() {
        return fechaantiguedad3;
    }

    public void setFechaantiguedad3(Date fechaantiguedad3) {
        this.fechaantiguedad3 = fechaantiguedad3;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Date getFechaeventocontrato() {
        return fechaeventocontrato;
    }

    public void setFechaeventocontrato(Date fechaeventocontrato) {
        this.fechaeventocontrato = fechaeventocontrato;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechainiciocontrato() {
        return fechainiciocontrato;
    }

    public void setFechainiciocontrato(Date fechainiciocontrato) {
        this.fechainiciocontrato = fechainiciocontrato;
    }

    public String getNumeroempleado() {
        return numeroempleado;
    }

    public void setNumeroempleado(String numeroempleado) {
        this.numeroempleado = numeroempleado;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public TipoRelacionLaboral getIdtiporellab() {
        return idtiporellab;
    }

    public void setIdtiporellab(TipoRelacionLaboral idtiporellab) {
        this.idtiporellab = idtiporellab;
    }

    public RelacionLaboralPosicion getIdrelacionlaboralposicion() {
        return idrelacionlaboralposicion;
    }

    public void setIdrelacionlaboralposicion(RelacionLaboralPosicion idrelacionlaboralposicion) {
        this.idrelacionlaboralposicion = idrelacionlaboralposicion;
    }

    public RegistroPatronal getIdregistropatronal() {
        return idregistropatronal;
    }

    public void setIdregistropatronal(RegistroPatronal idregistropatronal) {
        this.idregistropatronal = idregistropatronal;
    }

    public GrupoPago getIdgrupopago() {
        return idgrupopago;
    }

    public void setIdgrupopago(GrupoPago idgrupopago) {
        this.idgrupopago = idgrupopago;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    public Compania getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(Compania idcompania) {
        this.idcompania = idcompania;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrellab != null ? idrellab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionLaboral)) {
            return false;
        }
        RelacionLaboral other = (RelacionLaboral) object;
        if ((this.idrellab == null && other.idrellab != null) || (this.idrellab != null && !this.idrellab.equals(other.idrellab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.RelacionLaboral[ idrellab=" + idrellab + " ]";
    }

    @XmlTransient
    public List<CuentaBancaria> getCuentaBancoList() {
        return cuentaBancoList;
    }

    public void setCuentaBancoList(List<CuentaBancaria> cuentaBancoList) {
        this.cuentaBancoList = cuentaBancoList;
    }

    @XmlTransient
    public List<Infonavit> getInfonavitList() {
        return infonavitList;
    }

    public void setInfonavitList(List<Infonavit> infonavitList) {
        this.infonavitList = infonavitList;
    }

    @XmlTransient
    public List<EstructuraDatos> getEstructuraDatosList() {
        return estructuraDatosList;
    }

    public void setEstructuraDatosList(List<EstructuraDatos> estructuraDatosList) {
        this.estructuraDatosList = estructuraDatosList;
    }

    @XmlTransient
    public List<PosicionSueldo> getPosicionSueldoList() {
        return posicionSueldoList;
    }

    public void setPosicionSueldoList(List<PosicionSueldo> posicionSueldoList) {
        this.posicionSueldoList = posicionSueldoList;
    }

    @XmlTransient
    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }

    public String getSeleccione() {
        return seleccione;
    }

    public void setSeleccione(String seleccione) {
        this.seleccione = seleccione;
    }

    public String getFechaIngresoStr() {
        return fechaIngresoStr;
    }

    public void setFechaIngresoStr(String fechaIngresoStr) {
        this.fechaIngresoStr = fechaIngresoStr;
    }

    public String getFechaBajaStr() {
        return fechaBajaStr;
    }

    public void setFechaBajaStr(String fechaBajaStr) {
        this.fechaBajaStr = fechaBajaStr;
    }

    public String getFechaAntiguedadStr() {
        return fechaAntiguedadStr;
    }

    public void setFechaAntiguedadStr(String fechaAntiguedadStr) {
        this.fechaAntiguedadStr = fechaAntiguedadStr;
    }

    @XmlTransient
    public List<SaldoVacaciones> getSaldoVacacionesList() {
        return saldoVacacionesList;
    }

    public void setSaldoVacacionesList(List<SaldoVacaciones> saldoVacacionesList) {
        this.saldoVacacionesList = saldoVacacionesList;
    }

    public SistemaAntiguedad getIdsistemaantiguedad() {
        return idsistemaantiguedad;
    }

    public void setIdsistemaantiguedad(SistemaAntiguedad idsistemaantiguedad) {
        this.idsistemaantiguedad = idsistemaantiguedad;
    }

    @XmlTransient
    public List<AdelantoVacaciones> getAdelantoVacacionesList() {
        return adelantoVacacionesList;
    }

    public void setAdelantoVacacionesList(List<AdelantoVacaciones> adelantoVacacionesList) {
        this.adelantoVacacionesList = adelantoVacacionesList;
    }
}
