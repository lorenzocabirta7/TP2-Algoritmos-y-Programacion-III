package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.ControladorCrearJugadores;
import edu.fiuba.algo3.modelo.Modelo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static edu.fiuba.algo3.modelo.Juego.ANCHO_PANTALLA;
import static edu.fiuba.algo3.modelo.Juego.LARGO_PANTALLA;

public class VentanaInicio implements Ventana{

    private final Scene scene;
    private final Button mostrarLeaderBoardBoton;
    private final Label mensajeExito;
    private final Label numeroJugadoresLabel;
    private int numeroJugadores = 0;

    public VentanaInicio(Modelo modelo) {

        Label CartelBienvenida = new Label("Bienvenidos Al Juego del grupo 4 de Algoritmos y Programacion 3!");

        Label nameLabel = new Label("Ingresar Nombre Del Jugador:");
        TextField InputNombre = new TextField();
        InputNombre.setMaxWidth(250);

        Button ConfirmarJugadorBoton = new Button("Confirmar Jugador");
        ConfirmarJugadorBoton.setStyle("-fx-background-color: #65d24a; -fx-background-radius: 5px; -fx-padding: 8px;");

        mostrarLeaderBoardBoton = new Button("Avanzar");
        mostrarLeaderBoardBoton.setStyle("-fx-background-color: #f16363; -fx-background-radius: 5px; -fx-padding: 8px;");

        mensajeExito = new Label(); // Mensaje de éxito
        numeroJugadoresLabel = new Label("Número de Jugadores Actuales: " + numeroJugadores); // Contador de jugadores

        ControladorCrearJugadores controladorCrearJugador = new ControladorCrearJugadores(modelo);

        ConfirmarJugadorBoton.setOnAction(e -> {
            String NombreDeJugador = InputNombre.getText().trim();
            if (!NombreDeJugador.isEmpty()) {
                controladorCrearJugador.seleccionarBoton(NombreDeJugador);
                mensajeExito.setText(NombreDeJugador + " agregado exitosamente!");
                numeroJugadores++;
                numeroJugadoresLabel.setText("Número de Jugadores Actuales: " + numeroJugadores);
            }
        });

        VBox root = new VBox(20);
        root.setPadding(new Insets(60, 60, 60, 60));

        HBox jugadorHBox = new HBox(10);
        jugadorHBox.getChildren().addAll(InputNombre, mensajeExito);

        root.getChildren().addAll(CartelBienvenida, nameLabel, jugadorHBox, ConfirmarJugadorBoton, numeroJugadoresLabel, mostrarLeaderBoardBoton);

        scene = new Scene(root, ANCHO_PANTALLA, LARGO_PANTALLA);
    }

    public void inicializarVentana(Stage stage){
        stage.setScene(scene);
        stage.setTitle("Preguntados");
        stage.show();
    }

    @Override
    public void AlCambiarVentana(Runnable funcion) {
        mostrarLeaderBoardBoton.setOnAction(e -> funcion.run());
    }
}

