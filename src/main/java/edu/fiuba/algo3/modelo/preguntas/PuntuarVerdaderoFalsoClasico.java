package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

//Asigna un punto a cada jugador que responda con la opción correcta
public class PuntuarVerdaderoFalsoClasico extends PuntuarSinPenalidad {

    private TipoDePenalidad penalidad = new PenalidadClasica();

    private void verificarActivacionAnulador(){
        if (!jugadoresQueUsaronAnulador.isEmpty()){
            this.anulador.activar();
        }
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas, Jugador unjugador) {
        this.verificarActivacionAnulador();
        Respuesta respuestaDelJugador = respuestas.get(0); //sabemos que para verdadero falso solo nos llega una respuesta por eso agarramos la primera.
        int PuntajeObtenido = 1;

        PuntajeObtenido = respuestaDelJugador.actualizarPuntaje(PuntajeObtenido,penalidad, respuestaDelJugador);
        PuntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(PuntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        return PuntajeObtenido;
    }

    @Override
    public void agregarJugadorQueUsoExclusividad(Jugador jugador) {

    }
}
