package main;

public class RespuestaIncorrectaVerdaderoFalsoClasico implements RespuestasDeVerdaderoFalsoClasico{
        private final String contenido;
        private Jugador jugadorQueEligeRespuesta;
        private Boolean veracidad;

        public RespuestaIncorrectaVerdaderoFalsoClasico(String unContenido, Boolean unaVeracidad){
            this.contenido = unContenido;
            this.veracidad = unaVeracidad;
        }


    public Boolean esCorrecta() {
        return false;
    }

    @Override
    public void actualizarPuntaje(int puntaje) {
            //no hacer nada. Preguntar si esto esta bien, o sacamos de la interfaz el contrato del metodo.
    }

    @Override
    public void setJugador(Jugador unJugador){
            this.jugadorQueEligeRespuesta = unJugador;
    }
}
