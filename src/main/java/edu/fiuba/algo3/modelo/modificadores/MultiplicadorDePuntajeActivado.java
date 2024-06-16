package edu.fiuba.algo3.modelo.modificadores;

public class MultiplicadorDePuntajeActivado implements MultiplicadorDePuntaje {
    private int usosDisponibles;

    public MultiplicadorDePuntajeActivado() {
        this.usosDisponibles = 1;
    }

    @Override
    public int modificarPuntaje(int unPuntaje, int multiplicador) {
        return unPuntaje*multiplicador;
    }
}
