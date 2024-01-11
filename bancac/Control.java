/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancac;

import bancac.Modelos.Trabajador;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author localadmin
 */
public class Control { // Clase controldora intermedia (posiblemente para uso en la API)

    private Date fecha;
    private List<Double> salariosPTrabajadores;
    private List<Trabajador> listadoTrabajadores;
    private Map<String, Trabajador> datosEntrada; // <String (fecha), Trabajador> 

    public Control() {
        fecha = Date.from(Instant.now());
        salariosPTrabajadores = new ArrayList<>();
        listadoTrabajadores = new ArrayList<>();
        datosEntrada = new HashMap<>();
    }

    public void añadirTrabajador(Trabajador t) {
        listadoTrabajadores.add(t);
    }

    public void darBajaTrabajador(Trabajador t) {
        if (listadoTrabajadores.contains(t)) {
            listadoTrabajadores.remove(t);
        }
    }

    public Trabajador buscarTrabajador(String nombre, String id) {
        Trabajador t = null;
        for (Trabajador tmp : listadoTrabajadores) {
            if (tmp.getID().equalsIgnoreCase(id) && tmp.getNombre().equalsIgnoreCase(nombre)) {
                t = tmp;
                break;
            }
        }
        return t;
    }

    public void registrarEntrada(Trabajador entradaTrabajador) {
        // Implementa lógica para registrar resultados
        datosEntrada.put(fecha.toString(), entradaTrabajador);
    }

    public void establecerSalarioBase(double salario) {
        for (Trabajador t : listadoTrabajadores) {
            t.setSalario(salario);
        }
    }

    public void agregarEstipendioEspecifico(Trabajador t, double estipendio) {
        if (listadoTrabajadores.contains(t)) {
            listadoTrabajadores.get(listadoTrabajadores.indexOf(t)).setEstipendio(estipendio);
        }
    }

    public void agregarEstipendioGen(double estipendio) {
        for (Trabajador t : listadoTrabajadores) {
            agregarEstipendioEspecifico(t, estipendio);
        }
    }

    public boolean estaElTrabajadorNombre(String nombre) {
        for (Trabajador t : listadoTrabajadores) {
            if (t.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaElTrabajadorID(String ID) {
        for (Trabajador t : listadoTrabajadores) {
            if (t.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public List obtenerListadoTrabajadores() {
        return listadoTrabajadores;
    }

    public int cantTrabajadores() {
        return listadoTrabajadores.size();
    }

}
