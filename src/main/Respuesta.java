package main;

import java.util.ArrayList;

public interface Respuesta {

    public int actualizarPuntaje(int puntaje,Respuesta unaRespuesta);

    public Boolean EsCorrecta();

    public String getEnunciado();

    public String getOrdenParcial();
}