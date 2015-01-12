/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.xml;

import com.lam.to.ComprobanteTO;
import com.lam.to.ConceptoTO;
import com.lam.to.DomicilioFiscalTO;
import com.lam.to.DomicilioTO;
import com.lam.to.EmisorTO;
import com.lam.to.ImpuestoTO;
import com.lam.to.NominaTO;
import com.lam.to.ReceptorTO;
import com.lam.to.RegimenFiscalTO;
import com.lam.to.RegistroTO;
import com.lam.to.TimbreFiscalTO;
import com.lam.util.Util;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author Diego
 */
public class XmlScanner implements XmlScannerDao {

    /**
     * org.w3c.dom.Document document
     */
//    
    private Document document;
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

    /**
     * Create new XmlScanner with org.w3c.dom.Document.
     */
    public XmlScanner() {
        if (this.registros == null) {
            registros = new ArrayList<>();
        }
    }

    /**
     * Scan through org.w3c.dom.Document document.
     */
    @Override
    public void visitDocument() {
        org.w3c.dom.Element element = document.getDocumentElement();
        if ((element != null) && element.getTagName().equals("cfdi:Comprobante")) {
            visitElement_cfdi_Comprobante(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Emisor")) {
            visitElement_cfdi_Emisor(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:DomicilioFiscal")) {
            visitElement_cfdi_DomicilioFiscal(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:RegimenFiscal")) {
            visitElement_cfdi_RegimenFiscal(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Receptor")) {
            visitElement_cfdi_Receptor(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Domicilio")) {
            visitElement_cfdi_Domicilio(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Conceptos")) {
            visitElement_cfdi_Conceptos(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Concepto")) {
            visitElement_cfdi_Concepto(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Impuestos")) {
            visitElement_cfdi_Impuestos(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Retenciones")) {
            visitElement_cfdi_Retenciones(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Retencion")) {
            visitElement_cfdi_Retencion(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Traslados")) {
            visitElement_cfdi_Traslados(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Traslado")) {
            visitElement_cfdi_Traslado(element);
        }
        if ((element != null) && element.getTagName().equals("cfdi:Complemento")) {
            visitElement_cfdi_Complemento(element);
        }
        if ((element != null) && element.getTagName().equals("nomina:Nomina")) {
            visitElement_nomina_Nomina(element);
        }
        if ((element != null) && element.getTagName().equals("nomina:Percepciones")) {
            visitElement_nomina_Percepciones(element);
        }
        if ((element != null) && element.getTagName().equals("nomina:Percepcion")) {
            visitElement_nomina_Percepcion(element);
        }
        if ((element != null) && element.getTagName().equals("nomina:Deducciones")) {
            visitElement_nomina_Deducciones(element);
        }
        if ((element != null) && element.getTagName().equals("nomina:Deduccion")) {
            visitElement_nomina_Deduccion(element);
        }
        if ((element != null) && element.getTagName().equals("tfd:TimbreFiscalDigital")) {
            visitElement_tfd_TimbreFiscalDigital(element);
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Comprobante.
     */
    private void visitElement_cfdi_Comprobante(org.w3c.dom.Element element) {
        // <cfdi:Comprobante>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        comprobante = new ComprobanteTO();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("sello")) {
                comprobante.setSello(attr.getValue());
            }
            if (attr.getName().equals("certificado")) {
                comprobante.setCertificado(attr.getValue());
            }
            if (attr.getName().equals("noCertificado")) {
                comprobante.setNoCertificado(attr.getValue());
            }
            if (attr.getName().equals("LugarExpedicion")) {
                comprobante.setLugarExpedicion(attr.getValue());
            }
            if (attr.getName().equals("metodoDePago")) {
                comprobante.setMetodoDePago(attr.getValue());
            }
            if (attr.getName().equals("Moneda")) {
                comprobante.setMoneda(attr.getValue());
            }
            if (attr.getName().equals("TipoCambio")) {
                comprobante.setTipoCambio(Integer.parseInt(attr.getValue()));
            }
            if (attr.getName().equals("tipoDeComprobante")) {
                comprobante.setTipoDeComprobante(attr.getValue());
            }
            if (attr.getName().equals("version")) {
                comprobante.setVersion(attr.getValue());
            }
            if (attr.getName().equals("serie")) {
                comprobante.setSerie(attr.getValue());
            }
            if (attr.getName().equals("folio")) {
                comprobante.setFolio(attr.getValue());
            }
            if (attr.getName().equals("fecha")) {
                comprobante.setFecha(Util.stringToDateTime(attr.getValue()));
            }
            if (attr.getName().equals("formaDePago")) {
                comprobante.setFormaDePago(attr.getValue());
            }
            if (attr.getName().equals("subTotal")) {
                comprobante.setSubTotal(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("descuento")) {
                comprobante.setDescuento(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("motivoDescuento")) {
                comprobante.setMotivoDescuento(attr.getValue());
            }
            if (attr.getName().equals("total")) {
                comprobante.setTotal(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("xmlns:cfdi")) {
                comprobante.setCfdi(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("cfdi:Emisor")) {
                        visitElement_cfdi_Emisor(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("cfdi:Receptor")) {
                        visitElement_cfdi_Receptor(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("cfdi:Conceptos")) {
                        visitElement_cfdi_Conceptos(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("cfdi:Impuestos")) {
                        visitElement_cfdi_Impuestos(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("cfdi:Complemento")) {
                        visitElement_cfdi_Complemento(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Emisor.
     */
    void visitElement_cfdi_Emisor(org.w3c.dom.Element element) {
        // <cfdi:Emisor>
        // element.getValue();
        emisor = new EmisorTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("nombre")) {
                emisor.setNombre(attr.getValue());
            }
            if (attr.getName().equals("rfc")) {
                emisor.setRfc(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("cfdi:DomicilioFiscal")) {
                        visitElement_cfdi_DomicilioFiscal(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("cfdi:RegimenFiscal")) {
                        visitElement_cfdi_RegimenFiscal(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:DomicilioFiscal.
     */
    void visitElement_cfdi_DomicilioFiscal(org.w3c.dom.Element element) {
        // <cfdi:DomicilioFiscal>
        // element.getValue();
        domicilioFiscal = new DomicilioFiscalTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("pais")) {
                domicilioFiscal.setPais(attr.getValue());
            }
            if (attr.getName().equals("noExterior")) {
                domicilioFiscal.setNoExterior(attr.getValue());
            }
            if (attr.getName().equals("municipio")) {
                domicilioFiscal.setMunicipio(attr.getValue());
            }
            if (attr.getName().equals("estado")) {
                domicilioFiscal.setEstado(attr.getValue());
            }
            if (attr.getName().equals("colonia")) {
                domicilioFiscal.setColonia(attr.getValue());
            }
            if (attr.getName().equals("codigoPostal")) {
                domicilioFiscal.setCodigoPostal(attr.getValue());
            }
            if (attr.getName().equals("calle")) {
                domicilioFiscal.setCalle(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:RegimenFiscal.
     */
    void visitElement_cfdi_RegimenFiscal(org.w3c.dom.Element element) {
        // <cfdi:RegimenFiscal>
        // element.getValue();
        regimenFiscal = new RegimenFiscalTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("Regimen")) {
                regimenFiscal.setRegimen(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Receptor.
     */
    void visitElement_cfdi_Receptor(org.w3c.dom.Element element) {
        // <cfdi:Receptor>
        // element.getValue();
        receptor = new ReceptorTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("nombre")) {
                receptor.setNombre(attr.getValue());
            }
            if (attr.getName().equals("rfc")) {
                receptor.setRfc(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("cfdi:Domicilio")) {
                        visitElement_cfdi_Domicilio(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Domicilio.
     */
    void visitElement_cfdi_Domicilio(org.w3c.dom.Element element) {
        // <cfdi:Domicilio>
        // element.getValue();
        domicilio = new DomicilioTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("pais")) {
                domicilio.setPais(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Conceptos.
     */
    void visitElement_cfdi_Conceptos(org.w3c.dom.Element element) {
        // <cfdi:Conceptos>
        // element.getValue();
        conceptos = new ArrayList<>();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("cfdi:Concepto")) {
                        ConceptoTO concepto = visitElement_cfdi_Concepto(nodeElement);
                        conceptos.add(concepto);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Concepto.
     */
    private ConceptoTO visitElement_cfdi_Concepto(org.w3c.dom.Element element) {
        // <cfdi:Concepto>
        // element.getValue();
        ConceptoTO concepto = new ConceptoTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("importe")) {
                concepto.setImporte(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("valorUnitario")) {
                concepto.setValorUnitario(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("descripcion")) {
                concepto.setDescripcion(attr.getValue());
            }
            if (attr.getName().equals("unidad")) {
                concepto.setUnidad(attr.getValue());
            }
            if (attr.getName().equals("cantidad")) {
                concepto.setCantidad(Double.parseDouble(attr.getValue()));
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
        return concepto;
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Impuestos.
     */
    void visitElement_cfdi_Impuestos(org.w3c.dom.Element element) {
        // <cfdi:Impuestos>
        // element.getValue();
        impuestos = new ArrayList<>();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("totalImpuestosTrasladados")) {
            }
            if (attr.getName().equals("totalImpuestosRetenidos")) {
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("cfdi:Retenciones")) {
                        ImpuestoTO impuesto = visitElement_cfdi_Retenciones(nodeElement);
                        if (impuesto != null) {
                            impuestos.add(impuesto);
                        }
                    }
                    if (nodeElement.getTagName().equals("cfdi:Traslados")) {
                        ImpuestoTO impuesto = visitElement_cfdi_Traslados(nodeElement);
                        if (impuesto != null) {
                            impuestos.add(impuesto);
                        }
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Retenciones.
     */
    private ImpuestoTO visitElement_cfdi_Retenciones(org.w3c.dom.Element element) {
        // <cfdi:Retenciones>
        // element.getValue();
        ImpuestoTO impuesto = null;
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("cfdi:Retencion")) {
                        impuesto = visitElement_cfdi_Retencion(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
        return impuesto;
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Retencion.
     */
    private ImpuestoTO visitElement_cfdi_Retencion(org.w3c.dom.Element element) {
        // <cfdi:Retencion>
        // element.getValue();
        ImpuestoTO impuesto = new ImpuestoTO("RETENCION");
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("importe")) {
                impuesto.setImporte(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("impuesto")) {
                impuesto.setImpuesto(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
        return impuesto;
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Traslados.
     */
    private ImpuestoTO visitElement_cfdi_Traslados(org.w3c.dom.Element element) {
        // <cfdi:Traslados>
        // element.getValue();
        ImpuestoTO impuesto = null;
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("cfdi:Traslado")) {
                        impuesto = visitElement_cfdi_Traslado(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
        return impuesto;
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Traslado.
     */
    private ImpuestoTO visitElement_cfdi_Traslado(org.w3c.dom.Element element) {
        // <cfdi:Traslado>
        // element.getValue();
        ImpuestoTO impuesto = new ImpuestoTO("TRASLADO");
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);

            if (attr.getName().equals("importe")) {
                impuesto.setImporte(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("tasa")) {
                impuesto.setTasa(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("impuesto")) {
                impuesto.setImpuesto(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
        return impuesto;
    }

    /**
     * Scan through org.w3c.dom.Element named cfdi:Complemento.
     */
    private void visitElement_cfdi_Complemento(org.w3c.dom.Element element) {
        // <cfdi:Complemento>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("nomina:Nomina")) {
                        visitElement_nomina_Nomina(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("tfd:TimbreFiscalDigital")) {
                        visitElement_tfd_TimbreFiscalDigital(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named nomina:Nomina.
     */
    void visitElement_nomina_Nomina(org.w3c.dom.Element element) {
        // <nomina:Nomina>
        // element.getValue();
        nomina = new NominaTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("SalarioDiarioIntegrado")) {
                nomina.setSalarioDiarioIntegrado(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("RiesgoPuesto")) {
                nomina.setRiesgoPuesto(attr.getValue());
            }
            if (attr.getName().equals("SalarioBaseCotApor")) {
                nomina.setSalarioBaseCotApor(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("PeriodicidadPago")) {
                nomina.setPeriodicidadPago(attr.getValue());
            }
            if (attr.getName().equals("TipoJornada")) {
                nomina.setTipoJornada(attr.getValue());
            }
            if (attr.getName().equals("TipoContrato")) {
                nomina.setTipoContrato(attr.getValue());
            }
            if (attr.getName().equals("Puesto")) {
                nomina.setPuesto(attr.getValue());
            }
            if (attr.getName().equals("Antiguedad")) {
                nomina.setAntiguedad(Integer.parseInt(attr.getValue()));
            }
            if (attr.getName().equals("FechaInicioRelLaboral")) {
                nomina.setFechaInicioRelLaboral(Util.stringToDate(attr.getValue()));
            }
            if (attr.getName().equals("Version")) {
                nomina.setVersion(attr.getValue());
            }
            if (attr.getName().equals("RegistroPatronal")) {
                nomina.setRegistroPatronal(attr.getValue());
            }
            if (attr.getName().equals("NumEmpleado")) {
                nomina.setNumEmpleado(attr.getValue());
            }
            if (attr.getName().equals("CURP")) {
                nomina.setCurp(attr.getValue());
            }
            if (attr.getName().equals("TipoRegimen")) {
                nomina.setTipoRegimen(attr.getValue());
            }
            if (attr.getName().equals("NumSeguridadSocial")) {
                nomina.setNumSeguroSocial(attr.getValue());
            }
            if (attr.getName().equals("FechaPago")) {
                nomina.setFechaPago(Util.stringToDate(attr.getValue()));
            }
            if (attr.getName().equals("FechaInicialPago")) {
                nomina.setFechaInicialPago(Util.stringToDate(attr.getValue()));
            }
            if (attr.getName().equals("FechaFinalPago")) {
                nomina.setFechaFinalPago(Util.stringToDate(attr.getValue()));
            }
            if (attr.getName().equals("NumDiasPagados")) {
                nomina.setNumDiasPagados(Double.parseDouble(attr.getValue()));
            }
            if (attr.getName().equals("Departamento")) {
                nomina.setDepartamento(attr.getValue());
            }
            if (attr.getName().equals("Banco")) {
                nomina.setBanco(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("nomina:Percepciones")) {
                        visitElement_nomina_Percepciones(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("nomina:Deducciones")) {
                        visitElement_nomina_Deducciones(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named nomina:Percepciones.
     */
    void visitElement_nomina_Percepciones(org.w3c.dom.Element element) {
        // <nomina:Percepciones>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("TotalExento")) {
            }
            if (attr.getName().equals("TotalGravado")) {
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("nomina:Percepcion")) {
                        RegistroTO percepcion = visitElement_nomina_Percepcion(nodeElement);
                        registros.add(percepcion);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named nomina:Percepcion.
     */
    private RegistroTO visitElement_nomina_Percepcion(org.w3c.dom.Element element) {
        // <nomina:Percepcion>
        // element.getValue();
        RegistroTO percepcion = new RegistroTO();
        percepcion.setImporteDeduccion(0);
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        double total = 0;
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("ImporteExento")) {
                total += Double.parseDouble(attr.getValue());
            }
            if (attr.getName().equals("ImporteGravado")) {
                total += Double.parseDouble(attr.getValue());
            }
            if (attr.getName().equals("Concepto")) {
                percepcion.setConcepto(attr.getValue());
            }
            if (attr.getName().equals("Clave")) {
                percepcion.setClave(attr.getValue());
            }
            if (attr.getName().equals("TipoPercepcion")) {
                percepcion.setTipo(attr.getValue());
                switch (attr.getValue()) {
                    case "007":
                        percepcion.setPercepcionDeduccion("INFORMATIVO");
                        break;
                    default:
                        percepcion.setPercepcionDeduccion("PERCEPCION");
                        break;
                }
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
        percepcion.setImportePercepcion(total);
        if (percepcion.getPercepcionDeduccion().equals("PERCEPCION")) {
            percepcion.setImporteTotal(total);
        } else {
            percepcion.setImporteTotal(0);
        }
        return percepcion;
    }

    /**
     * Scan through org.w3c.dom.Element named nomina:Deducciones.
     */
    void visitElement_nomina_Deducciones(org.w3c.dom.Element element) {
        // <nomina:Deducciones>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("TotalExento")) {
            }
            if (attr.getName().equals("TotalGravado")) {
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("nomina:Deduccion")) {
                        RegistroTO deduccion = visitElement_nomina_Deduccion(nodeElement);
                        registros.add(deduccion);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named nomina:Deduccion.
     */
    private RegistroTO visitElement_nomina_Deduccion(org.w3c.dom.Element element) {
        // <nomina:Deduccion>
        // element.getValue();
        RegistroTO deduccion = new RegistroTO();
        deduccion.setPercepcionDeduccion("DEDUCCION");
        deduccion.setImportePercepcion(0);
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        double total = 0;
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("ImporteExento")) {
                total += Double.parseDouble(attr.getValue());
            }
            if (attr.getName().equals("ImporteGravado")) {
                total += Double.parseDouble(attr.getValue());
            }
            if (attr.getName().equals("Concepto")) {
                deduccion.setConcepto(attr.getValue());
            }
            if (attr.getName().equals("Clave")) {
                deduccion.setClave(attr.getValue());
            }
            if (attr.getName().equals("TipoDeduccion")) {
                deduccion.setTipo(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
        deduccion.setImporteDeduccion(total);
        deduccion.setImporteTotal(total);
        return deduccion;
    }

    /**
     * Scan through org.w3c.dom.Element named tfd:TimbreFiscalDigital.
     */
    void visitElement_tfd_TimbreFiscalDigital(org.w3c.dom.Element element) {
        // <tfd:TimbreFiscalDigital>
        // element.getValue();
        timbreFiscal = new TimbreFiscalTO();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("selloSAT")) {
                timbreFiscal.setSelloSAT(attr.getValue());
            }
            if (attr.getName().equals("noCertificadoSAT")) {
                timbreFiscal.setNoCertificadoSAT(attr.getValue());
            }
            if (attr.getName().equals("selloCFD")) {
                timbreFiscal.setSelloCFD(attr.getValue());
            }
            if (attr.getName().equals("FechaTimbrado")) {
                timbreFiscal.setFecha(Util.stringToDateTime(attr.getValue()));
            }
            if (attr.getName().equals("UUID")) {
                timbreFiscal.setUuid(attr.getValue());
            }
            if (attr.getName().equals("version")) {
                timbreFiscal.setVersion(attr.getValue());
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    @Override
    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public ComprobanteTO getComprobante() {
        return comprobante;
    }

    @Override
    public EmisorTO getEmisor() {
        return emisor;
    }

    @Override
    public DomicilioFiscalTO getDomicilioFiscal() {
        return domicilioFiscal;
    }

    @Override
    public RegimenFiscalTO getRegimenFiscal() {
        return regimenFiscal;
    }

    @Override
    public ReceptorTO getReceptor() {
        return receptor;
    }

    @Override
    public DomicilioTO getDomicilio() {
        return domicilio;
    }

    @Override
    public List<ConceptoTO> getConceptos() {
        return conceptos;
    }

    @Override
    public List<ImpuestoTO> getImpuestos() {
        return impuestos;
    }

    @Override
    public NominaTO getNomina() {
        return nomina;
    }

    @Override
    public TimbreFiscalTO getTimbreFiscal() {
        return timbreFiscal;
    }

    @Override
    public List<RegistroTO> getRegistros() {
        return registros;
    }
}
