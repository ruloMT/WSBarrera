package com.lam.conversorXml;

import com.lam.reporte.GenerarReporte;
import com.lam.to.FacturaElectronicaTO;
import com.lam.util.Util;
import com.lam.xml.XmlScanner;
import com.lam.xml.XmlScannerDao;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConversorXmlToEntity {

    public List<FacturaElectronicaTO> iniciarProceso(String pathCarpetaTimbre, String pathCarpetaLogo, int idCompania) {
        List<FacturaElectronicaTO> facturas = new ArrayList<>();
        File f = new File(pathCarpetaTimbre);
        if (f.exists()) {
            File[] ficheros = f.listFiles();
            for (File archivo : ficheros) {
                String nombreArchivoCBB = validarArchivos(pathCarpetaTimbre, archivo);
                if (nombreArchivoCBB != null && archivo.getName().contains("xml")) {
//                  CONVIERTE ARCHIVO  
                    FacturaElectronicaTO factura = convertirArchivos(archivo, nombreArchivoCBB, pathCarpetaLogo);
//                  AGREGA FACTURAS A LA LISTA  
                    if (factura != null) {
                        factura.setIdCompania(idCompania);
                        facturas.add(factura);
                        this.eliminarArchivos(pathCarpetaTimbre, archivo);
                    }
                }
            }
        }
        return facturas;
    }

    @SuppressWarnings({"CallToThreadDumpStack", "UseSpecificCatch"})
    private FacturaElectronicaTO convertirArchivos(File archivo, String nombreArchivoCBB,
            String pathCarpetaLogo) {
        org.w3c.dom.Document document;
        FacturaElectronicaTO factura;
        try {
            javax.xml.parsers.DocumentBuilderFactory builderFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            javax.xml.parsers.DocumentBuilder builder = builderFactory.newDocumentBuilder();
            document = builder.parse(archivo);
            XmlScannerDao scanner = new XmlScanner();
            scanner.setDocument(document);
            scanner.visitDocument();
            factura = new FacturaElectronicaTO(scanner);
            double subtotal = Util.calcularSubtotal(factura.getRegistros());
            double descuento = Util.calcularDescuento(factura.getRegistros());
            factura.setSubtotal(subtotal);
            factura.setDescuento(descuento);
            factura.setTotal(factura.getSubtotal() - factura.getDescuento());
//          CREA REPORTE EN PDF  

            GenerarReporte reportePDF = new GenerarReporte(factura, pathCarpetaLogo, nombreArchivoCBB);
//          CONVIERTE REPORTE PDF EN BYTE[]  
            byte[] archivoPdf = reportePDF.generarPDF();
//          CONVIERTE REPORTE XML EN BYTE[]  
            Path pathXml = Paths.get(archivo.getPath());
            byte[] archivoXml = Files.readAllBytes(pathXml);
            Path pathCBB = Paths.get(nombreArchivoCBB);
            byte[] archivoCBB = Files.readAllBytes(pathCBB);
//          SETEA BYTE[] 
            factura.setTimbre(archivoCBB);
            factura.setArchivoXml(archivoXml);
            factura.setArhivoPdf(archivoPdf);
//
            return factura;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void eliminarArchivos(String pathCarpetaTimbre, File archivo) {
        String pathPdf = pathCarpetaTimbre + archivo.getName().replaceAll("xml", "pdf");
        String pathPng = pathCarpetaTimbre + archivo.getName().replaceAll("xml", "png");
        archivo.delete();
        new File(pathPdf).delete();
        new File(pathPng).delete();
    }

    private String validarArchivos(String pathCarpetaTimbre, File archivo) {
        String sDirectorio = pathCarpetaTimbre + archivo.getName().replaceAll("xml", "png");
        File f = new File(sDirectorio);
        return f.exists() ? sDirectorio : null;
    }
}
