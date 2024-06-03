package main;

import java.util.ArrayList;

public class formasDeResponder {
    FormaRespuesta formaDeResponder;

    public formasDeResponder(FormaRespuesta unaFormaDeResponder)
    {
        this.formaDeResponder = unaFormaDeResponder;
    }
    public ArrayList<Respuesta> responder(Pregunta pregunta)
    {
        ArrayList<Respuesta> respuestas = formaDeResponder.responder(pregunta);
        return respuestas;
    }
}
