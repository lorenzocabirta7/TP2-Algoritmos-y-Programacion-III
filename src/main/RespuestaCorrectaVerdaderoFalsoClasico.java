package main;

import java.util.ArrayList;

public class RespuestaCorrectaVerdaderoFalsoClasico implements Respuesta{
    private String enunciadoRespuesta;

    public RespuestaCorrectaVerdaderoFalsoClasico(String enunciadoRespuesta){
        this.enunciadoRespuesta = enunciadoRespuesta;
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
