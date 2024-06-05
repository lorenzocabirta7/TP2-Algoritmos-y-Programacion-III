package main;

import java.util.ArrayList;

public class RespuestaIncorrectaVerdaderoFalsoClasico implements Respuesta{
    private String enunciadoRespuesta;

        public RespuestaIncorrectaVerdaderoFalsoClasico(String respuesta){
            enunciadoRespuesta = respuesta;
        }

    @Override
    public int actualizarPuntaje(int puntaje) {
            return 0;
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
