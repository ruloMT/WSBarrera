/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.cenicco;

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
@Table(name = "admusuariosportaltb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusario", query = "SELECT u FROM Usuario u WHERE u.idusario = :idusario"),
    @NamedQuery(name = "Usuario.findByNumeroEmpleado", query = "SELECT u FROM Usuario u WHERE u.numeroEmpleado = :numeroEmpleado"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByRfcAndNumeroEmpleado", query = "SELECT u FROM Usuario u WHERE u.rfc = :rfc AND u.numeroEmpleado = :numeroEmpleado"),
    @NamedQuery(name = "Usuario.findByCurp", query = "SELECT u FROM Usuario u WHERE u.curp = :curp"),
    @NamedQuery(name = "Usuario.findByNss", query = "SELECT u FROM Usuario u WHERE u.nss = :nss"),
    @NamedQuery(name = "Usuario.findByPerfilAdmin", query = "SELECT u FROM Usuario u WHERE u.perfilAdmin = :perfilAdmin"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSUARIO")
    private Integer idusario;
    @Column(name = "IDCOMPANIA")
    private Integer idcompania;
    @Size(max = 45)
    @Column(name = "NUMERO_EMPLEADO")
    private String numeroEmpleado;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "RFC")
    private String rfc;
    @Size(max = 45)
    @Column(name = "CURP")
    private String curp;
    @Size(max = 45)
    @Column(name = "NSS")
    private String nss;
    @Column(name = "PERFIL_ADMIN")
    private Integer perfilAdmin;
    @Size(max = 45)
    @Column(name = "PASSWORD")
    private String password;

    public Usuario() {
    }

    public Usuario(Integer idusario) {
        this.idusario = idusario;
    }

    public Integer getIdusario() {
        return idusario;
    }

    public void setIdusario(Integer idusario) {
        this.idusario = idusario;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public Integer getPerfilAdmin() {
        return perfilAdmin;
    }

    public void setPerfilAdmin(Integer perfilAdmin) {
        this.perfilAdmin = perfilAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(Integer idcompania) {
        this.idcompania = idcompania;
    }
}
