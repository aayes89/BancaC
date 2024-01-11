package bancac;

/**
 *
 * @author Slam
 */
import bancac.Modelos.Jugador;
import bancac.Modelos.Trabajador;
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
        System.out.println("Gracias por usar Banca");
    }
}
