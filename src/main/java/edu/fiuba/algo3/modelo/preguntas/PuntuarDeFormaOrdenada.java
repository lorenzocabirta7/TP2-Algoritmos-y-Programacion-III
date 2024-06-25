package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;

public class PuntuarDeFormaOrdenada extends PuntuarSinPenalidad{
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
        int puntajeObtenido = 0;

        for (Respuesta respuesta : respuestas) {
            for(Respuesta respuestaPosible : this.respuestas){
                RespuestasCorrectas += respuesta.actualizarPuntaje(1, respuestaPosible);
            }
        }
        if (RespuestasCorrectas == RespuestasCorrectasEsperadas) {
            puntajeObtenido = 1;
        }
        puntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(puntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        return puntajeObtenido;
    }
}

