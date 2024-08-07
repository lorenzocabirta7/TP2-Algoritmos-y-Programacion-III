package edu.fiuba.algo3.modelo.ModoDePregunta;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;
import edu.fiuba.algo3.modelo.Respuestas.Respuesta;
import edu.fiuba.algo3.modelo.exceptions.ExclusividadInvalida;

import java.util.ArrayList;

public class VerdaderoOFalso implements TipoDePregunta{

    private TipoDePenalidad penalidad;
    public VerdaderoOFalso(TipoDePenalidad unaPenalidad){
        this.penalidad = unaPenalidad;
    }

    @Override
    public int actualizarPuntaje(int puntosPorRespuestaCorrecta, ArrayList<Respuesta> respuestasDelJugador, ArrayList<Respuesta> respuestasDeLaPregunta) {
        int puntajeTotal = 0;
        for (Respuesta respuesta : respuestasDelJugador) {

            puntajeTotal += respuesta.actualizarPuntaje(puntosPorRespuestaCorrecta,penalidad,respuesta);
        }
        return puntajeTotal;
    }

    @Override
    public String getTipoDePregunta(String mensaje) {
        String mensajePenalidad = "Penalidad: ";
        return mensaje + "Verdadero Falso " + penalidad.getTipoPenalidad(mensajePenalidad);
    }

    @Override
    public boolean EsDeOrderedChoice() {
        return false;
    }

    @Override
    public boolean EsDeMultipleChoice() {
        return false;
    }

    @Override
    public boolean EsDeVerdaderoFalso() {
        return true;
    }

    @Override
    public boolean EsDeGroupChoice() {
        return false;
    }

    @Override
    public void activarExclusividad() throws ExclusividadInvalida {
        penalidad.activarExlcusividad();
    }
}
