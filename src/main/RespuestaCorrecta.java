package main;

public class RespuestaCorrecta implements Respuesta{
    private String enunciado;
    private OrdenParcial unOrden;

    public RespuestaCorrecta(String enunciadoRespuesta, OrdenParcial unOrden){
        this.unOrden = unOrden;
        this.enunciado = enunciadoRespuesta;
    }

    @Override
    public int actualizarPuntaje(int puntaje) {
        return puntaje;
    }

    @Override
    public Boolean EsCorrecta(){
        return true;
    }

    @Override
    public int TieneOrdenCorrecto(Respuesta unaRespuesta){
        return unOrden.TieneOrdenCorrecto(unaRespuesta);
    }

    @Override
    public String getEnunciado(){
        return enunciado;
    }

    @Override
    public String getOrdenParcial(){
        return unOrden.getOrdenParcial();
    }
}
