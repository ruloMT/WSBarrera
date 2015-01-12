    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.reporte;

import com.lam.to.FacturaElectronicaTO;
import com.lam.util.Util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Diego
 */
public class GenerarReporte {

    private final FacturaElectronicaTO factura;
    private final String pathCarpetaLogo;
    private final String pathCBB;

    //
    public GenerarReporte(FacturaElectronicaTO factura, String pathCarpetaLogo, String pathCBB) {
        this.factura = factura;
        this.pathCarpetaLogo = pathCarpetaLogo;
        this.pathCBB = pathCBB;
    }

    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch", "UseSpecificCatch", "CallToThreadDumpStack"})
    public byte[] generarPDF() {
        Map<String, Object> params = new HashMap<>();
        try {
//          SETEA PARAMETROS A EXPORTER
            String decimal = Util.calcularDecimal(this.factura.getTotal());
            String plantilla = "/com/lam/plantilla/ReporteFacturas.jrxml";
            JasperDesign jd = JRXmlLoader.load(this.getClass().getResourceAsStream(plantilla));
            params.put("folio", this.factura.getTimbreFiscal().getUuid());
            params.put("certificadoCSD", this.factura.getComprobante().getNoCertificado());
            params.put("lugarEmision", this.factura.getComprobante().getLugarExpedicion());
            params.put("fechaEmision", this.factura.getComprobante().getFecha());
            params.put("razonSocial", this.factura.getEmisor().getNombre());
            params.put("domicilioEmpresa", Util.concatDireccionEmisor(this.factura.getDomicilioFiscal()));
            params.put("rfcEmisor", this.factura.getEmisor().getRfc());
            params.put("registroPatronal", this.factura.getNomina().getRegistroPatronal());
            params.put("numeroEmpleado", this.factura.getNomina().getNumEmpleado());
            params.put("curp", this.factura.getNomina().getCurp());
            params.put("fechaAntiguedad", this.factura.getNomina().getFechaInicioRelLaboral());
            params.put("nss", this.factura.getNomina().getNumSeguroSocial());
            params.put("fechaPago", this.factura.getNomina().getFechaPago());
            params.put("periodoPago", Util.concatPeriodoPago(this.factura.getNomina()));
            String periodo = Util.getPeriodoPago(this.factura.getComprobante());
            factura.setPeriodo(periodo);
            params.put("periodo", factura.getPeriodo());
            params.put("diasPagados", this.factura.getNomina().getNumDiasPagados());
//            
            String departamento = this.factura.getNomina().getDepartamento() == null ? "" : this.factura.getNomina().getDepartamento();
            params.put("departamento", departamento);
            String puesto = this.factura.getNomina().getPuesto() == null ? "" : this.factura.getNomina().getPuesto();
            params.put("puesto", puesto);
//            
            params.put("perioricidad", this.factura.getNomina().getPeriodicidadPago());
            params.put("salario", this.factura.getNomina().getSalarioBaseCotApor());
            params.put("salarioIntegrado", this.factura.getNomina().getSalarioDiarioIntegrado());
            params.put("rfcReceptor", this.factura.getReceptor().getRfc());
            params.put("nombreReceptor", this.factura.getReceptor().getNombre());
            params.put("regimenFiscal", this.factura.getRegimenFiscal().getRegimen());
            params.put("subtotal", this.factura.getSubtotal());
            params.put("total", this.factura.getTotal());
            params.put("formaDePago", this.factura.getComprobante().getFormaDePago());
            params.put("metodoDePago", this.factura.getComprobante().getMetodoDePago());
            params.put("cfdi", this.factura.getTimbreFiscal().getSelloCFD());
            params.put("selloSAT", this.factura.getTimbreFiscal().getSelloSAT());
            System.out.println(this.factura.getNomina().getNumEmpleado() + " | " + this.factura.getSubtotal() + " - " + this.factura.getDescuento() + " | " + this.factura.getTotal() + " | " + decimal);
            String cantidadLetra = new numbertoletterconverter.NumberToLetterConverter().convertNumberToLetter(this.factura.getTotal()) + ", " + decimal + "/100 M.N.";
            params.put("cantidadLetra", cantidadLetra);
            String cadenaCertificado = Util.concatCadenaOriginalComplementoSAT(this.factura.getTimbreFiscal());
            params.put("cadenaCertificado", cadenaCertificado);
            params.put("noCertificadoSAT", this.factura.getTimbreFiscal().getNoCertificadoSAT());
            params.put("fechaTimbrado", this.factura.getTimbreFiscal().getFecha());
            params.put("precioUnitario", this.factura.getConceptos().get(0).getValorUnitario());
            params.put("importe", this.factura.getConceptos().get(0).getImporte());
            params.put("descripcion", this.factura.getConceptos().get(0).getDescripcion());
            params.put("unidad", this.factura.getConceptos().get(0).getUnidad());
            params.put("cantidad", this.factura.getConceptos().get(0).getCantidad());
            double isr = Util.buscarImpuestoISR(this.factura.getImpuestos());
            params.put("isr", isr);
            params.put("descuento", this.factura.getDescuento() - isr);
            params.put("timbre", pathCBB);
            params.put("logo", this.pathCarpetaLogo);
            params.put(JRParameter.REPORT_LOCALE, new Locale("es", "MX"));
//          
//          EXPORTA A FORMATO PDF  
//            
            JRPdfExporter exporter = new JRPdfExporter();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(this.factura.getRegistros()));
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
            exporter.exportReport();

//          CONVIERTE A BYTES  

            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
