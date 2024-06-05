package main;

import java.util.ArrayList;

public class RespuestaCorrectaMultipleChoicePenalidad implements Respuesta{
    private String enunciadoRespuesta;

    public RespuestaCorrectaMultipleChoicePenalidad(String respuesta){
        this.enunciadoRespuesta = respuesta;
    }

    @Override
    public int actualizarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public String getEnunciadoRespuesta(){
        return enunciadoRespuesta;
    }

    @Override
    public Boolean EsCorrecta(){
        return true;
    }
}
