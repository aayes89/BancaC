
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
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // variables e instancias generales
        Jugador j = new Jugador();
        Control ctrl = new Control();
        // variable de control del ciclo principal
        boolean seguir = true;
        // objeto de captura de datos
        Scanner scan = new Scanner(System.in);
        System.out.println("---- Bienvenido al sistema de Banca ----");
        // logica principal
        while (seguir) {

            System.out.println("---- MENU ----");
            System.out.println("1. añadir trabajador");
            System.out.println("2. dar baja trabajador");
            System.out.println("3. establecer salario base");
            System.out.println("4. establecer estipendio general");
            System.out.println("5. establecer estipendio específico");
            System.out.println("");
            System.out.println("0. salir del programa");
            int opcion = scan.nextInt();
            switch (opcion) {
                case 0: // salir
                    seguir = false;
                    break;
                case 1: // add worker
                    System.out.println("Ingrese el nombre del trabajador:");
                    String nombre = scan.next().concat(scan.nextLine());
                    if (!nombre.isEmpty()) {
                        int cantT = ctrl.cantTrabajadores();
                        ctrl.añadirTrabajador(new Trabajador("T" + cantT, nombre));
                    }
                    break;
                case 2: // del worker
                    System.out.println("Ingrese el nombre del trabajador:");
                    String nombreT = scan.next().concat(scan.nextLine());
                    boolean fueBaja = false;
                    if (ctrl.estaElTrabajadorNombre(nombreT)) {
                        ctrl.darBajaTrabajador(ctrl.buscarTrabajador(nombreT, null));
                        fueBaja = true;
                    } else {
                        System.out.println("El trabajador no se pudo encontar por su nombre\nIntente por su ID:");
                        System.out.println("El formato del ID es: Txxxx\n donde xxxx es un número con tope 9999");
                        String idT = scan.next().concat(scan.nextLine());
                        if (ctrl.estaElTrabajadorID(idT)) {
                            ctrl.darBajaTrabajador(ctrl.buscarTrabajador(null, idT));
                            fueBaja = true;
                        }
                    }
                    if (fueBaja) {
                        System.out.println("El trabajador fue dado de baja");
                    } else {
                        System.out.println("El trabajador no pudo encontrarse en la BD");
                    }
                    break;
                case 3: // add salary
                    if (ctrl.cantTrabajadores() == 0) {
                        System.out.println("No puede añadir salario si no hay trabajadores disponibles.");
                    } else {
                        System.out.println("Ingrese el salario base nominal para los trabajadores:");
                        double salarioBase = scan.nextDouble();
                        ctrl.establecerSalarioBase(salarioBase);
                    }
                    break;
                case 4: // add incentive
                    if (ctrl.cantTrabajadores() == 0) {
                        System.out.println("No puede añadir estipendio si no hay trabajadores disponibles.");
                    } else {
                        System.out.println("Ingrese el estipendio general para los trabajadores:");
                        double estipendio = scan.nextDouble();
                        ctrl.agregarEstipendioGen(estipendio);
                    }
                    break;
                case 5: // add individual incentive
                    if (ctrl.cantTrabajadores() == 0) {
                        System.out.println("No puede añadir estipendio si no hay trabajadores disponibles.");
                    } else {
                        System.out.println("Ingrese el nombre del trabajador a estimular:");
                        String nombreTE = scan.next().concat(scan.nextLine());
                        Trabajador tEst = ctrl.buscarTrabajador(nombreTE, null);
                        if (tEst != null) {
                            System.out.println("Ingrese el estipendio para el trabajador específico");
                            double estipendioT = scan.nextDouble();
                            ctrl.agregarEstipendioEspecifico(tEst, estipendioT);
                        } else {
                            System.out.println("No se encontró el trabajador.\n");
                        }
                    }
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente!");
                //throw new AssertionError();
            }

        }

    }
}

class Persona {

    private String ID;
    private String nombre;

    /*
     Definir si hace falta más información genérica que pueda ser usada luego
     */
    public Persona(String ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }

    public Persona() {
        this.ID = "";
        this.nombre = "";
    }

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
        super();
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

class Banco {

    public void distribuirGanancias(Map<Trabajador, Double> trabajadores) {
        // Implementa lógica para distribuir ganancias
    }
}
