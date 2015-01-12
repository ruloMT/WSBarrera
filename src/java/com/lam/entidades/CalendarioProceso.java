/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "calendario_procesos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarioProceso.find",
            query = "SELECT p FROM CalendarioProceso p WHERE p.tipoNomina = :tipoNomina AND p.anio = :anio AND p.periodo = :periodo")
})
public class CalendarioProceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_calendario")
    private Integer idCalendario;
    @Size(max = 2)
    @Column(name = "tipo_nomina")
    private String tipoNomina;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "periodo")
    private Integer periodo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "mes_acumular")
    private Integer mesAcumular;
    @Column(name = "anio_acumular")
    private Integer anioAcumular;

    public CalendarioProceso() {
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getTipoNomina() {
        return tipoNomina;
    }

    public void setTipoNomina(String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getMesAcumular() {
        return mesAcumular;
    }

    public void setMesAcumular(Integer mesAcumular) {
        this.mesAcumular = mesAcumular;
    }

    public Integer getAnioAcumular() {
        return anioAcumular;
    }

    public void setAnioAcumular(Integer anioAcumular) {
        this.anioAcumular = anioAcumular;
    }

}
