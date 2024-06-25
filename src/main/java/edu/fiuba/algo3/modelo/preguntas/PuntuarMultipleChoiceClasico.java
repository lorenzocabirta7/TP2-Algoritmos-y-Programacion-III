package edu.fiuba.algo3.modelo.preguntas;



import edu.fiuba.algo3.modelo.Respuestas.Respuesta;

import java.util.ArrayList;

public class PuntuarMultipleChoiceClasico implements FormaDePuntuar{
    private ArrayList<Respuesta> respuestas;

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
    public int puntuar(ArrayList<Respuesta> respuestas) {
        int RespuestasCorrectas = 0;
        int puntosObtenidos = 0;
        ArrayList<Respuesta>respuestasCorrectas = this.obtenerRespuestasCorrectas();

        for (Respuesta respuestaDelJugador : respuestas) {
            if (respuestaDelJugador.EsCorrecta(respuestaDelJugador)){
                RespuestasCorrectas += 1;
            }
        }
        if (RespuestasCorrectas == respuestasCorrectas.size()){
            puntosObtenidos = 1;
        }
        return puntosObtenidos;
    }
}
