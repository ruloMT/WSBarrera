/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.to;

import com.lam.entidades.cenicco.Usuario;
import com.lam.util.Util;
import com.lam.xml.XmlScannerDao;
import java.util.List;

/**
 *
 * @author Diego
 */
public class FacturaElectronicaTO {

    private Usuario usuario;
    private ComprobanteTO comprobante;
    private EmisorTO emisor;
    private DomicilioFiscalTO domicilioFiscal;
    private RegimenFiscalTO regimenFiscal;
    private ReceptorTO receptor;
    private DomicilioTO domicilio;
    private NominaTO nomina;
    private TimbreFiscalTO timbreFiscal;
    private List<ConceptoTO> conceptos;
    private List<ImpuestoTO> impuestos;
    private List<RegistroTO> registros;
    private String logo;
    private double subtotal;
    private double descuento;
    private double total;
    private int idCompania;
    private byte[] arhivoPdf;
    private byte[] archivoXml;
    private byte[] timbre;
    private boolean Edit;
    private String periodo;

    public FacturaElectronicaTO(XmlScannerDao scanner) {
        this.comprobante = scanner.getComprobante();
        this.emisor = scanner.getEmisor();
        this.domicilioFiscal = scanner.getDomicilioFiscal();
        this.regimenFiscal = scanner.getRegimenFiscal();
        this.receptor = scanner.getReceptor();
        this.domicilio = scanner.getDomicilio();
        this.nomina = scanner.getNomina();
        this.timbreFiscal = scanner.getTimbreFiscal();
        this.conceptos = scanner.getConceptos();
        this.impuestos = scanner.getImpuestos();
        this.registros = scanner.getRegistros();
    }

    public FacturaElectronicaTO() {
    }

    public ComprobanteTO getComprobante() {
        return comprobante;
    }

    public EmisorTO getEmisor() {
        return emisor;
    }

    public DomicilioFiscalTO getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public RegimenFiscalTO getRegimenFiscal() {
        return regimenFiscal;
    }

    public ReceptorTO getReceptor() {
        return receptor;
    }

    public DomicilioTO getDomicilio() {
        return domicilio;
    }

    public NominaTO getNomina() {
        return nomina;
    }

    public TimbreFiscalTO getTimbreFiscal() {
        return timbreFiscal;
    }

    public List<ConceptoTO> getConceptos() {
        return conceptos;
    }

    public List<ImpuestoTO> getImpuestos() {
        return impuestos;
    }

    public List<RegistroTO> getRegistros() {
        return registros;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = Util.redondear(subtotal);
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = Util.redondear(descuento);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = Util.redondear(total);
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public byte[] getArhivoPdf() {
        return arhivoPdf;
    }

    public void setArhivoPdf(byte[] arhivoPdf) {
        this.arhivoPdf = arhivoPdf;
    }

    public byte[] getArchivoXml() {
        return archivoXml;
    }

    public void setArchivoXml(byte[] archivoXml) {
        this.archivoXml = archivoXml;
    }

    public byte[] getTimbre() {
        return timbre;
    }

    public void setTimbre(byte[] timbre) {
        this.timbre = timbre;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public boolean isEdit() {
        return Edit;
    }

    public void setEdit(boolean Edit) {
        this.Edit = Edit;
    }

    public void setComprobante(ComprobanteTO comprobante) {
        this.comprobante = comprobante;
    }

    public void setEmisor(EmisorTO emisor) {
        this.emisor = emisor;
    }

    public void setDomicilioFiscal(DomicilioFiscalTO domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public void setRegimenFiscal(RegimenFiscalTO regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public void setReceptor(ReceptorTO receptor) {
        this.receptor = receptor;
    }

    public void setDomicilio(DomicilioTO domicilio) {
        this.domicilio = domicilio;
    }

    public void setNomina(NominaTO nomina) {
        this.nomina = nomina;
    }

    public void setTimbreFiscal(TimbreFiscalTO timbreFiscal) {
        this.timbreFiscal = timbreFiscal;
    }

    public void setConceptos(List<ConceptoTO> conceptos) {
        this.conceptos = conceptos;
    }

    public void setImpuestos(List<ImpuestoTO> impuestos) {
        this.impuestos = impuestos;
    }

    public void setRegistros(List<RegistroTO> registros) {
        this.registros = registros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
