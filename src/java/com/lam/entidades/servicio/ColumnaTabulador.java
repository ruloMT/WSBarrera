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
@Table(name = "nomcolumnastabuladortb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColumnaTabulador.findByIdTabulador", query = "SELECT t FROM ColumnaTabulador t WHERE t.idtabulador.idtabulador = :idtabulador"),
    @NamedQuery(name = "ColumnaTabulador.findByIdTabuladorAndDescripcion", query = "SELECT t FROM ColumnaTabulador t WHERE t.idtabulador.idtabulador = :idtabulador AND t.descripcion = :descripcion")
})
public class ColumnaTabulador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOLUMNA")
    private Integer idcolumna;
    @Column(name = "VALOR")
    private Double valor;
    @Size(max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "IDTABULADOR", referencedColumnName = "IDTABULADOR")
    @ManyToOne
    private TabuladorSistemaAntiguedad idtabulador;

    public Integer getIdcolumna() {
        return idcolumna;
    }

    public void setIdcolumna(Integer idcolumna) {
        this.idcolumna = idcolumna;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TabuladorSistemaAntiguedad getIdtabulador() {
        return idtabulador;
    }

    public void setIdtabulador(TabuladorSistemaAntiguedad idtabulador) {
        this.idtabulador = idtabulador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcolumna != null ? idcolumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColumnaTabulador)) {
            return false;
        }
        ColumnaTabulador other = (ColumnaTabulador) object;
        if ((this.idcolumna == null && other.idcolumna != null) || (this.idcolumna != null && !this.idcolumna.equals(other.idcolumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.servicio.ColumnaTabulador[ idcolumna=" + idcolumna + " ]";
    }
}
