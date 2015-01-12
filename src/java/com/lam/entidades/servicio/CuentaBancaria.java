/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhrelacionlaboralcuentatb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaBancaria.findAll", query = "SELECT c FROM CuentaBancaria c"),
    @NamedQuery(name = "CuentaBancaria.findByIdcuenta", query = "SELECT c FROM CuentaBancaria c WHERE c.idcuenta = :idcuenta"),
    @NamedQuery(name = "CuentaBancaria.findByClabe", query = "SELECT c FROM CuentaBancaria c WHERE c.clabe = :clabe"),
    @NamedQuery(name = "CuentaBancaria.findByIdRellab", query = "SELECT c FROM CuentaBancaria c WHERE c.idrellab.idrellab = :idrellab"),
    @NamedQuery(name = "CuentaBancaria.findByCuenta", query = "SELECT c FROM CuentaBancaria c WHERE c.cuenta = :cuenta"),
    @NamedQuery(name = "CuentaBancaria.findByEstatus", query = "SELECT c FROM CuentaBancaria c WHERE c.estatus = :estatus"),
    @NamedQuery(name = "CuentaBancaria.findByPorcentaje", query = "SELECT c FROM CuentaBancaria c WHERE c.porcentaje = :porcentaje"),
    @NamedQuery(name = "CuentaBancaria.findByProrrateo", query = "SELECT c FROM CuentaBancaria c WHERE c.prorrateo = :prorrateo"),
    @NamedQuery(name = "CuentaBancaria.findByTipocuenta", query = "SELECT c FROM CuentaBancaria c WHERE c.tipocuenta = :tipocuenta")})
public class CuentaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCUENTA")
    private Integer idcuenta;
    @Size(max = 255)
    @Column(name = "CLABE")
    private String clabe;
    @Size(max = 255)
    @Column(name = "CUENTA")
    private String cuenta;
    @Size(max = 255)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "PORCENTAJE")
    private Integer porcentaje;
    @Column(name = "PRORRATEO")
    private Integer prorrateo;
    @Size(max = 255)
    @Column(name = "TIPOCUENTA")
    private String tipocuenta;
    @JoinColumn(name = "IDRELLAB", referencedColumnName = "IDRELLAB")
    @ManyToOne
    private RelacionLaboral idrellab;
    @JoinColumn(name = "IDBANCO", referencedColumnName = "IDBANCO")
    @ManyToOne
    private Banco idbanco;

    public CuentaBancaria() {
    }

    public CuentaBancaria(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe != null ? clabe.trim().toUpperCase() : null;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta != null ? cuenta.trim().toUpperCase() : null;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getProrrateo() {
        return prorrateo;
    }

    public void setProrrateo(Integer prorrateo) {
        this.prorrateo = prorrateo;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta != null ? tipocuenta.trim().toUpperCase() : null;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuenta != null ? idcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria other = (CuentaBancaria) object;
        if ((this.idcuenta == null && other.idcuenta != null) || (this.idcuenta != null && !this.idcuenta.equals(other.idcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.impl.servicio.CuentaBanco[ idcuenta=" + idcuenta + " ]";
    }
}
