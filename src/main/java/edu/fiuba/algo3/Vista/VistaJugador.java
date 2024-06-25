package edu.fiuba.algo3.Vista;


import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Modelo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VistaJugador implements Observer {
    private Label playerLabel;
    private HBox boxJugador;
    private Button botonConfirmar;



    public VistaJugador(Modelo modelo) {
        playerLabel = new Label("Jugador Actual: " + modelo.conseguirJugador().obtenerNombre());
        botonConfirmar = new Button("Confirmar");
        boxJugador =  new HBox(playerLabel, botonConfirmar);
    }

    public HBox conseguirBoxJugador(){
        return boxJugador;
    }

    public Button getBotonConfirmar(){
        return botonConfirmar;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Modelo) {
            Modelo modelo = (Modelo) o;
            Jugador currentPlayer = modelo.conseguirJugador();
            playerLabel.setText(currentPlayer.obtenerNombre());
            boxJugador =  new HBox(playerLabel, botonConfirmar);
        }
    }


}
