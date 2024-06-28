package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.ModoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;

public interface Respuesta {


    public int actualizarPuntaje(int puntaje, TipoDePenalidad unaPenalidad, Respuesta unaRespuesta);

    public Boolean EsCorrecta(Respuesta unaRespuesta);

    public String getRespuesta();

    public String getOrdenParcial();

    public Boolean EsDeOrdenParcial(Respuesta respuesta);
}