package edu.fiuba.algo3.Controlador;



import edu.fiuba.algo3.modelo.Juego;

public class ControladorCrearJugadores {
    Juego juego;


    public ControladorCrearJugadores(Juego juego) {
        this.juego = juego;

    }

    public void seleccionarBoton(String nombreJugador) {
            if (!nombreJugador.isEmpty()) {
                juego.agregarJugador(nombreJugador);
            }
    }
}
