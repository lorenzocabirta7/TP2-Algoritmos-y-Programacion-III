package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.GestorPuntaje;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadConPenalidad;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

import java.util.ArrayList;

public class PuntuarVerdaderoFalsoPenalidad extends PuntuarConPenalidad {

    private TipoDePenalidad penalidad = new PenalidadConPenalidad();
    private void verificarActivacionAnulador(){
        if (!jugadoresQueUsaronAnulador.isEmpty()){
            this.anulador.activar();
        }
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador) {
        this.verificarActivacionAnulador();
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int PuntajeObtenido = GestorPuntaje.PuntajeAcierto();
        PuntajeObtenido = respuestaDelJugador.actualizarPuntaje(PuntajeObtenido,penalidad, respuestaDelJugador);
        PuntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(PuntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        return PuntajeObtenido;
    }

}
