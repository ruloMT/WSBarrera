/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.reporte.descarga;

import com.lam.to.FacturaElectronicaTO;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author JoséAntonio
 */
public class DescargarPdfs {

    public void setFacturas(List<FacturaElectronicaTO> facturas, String pathCarpetaProcesados) {
        for (FacturaElectronicaTO f : facturas) {
            byte[] pdf = f.getArhivoPdf();
            try {
                String nombreArchivo = f.getNomina().getNumEmpleado() + "-" + f.getReceptor().getNombre().replaceAll(" ", "") + ".pdf";
                OutputStream out = new FileOutputStream(pathCarpetaProcesados + nombreArchivo);
                out.write(pdf);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
