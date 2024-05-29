package Tests.Entrega01;

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
        //correctamente puntos a los jugadores que respondieron correctamente ✅

        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        Respuesta respuesta1 = new Respuesta("Verdadero", false);
        Respuesta respuesta2 = new Respuesta("Falso", true);
        respuestas.add(respuesta1);

        Pregunta pregunta = new VerdaderoFalsoClasico("Pregunta",  respuestas);

        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");

        ;
    }

    @Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }
}