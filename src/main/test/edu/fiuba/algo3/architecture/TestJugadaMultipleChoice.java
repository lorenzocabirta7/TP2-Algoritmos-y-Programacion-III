package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.ModoDePregunta.MultipleChoice;
import edu.fiuba.algo3.modelo.ModoDePregunta.VerdaderoOFalso;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaIncorrecta;
import edu.fiuba.algo3.modelo.exceptions.AnuladorSeUsaMasDeUnaVez;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadSeUsaMasdeDosVeces;
import edu.fiuba.algo3.modelo.exceptions.ModificadorSeUsaMasDeUnaVezException;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugadaMultipleChoice {
    Pregunta preguntaChoiceConPenalidad;
    Pregunta preguntaChoiceSinPenalidad;

    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;

    RespuestaCorrecta respuestaCorrecta1;
    RespuestaCorrecta respuestaCorrecta2;
    RespuestaCorrecta respuestaCorrecta3;
    RespuestaIncorrecta respuestaIncorrecta1;
    ArrayList<Respuesta> respuestas;

    @BeforeEach
    public void setUp() {
        respuestaCorrecta1 = new RespuestaCorrecta("Correcta1", "0");
        respuestaCorrecta2 = new RespuestaCorrecta("Correcta2", "0");
        respuestaCorrecta3 = new RespuestaCorrecta("Correcta3", "0");
        respuestaIncorrecta1 = new RespuestaIncorrecta("Incorrecta");


        respuestas = new ArrayList<>();
        respuestas.add(respuestaCorrecta1);
        respuestas.add(respuestaCorrecta2);
        respuestas.add(respuestaCorrecta3);
        respuestas.add(respuestaIncorrecta1);

        jugador1 = new Jugador("jugador1");
        jugador2 = new Jugador("jugador2");
        jugador3 = new Jugador("jugador3");

        preguntaChoiceConPenalidad = new Pregunta("Un Enunciado", "UnTema", respuestas, new MultipleChoice(new PenalidadConPenalidad()));
        preguntaChoiceSinPenalidad = new Pregunta("Un Enunciado", "UnTema", respuestas, new MultipleChoice(new PenalidadClasica()));

    }


    @Test
    public void test01TresJugadoresJueganUnaRonda() throws AnuladorSeUsaMasDeUnaVez {
        //Una Pregunta de Verdadero/Falso clásico recibe una lista de respuestas y asigna
        //correctamente puntos a los jugadores que respondieron correctamente

        int puntajeEsperadoJugador1 = 3;
        int puntajeEsperadoJugador2 = 2;
        int puntajeEsperadoJugador3 = 0;

        jugador1.responder(preguntaChoiceSinPenalidad,respuestaCorrecta1);
        jugador1.responder(preguntaChoiceSinPenalidad,respuestaCorrecta2);
        jugador1.responder(preguntaChoiceSinPenalidad,respuestaCorrecta3);

        jugador2.responder(preguntaChoiceSinPenalidad,respuestaIncorrecta1);
        jugador2.responder(preguntaChoiceSinPenalidad,respuestaCorrecta2);
        jugador2.responder(preguntaChoiceSinPenalidad,respuestaCorrecta3);

        jugador3.responder(preguntaChoiceSinPenalidad,respuestaIncorrecta1);

        preguntaChoiceSinPenalidad.puntuarJugadores();
    }
    

}
