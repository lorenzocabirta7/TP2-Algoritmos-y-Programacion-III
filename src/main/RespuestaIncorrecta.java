package main;

public class RespuestaIncorrecta implements Respuesta{
    private String enunciadoRespuesta;
    private TipoDeRespuesta tipoDePenalidad;

    public RespuestaIncorrecta(String respuesta, TipoDeRespuesta tipoDePenalidad){
        this.enunciadoRespuesta = respuesta;
        this.tipoDePenalidad = tipoDePenalidad;
    }

    @Override
    public int actualizarPuntaje(int puntaje) {
        return tipoDePenalidad.actualizarPuntaje(puntaje);
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
