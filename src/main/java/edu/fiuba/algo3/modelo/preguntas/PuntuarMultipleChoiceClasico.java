package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.GestorPuntaje;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

import java.util.ArrayList;

public class PuntuarMultipleChoiceClasico extends PuntuarSinPenalidad{

    private TipoDePenalidad penalidad = new PenalidadClasica();
    private ArrayList<Respuesta> respuestas;

    private void verificarActivacionAnulador(){
        if (!this.jugadoresQueUsaronAnulador.isEmpty()){
            this.anulador.activar();
        }
    }

    public PuntuarMultipleChoiceClasico(ArrayList<Respuesta> respuestasPosibles) {
        this.respuestas = respuestasPosibles;
    }
    private ArrayList<Respuesta> obtenerRespuestasCorrectas() {

        ArrayList<Respuesta> respuestasCorrectas = new ArrayList<>();

        for (Respuesta respuestaPosible : respuestas) {
            if (respuestaPosible.EsCorrecta(respuestaPosible)) {
                respuestasCorrectas.add(respuestaPosible);
            }
        }
        return respuestasCorrectas;
    }
    @Override
    public int puntuar(ArrayList<Respuesta> respuestas,Jugador unjugador) {
        this.verificarActivacionAnulador();
        int RespuestasCorrectas = 0;
        int PuntajeObtenido = GestorPuntaje.PuntajeError();
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestas) {
            if (respuestaDelJugador.EsCorrecta(respuestaDelJugador)){
                RespuestasCorrectas += 1;
            }
        }
        if (RespuestasCorrectas == respuestasCorrectas.size()){
            PuntajeObtenido = GestorPuntaje.PuntajeAcierto();
        }
        PuntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(PuntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        PuntajeObtenido = this.exclusividad.puntosLuegoDeEvaluacion(PuntajeObtenido,this.jugadoresQueUsaronExclusividad,this.jugadorQueSeAplica,unjugador);
        return PuntajeObtenido;
    }
}