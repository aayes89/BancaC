/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banca.Modelos;

import java.text.DateFormat;
import java.time.Instant;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author localadmin
 */
public class Dia {

    private Date fecha;
    private double montoBruto;
    private double centena;
    private Map<Date, Trabajador> asistenciaTrabajadores;

    public Dia() {
        this.fecha = Date.from(Instant.now());
        this.montoBruto = 0;
        this.centena = 0;
        this.asistenciaTrabajadores = new HashMap<>();
    }

    public String getFormatedFecha() {
        DateFormat df = DateFormat.getDateInstance(FormatStyle.FULL.ordinal());
        return (df.format(fecha));
    }

    public double getMontoBruto() {
        return montoBruto;
    }

    public void addMontoBruto(double montoBruto) {
        this.montoBruto += montoBruto;
    }

    public double getCentena() {
        return centena;
    }

    public void addCentena(double centena) {
        this.centena += centena;
    }

    public Map<Date, Trabajador> getAsistenciaTrabajadores() {
        return asistenciaTrabajadores;
    }

    public void addAsistenciaTrabajadores(Trabajador trabajador) {
        this.asistenciaTrabajadores.put(Date.from(Instant.now()), trabajador);
    }

}
