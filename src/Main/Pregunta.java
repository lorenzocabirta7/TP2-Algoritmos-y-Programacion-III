package Main;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public interface Pregunta {
   ArrayList<Respuesta> obtenerRespuestaCorrecta();
}

