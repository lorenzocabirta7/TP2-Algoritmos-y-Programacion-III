package main;

public class OrdenParcial {
    private String respuesta;
    private String ordenParcial;

    public OrdenParcial(String enunciado, String ordenParcial) {
        this.respuesta = enunciado;
        this.ordenParcial = ordenParcial;
    }

    public int TieneOrdenCorrecto(Respuesta unaRespuesta){
        int valor = 0;
        if (this.EsLaMismaRespuesta(unaRespuesta)){
            valor = 1;
        }
        return valor;
    }

    public String getOrdenParcial(){
        return this.ordenParcial;
    }

    private Boolean EsLaMismaRespuesta(Respuesta unaRespuesta){
        return(this.respuesta.equals(unaRespuesta.getEnunciado()) && (this.ordenParcial.equals( unaRespuesta.getOrdenParcial())));
    }
}
