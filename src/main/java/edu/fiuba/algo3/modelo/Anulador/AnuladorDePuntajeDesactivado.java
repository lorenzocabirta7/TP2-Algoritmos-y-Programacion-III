package edu.fiuba.algo3.modelo.Anulador;


import edu.fiuba.algo3.modelo.preguntas.Pregunta;

public class AnuladorDePuntajeDesactivado implements AnuladorDePuntaje {
    @Override
    public int modificarPuntaje(int unPuntaje) {return unPuntaje;}

    //no se si esto es como el caso del pato de goma y el pato normalk
    //en el sentido de que la clase anulador desactivadno
    // No puede anular un puntaje y por eso tiene un metodo
    //vacio
    @Override
    public void anulaPregunta(Pregunta pregunta) {return;}

    @Override
    public boolean estaActivo() {return false;}
}
