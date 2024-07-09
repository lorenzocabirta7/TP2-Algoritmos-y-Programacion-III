package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Alertas.BonificadorSeUsoMasVecesDeLoEsperado;
import edu.fiuba.algo3.Alertas.ExclusividadSeUsaEnPreguntaDePenalidad;
import edu.fiuba.algo3.Controlador.ControladorMostrarPregunta;
import edu.fiuba.algo3.Vista.VentanaRespuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadSeUsaMasdeDosVeces;
import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static edu.fiuba.algo3.modelo.cambioVentanas.ANCHO_PANTALLA;
import static edu.fiuba.algo3.modelo.cambioVentanas.LARGO_PANTALLA;

public class VentanaPregunta implements Ventana, Observer {
    private VBox cajaDeRespuestas;
    private ControladorMostrarPregunta controlador;
    private Scene escenaPregunta;
    private Button mostrarLeaderBoardBoton;
    private Button botonConfirmar;
    private Label labelEnunciado;
    private Label labelTipoDePregunta;

    private Label playerLabel;
    private ArrayList<Button> botonesDeModificadores;
    private Jugador jugadorActual;
    private SeccionRespuesta seccionRespuesta;


    public VentanaPregunta(Juego juego){

        mostrarLeaderBoardBoton = new Button("Avanzar");
        mostrarLeaderBoardBoton.setStyle("-fx-background-color: #f16363; -fx-background-radius: 5px; -fx-padding: 8px;");

        playerLabel = new Label("Jugador Actual: " + juego.conseguirJugador().obtenerNombre());
        botonConfirmar = new Button("Confirmar");

        HBox boxJugador =  new HBox(playerLabel, botonConfirmar);

        Pregunta preguntaInicial = juego.ConseguirPregunta();
        ArrayList<Respuesta> respuestasPosibles = preguntaInicial.respuestasPosibles();

        jugadorActual = juego.conseguirJugador();

        cajaDeRespuestas = new VBox(boxJugador);

        ArmarBoxRespuestas(preguntaInicial);

        cajaDeRespuestas.getChildren().add(seccionRespuesta.mostrarRespuestas(preguntaInicial,respuestasPosibles, jugadorActual));

        VBox cajaDeBonificadores = ArmarBoxModificadores(juego);


        labelEnunciado = new Label();
        labelEnunciado.setText(preguntaInicial.getEnunciado());

        labelTipoDePregunta = new Label();
        labelTipoDePregunta.setText(preguntaInicial.getTipoDePregunta());

        Label labelTemaDePregunta = new Label(preguntaInicial.getTema());

        controlador = new ControladorMostrarPregunta(juego, this, botonConfirmar);

        VBox cajaPregunta = new VBox(10, labelEnunciado, labelTemaDePregunta,labelTipoDePregunta, cajaDeRespuestas);

        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(cajaPregunta);
        mainPane.setRight(cajaDeBonificadores);
        mainPane.setBottom(mostrarLeaderBoardBoton);

        escenaPregunta = new Scene(mainPane, ANCHO_PANTALLA, LARGO_PANTALLA);
    }


    public void inicializarVentana(Stage stage){
        stage.setScene(escenaPregunta);
    }


