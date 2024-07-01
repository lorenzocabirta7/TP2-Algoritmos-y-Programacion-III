package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.ModoDePregunta.TipoDePregunta;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.PenalidadClasica;
import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;

public class RespuestaAVerificar implements Respuesta{
    private String respuesta;
    private String OrdenParcial;


    public RespuestaAVerificar(String respuesta, String OrdenParcial) {
        this.respuesta = respuesta;
        this.OrdenParcial = OrdenParcial;
    }

    @Override
    public int actualizarPuntaje(int puntaje, TipoDePenalidad unaPenalidad, Respuesta unaRespuesta) {
        Respuesta respuestaTransformada = TransformarRespuesta(this, unaRespuesta);
        return respuestaTransformada.actualizarPuntaje(puntaje, unaPenalidad, unaRespuesta);
    }

    @Override
    public Boolean EsCorrecta(Respuesta unaRespuesta){
        Respuesta respuestaVerificada = this.TransformarRespuesta(this, unaRespuesta);
        return respuestaVerificada.EsCorrecta(respuestaVerificada);
    }


    private Respuesta TransformarRespuesta(RespuestaAVerificar respuesta1, Respuesta unaRespuesta2){
        if (respuesta1.EsLaMismaRespuesta(unaRespuesta2)) {
            return (new RespuestaCorrecta(respuesta1.respuesta, respuesta1.OrdenParcial));
        }
        return (new RespuestaIncorrecta(respuesta1.respuesta));
    }

    private Boolean EsLaMismaRespuesta(Respuesta unaRespuesta){
        return(this.respuesta.equals(unaRespuesta.getRespuesta()) && (this.OrdenParcial.equals(unaRespuesta.getOrdenParcial())));
    }

    @Override
    public String getOrdenParcial(){
        return this.OrdenParcial;
    }

    @Override
    public String getRespuesta(){
        return this.respuesta;
    }

    @Override
    public Boolean EsDeOrdenParcial(Respuesta respuesta){
        return true;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "enunciado='" + respuesta + '\'' +
                ", ordenParcial='" + OrdenParcial + '\'' +
                '}';
    }

}
