package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;

public class PuntuarMultipleChoiceParcial extends PuntuarConPenalidad{
    private void verificarActivacionAnulador(){
        if (!jugadoresQueUsaronAnulador.isEmpty()){
            this.anulador.activar();
        }
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas,Jugador unjugador) {
        this.verificarActivacionAnulador();
        int PuntajeObtenido = 0;
        for (Respuesta respuestaDelJugador : respuestas) {
            PuntajeObtenido += respuestaDelJugador.actualizarPuntaje(1, respuestaDelJugador);
        }
        for (Respuesta respuestaDelJugador : respuestas) {
            if (!respuestaDelJugador.EsCorrecta(respuestaDelJugador)){
                PuntajeObtenido = 0;
            }
        }
        PuntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(PuntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        return PuntajeObtenido;
    }

    @Override
    public void agregarJugadorQueUsoExclusividad(Jugador jugador) {

    }
}

