package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Respuestas.Penalidad.TipoDePenalidad;

public class RespuestaIncorrecta implements Respuesta {
    private TipoDePenalidad tipoDePenalidad;
    private String enunciado;

    public RespuestaIncorrecta(String respuesta, TipoDePenalidad tipoDePenalidad){
        this.tipoDePenalidad = tipoDePenalidad;
        this.enunciado = respuesta;
    }

    @Override
    public int actualizarPuntaje(int puntaje, Respuesta unaRespuesta) {
        return tipoDePenalidad.actualizarPuntaje(puntaje);
    }

    @Override
    public Boolean EsCorrecta(Respuesta unaRespuesta){
        return false;
    }

    @Override
    public String getEnunciado(){
        return enunciado;
    }

    @Override
    public String getOrdenParcial(){
        return "0"; //el cero indica que NO hay orden parcial.
    }

}
