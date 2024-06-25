package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;

public class MultiplicadorPorDos {
    private int usosDisponibles;

    private int multiplicador = 2;
    private MultiplicadorDePuntaje estado = new MultiplicadorDePuntajeDesactivado();;

    public MultiplicadorPorDos() {
        this.usosDisponibles = 1;
    }

    public void activar() throws ModificadorSeUsaMasDeUnaVezException {
        if (usosDisponibles > 0) {
            estado = new MultiplicadorDePuntajeActivado();
            usosDisponibles--;
        }
        else {
            throw new ModificadorSeUsaMasDeUnaVezException("No hay usos disponibles");
        }
    }

    public int modificarPuntaje(int unPuntaje){
        int puntajeModificado =  estado.modificarPuntaje(unPuntaje, multiplicador);
        estado = new MultiplicadorDePuntajeDesactivado();
        return puntajeModificado;

    }
}
