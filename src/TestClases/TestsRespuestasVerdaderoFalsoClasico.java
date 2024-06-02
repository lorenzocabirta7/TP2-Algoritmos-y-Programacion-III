package TestClases;

import main.Jugador;
import main.RespuestaCorrectaVerdaderoFalsoClasico;
import main.RespuestaIncorrectaVerdaderoFalsoClasico;
import main.RespuestasDeVerdaderoFalsoClasico;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsRespuestasVerdaderoFalsoClasico {
    @org.junit.jupiter.api.Test
    public void Test01UnaRespuestaCorrectaSeInicializaCorrectamente() {

        Boolean respuestaEsperada = true;

        RespuestaCorrectaVerdaderoFalsoClasico respuesta = new RespuestaCorrectaVerdaderoFalsoClasico("Verdadero", true);

        Boolean respuestaObtenida = respuesta.esCorrecta();

        assertEquals(respuestaEsperada, respuestaObtenida);
    }
    @org.junit.jupiter.api.Test
    public void Test02UnaRespuestaIncorrectaSeInicializaCorrectamente() {

        Boolean respuestaEsperada = false;

        RespuestaIncorrectaVerdaderoFalsoClasico respuesta = new RespuestaIncorrectaVerdaderoFalsoClasico("Falso", false);
        Boolean respuestaObtenida = respuesta.esCorrecta();

        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @org.junit.jupiter.api.Test
    public void Test03UnaRespuestaCorrectaSeteaUnJugadorCorrectamente() {

        String nombreDeJugadorEsperado  = "Riquelme";

        Jugador jugador1 = new Jugador("Riquelme");
        RespuestaCorrectaVerdaderoFalsoClasico respuesta = new RespuestaCorrectaVerdaderoFalsoClasico("verdaderp", true);

        respuesta.setJugador(jugador1);
        String nombreDeJugadorObtenido =  respuesta.NombreDeJugador();

        assertEquals(nombreDeJugadorEsperado, nombreDeJugadorObtenido);
    }
}




