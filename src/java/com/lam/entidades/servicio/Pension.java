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
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhrelacionlaboralpensionestb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pension.findAll", query = "SELECT p FROM Pension p ORDER BY p.cuenta ASC"),
    @NamedQuery(name = "Pension.findByIdPension", query = "SELECT p FROM Pension p WHERE p.idpension = :idpension"),
    @NamedQuery(name = "Pension.findByIdRellab", query = "SELECT p FROM Pension p WHERE p.idrellab.idrellab = :idrellab"),
    @NamedQuery(name = "Pension.findByOficioAndNumeroEmpleado", query = "SELECT p FROM Pension p WHERE p.oficio = :oficio AND p.idrellab.numeroempleado = :numeroempleado")
})
public class Pension implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRELLABPENSION")
    private Integer idpension;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "APELLIDOPATERNO")
    private String apellidopaterno;
    @Size(max = 45)
    @Column(name = "APELIIDOMATERNO")
    private String apellidomaterno;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "TIPOCALCULO")
    private String tipocalculo;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Size(max = 45)
    @Column(name = "OFICIO")
    private String oficio;
    @Size(max = 100)
    @Column(name = "JUEZ")
    private String juez;
    @Size(max = 45)
    @Column(name = "FORMAPAGO")
    private String formadepago;
    @Size(max = 45)
    @Column(name = "CUENTA")
    private String cuenta;
    @Size(max = 45)
    @Column(name = "CLABE")
    private String clabe;
    @Size(max = 2)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @JoinColumn(name = "IDBANCO", referencedColumnName = "IDBANCO")
    @ManyToOne
    private Banco idbanco;
    @OneToMany(mappedBy = "idpension")
    private List<CatalogoGrupoPension> catalogoGrupoPensionList;
    @Transient
    private String fechaStr;

    public Pension() {
    }

    public Integer getIdpension() {
        return idpension;
    }

    public void setIdpension(Integer idpension) {
        this.idpension = idpension;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno != null ? apellidopaterno.trim().toUpperCase() : apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno != null ? apellidomaterno.trim().toUpperCase() : null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim().toUpperCase() : null;
    }

    public String getTipocalculo() {
        return tipocalculo;
    }

    public void setTipocalculo(String tipocalculo) {
        this.tipocalculo = tipocalculo;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getJuez() {
        return juez;
    }

    public void setJuez(String juez) {
        this.juez = juez != null ? juez.trim().toUpperCase() : null;
    }

    public String getFormadepago() {
        return formadepago;
    }

    public void setFormadepago(String formadepago) {
        this.formadepago = formadepago;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta != null ? cuenta.trim().toUpperCase() : null;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe != null ? clabe.trim().toUpperCase() : null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RelacionLaboral getIdrellab() {
        return idrellab;
    }

    public void setIdrellab(RelacionLaboral idrellab) {
        this.idrellab = idrellab;
    }

    public Banco getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Banco idbanco) {
        this.idbanco = idbanco;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio != null ? oficio.trim().toUpperCase() : null;
    }

    @XmlTransient
    public List<CatalogoGrupoPension> getCatalogoGrupoPensionList() {
        return catalogoGrupoPensionList;
    }

    public void setCatalogoGrupoPensionList(List<CatalogoGrupoPension> catalogoGrupoPensionList) {
        this.catalogoGrupoPensionList = catalogoGrupoPensionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpension != null ? idpension.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pension)) {
            return false;
        }
        Pension other = (Pension) object;
        if ((this.idpension == null && other.idpension != null) || (this.idpension != null && !this.idpension.equals(other.idpension))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Pension[ idpension=" + idpension + " ]";
    }

    public String getFechaStr() {
        return fechaStr;
    }

    public void setFechaStr(String fechaStr) {
        this.fechaStr = fechaStr;
    }
}
