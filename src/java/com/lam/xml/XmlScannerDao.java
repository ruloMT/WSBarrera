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
import java.util.List;
import org.w3c.dom.Document;

/**
 *
 * @author Diego
 */
public interface XmlScannerDao {

    public void setDocument(Document document);

    public void visitDocument();

    public ComprobanteTO getComprobante();

    public EmisorTO getEmisor();

    public DomicilioFiscalTO getDomicilioFiscal();

    public RegimenFiscalTO getRegimenFiscal();

    public ReceptorTO getReceptor();

    public DomicilioTO getDomicilio();

    public List<ConceptoTO> getConceptos();

    public List<ImpuestoTO> getImpuestos();

    public NominaTO getNomina();

    public TimbreFiscalTO getTimbreFiscal();

    public List<RegistroTO> getRegistros();
}
