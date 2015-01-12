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
import javax.persistence.Lob;
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
@Table(name = "rhempleadodoctotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByIddocto", query = "SELECT d FROM Documento d WHERE d.iddocto = :iddocto"),
    @NamedQuery(name = "Documento.findByIdEmpleado", query = "SELECT d FROM Documento d WHERE d.idempleado.idempleado = :idempleado"),
    @NamedQuery(name = "Documento.findByObservaciones", query = "SELECT d FROM Documento d WHERE d.observaciones = :observaciones")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDOCTO")
    private Integer iddocto;
    @Lob
    @Column(name = "ARCHIVO")
    private byte[] archivo;
    @Size(max = 300)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "IDTIPODOCTO", referencedColumnName = "IDTIPODOCTO")
    @ManyToOne
    private TipoDocumento idtipodocto;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne
    private Empleado idempleado;

    public Documento() {
    }

    public Documento(Integer iddocto) {
        this.iddocto = iddocto;
    }

    public Integer getIddocto() {
        return iddocto;
    }

    public void setIddocto(Integer iddocto) {
        this.iddocto = iddocto;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones != null ? observaciones.trim().toUpperCase() : null;
    }

    public TipoDocumento getIdtipodocto() {
        return idtipodocto;
    }

    public void setIdtipodocto(TipoDocumento idtipodocto) {
        this.idtipodocto = idtipodocto;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocto != null ? iddocto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.iddocto == null && other.iddocto != null) || (this.iddocto != null && !this.iddocto.equals(other.iddocto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.Documento[ iddocto=" + iddocto + " ]";
    }
}
