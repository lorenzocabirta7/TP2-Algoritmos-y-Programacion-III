package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.GestorPuntaje;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;

public class PuntuarDeFormaOrdenada extends PuntuarSinPenalidad{

    private TipoDePenalidad penalidad = new PenalidadClasica();
    private ArrayList<Respuesta> respuestas;
    private void verificarActivacionAnulador(){
        if (!jugadoresQueUsaronAnulador.isEmpty()){
            this.anulador.activar();
        }
    }

    public PuntuarDeFormaOrdenada(ArrayList<Respuesta> respuestasPosibles) {
        this.respuestas = respuestasPosibles;
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas,Jugador unjugador) {
        this.verificarActivacionAnulador();

        int RespuestasCorrectas = 0;
        int RespuestasCorrectasEsperadas = respuestas.size();
        int puntajeObtenido = GestorPuntaje.PuntajeError();


        for (Respuesta respuesta : respuestas) {
            for(Respuesta respuestaPosible : this.respuestas){
                RespuestasCorrectas += respuesta.actualizarPuntaje(GestorPuntaje.PuntajeAcierto(),penalidad, respuestaPosible);
            }
        }
        if (RespuestasCorrectas == RespuestasCorrectasEsperadas) {
            puntajeObtenido = GestorPuntaje.PuntajeAcierto();
        }
        puntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(puntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        puntajeObtenido = this.exclusividad.puntosLuegoDeEvaluacion(puntajeObtenido,this.jugadoresQueUsaronExclusividad,this.jugadorQueSeAplica,unjugador);
        return puntajeObtenido;
    }

}

