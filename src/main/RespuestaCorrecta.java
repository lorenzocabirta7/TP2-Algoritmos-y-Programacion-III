package main;

public class RespuestaCorrecta implements Respuesta{
    private String enunciado;
    private TipoDeOrden unOrden;

    public RespuestaCorrecta(String enunciadoRespuesta, TipoDeOrden unOrden){
        this.unOrden = unOrden;
        this.enunciado = enunciadoRespuesta;
    }

    @Override
    public int actualizarPuntaje(int puntaje, Respuesta unaRespuesta) {
        return unOrden.actualizarPuntaje(puntaje, unaRespuesta);
    }

    @Override
    public Boolean EsCorrecta(){
        return true;
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
