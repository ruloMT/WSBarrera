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
@Table(name = "nomincidenciastb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i "),
    @NamedQuery(name = "Incidencia.findByFechaRegistro", query = "SELECT i FROM Incidencia i WHERE i.fechaact <= :fechafin AND i.fechaact >= :fechainicio"),
    @NamedQuery(name = "Incidencia.findByIdincidencia", query = "SELECT i FROM Incidencia i WHERE i.idincidencia = :idincidencia"),
    @NamedQuery(name = "Incidencia.findByUnidades", query = "SELECT i FROM Incidencia i WHERE i.unidades = :unidades"),
    @NamedQuery(name = "Incidencia.findByImporte", query = "SELECT i FROM Incidencia i WHERE i.importe = :importe"),
    @NamedQuery(name = "Incidencia.findByImportedirecto", query = "SELECT i FROM Incidencia i WHERE i.importedirecto = :importedirecto"),
    @NamedQuery(name = "Incidencia.findByImporteaux01", query = "SELECT i FROM Incidencia i WHERE i.importeaux01 = :importeaux01"),
    @NamedQuery(name = "Incidencia.findByImporteaux02", query = "SELECT i FROM Incidencia i WHERE i.importeaux02 = :importeaux02"),
    @NamedQuery(name = "Incidencia.findByFechaaux01", query = "SELECT i FROM Incidencia i WHERE i.fechaaux01 = :fechaaux01"),
    @NamedQuery(name = "Incidencia.findByFechaaux02", query = "SELECT i FROM Incidencia i WHERE i.fechaaux02 = :fechaaux02"),
    @NamedQuery(name = "Incidencia.findByTextoaux01", query = "SELECT i FROM Incidencia i WHERE i.textoaux01 = :textoaux01"),
    @NamedQuery(name = "Incidencia.findByTextoaux02", query = "SELECT i FROM Incidencia i WHERE i.textoaux02 = :textoaux02"),
    @NamedQuery(name = "Incidencia.findByReferencia01", query = "SELECT i FROM Incidencia i WHERE i.referencia01 = :referencia01"),
    @NamedQuery(name = "Incidencia.findByReferencia02", query = "SELECT i FROM Incidencia i WHERE i.referencia02 = :referencia02"),
    @NamedQuery(name = "Incidencia.findByOrigen", query = "SELECT i FROM Incidencia i WHERE i.origen = :origen"),
    @NamedQuery(name = "Incidencia.findByEstatus", query = "SELECT i FROM Incidencia i WHERE i.estatus = :estatus"),
    @NamedQuery(name = "Incidencia.findByFechaact", query = "SELECT i FROM Incidencia i WHERE i.fechaact = :fechaact")})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINCIDENCIA")
    private Integer idincidencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UNIDADES")
    private Double unidades;
    @Column(name = "IMPORTE")
    private Double importe;
    @Column(name = "IMPORTEDIRECTO")
    private Double importedirecto;
    @Column(name = "IMPORTEAUX01")
    private Double importeaux01;
    @Column(name = "IMPORTEAUX02")
    private Double importeaux02;
    @Column(name = "FECHAAUX01")
    @Temporal(TemporalType.DATE)
    private Date fechaaux01;
    @Column(name = "FECHAAUX02")
    @Temporal(TemporalType.DATE)
    private Date fechaaux02;
    @Size(max = 100)
    @Column(name = "TEXTOAUX01")
    private String textoaux01;
    @Size(max = 100)
    @Column(name = "TEXTOAUX02")
    private String textoaux02;
    @Size(max = 100)
    @Column(name = "REFERENCIA01")
    private String referencia01;
    @Size(max = 100)
    @Column(name = "REFERENCIA02")
    private String referencia02;
    @Column(name = "ORIGEN")
    private Integer origen;
    @Size(max = 2)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHAACT")
    @Temporal(TemporalType.DATE)
    private Date fechaact;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @JoinColumn(name = "IDPERIODO", referencedColumnName = "IDPERIODO")
    @ManyToOne
    private Periodo idperiodo;
    @JoinColumn(name = "IDCATCONCEPTO", referencedColumnName = "IDCATCONCEPTO")
    @ManyToOne
    private CatalogoConcepto idcatconcepto;
    @Transient
    private String fAux01;
    @Transient
    private String fAux02;
    @Transient
    private String fActualiza;
    @Transient
    private String statusStr;

    public Incidencia() {
    }

    public Incidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Integer getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Double getUnidades() {
        return unidades;
    }

    public void setUnidades(Double unidades) {
        this.unidades = unidades;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getImportedirecto() {
        return importedirecto;
    }

    public void setImportedirecto(Double importedirecto) {
        this.importedirecto = importedirecto;
    }

    public Double getImporteaux01() {
        return importeaux01;
    }

    public void setImporteaux01(Double importeaux01) {
        this.importeaux01 = importeaux01;
    }

    public Double getImporteaux02() {
        return importeaux02;
    }

    public void setImporteaux02(Double importeaux02) {
        this.importeaux02 = importeaux02;
    }

    public Date getFechaaux01() {
        return fechaaux01;
    }

    public void setFechaaux01(Date fechaaux01) {
        this.fechaaux01 = fechaaux01;
    }

    public Date getFechaaux02() {
        return fechaaux02;
    }

    public void setFechaaux02(Date fechaaux02) {
        this.fechaaux02 = fechaaux02;
    }

    public String getTextoaux01() {
        return textoaux01;
    }

    public void setTextoaux01(String textoaux01) {
        this.textoaux01 = textoaux01;
    }

    public String getTextoaux02() {
        return textoaux02;
    }

    public void setTextoaux02(String textoaux02) {
        this.textoaux02 = textoaux02;
    }

    public String getReferencia01() {
        return referencia01;
    }

    public void setReferencia01(String referencia01) {
        this.referencia01 = referencia01;
    }

    public String getReferencia02() {
        return referencia02;
    }

    public void setReferencia02(String referencia02) {
        this.referencia02 = referencia02;
    }

    public Integer getOrigen() {
        return origen;
    }

    public void setOrigen(Integer origen) {
        this.origen = origen;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaact() {
        return fechaact;
    }

    public void setFechaact(Date fechaact) {
        this.fechaact = fechaact;
    }

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
    }

    public Periodo getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Periodo idperiodo) {
        this.idperiodo = idperiodo;
    }

    public CatalogoConcepto getIdcatconcepto() {
        return idcatconcepto;
    }

    public void setIdcatconcepto(CatalogoConcepto idcatconcepto) {
        this.idcatconcepto = idcatconcepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idincidencia != null ? idincidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.idincidencia == null && other.idincidencia != null) || (this.idincidencia != null && !this.idincidencia.equals(other.idincidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Incidencia[ idincidencia=" + idincidencia + " ]";
    }

    public String getfAux01() {
        return fAux01;
    }

    public void setfAux01(String fAux01) {
        this.fAux01 = fAux01;
    }

    public String getfAux02() {
        return fAux02;
    }

    public void setfAux02(String fAux02) {
        this.fAux02 = fAux02;
    }

    public String getfActualiza() {
        return fActualiza;
    }

    public void setfActualiza(String fActualiza) {
        this.fActualiza = fActualiza;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public void toUpperCaseTrim() {
        this.textoaux01 = this.textoaux01 != null ? this.textoaux01.trim().toUpperCase() : null;
        this.textoaux02 = this.textoaux02 != null ? this.textoaux02.trim().toUpperCase() : null;
//        
        this.referencia01 = this.referencia01 != null ? this.referencia01.trim().toUpperCase() : null;
        this.referencia02 = this.referencia02 != null ? this.referencia02.trim().toUpperCase() : null;
//
        this.fechaact = new Date();
    }
}
