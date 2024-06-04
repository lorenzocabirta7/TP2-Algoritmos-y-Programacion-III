package main;

import java.util.ArrayList;

public class RespuestaChoiceStrategy extends FormasDeResponder {

    public RespuestaChoiceStrategy(FormaRespuesta unaFormaDeResponder)
    {
        super(unaFormaDeResponder);
    }
    public ArrayList<Respuesta> responder(PreguntaMultipleChoiceClasico pregunta)
    {
        return super.responder(pregunta);
    }
}
