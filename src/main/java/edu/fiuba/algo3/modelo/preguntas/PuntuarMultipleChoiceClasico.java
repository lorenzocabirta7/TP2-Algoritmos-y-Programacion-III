package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.Anulador.*;
import edu.fiuba.algo3.modelo.Respuestas.*;
import edu.fiuba.algo3.modelo.Jugador;
import java.util.ArrayList;

public class PuntuarMultipleChoiceClasico extends PuntuarSinPenalidad{
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
        int PuntajeObtenido = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestas) {
            if (respuestaDelJugador.EsCorrecta(respuestaDelJugador)){
                RespuestasCorrectas += 1;
            }
        }
        if (RespuestasCorrectas == respuestasCorrectas.size()){
            PuntajeObtenido = 1;
        }
        PuntajeObtenido = this.anulador.puntosLuegoDeEvaluacion(PuntajeObtenido,this.jugadoresQueUsaronAnulador,unjugador);
        return PuntajeObtenido;
    }

    @Override
    public void agregarJugadorQueUsoExclusividad(Jugador jugador) {

    }
}