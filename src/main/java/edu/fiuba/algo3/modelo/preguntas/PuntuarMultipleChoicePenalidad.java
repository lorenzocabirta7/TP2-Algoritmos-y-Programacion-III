package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;


public class PuntuarMultipleChoicePenalidad extends FormaDePuntuar{
    private Anulador anulador = new AnuladorPenalidad();
    private void verificarActivacionAnulador(){
        if (!jugadoresQueUsaronAnulador.isEmpty()){
            this.anulador.activar();
        }
    }

    @Override
    public int puntuar(ArrayList<Respuesta> respuestas,Jugador unjugador) {
        this.verificarActivacionAnulador();
        int PuntajeObtenido = 0;
        for (Respuesta respuesta : respuestas) {
            PuntajeObtenido += respuesta.actualizarPuntaje(1, respuesta);
        }
        PuntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(PuntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        return PuntajeObtenido;
    }
}