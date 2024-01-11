/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancac.Modelos;

/**
 *
 * @author localadmin
 */
public class Persona {

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
