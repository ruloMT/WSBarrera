/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.servicio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhtipocontactotb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContacto.findAll", query = "SELECT t FROM TipoContacto t ORDER BY t.nombre ASC"),
    @NamedQuery(name = "TipoContacto.findByIdtipocontacto", query = "SELECT t FROM TipoContacto t WHERE t.idtipocontacto = :idtipocontacto"),
    @NamedQuery(name = "TipoContacto.findByNombre", query = "SELECT t FROM TipoContacto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoContacto.findByPersonal", query = "SELECT t FROM TipoContacto t WHERE t.personal = :personal")})
public class TipoContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPOCONTACTO")
    private Integer idtipocontacto;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 255)
    @Column(name = "PERSONAL")
    private String personal;
    @OneToMany(mappedBy = "idtipocontacto")
    private List<Contacto> contactoList;

    public TipoContacto() {
    }

    public TipoContacto(Integer idtipocontacto) {
        this.idtipocontacto = idtipocontacto;
    }

    public Integer getIdtipocontacto() {
        return idtipocontacto;
    }

    public void setIdtipocontacto(Integer idtipocontacto) {
        this.idtipocontacto = idtipocontacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocontacto != null ? idtipocontacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContacto)) {
            return false;
        }
        TipoContacto other = (TipoContacto) object;
        if ((this.idtipocontacto == null && other.idtipocontacto != null) || (this.idtipocontacto != null && !this.idtipocontacto.equals(other.idtipocontacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.TipoContacto[ idtipocontacto=" + idtipocontacto + " ]";
    }
    
}
