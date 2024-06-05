package main;

import java.util.ArrayList;

public class RespuestaIncorrectaVerdaderoFalsoPenalidad implements Respuesta{
    private final String enunciadoRespuesta;

    public RespuestaIncorrectaVerdaderoFalsoPenalidad(String respuesta){
        this.enunciadoRespuesta = respuesta;
    }

    @Override
    public int actualizarPuntaje(int puntaje) {
        return (puntaje * -1);
    }

    @Override
    public String getEnunciadoRespuesta(){
        return enunciadoRespuesta;
    }

    @Override
    public Boolean EsCorrecta(){
        return false;
    }
}
