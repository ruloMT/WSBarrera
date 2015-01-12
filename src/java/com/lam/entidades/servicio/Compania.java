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
@Table(name = "admcompaniatb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compania.findAll", query = "SELECT c FROM Compania c ORDER BY c.nombre ASC"),
    @NamedQuery(name = "Compania.findByIdcompania", query = "SELECT c FROM Compania c WHERE c.idcompania = :idcompania"),
    @NamedQuery(name = "Compania.findByNombreCorto", query = "SELECT c FROM Compania c WHERE c.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "Compania.findByEstatus", query = "SELECT c FROM Compania c WHERE c.estatus = :estatus"),
    @NamedQuery(name = "Compania.findByNombre", query = "SELECT c FROM Compania c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Compania.findByClave", query = "SELECT c FROM Compania c WHERE c.clave = :clave"),
    @NamedQuery(name = "Compania.findByRfc", query = "SELECT c FROM Compania c WHERE c.rfc = :rfc"),
    @NamedQuery(name = "Compania.findByPathCarpetaTxt", query = "SELECT c FROM Compania c WHERE c.pathCarpetaTxt = :pathCarpetaTxt"),
    @NamedQuery(name = "Compania.findByPathCarpetaLogo", query = "SELECT c FROM Compania c WHERE c.pathCarpetaLogo = :pathCarpetaLogo"),
    @NamedQuery(name = "Compania.findByPathCarpetaTimbre", query = "SELECT c FROM Compania c WHERE c.pathCarpetaTimbre = :pathCarpetaTimbre"),
    @NamedQuery(name = "Compania.findByPathCarpetaProcesados", query = "SELECT c FROM Compania c WHERE c.pathCarpetaProcesados = :pathCarpetaProcesados"),
    @NamedQuery(name = "Compania.findByPathCarpetaLogs", query = "SELECT c FROM Compania c WHERE c.pathCarpetaLogs = :pathCarpetaLogs")})
public class Compania implements Serializable {
    @OneToMany(mappedBy = "idcompania")
    private List<Formula> formulastbList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMPANIA")
    private Integer idcompania;
    @Size(max = 255)
    @Column(name = "NOMBRE_CORTO")
    private String nombreCorto;
    @Size(max = 255)
    @Column(name = "ESTATUS")
    private String estatus;
    @Size(max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 255)
    @Column(name = "RFC")
    private String rfc;
    @Size(max = 255)
    @Column(name = "PATH_CARPETA_TXT")
    private String pathCarpetaTxt;
    @Size(max = 255)
    @Column(name = "PATH_CARPETA_LOGO")
    private String pathCarpetaLogo;
    @Size(max = 255)
    @Column(name = "PATH_CARPETA_TIMBRE")
    private String pathCarpetaTimbre;
    @Size(max = 255)
    @Column(name = "PATH_CARPETA_PROCESADOS")
    private String pathCarpetaProcesados;
    @Size(max = 255)
    @Column(name = "PATH_CARPETA_LOGS")
    private String pathCarpetaLogs;
    @OneToMany(mappedBy = "idcompania")
    private List<RegistroPatronal> registroPatronalList;
    @OneToMany(mappedBy = "idcompania")
    private List<RelacionLaboral> relacionLaboralList;
    @OneToMany(mappedBy = "idcompania")
    private List<Puesto> puestoList;
    @OneToMany(mappedBy = "idcompania")
    private List<Departamento> departamentoList;
    @OneToMany(mappedBy = "idcompania")
    private List<GrupoPago> grupoPagoList;
    @OneToMany(mappedBy = "idcompania")
    private List<Turno> turnoList;

    public Compania() {
    }

    public Compania(Integer idcompania) {
        this.idcompania = idcompania;
    }

    public Integer getIdcompania() {
        return idcompania;
    }

    public void setIdcompania(Integer idcompania) {
        this.idcompania = idcompania;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getPathCarpetaTxt() {
        return pathCarpetaTxt;
    }

    public void setPathCarpetaTxt(String pathCarpetaTxt) {
        this.pathCarpetaTxt = pathCarpetaTxt;
    }

    public String getPathCarpetaLogo() {
        return pathCarpetaLogo;
    }

    public void setPathCarpetaLogo(String pathCarpetaLogo) {
        this.pathCarpetaLogo = pathCarpetaLogo;
    }

    public String getPathCarpetaTimbre() {
        return pathCarpetaTimbre;
    }

    public void setPathCarpetaTimbre(String pathCarpetaTimbre) {
        this.pathCarpetaTimbre = pathCarpetaTimbre;
    }

    public String getPathCarpetaProcesados() {
        return pathCarpetaProcesados;
    }

    public void setPathCarpetaProcesados(String pathCarpetaProcesados) {
        this.pathCarpetaProcesados = pathCarpetaProcesados;
    }

    public String getPathCarpetaLogs() {
        return pathCarpetaLogs;
    }

    public void setPathCarpetaLogs(String pathCarpetaLogs) {
        this.pathCarpetaLogs = pathCarpetaLogs;
    }

    @XmlTransient
    public List<RegistroPatronal> getRegistroPatronalList() {
        return registroPatronalList;
    }

    public void setRegistroPatronalList(List<RegistroPatronal> registroPatronalList) {
        this.registroPatronalList = registroPatronalList;
    }

    @XmlTransient
    public List<RelacionLaboral> getRelacionLaboralList() {
        return relacionLaboralList;
    }

    public void setRelacionLaboralList(List<RelacionLaboral> relacionLaboralList) {
        this.relacionLaboralList = relacionLaboralList;
    }

    @XmlTransient
    public List<Puesto> getPuestoList() {
        return puestoList;
    }

    public void setPuestoList(List<Puesto> puestoList) {
        this.puestoList = puestoList;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @XmlTransient
    public List<GrupoPago> getGrupoPagoList() {
        return grupoPagoList;
    }

    public void setGrupoPagoList(List<GrupoPago> grupoPagoList) {
        this.grupoPagoList = grupoPagoList;
    }

    @XmlTransient
    public List<Turno> getTurnoList() {
        return turnoList;
    }

    public void setTurnoList(List<Turno> turnoList) {
        this.turnoList = turnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompania != null ? idcompania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compania)) {
            return false;
        }
        Compania other = (Compania) object;
        if ((this.idcompania == null && other.idcompania != null) || (this.idcompania != null && !this.idcompania.equals(other.idcompania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.Compania[ idcompania=" + idcompania + " ]";
    }

    @XmlTransient
    public List<Formula> getFormulastbList() {
        return formulastbList;
    }

    public void setFormulastbList(List<Formula> formulastbList) {
        this.formulastbList = formulastbList;
    }
    
}
