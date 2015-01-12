/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.util;

import com.lam.entidades.servicio.AcumuladoConcepto;
import com.lam.entidades.servicio.Liquidacion;
import com.lam.entidades.servicio.SaldoVacaciones;
import com.lam.to.ComprobanteTO;
import com.lam.to.DomicilioFiscalTO;
import com.lam.to.GranTotalCargosAbonosTO;
import com.lam.to.GranTotalSaldoTO;
import com.lam.to.ImpuestoTO;
import com.lam.to.NominaTO;
import com.lam.to.ParametroTO;
import com.lam.to.RegistroTO;
import com.lam.to.ResumenAcumuladoConceptosTO;
import com.lam.to.ResumenLiquidacionTO;
import com.lam.to.ResumenSaldoTO;
import com.lam.to.TimbreFiscalTO;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * @author JoséAntonio
 */
public class Util {

    public static double redondear(double numero) {
        return Math.rint(numero * 100) / 100;
    }

    public static Timestamp getFechaTimeStamp(Date fecha) {
        try {
            return new Timestamp(fecha.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static String getFileName(ParametroTO parametro, String nombreCompania) {
        String periodo = Integer.toString(parametro.getPeriodo());
        if (periodo.length() == 1) {
            periodo = "0" + periodo;
        }
        return nombreCompania.toLowerCase() + "_" + parametro.getClaseNomina().toLowerCase() + "_"
                + parametro.getTipoNomina().toLowerCase() + "_" + periodo + parametro.getAnio() + ".txt";
    }

    public static String dateToStringCertificadoDigitalSAT(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(fecha).replaceAll(" ", "T");
    }

    @SuppressWarnings({"CallToThreadDumpStack", "BroadCatchBlock", "TooBroadCatch"})
    public static Date stringToDateTime(String fecha) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fecha.replaceAll("T", " "));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch", "CallToThreadDumpStack"})
    public static Date stringToDate(String fecha) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static double calcularSubtotal(List<RegistroTO> registros) {
        double subtotal = 0;
        for (RegistroTO r : registros) {
            if (r.getPercepcionDeduccion().equals("PERCEPCION")) {
                subtotal += r.getImportePercepcion();
            }
        }
        return subtotal;
    }

    public static double calcularDescuento(List<RegistroTO> registros) {
        double descuento = 0;
        for (RegistroTO r : registros) {
            descuento += r.getImporteDeduccion();
        }
        return descuento;
    }

    public static String calcularDecimal(Double cantidad) {
        cantidad = redondear(cantidad);
        String decimal;
        try {
            StringTokenizer token = new StringTokenizer(cantidad.toString(), ".");
            token.nextToken();
            decimal = token.nextToken();
            if (decimal.length() == 1) {
                decimal += "0";
            }
        } catch (Exception e) {
            decimal = "00";
        }
        return decimal;
    }

    public static String concatCadenaOriginalComplementoSAT(TimbreFiscalTO timbre) {
        String cadena = "||" + timbre.getVersion() + "|" + timbre.getUuid() + "|"
                + dateToStringCertificadoDigitalSAT(timbre.getFecha()) + "|"
                + timbre.getSelloCFD() + "|" + timbre.getNoCertificadoSAT() + "||";
        return cadena;
    }

    public static String concatDireccionEmisor(DomicilioFiscalTO domicilio) {
        String cadena = domicilio.getCalle() + " " + domicilio.getNoExterior() + ", " + domicilio.getColonia() + ". "
                + domicilio.getMunicipio() + " " + domicilio.getEstado() + " " + domicilio.getPais() + " " + domicilio.getCodigoPostal();
        return cadena.toUpperCase();
    }

    public static String concatPeriodoPago(NominaTO nomina) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "MX"));
        String cadena = sdf.format(nomina.getFechaInicialPago()) + " al " + sdf.format(nomina.getFechaFinalPago());
        return cadena.toUpperCase();
    }

    public static double buscarImpuestoISR(List<ImpuestoTO> impuestos) {
        double isr = 0.0;
        for (ImpuestoTO i : impuestos) {
            if (i.getImpuesto().equals("ISR")) {
                isr = i.getImporte();
            }
        }
        return isr;
    }

    public static String getPeriodoPago(ComprobanteTO comprobante) {
        return comprobante.getFolio().substring(4, 6);
    }

    public static String getAnioPago(Date fechaPago) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(fechaPago);
    }

    public static String generarPassword() {
        char[] elementos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] conjunto = new char[5];
        for (int i = 0; i < 5; i++) {
            int el = (int) (Math.random() * 33);
            System.out.println("Aleatorio: " + el);
            conjunto[i] = (char) elementos[el];
        }
        return new String(conjunto);
    }

    public static String convertDateToString(Date fecha) {
        return fecha != null ? new SimpleDateFormat("dd/MM/yyy").format(fecha) : "";
    }

    public static String convertDateTimeToString(Date fecha) {
        return fecha != null ? new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(fecha) : "";
    }

    public static Date convertStringToDate(String fecha) {
        try {
            return new SimpleDateFormat("dd/MM/yyy").parse(fecha);
        } catch (Exception e) {
            return null;
        }
    }

    public static double calcularCiclos(Date fecha) {
        Calendar calActual = Calendar.getInstance();
//
        Calendar calFecha = Calendar.getInstance();
        calFecha.setTime(fecha);
//        
        double diferencia = (calActual.getTime().getTime() - calFecha.getTime().getTime()) / (24 * 60 * 60 * 1000);

        return diferencia / 365;
    }

    public static void sumarResumenVacaciones(ResumenSaldoTO resumen, SaldoVacaciones saldo) {
//
        resumen.getTotal().setTotalDerecho((double) saldo.getPorderecho());
        resumen.getTotal().setTotalDevengadas((double) saldo.getDevengadas());
        resumen.getTotal().setTotalSolicitadas((double) saldo.getSolicitadas());
        resumen.getTotal().setTotalAutorizadas((double) saldo.getAutorizadas());
        resumen.getTotal().setTotalDisfrutadas((double) saldo.getDisfrutadas());
        resumen.getTotal().setTotalVencidas((double) saldo.getVencidas());
        resumen.getTotal().setTotalSaldo((double) (saldo.getSaldo()));
//        
        resumen.getTotal().redondear();

    }

    public static GranTotalSaldoTO getGranTotal(List<ResumenSaldoTO> registros) {
        GranTotalSaldoTO gt = new GranTotalSaldoTO();
        for (ResumenSaldoTO r : registros) {
            gt.setTotalDerecho((double) r.getTotal().getTotalDerecho());
            gt.setTotalDevengadas((double) r.getTotal().getTotalDevengadas());
            gt.setTotalSolicitadas((double) r.getTotal().getTotalSolicitadas());
            gt.setTotalAutorizadas((double) r.getTotal().getTotalAutorizadas());
            gt.setTotalDisfrutadas((double) r.getTotal().getTotalDisfrutadas());
            gt.setTotalVencidas((double) r.getTotal().getTotalVencidas());
            gt.setTotalSaldo((double) r.getTotal().getTotalSaldo());
            gt.redondear();
        }
        return gt;
    }

    public static void sumarResumenLiquidaciones(ResumenLiquidacionTO resumen, Liquidacion liquidacion, String tipoTransaccion) {
        resumen.getTotal().setTiempo(liquidacion.getTiempo());
        switch (tipoTransaccion) {
            case "Percepcion":
                resumen.getTotal().setPercepcion(liquidacion.getImporte());
                break;
            case "Deduccion":
                resumen.getTotal().setDeduccion(liquidacion.getImporte());
                break;
        }
    }

    public static GranTotalCargosAbonosTO getTotalLiquidacion(List<ResumenLiquidacionTO> registros) {
        GranTotalCargosAbonosTO total = new GranTotalCargosAbonosTO();
        for (ResumenLiquidacionTO r : registros) {
            total.setTiempo(r.getTotal().getTiempo());
            total.setDeduccion(r.getTotal().getDeduccion());
            total.setPercepcion(r.getTotal().getPercepcion());
        }
        return total;
    }

    public static void sumarResumenCifrasNominas(ResumenAcumuladoConceptosTO resumen, AcumuladoConcepto acumulado, String tipoTransaccion) {
        resumen.getTotal().setTiempo(acumulado.getTiempo());
        resumen.getTotal().setTrabajadores(1);
        switch (tipoTransaccion) {
            case "Percepcion":
                resumen.getTotal().setPercepcion(acumulado.getImporte());
                break;
            case "Deduccion":
                resumen.getTotal().setDeduccion(acumulado.getImporte());
                break;
            case "Provision":
                resumen.getTotal().setProvision(acumulado.getImporte());
                break;
        }
    }

    public static void sumarResumenListadoNominas(ResumenAcumuladoConceptosTO resumen, AcumuladoConcepto acumulado, String tipoTransaccion) {
        resumen.getTotal().setTiempo(acumulado.getTiempo());
        switch (tipoTransaccion) {
            case "Percepcion":
                resumen.getTotal().setPercepcion(acumulado.getImporte());
                break;
            case "Deduccion":
                resumen.getTotal().setDeduccion(acumulado.getImporte());
                break;
        }
    }
}
