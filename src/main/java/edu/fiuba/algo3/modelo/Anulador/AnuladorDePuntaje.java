package edu.fiuba.algo3.modelo.Anulador;


import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public interface AnuladorDePuntaje {
    public int modificarPuntaje(int unPuntaje);
    public void anulaPregunta(Pregunta pregunta);
    public boolean estaActivo();
}
