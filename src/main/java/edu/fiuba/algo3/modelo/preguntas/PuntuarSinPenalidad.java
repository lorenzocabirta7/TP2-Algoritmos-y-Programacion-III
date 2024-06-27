package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadActivado;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDesactivado;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public abstract class PuntuarSinPenalidad implements FormaDePuntuar {
    protected ArrayList<Jugador> jugadoresQueUsaronAnulador = new ArrayList<Jugador>();
    protected ArrayList<Jugador> jugadoresQueUsaronExclusividad = new ArrayList<Jugador>();

    protected Jugador jugadorQueSeAplica = null;
    protected Anulador anulador = new AnuladorClasico();
    protected Exclusividad exclusividad = new ExclusividadDesactivado();

    public void agregarJugadorQueUsoAnulador(Jugador jugador){
        this.jugadoresQueUsaronAnulador.add(jugador);
    }

    public void agregarJugadorQueUsoExclusividad(Jugador jugador,Pregunta pregunta){
        this.exclusividad = new ExclusividadActivado();
        boolean jugadorRespondioCorrectamente = true;
        for (Respuesta respuesta : jugador.obtenerRespuestas()) {
            for (Respuesta respuestaCorrecta : pregunta.getRespuestaCorrecta()) {
                if (respuestaCorrecta.getRespuesta().equals(respuesta.getRespuesta())) {
                    if (!respuesta.EsCorrecta(respuestaCorrecta)){
                        jugadorRespondioCorrectamente = false;
                        break;
                    }
                }
            }
        }
        if (jugadoresQueUsaronExclusividad.isEmpty() && jugadorRespondioCorrectamente){
            this.jugadorQueSeAplica = jugador;
        }
        if (!jugadoresQueUsaronExclusividad.isEmpty() && jugadorRespondioCorrectamente && this.jugadorQueSeAplica == null){
            this.jugadorQueSeAplica = jugador;
        }
        if (!jugadoresQueUsaronExclusividad.isEmpty() && jugadorRespondioCorrectamente && this.jugadorQueSeAplica != null){
            this.jugadorQueSeAplica = null;
        }
        this.jugadoresQueUsaronExclusividad.add(jugador);
    }

}