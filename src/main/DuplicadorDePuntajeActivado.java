package main;

public class DuplicadorDePuntajeActivado implements DuplicadorDePuntaje {
    private int usosDisponibles;
    private int multiplicador = 2;



    public DuplicadorDePuntajeActivado() {
        this.usosDisponibles = 1;
    }

    @Override
    public int modificarPuntaje(int unPuntaje){
        return unPuntaje*multiplicador;
    }
}
