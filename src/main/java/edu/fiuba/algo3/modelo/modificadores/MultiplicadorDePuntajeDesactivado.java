package edu.fiuba.algo3.modelo.modificadores;

public class MultiplicadorDePuntajeDesactivado implements MultiplicadorDePuntaje {
    private int usosDisponibles;

    public MultiplicadorDePuntajeDesactivado(){
    }

    @Override
    public int modificarPuntaje(int unPuntaje, int multiplicador) {
        return unPuntaje;
    }
}
