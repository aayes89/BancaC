
/**
 *
 * @author Slam
 */
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }
}

class Persona {

    private String ID;
    private String nombre;

    /*
     Definir si hace falta más información genérica que pueda ser usada luego
     */
    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public void setSalario(double salario) {
        this.salarioTrabajador = salario;
    }

    public void setEstipendio(double estipendio) {
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

class Control { // Clase controldora intermedia (posiblemente para uso en la API)

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

    public void agregarEstipendio(Trabajador t, double estipendio) {
        if (listadoTrabajadores.contains(t)) {
            listadoTrabajadores.get(listadoTrabajadores.indexOf(t)).setEstipendio(estipendio);
        }
    }
}

class Banco {

    public void distribuirGanancias(Map<Trabajador, Double> trabajadores) {
        // Implementa lógica para distribuir ganancias
    }
}
