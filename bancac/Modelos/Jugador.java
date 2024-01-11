/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancac.Modelos;

import bancac.Modals.ModalidadesEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author localadmin
 */
public class Jugador extends Persona {

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
            this.modalidad = ModalidadesEnum.CANDADO.toString();
        } else if (modalidad.equalsIgnoreCase("parle")) {
            this.modalidad = ModalidadesEnum.PARLE.toString();
        } else if (modalidad.equalsIgnoreCase("fijo")) {
            this.modalidad = ModalidadesEnum.FIJO.toString();
        } else if (modalidad.equalsIgnoreCase("corrido")) {
            this.modalidad = ModalidadesEnum.CORRIDO.toString();
        }
    }

    public void addApuesta(int numero) {
        numeroApostado.add(numero);
    }

    public void setNumeroApostado(List<Integer> numeroApostado) {
        this.numeroApostado = numeroApostado;
    }

}
