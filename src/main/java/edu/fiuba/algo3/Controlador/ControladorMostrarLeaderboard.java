package edu.fiuba.algo3.Controlador;

import edu.fiuba.algo3.Vista.VentanaLeaderboard;
import edu.fiuba.algo3.modelo.Juego;
import java.awt.event.MouseAdapter;


public class ControladorMostrarLeaderboard extends MouseAdapter {
    Juego juego;
    private VentanaLeaderboard vista;

    public ControladorMostrarLeaderboard(Juego juego, VentanaLeaderboard vista) {
        this.juego = juego;
        this.vista = vista;
        this.juego.addObserver(this.vista);
    }


    public void ApretarBotonSiguientePregunta()  {
        juego.SiguientePregunta();
    }



}
