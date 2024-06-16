package edu.fiuba.algo3.modelo.Respuestas;

public class RespuestaCorrecta implements Respuesta {
    private String enunciado;
    private String ordenParcial;

    public RespuestaCorrecta(String enunciadoRespuesta, String unOrden){
        this.enunciado = enunciadoRespuesta;
        this.ordenParcial = unOrden;
    }

    @Override
    public int actualizarPuntaje(int puntaje, Respuesta unaRespuesta) {
        return puntaje;
    }

    @Override
    public Boolean EsCorrecta(Respuesta unaRespuesta){
        return true;
    }

    @Override
    public String getEnunciado(){
        return enunciado;
    }

    @Override
    public String getOrdenParcial(){
        return this.ordenParcial;
    }
}
