package edu.fiuba.algo3.modelo.Respuestas;

public class RespuestaCorrecta implements Respuesta {
    private String respuesta;
    private String ordenParcial;

    public RespuestaCorrecta(String enunciadoRespuesta, String unOrden){
        this.respuesta = enunciadoRespuesta;
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
    public String getRespuesta(){
        return respuesta;
    }

    @Override
    public String getOrdenParcial(){
        return this.ordenParcial;
    }


    @Override
    public Boolean EsDeOrdenParcial(Respuesta respuesta){
        return false;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "enunciado='" + respuesta + '\'' +
                ", ordenParcial='" + ordenParcial + '\'' +
                '}';
    }

}
