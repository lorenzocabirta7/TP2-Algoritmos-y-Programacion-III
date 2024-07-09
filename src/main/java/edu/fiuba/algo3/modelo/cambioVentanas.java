package edu.fiuba.algo3.modelo;




import edu.fiuba.algo3.Vista.VentanaInicio;
import edu.fiuba.algo3.Vista.VentanaLeaderboard;
import edu.fiuba.algo3.Vista.VentanaPregunta;
import javafx.stage.Stage;

public class cambioVentanas {
    public static final int ANCHO_PANTALLA = 600;
    public static final int LARGO_PANTALLA = 450;
    private Stage stage;
    private VentanaInicio ventanaInicio;
    private VentanaLeaderboard ventanaLeaderboard;
    private VentanaPregunta ventanaPregunta;
    Juego juego;


    public void iniciar() {
        juego = new Juego();
        stage = new Stage();
        crearVentanas();
    }


    private void crearVentanas() {

        ventanaInicio = new VentanaInicio(juego);
        ventanaInicio.inicializarVentana(stage);

        ventanaInicio.AlCambiarVentana(() -> {
            ventanaLeaderboard = new VentanaLeaderboard(juego);

            ventanaLeaderboard.AlCambiarVentana(() -> {

                ventanaPregunta = new VentanaPregunta(juego);

                ventanaPregunta.AlCambiarVentana(() -> {
                    ventanaLeaderboard.inicializarVentana(stage);
                });

                ventanaPregunta.inicializarVentana(stage);

            });
            ventanaLeaderboard.inicializarVentana(stage);


        });

    }
}
