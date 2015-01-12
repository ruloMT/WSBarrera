/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "clases_nomina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaseNomina.findAll", query = "SELECT c FROM ClaseNomina c ORDER BY c.claseNomina ASC"),
    @NamedQuery(name = "ClaseNomina.findByClaseNomina", query = "SELECT c FROM ClaseNomina c WHERE c.claseNomina = :claseNomina")
})
public class ClaseNomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 2)
    @Column(name = "clase_nomina")
    private String claseNomina;
    @Size(max = 40)
    @Column(name = "descripcion")
    private String descripcion;

    public ClaseNomina() {
    }

    public String getClaseNomina() {
        return claseNomina;
    }

    public void setClaseNomina(String claseNomina) {
        this.claseNomina = claseNomina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
