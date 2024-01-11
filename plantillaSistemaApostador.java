/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bancac;

/**
 *
 * @author localadmin
 */
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        SistemaApostador sa = new SistemaApostador();

    }
}

class SistemaApostador {

    private Map<String, Trabajador> trabajadores;
    private List<List<String>> lista;
    private Modalidad modalidad;
    private Control control;
    private Banco banco;

    public SistemaApostador() {
        this.trabajadores = new HashMap<>();
        this.modalidad = new Modalidad();
        this.control = new Control();
        this.banco = new Banco();
    }

    public void agregarJugador(String nombre, String numeroApostado, String modalidad) {

    }

    public void capturarResultado(String nombreJugador, int resultado) {

    }

    public void distribuirGanancias() {
        banco.distribuirGanancias(trabajadores);
    }
}

class Persona {

    private String nombre;
    /*
     Definir si hace falta más información genérica que pueda ser usada luego
     */
}

class Jugador extends Persona {

    private String modalidad;
    private List<Integer> numeroApostado;
    private boolean esGanador;
    private double cantGanada;

    public Jugador() {
        this.modalidad = "";
        this.numeroApostado = new ArrayList<>();
        this.esGanador = false;
        this.cantGanada = 0;
    }

    public String getModalidad() {
        return modalidad;
    }

    public List<Integer> getNumeroApostado() {
        return numeroApostado;
    }

    public boolean esGanador() {
        return esGanador;
    }

    public double getCantGanada() {
        return cantGanada;
    }

    public void setCantGanada(double cantGanada) {
        this.cantGanada = cantGanada;
    }

    public void setEsGanador(boolean esGanador) {
        this.esGanador = esGanador;
    }

    public void setModalidad(String modalidad) {
        if (modalidad.equalsIgnoreCase("candado")) {
            this.modalidad = Modalidades.CANDADO.toString();
        } else if (modalidad.equalsIgnoreCase("parle")) {
            this.modalidad = Modalidades.PARLE.toString();
        } else if (modalidad.equalsIgnoreCase("fijo")) {
            this.modalidad = Modalidades.FIJO.toString();
        } else if (modalidad.equalsIgnoreCase("corrido")) {
            this.modalidad = Modalidades.CORRIDO.toString();
        }
    }

    public void addApuesta(int numero) {
        numeroApostado.add(numero);
    }

    public void setNumeroApostado(List<Integer> numeroApostado) {
        this.numeroApostado = numeroApostado;
    }

}

class Trabajador extends Persona {

    private double salarioTrabajador;
    private double estipendio;
    private final List<Jugador> jugadores;

    public Trabajador() {
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
    
    public void setSalario(double salario){
        this.salarioTrabajador = salario;
    }
    public void setEstipendio(double estipendio){
        this.estipendio = estipendio;
    }

}

enum Modalidades {
    FIJO, CANDADO, PARLE, CORRIDO
};

class Modalidad {

    // Implementa lógica para las modalidades fijo, corrido, parle, candado
    private String tipo;
    private int centena; // 0-9 -> posición en que aparece, se premia
}

class Fijo extends Modalidad {

}

class Corrido extends Modalidad {

}

class Parle extends Modalidad {

}

class Candado extends Modalidad {

}

class Control { // Clase intermedia (posiblemente para uso en la API)

    private Date fecha;
    private List<Float> salariosPTrabajadores;
    private List<Trabajador> listadoTrabajadores;
    private Map<String, Trabajador> datosEntrada; // <String (fecha), Trabajador> 

    public Control() {
        fecha = Date.from(Instant.now());
        salariosPTrabajadores = new ArrayList<>();
        listadoTrabajadores = new ArrayList<>();
        datosEntrada = new HashMap<>();
    }

    public void registrarEntrada(Trabajador entradaTrabajador) {
        // Implementa lógica para registrar resultados
        datosEntrada.put(fecha.toString(), entradaTrabajador);
    }

    public void establecerSalarioBase(float salario) {
       for(Trabajador t:listadoTrabajadores){
           t.setSalario(salario);
       }
    }
    public void agregarEstipendio(Trabajador t, double estipendio){
        if(listadoTrabajadores.contains(t)){
            listadoTrabajadores.get(listadoTrabajadores.indexOf(t)).setEstipendio(estipendio);
        }
    }
}

class Banco {

    public void distribuirGanancias(Map<String, Trabajador> jugadores) {
        // Implementa lógica para distribuir ganancias
    }
}
