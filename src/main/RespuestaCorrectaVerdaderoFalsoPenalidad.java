package main;

import java.util.ArrayList;

public class RespuestaCorrectaVerdaderoFalsoPenalidad implements Respuesta{
    private final String enunciadoRespuesta;

    public RespuestaCorrectaVerdaderoFalsoPenalidad(String respuesta){
        this.enunciadoRespuesta = respuesta ;

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
