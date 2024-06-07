package main;

import java.util.ArrayList;

public interface Respuesta {

    public int actualizarPuntaje(int puntaje);

    public Boolean EsCorrecta();

    public int TieneOrdenCorrecto(Respuesta respuestaPosible);

    public String getEnunciado();

    public String getOrdenParcial();
}