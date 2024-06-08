package main;

import main.exceptions.AnuladorSeUsaMasDeUnaVez;
import main.exceptions.ModificadorSeUsaMasDeUnaVezException;

public class Anulador {
    private int usosDisponibles;
    private AnuladorDePuntaje estado ;

    public Anulador(){
        this.usosDisponibles = 1;
        this.estado = new AnuladorDePuntajeDesactivado();
    }

    public void activar() throws AnuladorSeUsaMasDeUnaVez {
        if (usosDisponibles > 0) {
            estado = new AnuladorDePuntajeActivado();
            usosDisponibles--;
        }
        else {
            throw new AnuladorSeUsaMasDeUnaVez("No hay usos disponibles");

        }
    }

}
