package edu.fiuba.algo3.modelo.Respuestas;

import edu.fiuba.algo3.modelo.Penalidad.Penalidad.TipoDePenalidad;

public class RespuestaIncorrecta implements Respuesta {
    private TipoDePenalidad tipoDePenalidad;
    private String enunciado;


    //Hay que Sacar esto
    public RespuestaIncorrecta(String respuesta, TipoDePenalidad tipoDePenalidad){
        this.tipoDePenalidad = tipoDePenalidad;
        this.enunciado = respuesta;
    }

    public RespuestaIncorrecta(String respuesta){
        this.enunciado = respuesta;
    }

    @Override
    public int actualizarPuntaje(int puntaje,TipoDePenalidad tipoDePenalidad, Respuesta unaRespuesta) {
        return tipoDePenalidad.actualizarPuntaje(puntaje);
    }

    @Override
    public Boolean EsCorrecta(Respuesta unaRespuesta){
        return false;
    }

    @Override
    public String getRespuesta(){
        return enunciado;
    }

    @Override
    public String getOrdenParcial(){
        return "0"; //el cero indica que NO hay orden parcial.
    }

    @Override
    public Boolean EsDeOrdenParcial(Respuesta respuesta){
        return false;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "enunciado='" + enunciado + '\'' +
                ", tipoDePenalidad='" + tipoDePenalidad + '\'' +
                '}';
    }

}
