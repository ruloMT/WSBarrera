/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.entidades.cenicco;

import com.lam.to.FacturaElectronicaTO;
import com.lam.util.Util;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoséAntonio
 */
@Entity
@Table(name = "rhrecibocfditb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimbreRecibo.findAll", query = "SELECT t FROM TimbreRecibo t ORDER BY t.fechaPago ASC"),
    @NamedQuery(name = "TimbreRecibo.findByIdrecibocfdi", query = "SELECT t FROM TimbreRecibo t WHERE t.idrecibocfdi = :idrecibocfdi"),
    @NamedQuery(name = "TimbreRecibo.findByUuid", query = "SELECT t FROM TimbreRecibo t WHERE t.uuid = :uuid"),
    @NamedQuery(name = "TimbreRecibo.findByCertificadocsd", query = "SELECT t FROM TimbreRecibo t WHERE t.certificadocsd = :certificadocsd"),
    @NamedQuery(name = "TimbreRecibo.findByLugarEmision", query = "SELECT t FROM TimbreRecibo t WHERE t.lugarEmision = :lugarEmision"),
    @NamedQuery(name = "TimbreRecibo.findByFechaEmision", query = "SELECT t FROM TimbreRecibo t WHERE t.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "TimbreRecibo.findByRazonSocial", query = "SELECT t FROM TimbreRecibo t WHERE t.razonSocial = :razonSocial"),
    @NamedQuery(name = "TimbreRecibo.findByDomicilioEmpresa", query = "SELECT t FROM TimbreRecibo t WHERE t.domicilioEmpresa = :domicilioEmpresa"),
    @NamedQuery(name = "TimbreRecibo.findByRfcEmisor", query = "SELECT t FROM TimbreRecibo t WHERE t.rfcEmisor = :rfcEmisor"),
    @NamedQuery(name = "TimbreRecibo.findByRegistroPatronal", query = "SELECT t FROM TimbreRecibo t WHERE t.registroPatronal = :registroPatronal"),
    @NamedQuery(name = "TimbreRecibo.findByFechaAntiguedad", query = "SELECT t FROM TimbreRecibo t WHERE t.fechaAntiguedad = :fechaAntiguedad"),
    @NamedQuery(name = "TimbreRecibo.findByFechaPago", query = "SELECT t FROM TimbreRecibo t WHERE t.fechaPago = :fechaPago"),
    @NamedQuery(name = "TimbreRecibo.findByPeriodoPago", query = "SELECT t FROM TimbreRecibo t WHERE t.periodoPago = :periodoPago"),
    @NamedQuery(name = "TimbreRecibo.findByDiasPagados", query = "SELECT t FROM TimbreRecibo t WHERE t.diasPagados = :diasPagados"),
    @NamedQuery(name = "TimbreRecibo.findByDepartamento", query = "SELECT t FROM TimbreRecibo t WHERE t.departamento = :departamento"),
    @NamedQuery(name = "TimbreRecibo.findByPuesto", query = "SELECT t FROM TimbreRecibo t WHERE t.puesto = :puesto"),
    @NamedQuery(name = "TimbreRecibo.findByPeriodicidad", query = "SELECT t FROM TimbreRecibo t WHERE t.periodicidad = :periodicidad"),
    @NamedQuery(name = "TimbreRecibo.findBySalario", query = "SELECT t FROM TimbreRecibo t WHERE t.salario = :salario"),
    @NamedQuery(name = "TimbreRecibo.findBySalarioIntegrado", query = "SELECT t FROM TimbreRecibo t WHERE t.salarioIntegrado = :salarioIntegrado"),
    @NamedQuery(name = "TimbreRecibo.findByRegimenFiscal", query = "SELECT t FROM TimbreRecibo t WHERE t.regimenFiscal = :regimenFiscal"),
    @NamedQuery(name = "TimbreRecibo.findBySubtotal", query = "SELECT t FROM TimbreRecibo t WHERE t.subtotal = :subtotal"),
    @NamedQuery(name = "TimbreRecibo.findByTotal", query = "SELECT t FROM TimbreRecibo t WHERE t.total = :total"),
    @NamedQuery(name = "TimbreRecibo.findByFormaPago", query = "SELECT t FROM TimbreRecibo t WHERE t.formaPago = :formaPago"),
    @NamedQuery(name = "TimbreRecibo.findByMetodoPago", query = "SELECT t FROM TimbreRecibo t WHERE t.metodoPago = :metodoPago"),
    @NamedQuery(name = "TimbreRecibo.findByCfdi", query = "SELECT t FROM TimbreRecibo t WHERE t.cfdi = :cfdi"),
    @NamedQuery(name = "TimbreRecibo.findBySelloSat", query = "SELECT t FROM TimbreRecibo t WHERE t.selloSat = :selloSat"),
    @NamedQuery(name = "TimbreRecibo.findByTimbreVersion", query = "SELECT t FROM TimbreRecibo t WHERE t.timbreVersion = :timbreVersion"),
    @NamedQuery(name = "TimbreRecibo.findByTimbreFecha", query = "SELECT t FROM TimbreRecibo t WHERE t.timbreFecha = :timbreFecha"),
    @NamedQuery(name = "TimbreRecibo.findByTimbreSelloCfdi", query = "SELECT t FROM TimbreRecibo t WHERE t.timbreSelloCfdi = :timbreSelloCfdi"),
    @NamedQuery(name = "TimbreRecibo.findByTimbreNocertificadoSat", query = "SELECT t FROM TimbreRecibo t WHERE t.timbreNocertificadoSat = :timbreNocertificadoSat"),
    @NamedQuery(name = "TimbreRecibo.findByPrecioUnitario", query = "SELECT t FROM TimbreRecibo t WHERE t.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "TimbreRecibo.findByImporte", query = "SELECT t FROM TimbreRecibo t WHERE t.importe = :importe"),
    @NamedQuery(name = "TimbreRecibo.findByDescripcion", query = "SELECT t FROM TimbreRecibo t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TimbreRecibo.findByUnidad", query = "SELECT t FROM TimbreRecibo t WHERE t.unidad = :unidad"),
    @NamedQuery(name = "TimbreRecibo.findByCantidad", query = "SELECT t FROM TimbreRecibo t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TimbreRecibo.findByIsr", query = "SELECT t FROM TimbreRecibo t WHERE t.isr = :isr"),
    @NamedQuery(name = "TimbreRecibo.findGroupBy", query = "SELECT t,count(t) as cont FROM TimbreRecibo t GROUP BY t.idusuario.rfc, t.periodoPago HAVING cont > 1 ORDER BY t.idusuario.rfc ASC")})
