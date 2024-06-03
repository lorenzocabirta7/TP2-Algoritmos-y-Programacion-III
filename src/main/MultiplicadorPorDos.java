package main;

import main.exceptions.ModificadorSeUsaMasDeUnaVezException;

public class MultiplicadorPorDos {
    private int usosDisponibles;
    private int multiplicador = 2;
    private DuplicadorDePuntaje estado = new DuplicadorDePuntajeDesactivado();;

    public MultiplicadorPorDos() {
        this.usosDisponibles = 1;

    }

    public void activar() throws ModificadorSeUsaMasDeUnaVezException {
        if (usosDisponibles > 0) {
            estado = new DuplicadorDePuntajeActivado();
            usosDisponibles--;
        }
        else {
            throw new ModificadorSeUsaMasDeUnaVezException("No hay usos disponibles");

        }
    }

    public int modificarPuntaje(int unPuntaje){

        int puntajeModificado =  estado.modificarPuntaje(unPuntaje);
        estado = new DuplicadorDePuntajeDesactivado();
        return puntajeModificado;

    }
}