    private VBox ArmarBoxModificadores(Juego juego){

        Button botonMultiplicadorPorDos = new Button("Multiplicador X2");
        botonMultiplicadorPorDos.setOnAction(event -> {
            Jugador unJugador = juego.conseguirJugador();
            try {
                unJugador.activarDuplicadorDePuntaje();
            } catch (ModificadorSeUsaMasDeUnaVezException ex) {
                BonificadorSeUsoMasVecesDeLoEsperado.mostrarAlerta();
            }

        });
        Button botonMultiplicadorPorTres = new Button("Multiplicador X3");
        botonMultiplicadorPorTres.setOnAction(event -> {
            Jugador unJugador = juego.conseguirJugador();
            try {
                unJugador.activarDuplicadorDePuntaje();
            } catch (ModificadorSeUsaMasDeUnaVezException ex) {
                BonificadorSeUsoMasVecesDeLoEsperado.mostrarAlerta();

            }

        });
        Button botonExclusividad = new Button("Exclusividad");
        botonExclusividad.setOnAction(event -> {
            Jugador unJugador = juego.conseguirJugador();
            try {
                unJugador.activarExclusividad(juego.ConseguirPregunta());
            } catch (ExclusividadInvalida | ExclusividadSeUsaMasdeDosVeces ex) {
                ExclusividadSeUsaEnPreguntaDePenalidad.mostrarAlerta();
            }
        });

        Button botonAnulador = new Button("Anulador");
        botonAnulador.setOnAction(event -> {
            Jugador unJugador = juego.conseguirJugador();
            try {
                unJugador.activarAnuladorDePuntaje(juego.ConseguirPregunta());
            } catch (AnuladorSeUsaMasDeUnaVez ex) {
                BonificadorSeUsoMasVecesDeLoEsperado.mostrarAlerta();
            }

        });

        botonesDeModificadores = new ArrayList<>();
        botonesDeModificadores.add(botonMultiplicadorPorDos);
        botonesDeModificadores.add(botonMultiplicadorPorTres);
        botonesDeModificadores.add(botonExclusividad);
        botonesDeModificadores.add(botonAnulador);

        VBox cajaDeBonificadores = new VBox(10, botonMultiplicadorPorDos, botonMultiplicadorPorTres, botonExclusividad, botonAnulador);
        cajaDeBonificadores.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(10), Insets.EMPTY)));
        return cajaDeBonificadores;
    }

    public void ArmarBoxRespuestas(Pregunta pregunta){

        if (pregunta.esOrderChoice()){
            seccionRespuesta = new SeccionOrdenParcial();
        }
        else if (pregunta.esDeMultipleChoice()) {
            seccionRespuesta = new SeccionMultipleChoice();
        }
        else if (pregunta.esDeVerdaderoFalso()){
            seccionRespuesta = new SeccionVerdaderoFalso();
        }
        else if (pregunta.esGroupChoice()){
            seccionRespuesta = new SeccionGroupChoice();
        }
        else {
            throw new RuntimeException("Tipo de Pregunta inesperado");
        }

    }

    @Override
    public void AlCambiarVentana(Runnable funcion) {
        mostrarLeaderBoardBoton.setOnAction(e -> {
            funcion.run();
        });
    }

    public void updatePlayerLabel(String nombreJugador) {
        playerLabel.setText("Jugador Actual:  " + nombreJugador);
    }


    public void siguienteJugador(Jugador unJugador) {
        jugadorActual = unJugador;
    }

    public void resetModificadores(){
        for (Button button : botonesDeModificadores) {
            button.setDisable(false);
        }
    }

    public void updatePreguntaLabel(Pregunta pregunta){
        labelEnunciado.setText(pregunta.getEnunciado());
    }

    @Override
    public void update(Observable o, Object arg) {
        Juego juego = (Juego) o;
        if (arg.equals("Siguiente Jugador")) {
            this.updatePlayerLabel(juego.conseguirJugador().obtenerNombre());
            this.resetModificadores();
            this.siguienteJugador(juego.conseguirJugador());

            Pregunta preguntaActual = juego.ConseguirPregunta();
            ArrayList<Respuesta> respuestasPosibles = preguntaActual.respuestasPosibles();
            jugadorActual = juego.conseguirJugador();

            cajaDeRespuestas.getChildren().remove(1);

            ArmarBoxRespuestas(preguntaActual);
            cajaDeRespuestas.getChildren().add(seccionRespuesta.mostrarRespuestas(preguntaActual, respuestasPosibles, jugadorActual));
        }
        if (arg.equals("Siguiente Pregunta")) {
            this.updatePreguntaLabel(juego.ConseguirPregunta());
            mostrarLeaderBoardBoton.fire();
        }
    }
}
