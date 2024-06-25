package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Respuestas.Penalidad.*;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Cada jugador tendrá dos opciones de “exclusividad de puntaje” que podrá elegir
//utilizar en cualquiera de las preguntas que no tienen “penalidad”.
//        ➔ El jugador podrá asignar la exclusividad de puntaje a la pregunta cuando le llegue
//el turno de responder.
//        ➔ Al calcular los puntos, se asignará el doble del puntaje, pero solo en caso de que
//solo uno de los jugadores haya realizado la opción correcta. Es decir, si los N
//jugadores eligen la opción correcta, no se asignará puntaje a ninguno. Si uno de
//los jugadores eligió la opción correcta, ese jugador conseguirá el doble del puntaje.
//        ➔ Alcanza con que uno de los jugadores asigne la exclusividad de puntaje para que
//la regla afecte a todos los jugadores en esa pregunta.
//        ➔ Si por lo menos 2 jugadores asignan exclusividad de puntaje, entonces el efecto se
//multiplica por la cantidad de jugadores que la asignaron y se asignará el puntaje al
//jugador que elija la opción correcta (sólo si ningún otro jugador no eligió la opción
//        correcta a su vez).
//        ➔ Al mostrar los resultados (después de que respondieron los jugadores), se deberá
//indicar que se usó este modificador



public class TestExclusividad {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private ArrayList<Respuesta> respuestas;
    private Pregunta pregunta;


    @BeforeEach
    public void SetUp() {

        jugador1 = new Jugador("FIUBERO");
        jugador2 = new Jugador("TinchoSaad");
        jugador3 = new Jugador("LaCapitalDeEcuador");


        respuestas = new ArrayList<Respuesta>();

        RespuestaCorrecta respuesta1 = new RespuestaCorrecta("Si", "0");
        RespuestaIncorrecta respuesta2 = new RespuestaIncorrecta("No", new PenalidadClasica());

        respuestas.add(respuesta1);
        respuestas.add(respuesta2);

        String enunciado = "Vamos a aprobar el TP?";

        pregunta = new Pregunta(enunciado, respuestas, new PuntuarVerdaderoFalsoClasico());

    }

    @Test
    public void test01UnUnicoJugadorUtilizaExclusividadRespondeCorrectamenteYSeLeDuplicaElPuntaje() throws ExclusividadSeUsaMasdeDosVeces {
        int puntosEsperados = 4;
        int puntosPregunta = 2;

        jugador1.activarExclusividad(pregunta);

    }
    @Test
    public void test02UnJugadorActivaExclusividadYTodosLosJugadoresRespondenBienYSumanCeroPuntos(){
        int puntosEsperadosJugador1 = 0;
        int puntosEsperadosJugador2 = 0;
        int puntosEsperadosJugador3 = 0;

    }

    @Test
    public void test03VariosJugadoresUsanExclusividadYSoloUnoRespondeBienSeMultiplicaElPuntaje() throws ExclusividadSeUsaMasdeDosVeces {
        int puntosEsperadosJugador1 = 8; //2^n siendo n los jugadores que activan el multi
        int puntosEsperadosJugador2 = 0;
        int puntosEsperadosJugador3 = 0;



        jugador2.activarExclusividad(pregunta);
        jugador3.activarExclusividad(pregunta);

        pregunta.ObtenerResultados();

    }

    @Test
    public void test04VariosJugadoresUsanExclusividadYSoloUnoRespondeBienSeMultiplicaElPuntaje(){

    }

}
