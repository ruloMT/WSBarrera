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
@Table(name = "catgeneraltb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoGeneral.findAll", query = "SELECT c FROM CatalogoGeneral c ORDER BY c.tabla,c.columna ASC"),
    @NamedQuery(name = "CatalogoGeneral.findByIdcatgeneral", query = "SELECT c FROM CatalogoGeneral c WHERE c.idcatgeneral = :idcatgeneral"),
    @NamedQuery(name = "CatalogoGeneral.findByTablaAndColumna", query = "SELECT c FROM CatalogoGeneral c WHERE c.tabla = :tabla AND c.columna = :columna ORDER BY c.valor ASC"),
    @NamedQuery(name = "CatalogoGeneral.findByColumna", query = "SELECT c FROM CatalogoGeneral c WHERE c.columna = :columna"),
    @NamedQuery(name = "CatalogoGeneral.findByNombreAndTabla", query = "SELECT c FROM CatalogoGeneral c WHERE c.nombre = :nombre AND c.tabla = :tabla AND c.columna = :columna"),
    @NamedQuery(name = "CatalogoGeneral.findByTabla", query = "SELECT c FROM CatalogoGeneral c WHERE c.tabla = :tabla"),
    @NamedQuery(name = "CatalogoGeneral.findByValor", query = "SELECT c FROM CatalogoGeneral c WHERE c.valor = :valor")})
public class CatalogoGeneral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATGENERAL")
    private Integer idcatgeneral;
    @Size(max = 255)
    @Column(name = "COLUMNA")
    private String columna;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 255)
    @Column(name = "TABLA")
    private String tabla;
    @Size(max = 255)
    @Column(name = "VALOR")
    private String valor;

    public CatalogoGeneral() {
    }

    public CatalogoGeneral(Integer idcatgeneral) {
        this.idcatgeneral = idcatgeneral;
    }

    public Integer getIdcatgeneral() {
        return idcatgeneral;
    }

    public void setIdcatgeneral(Integer idcatgeneral) {
        this.idcatgeneral = idcatgeneral;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna.trim().toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim().toUpperCase();
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla.trim().toUpperCase();
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor.trim().toUpperCase();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcatgeneral != null ? idcatgeneral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoGeneral)) {
            return false;
        }
        CatalogoGeneral other = (CatalogoGeneral) object;
        if ((this.idcatgeneral == null && other.idcatgeneral != null) || (this.idcatgeneral != null && !this.idcatgeneral.equals(other.idcatgeneral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.CatalogoGeneral[ idcatgeneral=" + idcatgeneral + " ]";
    }
}
