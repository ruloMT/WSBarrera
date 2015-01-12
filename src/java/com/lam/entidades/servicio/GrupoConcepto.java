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
@Table(name = "nomgruposconceptosdetalletb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoConcepto.findAll", query = "SELECT g FROM GrupoConcepto g"),
    @NamedQuery(name = "GrupoConcepto.findByIdgrupoconcepto", query = "SELECT g FROM GrupoConcepto g WHERE g.idgrupoconcepto = :idgrupoconcepto"),
    @NamedQuery(name = "GrupoConcepto.findByFecha", query = "SELECT g FROM GrupoConcepto g WHERE g.fecha = :fecha"),
    @NamedQuery(name = "GrupoConcepto.findByGrupoConcepto", query = "SELECT g FROM GrupoConcepto g WHERE g.grupoconcepto = :grupoconcepto"),
    @NamedQuery(name = "GrupoConcepto.findByNombre", query = "SELECT g FROM GrupoConcepto g WHERE g.nombre = :nombre")})
public class GrupoConcepto implements Serializable {

    @Size(max = 45)
    @Column(name = "GRUPOCONCEPTO")
    private String grupoconcepto;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDGRUPOCONCEPTO")
    private Integer idgrupoconcepto;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idgrupoconcepto")
    private List<CatalogoGrupoConcepto> catalogoGrupoConceptoList;

    public GrupoConcepto() {
    }

    public GrupoConcepto(Integer idgrupoconcepto) {
        this.idgrupoconcepto = idgrupoconcepto;
    }

    public Integer getIdgrupoconcepto() {
        return idgrupoconcepto;
    }

    public void setIdgrupoconcepto(Integer idgrupoconcepto) {
        this.idgrupoconcepto = idgrupoconcepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre == null ? nombre : nombre.toUpperCase().trim();
    }

    @XmlTransient
    public List<CatalogoGrupoConcepto> getCatalogoGrupoConceptoList() {
        return catalogoGrupoConceptoList;
    }

    public void setCatalogoGrupoConceptoList(List<CatalogoGrupoConcepto> catalogoGrupoConceptoList) {
        this.catalogoGrupoConceptoList = catalogoGrupoConceptoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupoconcepto != null ? idgrupoconcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoConcepto)) {
            return false;
        }
        GrupoConcepto other = (GrupoConcepto) object;
        if ((this.idgrupoconcepto == null && other.idgrupoconcepto != null) || (this.idgrupoconcepto != null && !this.idgrupoconcepto.equals(other.idgrupoconcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.GrupoConcepto[ idgrupoconcepto=" + idgrupoconcepto + " ]";
    }

    public String getGrupoconcepto() {
        return grupoconcepto;
    }

    public void setGrupoconcepto(String grupoconcepto) {
        this.grupoconcepto = grupoconcepto == null ? grupoconcepto : grupoconcepto.trim().toUpperCase();
    }
}