public class TimbreRecibo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRECIBOCFDI")
    private Integer idrecibocfdi;
    @Size(max = 300)
    @Column(name = "UUID")
    private String uuid;
    @Size(max = 300)
    @Column(name = "CERTIFICADOCSD")
    private String certificadocsd;
    @Size(max = 300)
    @Column(name = "LUGAR_EMISION")
    private String lugarEmision;
    @Column(name = "FECHA_EMISION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @Size(max = 300)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Size(max = 300)
    @Column(name = "DOMICILIO_EMPRESA")
    private String domicilioEmpresa;
    @Size(max = 90)
    @Column(name = "RFC_EMISOR")
    private String rfcEmisor;
    @Size(max = 300)
    @Column(name = "REGISTRO_PATRONAL")
    private String registroPatronal;
    @Column(name = "FECHA_ANTIGUEDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAntiguedad;
    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Size(max = 90)
    @Column(name = "PERIODO_PAGO")
    private String periodoPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DIAS_PAGADOS")
    private Double diasPagados;
    @Size(max = 90)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Size(max = 90)
    @Column(name = "PUESTO")
    private String puesto;
    @Size(max = 90)
    @Column(name = "PERIODICIDAD")
    private String periodicidad;
    @Column(name = "SALARIO")
    private Double salario;
    @Column(name = "SALARIO_INTEGRADO")
    private Double salarioIntegrado;
    @Size(max = 300)
    @Column(name = "REGIMEN_FISCAL")
    private String regimenFiscal;
    @Column(name = "SUBTOTAL")
    private Double subtotal;
    @Column(name = "TOTAL")
    private Double total;
    @Size(max = 300)
    @Column(name = "FORMA_PAGO")
    private String formaPago;
    @Size(max = 300)
    @Column(name = "METODO_PAGO")
    private String metodoPago;
    @Size(max = 600)
    @Column(name = "CFDI")
    private String cfdi;
    @Size(max = 600)
    @Column(name = "SELLO_SAT")
    private String selloSat;
    @Size(max = 90)
    @Column(name = "TIMBRE_VERSION")
    private String timbreVersion;
    @Column(name = "TIMBRE_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timbreFecha;
    @Size(max = 600)
    @Column(name = "TIMBRE_SELLO_CFDI")
    private String timbreSelloCfdi;
    @Size(max = 300)
    @Column(name = "TIMBRE_NOCERTIFICADO_SAT")
    private String timbreNocertificadoSat;
    @Column(name = "PRECIO_UNITARIO")
    private Double precioUnitario;
    @Column(name = "IMPORTE")
    private Double importe;
    @Size(max = 300)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 3)
    @Column(name = "PERIODO")
    private String periodo;
    @Size(max = 90)
    @Column(name = "UNIDAD")
    private String unidad;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "ISR")
    private Double isr;
    @Column(name = "DESCUENTO")
    private Double descuento;
    @Lob
    @Column(name = "TIMBRE")
    private byte[] timbre;
    @Lob
    @Column(name = "ARCHIVOPDF")
    private byte[] archivopdf;
    @Lob
    @Column(name = "ARCHIVOXML")
    private byte[] archivoxml;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario idusuario;
    @Transient
    private Long cont;

    public TimbreRecibo() {
    }

    public TimbreRecibo(FacturaElectronicaTO factura) {
        this.idusuario = factura.getUsuario();
        this.uuid = factura.getTimbreFiscal().getUuid();
        System.out.println("this.uuid: " + this.uuid);
        this.certificadocsd = factura.getComprobante().getNoCertificado();
        System.out.println("this.certificadocsd: " + this.certificadocsd);
        this.lugarEmision = factura.getComprobante().getLugarExpedicion();
        System.out.println("this.lugarEmision: " + this.lugarEmision);
        this.fechaEmision = factura.getComprobante().getFecha();
        System.out.println("this.fechaEmision: " + this.fechaEmision);
        this.razonSocial = factura.getEmisor().getNombre();
        System.out.println("this.razonSocial: " + this.razonSocial);
//        
        this.domicilioEmpresa = Util.concatDireccionEmisor(factura.getDomicilioFiscal());
        System.out.println("this.domicilioEmpresa: " + this.domicilioEmpresa);
        this.rfcEmisor = factura.getEmisor().getRfc();
        System.out.println("this.rfcEmisor: " + this.rfcEmisor);
        this.registroPatronal = factura.getNomina().getRegistroPatronal();
        System.out.println("this.registroPatronal: " + this.registroPatronal);
//        
        this.fechaAntiguedad = factura.getNomina().getFechaInicioRelLaboral();
        System.out.println("this.fechaAntiguedad: " + this.fechaAntiguedad);
        this.fechaPago = factura.getNomina().getFechaPago();
        System.out.println("this.fechaPago: " + this.fechaPago);
        this.periodoPago = Util.concatPeriodoPago(factura.getNomina());
        System.out.println("this.periodoPago: " + this.periodoPago);
        this.diasPagados = factura.getNomina().getNumDiasPagados();
        System.out.println("this.diasPagados: " + this.diasPagados);
        this.departamento = factura.getNomina().getDepartamento();
        System.out.println("this.departamento: " + this.departamento);
//        
        this.puesto = factura.getNomina().getPuesto();
        System.out.println("this.puesto: " + this.puesto);
        this.periodicidad = factura.getNomina().getPeriodicidadPago();
        System.out.println("this.periodicidad: " + this.periodicidad);
        this.salario = factura.getNomina().getSalarioBaseCotApor();
        System.out.println("this.salario: " + this.salario);
        this.salarioIntegrado = factura.getNomina().getSalarioDiarioIntegrado();
        System.out.println("this.salarioIntegrado: " + this.salarioIntegrado);
//        
        this.regimenFiscal = factura.getRegimenFiscal().getRegimen();
        System.out.println("this.regimenFiscal: " + this.regimenFiscal);
        this.subtotal = factura.getSubtotal();
        System.out.println("this.subtotal: " + this.subtotal);
        this.total = factura.getTotal();
        System.out.println("this.total: " + this.total);
        this.formaPago = factura.getComprobante().getFormaDePago();
        System.out.println("this.formaPago: " + this.formaPago);
        this.metodoPago = factura.getComprobante().getMetodoDePago();
        System.out.println("this.metodoPago: " + this.metodoPago);
        this.cfdi = factura.getTimbreFiscal().getSelloCFD();
        System.out.println("this.cfdi: " + this.cfdi);
//        
        this.selloSat = factura.getTimbreFiscal().getSelloSAT();
        System.out.println("this.selloSat: " + this.selloSat);
        this.timbreVersion = factura.getTimbreFiscal().getVersion();
        System.out.println("this.timbreVersion: " + this.timbreVersion);
        this.timbreFecha = factura.getTimbreFiscal().getFecha();
        System.out.println("this.timbreFecha: " + this.timbreFecha);
        this.timbreSelloCfdi = factura.getTimbreFiscal().getSelloCFD();
        System.out.println("this.timbreSelloCfdi: " + this.timbreSelloCfdi);
        this.timbreNocertificadoSat = factura.getTimbreFiscal().getNoCertificadoSAT();
        System.out.println("this.timbreNocertificadoSat: " + this.timbreNocertificadoSat);
        this.precioUnitario = factura.getConceptos().get(0).getValorUnitario();
        System.out.println("this.precioUnitario: " + this.precioUnitario);
//        
        this.importe = factura.getConceptos().get(0).getImporte();
        System.out.println("this.importe: " + this.importe);
        this.descripcion = factura.getConceptos().get(0).getDescripcion();
        System.out.println("this.descripcion: " + this.descripcion);
        this.unidad = factura.getConceptos().get(0).getUnidad();
        System.out.println("this.unidad: " + this.unidad);
        this.cantidad = factura.getConceptos().get(0).getCantidad();
        System.out.println("this.cantidad: " + this.cantidad);
        this.isr = Util.buscarImpuestoISR(factura.getImpuestos());
        System.out.println("this.isr: " + this.isr);
//        
        this.descuento = factura.getDescuento() - isr;
        System.out.println("this.descuento: " + this.descuento);
        this.timbre = factura.getTimbre();
        System.out.println("this.timbre: " + this.timbre);
        this.archivopdf = factura.getArhivoPdf();
        System.out.println("this.archivopdf: " + this.archivopdf);
        this.archivoxml = factura.getArchivoXml();
        System.out.println("this.archivoxml: " + this.archivoxml);
        this.periodo = factura.getPeriodo();
        System.out.println("this.periodo: " + this.periodo);
    }

    public void editTimbre(FacturaElectronicaTO factura) {
        this.uuid = factura.getTimbreFiscal().getUuid();
        System.out.println("this.uuid: " + this.uuid);
        this.certificadocsd = factura.getComprobante().getNoCertificado();
        System.out.println("this.certificadocsd: " + this.certificadocsd);
        this.lugarEmision = factura.getComprobante().getLugarExpedicion();
        System.out.println("this.lugarEmision: " + this.lugarEmision);
        this.fechaEmision = factura.getComprobante().getFecha();
        System.out.println("this.fechaEmision: " + this.fechaEmision);
        this.razonSocial = factura.getEmisor().getNombre();
        System.out.println("this.razonSocial: " + this.razonSocial);
//        
        this.domicilioEmpresa = Util.concatDireccionEmisor(factura.getDomicilioFiscal());
        System.out.println("this.domicilioEmpresa: " + this.domicilioEmpresa);
        this.rfcEmisor = factura.getEmisor().getRfc();
        System.out.println("this.rfcEmisor: " + this.rfcEmisor);
        this.registroPatronal = factura.getNomina().getRegistroPatronal();
        System.out.println("this.registroPatronal: " + this.registroPatronal);
//        
        this.fechaAntiguedad = factura.getNomina().getFechaInicioRelLaboral();
        System.out.println("this.fechaAntiguedad: " + this.fechaAntiguedad);
        this.fechaPago = factura.getNomina().getFechaPago();
        System.out.println("this.fechaPago: " + this.fechaPago);
        this.periodoPago = Util.concatPeriodoPago(factura.getNomina());
        System.out.println("this.periodoPago: " + this.periodoPago);
        this.diasPagados = factura.getNomina().getNumDiasPagados();
        System.out.println("this.diasPagados: " + this.diasPagados);
        this.departamento = factura.getNomina().getDepartamento();
        System.out.println("this.departamento: " + this.departamento);
//        
        this.puesto = factura.getNomina().getPuesto();
        System.out.println("this.puesto: " + this.puesto);
        this.periodicidad = factura.getNomina().getPeriodicidadPago();
        System.out.println("this.periodicidad: " + this.periodicidad);
        this.salario = factura.getNomina().getSalarioBaseCotApor();
        System.out.println("this.salario: " + this.salario);
        this.salarioIntegrado = factura.getNomina().getSalarioDiarioIntegrado();
        System.out.println("this.salarioIntegrado: " + this.salarioIntegrado);
//        
        this.regimenFiscal = factura.getRegimenFiscal().getRegimen();
        System.out.println("this.regimenFiscal: " + this.regimenFiscal);
        this.subtotal = factura.getSubtotal();
        System.out.println("this.subtotal: " + this.subtotal);
        this.total = factura.getTotal();
        System.out.println("this.total: " + this.total);
        this.formaPago = factura.getComprobante().getFormaDePago();
        System.out.println("this.formaPago: " + this.formaPago);
        this.metodoPago = factura.getComprobante().getMetodoDePago();
        System.out.println("this.metodoPago: " + this.metodoPago);
        this.cfdi = factura.getTimbreFiscal().getSelloCFD();
        System.out.println("this.cfdi: " + this.cfdi);
//        
        this.selloSat = factura.getTimbreFiscal().getSelloSAT();
        System.out.println("this.selloSat: " + this.selloSat);
        this.timbreVersion = factura.getTimbreFiscal().getVersion();
        System.out.println("this.timbreVersion: " + this.timbreVersion);
        this.timbreFecha = factura.getTimbreFiscal().getFecha();
        System.out.println("this.timbreFecha: " + this.timbreFecha);
        this.timbreSelloCfdi = factura.getTimbreFiscal().getSelloCFD();
        System.out.println("this.timbreSelloCfdi: " + this.timbreSelloCfdi);
        this.timbreNocertificadoSat = factura.getTimbreFiscal().getNoCertificadoSAT();
        System.out.println("this.timbreNocertificadoSat: " + this.timbreNocertificadoSat);
        this.precioUnitario = factura.getConceptos().get(0).getValorUnitario();
        System.out.println("this.precioUnitario: " + this.precioUnitario);
//        
        this.importe = factura.getConceptos().get(0).getImporte();
        System.out.println("this.importe: " + this.importe);
        this.descripcion = factura.getConceptos().get(0).getDescripcion();
        System.out.println("this.descripcion: " + this.descripcion);
        this.unidad = factura.getConceptos().get(0).getUnidad();
        System.out.println("this.unidad: " + this.unidad);
        this.cantidad = factura.getConceptos().get(0).getCantidad();
        System.out.println("this.cantidad: " + this.cantidad);
        this.isr = Util.buscarImpuestoISR(factura.getImpuestos());
        System.out.println("this.isr: " + this.isr);
//        
        this.descuento = factura.getDescuento() - isr;
        System.out.println("this.descuento: " + this.descuento);
        this.timbre = factura.getTimbre();
        System.out.println("this.timbre: " + this.timbre);
        this.archivopdf = factura.getArhivoPdf();
        System.out.println("this.archivopdf: " + this.archivopdf);
        this.archivoxml = factura.getArchivoXml();
        System.out.println("this.archivoxml: " + this.archivoxml);
        this.periodo = factura.getPeriodo();
        System.out.println("this.periodo: " + this.periodo);
    }

    public TimbreRecibo(Integer idrecibocfdi) {
        this.idrecibocfdi = idrecibocfdi;
    }

    public Integer getIdrecibocfdi() {
        return idrecibocfdi;
    }

    public void setIdrecibocfdi(Integer idrecibocfdi) {
        this.idrecibocfdi = idrecibocfdi;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCertificadocsd() {
        return certificadocsd;
    }

    public void setCertificadocsd(String certificadocsd) {
        this.certificadocsd = certificadocsd;
    }

    public String getLugarEmision() {
        return lugarEmision;
    }

    public void setLugarEmision(String lugarEmision) {
        this.lugarEmision = lugarEmision;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDomicilioEmpresa() {
        return domicilioEmpresa;
    }

    public void setDomicilioEmpresa(String domicilioEmpresa) {
        this.domicilioEmpresa = domicilioEmpresa;
    }

    public String getRfcEmisor() {
        return rfcEmisor;
    }

    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }

    public String getRegistroPatronal() {
        return registroPatronal;
    }

    public void setRegistroPatronal(String registroPatronal) {
        this.registroPatronal = registroPatronal;
    }

    public Date getFechaAntiguedad() {
        return fechaAntiguedad;
    }

    public void setFechaAntiguedad(Date fechaAntiguedad) {
        this.fechaAntiguedad = fechaAntiguedad;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getPeriodoPago() {
        return periodoPago;
    }

    public void setPeriodoPago(String periodoPago) {
        this.periodoPago = periodoPago;
    }

    public Double getDiasPagados() {
        return diasPagados;
    }

    public void setDiasPagados(Double diasPagados) {
        this.diasPagados = diasPagados;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getSalarioIntegrado() {
        return salarioIntegrado;
    }

    public void setSalarioIntegrado(Double salarioIntegrado) {
        this.salarioIntegrado = salarioIntegrado;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getCfdi() {
        return cfdi;
    }

    public void setCfdi(String cfdi) {
        this.cfdi = cfdi;
    }

    public String getSelloSat() {
        return selloSat;
    }

    public void setSelloSat(String selloSat) {
        this.selloSat = selloSat;
    }

    public String getTimbreVersion() {
        return timbreVersion;
    }

    public void setTimbreVersion(String timbreVersion) {
        this.timbreVersion = timbreVersion;
    }

    public Date getTimbreFecha() {
        return timbreFecha;
    }

    public void setTimbreFecha(Date timbreFecha) {
        this.timbreFecha = timbreFecha;
    }

    public String getTimbreSelloCfdi() {
        return timbreSelloCfdi;
    }

    public void setTimbreSelloCfdi(String timbreSelloCfdi) {
        this.timbreSelloCfdi = timbreSelloCfdi;
    }

    public String getTimbreNocertificadoSat() {
        return timbreNocertificadoSat;
    }

    public void setTimbreNocertificadoSat(String timbreNocertificadoSat) {
        this.timbreNocertificadoSat = timbreNocertificadoSat;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getIsr() {
        return isr;
    }

    public void setIsr(Double isr) {
        this.isr = isr;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public byte[] getTimbre() {
        return timbre;
    }

    public void setTimbre(byte[] timbre) {
        this.timbre = timbre;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

    public byte[] getArchivoxml() {
        return archivoxml;
    }

    public void setArchivoxml(byte[] archivoxml) {
        this.archivoxml = archivoxml;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecibocfdi != null ? idrecibocfdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimbreRecibo)) {
            return false;
        }
        TimbreRecibo other = (TimbreRecibo) object;
        if ((this.idrecibocfdi == null && other.idrecibocfdi != null) || (this.idrecibocfdi != null && !this.idrecibocfdi.equals(other.idrecibocfdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lam.entidades.TimbreRecibo[ idrecibocfdi=" + idrecibocfdi + " ]";
    }

    public Long getCont() {
        return cont;
    }

    public void setCont(Long cont) {
        this.cont = cont;
    }
}
