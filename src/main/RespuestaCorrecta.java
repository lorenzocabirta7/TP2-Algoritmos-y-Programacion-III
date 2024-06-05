package main;

public class RespuestaCorrecta implements Respuesta{
    private String enunciadoRespuesta;

    public RespuestaCorrecta(String respuesta){
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
