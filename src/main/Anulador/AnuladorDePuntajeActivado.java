package main.Anulador;

import main.Pregunta;

public class AnuladorDePuntajeActivado implements AnuladorDePuntaje{
    @Override
    public int modificarPuntaje(int unPuntaje) {return 0;}

    @Override
    public void anulaPregunta(Pregunta pregunta) {pregunta.anulate();}

    @Override
    public boolean estaActivo() {return true;}

}
