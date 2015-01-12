/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.util;

import com.lam.entidades.cenicco.Usuario;
import com.lam.to.ResumenAcumuladoConceptosTO;
import java.util.Map;

/**
 *
 * @author Antonio
 */
public class Parametros {

    public static final int MAXIMO_HILOS_RECIBOS = 50;
    public static final int MAXIMO_HILOS_ACUMULADOS = 2500;
//
    public static Map<String, Usuario> MAPA_USUARIOS;
    public static Map<String, String> MAPA_CATALOGO;
//    
    public static Map<String, ResumenAcumuladoConceptosTO> MAPA_ACUMULADOS_CONCEPTOS_X_CONCEPTO;
    public static Map<String, ResumenAcumuladoConceptosTO> MAPA_ACUMULADOS_CONCEPTOS_X_TRABAJADOR;
//
    public static final int TIEMPO_HILO_ESPERA = 15000;
    public static final String TIPO_NOMINA_FINIQUITOS = "NL";
    public static final String CLAVE_RECIBO = "Lam0001";
//    
    public static final String COLUMNA_TIPOCONCEPTO = "TIPOCONCEPTO";
    public static final String COLUMNA_UNIDAD = "UNIDAD";
    public static final String COLUMNA_ESTATUS = "ESTATUS";
    public static final String COLUMNA_TIPODESCUENTO = "TIPODESCUENTO";
    public static final String COLUMNA_CALCULO = "CALCULO";
//    
    public static final String TABLA_NOMCONCEPTOSTB = "NOMCONCEPTOSTB";
    public static final String TABLA_NOMINCIDENCIASTB = "NOMINCIDENCIASTB";
    public static final String TABLA_FISINFONAVITTB = "FISINFONAVITTB";
    public static final String TABLA_RHPOSICIONESSUELDOSTB = "RHPOSICIONESSUELDOSTB";
    public static final String TABLA_VACSOLICITUDESTB = "VACSOLICITUDESTB";
    public static final String TABLA_FORMULASTB = "FORMULASTB";
    //    
    public static final String TIPO_INCIDENCIAS = "01";
//  SDI
    public static final String TIPO_CALCULO_SDI = "01";
    public static final String TIPO_CALCULO_SDN = "03";
//    
    public static final String ID_SOLICITUDES_AUTORIZADAS = "02";
//
    public static final Integer CONCEPTO_AUXILIAR = 9999;
}
