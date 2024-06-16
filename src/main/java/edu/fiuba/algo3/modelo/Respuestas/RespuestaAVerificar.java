package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Respuestas.Penalidad.PenalidadClasica;

public class RespuestaAVerificar implements Respuesta{
    private String respuesta;
    private String OrdenParcial;


    public RespuestaAVerificar(String respuesta, String OrdenParcial) {
        this.respuesta = respuesta;
        this.OrdenParcial = OrdenParcial;
    }
    @Override
    public Boolean EsCorrecta(Respuesta unaRespuesta){
        Respuesta respuestaVerificada = this.TransformarRespuesta(this, unaRespuesta);
        return respuestaVerificada.EsCorrecta(respuestaVerificada);
    }

    @Override
    public int actualizarPuntaje(int puntaje, Respuesta unaRespuesta){
        Respuesta respuestaVerificada = this.TransformarRespuesta(this, unaRespuesta);
            return respuestaVerificada.actualizarPuntaje(puntaje, respuestaVerificada);
    }

    private Respuesta TransformarRespuesta(RespuestaAVerificar respuesta1, Respuesta unaRespuesta2){
        if (respuesta1.EsLaMismaRespuesta(unaRespuesta2)) {
            return (new RespuestaCorrecta(respuesta1.respuesta, respuesta1.OrdenParcial));
        }
        return (new RespuestaIncorrecta(respuesta1.respuesta, new PenalidadClasica()));
    }

    private Boolean EsLaMismaRespuesta(Respuesta unaRespuesta){
        return(this.respuesta.equals(unaRespuesta.getEnunciado()) && (this.OrdenParcial.equals(unaRespuesta.getOrdenParcial())));
    }

    @Override
    public String getOrdenParcial(){
        return this.OrdenParcial;
    }

    @Override
    public String getEnunciado(){
        return this.respuesta;
    }
}
