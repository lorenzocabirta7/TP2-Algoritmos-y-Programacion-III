package main;

public class DuplicadorDePuntajeActivo implements Modificador{
    private int usosDisponibles;
    private int multiplicador = 2;



    public DuplicadorDePuntajeActivo() {
        this.usosDisponibles = 1;
    }

    @Override
    public int modificarPuntaje(int unPuntaje){
        if (usosDisponibles < 1){
            return unPuntaje;
        }
        usosDisponibles --;
        return unPuntaje*multiplicador;

    }
}
