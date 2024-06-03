package main;

import java.util.ArrayList;

public class RespuestaChoiceStrategy extends formasDeResponder {

    public RespuestaChoiceStrategy(FormaRespuesta unaFormaDeResponder)
    {
        super(unaFormaDeResponder);
    }
    public ArrayList<Respuesta> responder(Pregunta pregunta)
    {
        return super.responder(pregunta);
    }
}
