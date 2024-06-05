package main;

import java.util.ArrayList;

public interface Respuesta {

    public int actualizarPuntaje(int puntaje);

    public String getEnunciadoRespuesta();

    public Boolean EsCorrecta();
}