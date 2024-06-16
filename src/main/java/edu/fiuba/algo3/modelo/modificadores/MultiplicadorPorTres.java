package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;

public class MultiplicadorPorTres {
    private int usosDisponibles;
    private int multiplicador = 3;
    private MultiplicadorDePuntaje estado = new MultiplicadorDePuntajeDesactivado();

    public MultiplicadorPorTres() {
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
