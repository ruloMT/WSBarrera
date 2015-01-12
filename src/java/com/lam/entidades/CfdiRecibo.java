/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades;

import com.lam.to.ParametroTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import static javax.persistence.ParameterMode.IN;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@NamedStoredProcedureQuery(
        name = "ProcedureNomina",
        resultClasses = CfdiRecibo.class,
        procedureName = "sp_ReciboNomina_2014",
        parameters = {
    @StoredProcedureParameter(mode = IN, name = "chcompania", type = String.class),
    @StoredProcedureParameter(mode = IN, name = "chclase_nomina", type = String.class),
    @StoredProcedureParameter(mode = IN, name = "nid_calendario", type = Integer.class),
    @StoredProcedureParameter(mode = IN, name = "chtipo_nomina", type = String.class),
    @StoredProcedureParameter(mode = IN, name = "chagr_orden", type = String.class),
    @StoredProcedureParameter(mode = IN, name = "iNumero_recibo", type = Integer.class),
    @StoredProcedureParameter(mode = IN, name = "dFechaPago", type = Timestamp.class),
    @StoredProcedureParameter(mode = IN, name = "chClave_recibo", type = String.class)
})
@Entity
@Table(name = "cfdi_recibo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfdiRecibo.findAll", query = "SELECT c FROM CfdiRecibo c WHERE c.compania = :compania ORDER BY c.trabajador ASC"),
    @NamedQuery(name = "CfdiRecibo.findByIdRegistro", query = "SELECT c FROM CfdiRecibo c WHERE c.idRegistro = :idRegistro"),
    @NamedQuery(name = "CfdiRecibo.findByCompania", query = "SELECT c FROM CfdiRecibo c WHERE c.compania = :compania"),
    @NamedQuery(name = "CfdiRecibo.findByTrabajador", query = "SELECT c FROM CfdiRecibo c WHERE c.trabajador = :trabajador"),
    @NamedQuery(name = "CfdiRecibo.findByFecha", query = "SELECT c FROM CfdiRecibo c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CfdiRecibo.findByFormaDePago", query = "SELECT c FROM CfdiRecibo c WHERE c.formaDePago = :formaDePago"),
    @NamedQuery(name = "CfdiRecibo.findBySubTotal", query = "SELECT c FROM CfdiRecibo c WHERE c.subTotal = :subTotal"),
    @NamedQuery(name = "CfdiRecibo.findByDescuento", query = "SELECT c FROM CfdiRecibo c WHERE c.descuento = :descuento"),
    @NamedQuery(name = "CfdiRecibo.findByMotivoDescuento", query = "SELECT c FROM CfdiRecibo c WHERE c.motivoDescuento = :motivoDescuento"),
    @NamedQuery(name = "CfdiRecibo.findByMoneda", query = "SELECT c FROM CfdiRecibo c WHERE c.moneda = :moneda"),
    @NamedQuery(name = "CfdiRecibo.findByTotal", query = "SELECT c FROM CfdiRecibo c WHERE c.total = :total"),
    @NamedQuery(name = "CfdiRecibo.findByTipoDeComprobante", query = "SELECT c FROM CfdiRecibo c WHERE c.tipoDeComprobante = :tipoDeComprobante"),
    @NamedQuery(name = "CfdiRecibo.findByMetodoDePago", query = "SELECT c FROM CfdiRecibo c WHERE c.metodoDePago = :metodoDePago"),
    @NamedQuery(name = "CfdiRecibo.findByLugarExpedicion", query = "SELECT c FROM CfdiRecibo c WHERE c.lugarExpedicion = :lugarExpedicion"),
    @NamedQuery(name = "CfdiRecibo.findBySerie", query = "SELECT c FROM CfdiRecibo c WHERE c.serie = :serie"),
    @NamedQuery(name = "CfdiRecibo.findByFolio", query = "SELECT c FROM CfdiRecibo c WHERE c.folio = :folio"),
    @NamedQuery(name = "CfdiRecibo.findByRfc", query = "SELECT c FROM CfdiRecibo c WHERE c.rfc = :rfc"),
    @NamedQuery(name = "CfdiRecibo.findByNombre", query = "SELECT c FROM CfdiRecibo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CfdiRecibo.findByPais", query = "SELECT c FROM CfdiRecibo c WHERE c.pais = :pais"),
    @NamedQuery(name = "CfdiRecibo.findByCantidad", query = "SELECT c FROM CfdiRecibo c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CfdiRecibo.findByUnidadDeMedida", query = "SELECT c FROM CfdiRecibo c WHERE c.unidadDeMedida = :unidadDeMedida"),
    @NamedQuery(name = "CfdiRecibo.findByDescripcion", query = "SELECT c FROM CfdiRecibo c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CfdiRecibo.findByValorUnitario", query = "SELECT c FROM CfdiRecibo c WHERE c.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "CfdiRecibo.findByImporte", query = "SELECT c FROM CfdiRecibo c WHERE c.importe = :importe"),
    @NamedQuery(name = "CfdiRecibo.findByTotalImpuestosRetenidos", query = "SELECT c FROM CfdiRecibo c WHERE c.totalImpuestosRetenidos = :totalImpuestosRetenidos"),
    @NamedQuery(name = "CfdiRecibo.findByImpuesto", query = "SELECT c FROM CfdiRecibo c WHERE c.impuesto = :impuesto"),
    @NamedQuery(name = "CfdiRecibo.findByImporteRet", query = "SELECT c FROM CfdiRecibo c WHERE c.importeRet = :importeRet"),
    @NamedQuery(name = "CfdiRecibo.findByTImpuesto", query = "SELECT c FROM CfdiRecibo c WHERE c.tImpuesto = :tImpuesto"),
    @NamedQuery(name = "CfdiRecibo.findByTTasa", query = "SELECT c FROM CfdiRecibo c WHERE c.tTasa = :tTasa"),
    @NamedQuery(name = "CfdiRecibo.findByTImporte", query = "SELECT c FROM CfdiRecibo c WHERE c.tImporte = :tImporte"),
    @NamedQuery(name = "CfdiRecibo.findByRegistro", query = "SELECT c FROM CfdiRecibo c WHERE c.registro = :registro")
})
public class CfdiRecibo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRegistro")
    private Integer idRegistro;
    @Size(max = 4)
    @Column(name = "compania")
    private String compania;
    @Size(max = 10)
    @Column(name = "trabajador")
    private String trabajador;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 35)
    @Column(name = "FormaDePago")
    private String formaDePago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SubTotal")
    private BigDecimal subTotal;
    @Column(name = "Descuento")
    private BigDecimal descuento;
    @Size(max = 20)
    @Column(name = "MotivoDescuento")
    private String motivoDescuento;
    @Size(max = 5)
    @Column(name = "Moneda")
    private String moneda;
    @Column(name = "Total")
    private BigDecimal total;
    @Size(max = 20)
    @Column(name = "TipoDeComprobante")
    private String tipoDeComprobante;
    @Size(max = 30)
    @Column(name = "MetodoDePago")
    private String metodoDePago;
    @Size(max = 60)
    @Column(name = "LugarExpedicion")
    private String lugarExpedicion;
    @Size(max = 25)
    @Column(name = "Serie")
    private String serie;
    @Size(max = 20)
    @Column(name = "Folio")
    private String folio;
    @Size(max = 20)
    @Column(name = "RFC")
    private String rfc;
    @Size(max = 120)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 15)
    @Column(name = "Pais")
    private String pais;
    @Size(max = 10)
    @Column(name = "Cantidad")
    private String cantidad;
    @Size(max = 15)
    @Column(name = "UnidadDeMedida")
    private String unidadDeMedida;
    @Size(max = 14)
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "ValorUnitario")
    private BigDecimal valorUnitario;
    @Column(name = "Importe")
    private BigDecimal importe;
    @Column(name = "TotalImpuestosRetenidos")
    private BigDecimal totalImpuestosRetenidos;
    @Size(max = 5)
    @Column(name = "Impuesto")
    private String impuesto;
    @Column(name = "ImporteRet")
    private BigDecimal importeRet;
    @Size(max = 5)
    @Column(name = "tImpuesto")
    private String tImpuesto;
    @Size(max = 5)
    @Column(name = "tTasa")
    private String tTasa;
    @Column(name = "tImporte")
    private BigDecimal tImporte;
    @Size(max = 7000)
    @Column(name = "REGISTRO")
    private String registro;
