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
import javax.persistence.Lob;
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
@Table(name = "rhempleadotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e ORDER BY e.nombre ASC"),
    @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado"),
    @NamedQuery(name = "Empleado.findByAfiliacion", query = "SELECT e FROM Empleado e WHERE e.afiliacion = :afiliacion"),
    @NamedQuery(name = "Empleado.findByApellidomaterno", query = "SELECT e FROM Empleado e WHERE e.apellidomaterno = :apellidomaterno"),
    @NamedQuery(name = "Empleado.findByApellidopaterno", query = "SELECT e FROM Empleado e WHERE e.apellidopaterno = :apellidopaterno"),
    @NamedQuery(name = "Empleado.findByCurp", query = "SELECT e FROM Empleado e WHERE e.curp = :curp"),
    @NamedQuery(name = "Empleado.findByEstadocivil", query = "SELECT e FROM Empleado e WHERE e.estadocivil = :estadocivil"),
    @NamedQuery(name = "Empleado.findByEstatus", query = "SELECT e FROM Empleado e WHERE e.estatus = :estatus"),
    @NamedQuery(name = "Empleado.findByExpediente", query = "SELECT e FROM Empleado e WHERE e.expediente = :expediente"),
    @NamedQuery(name = "Empleado.findByFechanacimiento", query = "SELECT e FROM Empleado e WHERE e.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Empleado.findByLugarnacimiento", query = "SELECT e FROM Empleado e WHERE e.lugarnacimiento = :lugarnacimiento"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByPathfirma", query = "SELECT e FROM Empleado e WHERE e.pathfirma = :pathfirma"),
    @NamedQuery(name = "Empleado.findByRfc", query = "SELECT e FROM Empleado e WHERE e.rfc = :rfc"),
    @NamedQuery(name = "Empleado.findBySexo", query = "SELECT e FROM Empleado e WHERE e.sexo = :sexo")})
public class Empleado implements Serializable {

    @Lob
    @Column(name = "PATHFOTO")
    private byte[] pathfoto;
    @OneToMany(mappedBy = "idempleado")
    private List<Contacto> contactoList;
    @OneToMany(mappedBy = "idempleado")
    private List<Documento> documentoList;
    @OneToMany(mappedBy = "idempleado")
    private List<Domicilio> domicilioList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEMPLEADO")
    private Integer idempleado;
    @Size(max = 255)
    @Column(name = "AFILIACION")
    private String afiliacion;
    @Size(max = 255)
    @Column(name = "APELLIDOMATERNO")
    private String apellidomaterno;
    @Size(max = 255)
    @Column(name = "APELLIDOPATERNO")
    private String apellidopaterno;
    @Size(max = 255)
    @Column(name = "CURP")
    private String curp;
    @Size(max = 255)
    @Column(name = "ESTADOCIVIL")
    private String estadocivil;
    @Size(max = 255)
    @Column(name = "ESTATUS")
    private String estatus;
    @Size(max = 255)
    @Column(name = "EXPEDIENTE")
    private String expediente;
    @Column(name = "FECHANACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Size(max = 255)
    @Column(name = "LUGARNACIMIENTO")
    private String lugarnacimiento;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 255)
    @Column(name = "PATHFIRMA")
    private String pathfirma;
    @Size(max = 255)
    @Column(name = "RFC")
    private String rfc;
    @Size(max = 255)
    @Column(name = "SEXO")
    private String sexo;
    @OneToMany(mappedBy = "idempleado")
    private List<RelacionLaboral> relacionLaboralList;
    @JoinColumn(name = "IDESTADONACIMIENTO", referencedColumnName = "IDESTADO")
    @ManyToOne
    private Estado idestadonacimiento;

    public Empleado() {
    }

    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion != null ? afiliacion.trim().toUpperCase() : null;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno != null ? apellidomaterno.trim().toUpperCase() : null;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno != null ? apellidopaterno.trim().toUpperCase() : null;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp != null ? curp.trim().toUpperCase() : null;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente != null ? expediente.trim().toUpperCase() : null;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        if (lugarnacimiento == null || lugarnacimiento.equals("")) {
            this.lugarnacimiento = "DESCONOCIDO";
        } else {
            this.lugarnacimiento = lugarnacimiento.trim().toUpperCase();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim().toUpperCase() : null;
    }

    public String getPathfirma() {
        return pathfirma;
    }

    public void setPathfirma(String pathfirma) {
        this.pathfirma = pathfirma;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc != null ? rfc.trim().toUpperCase() : null;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }

    public Estado getIdestadonacimiento() {
        return idestadonacimiento;
    }

    public void setIdestadonacimiento(Estado idestadonacimiento) {
        this.idestadonacimiento = idestadonacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.Empleado[ idempleado=" + idempleado + " ]";
    }

    @XmlTransient
    public List<Domicilio> getDomicilioList() {
        return domicilioList;
    }

    public void setDomicilioList(List<Domicilio> domicilioList) {
        this.domicilioList = domicilioList;
    }

    @XmlTransient
    public List<Documento> getDocumentoList() {
        return documentoList;
    }

    public void setDocumentoList(List<Documento> documentoList) {
        this.documentoList = documentoList;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    public byte[] getPathfoto() {
        return pathfoto;
    }

    public void setPathfoto(byte[] pathfoto) {
        this.pathfoto = pathfoto;
    }
}
