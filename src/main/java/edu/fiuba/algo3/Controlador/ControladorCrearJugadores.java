package edu.fiuba.algo3.Controlador;



import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Modelo;

public class ControladorCrearJugadores {
    Modelo modelo;


    public ControladorCrearJugadores(Modelo modelo) {
        this.modelo = modelo;

    }

    public void seleccionarBoton(String nombreJugador) {
            if (!nombreJugador.isEmpty()) {
                modelo.agregarJugador(nombreJugador);
            } else {
                System.out.println("Please enter your name.");
            }
    }
}
