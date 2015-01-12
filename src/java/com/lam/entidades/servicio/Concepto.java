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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "nomconceptostb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concepto.findAll", query = "SELECT c FROM Concepto c ORDER BY c.nombre ASC"),
    @NamedQuery(name = "Concepto.findByIdconcepto", query = "SELECT c FROM Concepto c WHERE c.idconcepto = :idconcepto"),
    @NamedQuery(name = "Concepto.findByConcepto", query = "SELECT c FROM Concepto c WHERE c.concepto = :concepto"),
    @NamedQuery(name = "Concepto.findByNombre", query = "SELECT c FROM Concepto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Concepto.findByNombrecorto", query = "SELECT c FROM Concepto c WHERE c.nombrecorto = :nombrecorto"),
    @NamedQuery(name = "Concepto.findByTipoconcepto", query = "SELECT c FROM Concepto c WHERE c.tipoconcepto = :tipoconcepto"),
    @NamedQuery(name = "Concepto.findByUnidad", query = "SELECT c FROM Concepto c WHERE c.unidad = :unidad")})
public class Concepto implements Serializable {
    @OneToMany(mappedBy = "idconcepto")
    private List<CatalogoConcepto> catalogoConceptoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCONCEPTO")
    private Integer idconcepto;
    @Size(max = 45)
    @Column(name = "CONCEPTO")
    private String concepto;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "NOMBRECORTO")
    private String nombrecorto;
    @Size(max = 2)
    @Column(name = "TIPOCONCEPTO")
    private String tipoconcepto;
    @Size(max = 45)
    @Column(name = "UNIDAD")
    private String unidad;
    @OneToMany(mappedBy = "idconcepto")
    private List<CatalogoGrupoConcepto> catalogoGrupoConceptoList;
    @Transient
    private String signo;
    @Transient
    private String conceptoDescripcion;
    @Transient
    private String unidadDescripcion;

    public Concepto() {
    }

    public Concepto(Integer idconcepto) {
        this.idconcepto = idconcepto;
    }

    public Integer getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Integer idconcepto) {
        this.idconcepto = idconcepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto != null ? concepto.trim().toUpperCase() : null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre != null ? nombre.trim().toUpperCase() : null;
    }

    public String getNombrecorto() {
        return nombrecorto;
    }

    public void setNombrecorto(String nombrecorto) {
        this.nombrecorto = nombrecorto != null ? nombrecorto.trim().toUpperCase() : null;
    }

    public String getTipoconcepto() {
        return tipoconcepto;
    }

    public void setTipoconcepto(String tipoconcepto) {
        this.tipoconcepto = tipoconcepto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad != null ? unidad.trim().toUpperCase() : null;
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
        hash += (idconcepto != null ? idconcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concepto)) {
            return false;
        }
        Concepto other = (Concepto) object;
        if ((this.idconcepto == null && other.idconcepto != null) || (this.idconcepto != null && !this.idconcepto.equals(other.idconcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.Concepto[ idconcepto=" + idconcepto + " ]";
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getConceptoDescripcion() {
        return conceptoDescripcion;
    }

    public void setConceptoDescripcion(String conceptoDescripcion) {
        this.conceptoDescripcion = conceptoDescripcion;
    }

    public String getUnidadDescripcion() {
        return unidadDescripcion;
    }

    public void setUnidadDescripcion(String unidadDescripcion) {
        this.unidadDescripcion = unidadDescripcion;
    }

    @XmlTransient
    public List<CatalogoConcepto> getCatalogoConceptoList() {
        return catalogoConceptoList;
    }

    public void setCatalogoConceptoList(List<CatalogoConcepto> catalogoConceptoList) {
        this.catalogoConceptoList = catalogoConceptoList;
    }
}
