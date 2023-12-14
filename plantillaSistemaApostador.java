import java.util.HashMap;
import java.util.Map;

public class SistemaApostador {
    private Map<String, Jugador> jugadores;
    private Modalidad modalidad;
    private Control control;
    private Banco banco;

    public SistemaApostador() {
        this.jugadores = new HashMap<>();
        this.modalidad = new Modalidad();
        this.control = new Control();
        this.banco = new Banco();
    }

    public void agregarJugador(String nombre, String numeroApostado, String modalidad) {
        Jugador jugador = new Jugador(nombre, numeroApostado, modalidad);
        jugadores.put(nombre, jugador);
    }

    public void capturarResultado(String nombreJugador, int resultado) {
        control.registrarResultado(jugadores.get(nombreJugador), resultado);
    }

    public void distribuirGanancias() {
        banco.distribuirGanancias(jugadores);
    }
}

class Jugador {
    private String nombre;
    private String numeroApostado;
    private String modalidad;

    public Jugador(String nombre, String numeroApostado, String modalidad) {
        this.nombre = nombre;
        this.numeroApostado = numeroApostado;
        this.modalidad = modalidad;
    }
}

class Modalidad {
    // Implementa lógica para las modalidades fijo, corrido, parle, candado
}

class Control {
    public void registrarResultado(Jugador jugador, int resultado) {
        // Implementa lógica para registrar resultados
    }
}

class Banco {
    public void distribuirGanancias(Map<String, Jugador> jugadores) {
        // Implementa lógica para distribuir ganancias
    }
}
