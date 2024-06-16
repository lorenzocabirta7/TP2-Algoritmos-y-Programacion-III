package edu.fiuba.algo3.modelo.Anulador;


import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public class AnuladorDePuntajeActivado implements AnuladorDePuntaje{
    @Override
    public int modificarPuntaje(int unPuntaje) {return 0;}

    @Override
    public void anulaPregunta(Pregunta pregunta) {pregunta.anulate();}

    @Override
    public boolean estaActivo() {return true;}

}