package main;

public class DuplicadorDePuntajeDesactivado implements DuplicadorDePuntaje{
    private int usosDisponibles;

    public DuplicadorDePuntajeDesactivado(){
    }

    public int modificarPuntaje(int unPuntaje){
        return unPuntaje;
    }

}
