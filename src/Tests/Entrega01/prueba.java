package Tests.Entrega01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class prueba01{
    @Test
    public void messageGreeting() {

        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente ✅

        Arraylist<Respuesta> respuestas = new Arraylist<Respuesta>();
        Respuesta respuesta1 = new Respuesta("Verdadero", false);
        Respuesta respuesta2 = new Respuesta("Falso", true);
        jugador1

        Pregunta pregunta = new VerdaderoFalsoClasico("Pregunta", Arraylist<Respuesta> respuestas);

        assertEquals("Hello world!", message.greet("us"));
    }

    @Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }
}