//    
    @Transient
    private ParametroTO parametro;
    @Transient
    private ListadoRecibosCfdi listadoReciboCfdi;

    public CfdiRecibo() {
    }

    public CfdiRecibo(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getMotivoDescuento() {
        return motivoDescuento;
    }

    public void setMotivoDescuento(String motivoDescuento) {
        this.motivoDescuento = motivoDescuento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    public void setTotalImpuestosRetenidos(BigDecimal totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getImporteRet() {
        return importeRet;
    }

    public void setImporteRet(BigDecimal importeRet) {
        this.importeRet = importeRet;
    }

    public String getTImpuesto() {
        return tImpuesto;
    }

    public void setTImpuesto(String tImpuesto) {
        this.tImpuesto = tImpuesto;
    }

    public String getTTasa() {
        return tTasa;
    }

    public void setTTasa(String tTasa) {
        this.tTasa = tTasa;
    }

    public BigDecimal getTImporte() {
        return tImporte;
    }

    public void setTImporte(BigDecimal tImporte) {
        this.tImporte = tImporte;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfdiRecibo)) {
            return false;
        }
        CfdiRecibo other = (CfdiRecibo) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.recibos.cfdi.entidades.CfdiRecibo[ idRegistro=" + idRegistro + " ]";
    }

    public ParametroTO getParametro() {
        return parametro;
    }

    public void setParametro(ParametroTO parametro) {
        this.parametro = parametro;
    }

    public ListadoRecibosCfdi getListadoReciboCfdi() {
        return listadoReciboCfdi;
    }

    public void setListadoReciboCfdi(ListadoRecibosCfdi listadoReciboCfdi) {
        this.listadoReciboCfdi = listadoReciboCfdi;
    }
}
