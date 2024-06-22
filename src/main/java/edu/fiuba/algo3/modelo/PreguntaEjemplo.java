package edu.fiuba.algo3.modelo;


import com.google.gson.annotations.SerializedName;

public class PreguntaEjemplo {
        private int ID;
        private String Tema;
        private String TipoPregunta;
        private String Pregunta;
        private String respuesta;
        private String opcion1;
        private String opcion2;
        private String opcion3;
        private String opcion4;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getTema() {
        return Tema;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.TipoPregunta= tipoPregunta;
    }

    public void setPregunta(String pregunta) {
        this.Pregunta = pregunta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public void setOpcion1(String opcion) {
        this.opcion1 = opcion;
    }

    public void setOpcion2(String opcion) {
        this.opcion2 = opcion;
    }
    public void setOpcion3(String opcion) {
        this.opcion3 = opcion;
    }
    public void setOpcion4(String opcion) {
        this.opcion4 = opcion;
    }

}
