package Tests.Entrega01;

import Main.Jugador;
import Main.Pregunta;
import Main.Respuesta;
import Main.VerdaderoFalsoClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class pruebaaaa{
    @Test
    public void messageGreeting() {

        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        String enunciado = "el sol existe";

        Respuesta respuesta_erronea = new Respuesta("Verdadero", false);
        Respuesta respuesta_correcta = new Respuesta("Falso", true);

        Pregunta pregunta = new VerdaderoFalsoClasico(enunciado,  respuesta_correcta);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Jugador jugador3 = new Jugador("Jugador 3");


        respuesta1 = jugador1.responder(pregunta);
        respuesta2 = jugador1.responder(pregunta);
        respuesta3 =
        respuestas.add(respuesta1,respuesta2,respuesta3)
        ArrayList<Respuesta> respuestasDeJugadores = new ArrayList<Respuesta>();
        respuestasDeJugadores.add(respuesta_correcta)
        respuestasDeJugadores.add(respuesta_erronea)




    }

}