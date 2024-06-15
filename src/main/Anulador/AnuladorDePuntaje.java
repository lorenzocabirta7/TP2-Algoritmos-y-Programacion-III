package main.Anulador;

import main.preguntas.*;

public interface AnuladorDePuntaje {
    public int modificarPuntaje(int unPuntaje);
    public void anulaPregunta(Pregunta pregunta);
    public boolean estaActivo();
}
