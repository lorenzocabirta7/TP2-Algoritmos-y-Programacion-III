package main;

import main.exceptions.AnuladorSeUsaMasDeUnaVez;
import main.exceptions.ModificadorSeUsaMasDeUnaVezException;

public class Anulador {
    private int usosDisponibles;
    //private AnuladorDePuntaje estado = new AnuladorDePuntajeDesactivado;
    public Anulador(){
        this.usosDisponibles = 1;
    }

    public void activar() throws AnuladorSeUsaMasDeUnaVez {
        if (usosDisponibles > 0) {
            //estado = new DuplicadorDePuntajeActivado();
            usosDisponibles--;
        }
        else {
            throw new AnuladorSeUsaMasDeUnaVez("No hay usos disponibles");

        }
    }
}
