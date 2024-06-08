package main;
public interface AnuladorDePuntaje {
    public int modificarPuntaje(int unPuntaje);
    public void anulaPregunta(Pregunta pregunta);
    public boolean estaActivo();
}
