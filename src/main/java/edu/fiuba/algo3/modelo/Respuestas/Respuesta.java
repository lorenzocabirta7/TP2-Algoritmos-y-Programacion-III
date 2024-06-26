package edu.fiuba.algo3.modelo.Respuestas;

public interface Respuesta {

    public int actualizarPuntaje(int puntaje, Respuesta unaRespuesta);

    public Boolean EsCorrecta(Respuesta unaRespuesta);

    public String getRespuesta();

    public String getOrdenParcial();

    public Boolean EsDeOrdenParcial(Respuesta respuesta);
}