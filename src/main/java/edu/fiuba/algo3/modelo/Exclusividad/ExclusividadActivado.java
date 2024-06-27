package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.Respuestas.RespuestaCorrecta;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import java.lang.Math.*;
import java.util.ArrayList;


public class ExclusividadActivado implements Exclusividad {

    private ArrayList<Jugador> jugadoresQueRespondieronCorrectamente = new ArrayList<Jugador>();


    @Override
    public int puntosLuegoDeEvaluacion(int puntajeSinModificar, ArrayList<Jugador> jugaodoresQueUsaronExclusividad, Jugador jugadorEvaluado, Jugador juagdorAlQueSeLeAplica) {
        int numeroDeJugadoresConExclusividadActivado = jugaodoresQueUsaronExclusividad.size();

        int multiplicador = (int) Math.pow(2,numeroDeJugadoresConExclusividadActivado);
        if (juagdorAlQueSeLeAplica == null){
            return puntajeSinModificar;
        }else {
            if (jugadorEvaluado == (juagdorAlQueSeLeAplica)){
                return multiplicador*puntajeSinModificar;
            }
            return puntajeSinModificar;
        }

    }
}