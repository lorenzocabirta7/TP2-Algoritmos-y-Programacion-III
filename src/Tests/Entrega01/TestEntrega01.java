package Tests.Entrega01;

import main.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//test 01  ✅UnaPreguntadeVerdadero/Falsoclásicorecibeunalistaderespuestasyasignacorrectamentepuntosalosjugadoresquerespondieroncorrectamente✅.
//test 02  ●UnaPreguntadeVerdadero/Falsoclásicorecibeunalistaderespuestasyasignacorrectamentepuntosalosjugadoresquerespondierondeformaincorrecta❌.
//test 03  ●UnaPreguntadeMúltipleChoiceclásicorecibeunalistaderespuestadeunjugadoryasignacorrectamentepuntosalosjugadoresquerespondieroncorrectamente✅.
//test 04  ●UnaPreguntadeMúltipleChoiceclásicorecibeunalistaderespuestadeunjugadoryasignacorrectamentepuntosalosjugadoresquerespondierondeformaincorrecta❌.
//test 05  ●UnaPreguntadeVerdadero/Falsoconpenalidadrecibeunalistaderespuestasyasignacorrectamentepuntosalosjugadoresquerespondieroncorrectamente✅.
//test 06  ●UnaPreguntadeVerdadero/Falsoconpenalidadrecibeunalistaderespuestasyasignacorrectamentepuntosalosjugadoresquerespondierondeformaincorrecta❌.
//test 07  ●UnaPreguntadeMúltipleChoiceconpenalidadrecibeunalistaderespuestadeunjugadoryasignacorrectamentepuntosalosjugadoresquerespondieroncorrectamente✅.
//test 08  ●UnaPreguntadeMúltipleChoiceconpenalidadrecibeunalistaderespuestadeunjugadoryasignacorrectamentepuntosalosjugadoresquerespondierondeformaincorrecta❌.



public class TestEntrega01 {
    @org.junit.jupiter.api.Test
    public void test01VerdaderoFalsoRecibeListaDeRespuestasYAsignaPuntosAJugadoresQueRespondieronCorrectamenteTest01() {

        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 1;
        int puntajeEsperadoJugador2 = 1;

        String enunciado = "Estamos en el año 2024?";

        RespuestaCorrectaVerdaderoFalsoClasico respuesta1 = new RespuestaCorrectaVerdaderoFalsoClasico("Verdadero", true);
        RespuestaIncorrectaVerdaderoFalsoClasico respuesta2 = new RespuestaIncorrectaVerdaderoFalsoClasico("Falso", false);

        ArrayList<Respuesta> respuestasPosibles = new ArrayList<Respuesta>();

        respuestasPosibles.add(respuesta1);
        respuestasPosibles.add(respuesta2);

        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico(enunciado, respuestasPosibles);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        jugador1.responder(pregunta);
        jugador2.responder(pregunta);

        pregunta.puntuar(respuestasPosibles);

        int puntajeObtenidoJugador1 = jugador1.obtenerPuntos();
        int puntajeObtenidoJugador2 = jugador2.obtenerPuntos();

        assertEquals(puntajeEsperadoJugador1,puntajeObtenidoJugador1);
        assertEquals(puntajeEsperadoJugador2,puntajeObtenidoJugador2);
    }

    @org.junit.jupiter.api.Test
    public void test02PreguntadeVerdaderoFalsoRecibeListaDeRespuestasYAsignaPuntosalosjugadores(){

        //Una PreguntadeVerdadero/Falso clásico recibe una lista de respuestas
        //y asigna correctamente puntos a los jugadores que respondieron de forma incorrecta❌.

    }

    @org.junit.jupiter.api.Test
    public void test03PreguntadeVerdaderoFalsoRecibeListaDeRespuestasYAsignaPuntosalosjugadores(){

        //UnaPreguntadeMúltipleChoiceclásicorecibeunalistaderespuestadeunjugador
        // yasignacorrectamentepuntosalosjugadoresquerespondieroncorrectamente✅.

    }

    @org.junit.jupiter.api.Test
    public void test04(){



    }

    @org.junit.jupiter.api.Test
    public void test05(){



    }

    @org.junit.jupiter.api.Test
    public void test06(){



    }

    @org.junit.jupiter.api.Test
    public void test07(){



    }

    @org.junit.jupiter.api.Test
    public void test08(){



    }

}