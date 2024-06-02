package Tests.Entrega01;

import main.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class prueba {
    @Test
    public void messageGreeting() {

        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        String enunciado = "Estamos en el año 2024?";

        Respuesta respuestaErronea = new Respuesta("Verdadero", true);
        Respuesta respuestaCorrecta = new Respuesta("Falso", false);
        ArrayList<Respuesta> opciones = new ArrayList<>();

        opciones.add(respuestaErronea);
        opciones.add(respuestaCorrecta);
        Pregunta pregunta = new VerdaderoFalsoClasico(enunciado, respuestaCorrecta);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");


        jugador1.responder(pregunta,opciones);
        jugador2.responder(pregunta,opciones);

        pregunta.puntuar(respuestaErronea);
        pregunta.puntuar(respuestaCorrecta);
    }

}