package edu.fiuba.algo3.modelo;




import edu.fiuba.algo3.Vista.VentanaInicio;
import edu.fiuba.algo3.Vista.VentanaLeaderboard;
import edu.fiuba.algo3.Vista.VentanaPregunta;
import javafx.stage.Stage;

public class Juego {
    public static final int ANCHO_PANTALLA = 600;
    public static final int LARGO_PANTALLA = 450;
    private Stage stage;
    private VentanaInicio ventanaInicio;
    private VentanaLeaderboard ventanaLeaderboard;
    private VentanaPregunta ventanaPregunta;
    Modelo modelo;


    public void iniciar() {
        modelo = new Modelo();
        stage = new Stage();
        crearVentanas();
    }


    private void crearVentanas() {

        ventanaInicio = new VentanaInicio(modelo);
        ventanaInicio.inicializarVentana(stage);

        ventanaInicio.AlCambiarVentana(() -> {
            ventanaLeaderboard = new VentanaLeaderboard(modelo);

            ventanaLeaderboard.AlCambiarVentana(() -> {

                ventanaPregunta = new VentanaPregunta(modelo);

                ventanaPregunta.AlCambiarVentana(() -> {
                    ventanaLeaderboard.inicializarVentana(stage);
                });

                ventanaPregunta.inicializarVentana(stage);

            });
            ventanaLeaderboard.inicializarVentana(stage);


        });

    }
}
