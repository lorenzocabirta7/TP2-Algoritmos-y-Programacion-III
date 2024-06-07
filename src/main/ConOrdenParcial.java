package main;

public class ConOrdenParcial implements TipoDeOrden{
    private String respuesta;
    private String ordenParcial;

    public ConOrdenParcial(String enunciado, String ordenParcial) {
        this.respuesta = enunciado;
        this.ordenParcial = ordenParcial;
    }

    @Override
    public int actualizarPuntaje(int puntaje, Respuesta unaRespuesta){
        if (this.EsLaMismaRespuesta(unaRespuesta)){
            return puntaje;
        }
        return 0;
    }

    public String getOrdenParcial(){
        return this.ordenParcial;
    }

    public Boolean EsLaMismaRespuesta(Respuesta unaRespuesta){
        return(this.respuesta.equals(unaRespuesta.getEnunciado()) && (this.ordenParcial.equals( unaRespuesta.getOrdenParcial())));
    }
}
