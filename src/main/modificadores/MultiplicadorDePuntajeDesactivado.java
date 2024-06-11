package main.modificadores;

public class MultiplicadorDePuntajeDesactivado implements MultiplicadorDePuntaje {
    private int usosDisponibles;

    public MultiplicadorDePuntajeDesactivado(){
    }

    @Override
    public int modificarPuntaje(int unPuntaje, int multiplicador) {
        return unPuntaje;
    }
}
