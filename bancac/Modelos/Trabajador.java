/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancac.Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author localadmin
 */
public class Trabajador extends Persona {

    private double salarioTrabajador;
    private double estipendio;
    private List<Jugador> jugadores;

    public Trabajador() {
        super();
        this.salarioTrabajador = 0;
        this.estipendio = 0;
        this.jugadores = new ArrayList<>();
    }

    public Trabajador(String ID, String nombre) {
        super(ID, nombre);
        this.salarioTrabajador = 0;
        this.estipendio = 0;
        this.jugadores = new ArrayList<>();
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public double getSalarioTrabajador() {
        return salarioTrabajador + estipendio;
    }

    public void setSalario(double salario) {
        this.salarioTrabajador = salario;
    }

    public void setEstipendio(double estipendio) {
        this.estipendio = estipendio;
    }

}
