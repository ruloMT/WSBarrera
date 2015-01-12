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
@Table(name = "tipos_nomina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoNomina.findAll", query = "SELECT t FROM TipoNomina t ORDER BY t.tipoNomina ASC"),
    @NamedQuery(name = "TipoNomina.findByTipoNomina", query = "SELECT t FROM TipoNomina t WHERE t.tipoNomina = :tipoNomina")
})
public class TipoNomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 2)
    @Column(name = "tipo_nomina")
    private String tipoNomina;
    @Size(max = 40)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "manejo")
    private Integer manejo;
    @Column(name = "agr_historica")
    private Integer agrHistorica;

    public TipoNomina() {
    }

    public String getTipoNomina() {
        return tipoNomina;
    }

    public void setTipoNomina(String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getManejo() {
        return manejo;
    }

    public void setManejo(Integer manejo) {
        this.manejo = manejo;
    }

    public Integer getAgrHistorica() {
        return agrHistorica;
    }

    public void setAgrHistorica(Integer agrHistorica) {
        this.agrHistorica = agrHistorica;
    }
}
