package main;

import java.util.ArrayList;

public class RespuestaCorrectaMultipleChoiceClasico implements Respuesta{
    private String enunciadoRespuesta;

    public RespuestaCorrectaMultipleChoiceClasico(String respuesta){
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
