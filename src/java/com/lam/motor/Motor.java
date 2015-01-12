/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lam.motor;

import com.lam.entidades.servicio.ColumnaTabulador;
import com.lam.entidades.servicio.Formula;
import com.lam.entidades.servicio.RelacionLaboral;
import com.lam.entidades.servicio.TabuladorSistemaAntiguedad;
import com.lam.impl.servicio.ColumnaTabuladorFacade;
import com.lam.impl.servicio.FormulaFacade;
import com.lam.impl.servicio.TabuladorSistemaAntiguedadFacade;
import com.lam.util.Parametros;
import com.lam.util.Util;
import java.util.List;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author JoséAntonio
 */
public class Motor {

    ColumnaTabuladorFacade controladorColumnaTabulador;
    TabuladorSistemaAntiguedadFacade controladorTabuladorSistemaAntiguedad;
    FormulaFacade controladorFormula;
//    

//    
    public Motor() {
        if (this.controladorColumnaTabulador == null) {
            this.controladorColumnaTabulador = new ColumnaTabuladorFacade();
        }
        if (this.controladorTabuladorSistemaAntiguedad == null) {
            this.controladorTabuladorSistemaAntiguedad = new TabuladorSistemaAntiguedadFacade();
        }
        if (this.controladorFormula == null) {
            this.controladorFormula = new FormulaFacade();
        }
    }

    public double calcularSDI(RelacionLaboral rl, double saldo) {
//        
        Double ciclo = Util.calcularCiclos(rl.getFechaingreso());
        TabuladorSistemaAntiguedad tb = (TabuladorSistemaAntiguedad) this.controladorTabuladorSistemaAntiguedad.find(rl.getIdsistemaantiguedad().getIdsistemaantiguedad().toString(), ciclo.toString());
        List<ColumnaTabulador> columnas = this.controladorColumnaTabulador.findEntities(tb.getIdtabulador());
        Formula formulatb = (Formula) this.controladorFormula.find(rl.getIdcompania().getIdcompania().toString(), Parametros.TIPO_CALCULO_SDI);
//        
        String formula = formulatb.getFormula();
        for (ColumnaTabulador c : columnas) {
            formula = formula.replaceAll(c.getDescripcion(), c.getValor().toString());
        }
//        
        
        return this.ejecutarFormula(formula) * saldo;
    }

    private double ejecutarFormula(String expresion) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
//        
        try {
            return (double) engine.eval(expresion);
        } catch (Exception e) {
            return 0;
        }
    }
//    private FormulaFacade lookupcontroladorFormulaBean() {
//        try {
//            Context c = new InitialContext();
//            return (FormulaFacade) c.lookup("java:global/WSRexam/controladorFormula!com.lam.impl.servicio.FormulaFacade");
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
//    }
//
//    private TabuladorSistemaAntiguedadFacade lookupcontroladorTabuladorSistemaAntiguedadBean() {
//        try {
//            Context c = new InitialContext();
//            return (TabuladorSistemaAntiguedadFacade) c.lookup("java:global/WSRexam/controladorTabuladorSistemaAntiguedad!com.lam.impl.servicio.TabuladorSistemaAntiguedadFacade");
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
//    }
//
//    private ColumnaTabuladorFacade lookupcontroladorColumnaTabuladorBean() {
//        try {
//            Context c = new InitialContext();
//            return (ColumnaTabuladorFacade) c.lookup("java:global/WSRexam/controladorColumnaTabulador!com.lam.impl.servicio.ColumnaTabuladorFacade");
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
//    }
}
