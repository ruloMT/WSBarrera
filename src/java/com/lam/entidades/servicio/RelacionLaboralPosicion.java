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
@Table(name = "rhrelacionlaboralposiciontb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacionLaboralPosicion.findAll", query = "SELECT r FROM RelacionLaboralPosicion r"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByIdrelacionlaboralposicion", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.idrelacionlaboralposicion = :idrelacionlaboralposicion"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByEstatus", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.estatus = :estatus"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByFechafin", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.fechafin = :fechafin"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByFechainicio", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.fechainicio = :fechainicio"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByFormapago", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.formapago = :formapago"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByJornadalaboral", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.jornadalaboral = :jornadalaboral"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByNivel", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.nivel = :nivel"),
    @NamedQuery(name = "RelacionLaboralPosicion.findBySindicalizado", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.sindicalizado = :sindicalizado"),
    @NamedQuery(name = "RelacionLaboralPosicion.findByIds", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.idtiposueldo.idtiposueldo = :idtiposueldo AND r.iddepartamento.iddepartamento = :iddepartamento AND r.idpuesto.idpuesto = :idpuesto AND r.idturno.idturno = :idturno ORDER BY r.idrelacionlaboralposicion DESC"),
    @NamedQuery(name = "RelacionLaboralPosicion.findBySistemahorario", query = "SELECT r FROM RelacionLaboralPosicion r WHERE r.sistemahorario = :sistemahorario")})
public class RelacionLaboralPosicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRELACIONLABORALPOSICION")
    private Integer idrelacionlaboralposicion;
    @Size(max = 255)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Size(max = 255)
    @Column(name = "FORMAPAGO")
    private String formapago;
    @Size(max = 255)
    @Column(name = "JORNADALABORAL")
    private String jornadalaboral;
    @Size(max = 255)
    @Column(name = "NIVEL")
    private String nivel;
    @Size(max = 255)
    @Column(name = "SINDICALIZADO")
    private String sindicalizado;
    @Size(max = 255)
    @Column(name = "SISTEMAHORARIO")
    private String sistemahorario;
    @OneToMany(mappedBy = "idrelacionlaboralposicion")
    private List<RelacionLaboral> relacionLaboralList;
    @JoinColumn(name = "IDTURNO", referencedColumnName = "IDTURNO")
    @ManyToOne
    private Turno idturno;
    @JoinColumn(name = "IDTIPOSUELDO", referencedColumnName = "IDTIPOSUELDO")
    @ManyToOne
    private TipoSueldo idtiposueldo;
    @JoinColumn(name = "IDPUESTO", referencedColumnName = "IDPUESTO")
    @ManyToOne
    private Puesto idpuesto;
    @JoinColumn(name = "IDDEPARTAMENTO", referencedColumnName = "IDDEPARTAMENTO")
    @ManyToOne
    private Departamento iddepartamento;

    public RelacionLaboralPosicion() {
    }

    public RelacionLaboralPosicion(Integer idrelacionlaboralposicion) {
        this.idrelacionlaboralposicion = idrelacionlaboralposicion;
    }

    public Integer getIdrelacionlaboralposicion() {
        return idrelacionlaboralposicion;
    }

    public void setIdrelacionlaboralposicion(Integer idrelacionlaboralposicion) {
        this.idrelacionlaboralposicion = idrelacionlaboralposicion;
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

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getJornadalaboral() {
        return jornadalaboral;
    }

    public void setJornadalaboral(String jornadalaboral) {
        this.jornadalaboral = jornadalaboral;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getSindicalizado() {
        return sindicalizado;
    }

    public void setSindicalizado(String sindicalizado) {
        this.sindicalizado = sindicalizado;
    }

    public String getSistemahorario() {
        return sistemahorario;
    }

    public void setSistemahorario(String sistemahorario) {
        this.sistemahorario = sistemahorario;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }

    public Turno getIdturno() {
        return idturno;
    }

    public void setIdturno(Turno idturno) {
        this.idturno = idturno;
    }

    public TipoSueldo getIdtiposueldo() {
        return idtiposueldo;
    }

    public void setIdtiposueldo(TipoSueldo idtiposueldo) {
        this.idtiposueldo = idtiposueldo;
    }

    public Puesto getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(Puesto idpuesto) {
        this.idpuesto = idpuesto;
    }

    public Departamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Departamento iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelacionlaboralposicion != null ? idrelacionlaboralposicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionLaboralPosicion)) {
            return false;
        }
        RelacionLaboralPosicion other = (RelacionLaboralPosicion) object;
        if ((this.idrelacionlaboralposicion == null && other.idrelacionlaboralposicion != null) || (this.idrelacionlaboralposicion != null && !this.idrelacionlaboralposicion.equals(other.idrelacionlaboralposicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.RelacionLaboralPosicion[ idrelacionlaboralposicion=" + idrelacionlaboralposicion + " ]";
    }
    
}
