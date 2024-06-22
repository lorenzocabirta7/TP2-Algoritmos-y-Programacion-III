package edu.fiuba.algo3.modelo.DTO;

import com.google.gson.annotations.SerializedName;

public class PreguntaDTO {

    @SerializedName("ID")
    public int id;

    @SerializedName("Tema")
    public String tema;

    @SerializedName("Tipo")
    public String tipo;

    @SerializedName("Pregunta")
    public String pregunta;

    @SerializedName("Respuesta")
    public String respuesta;

    @SerializedName("Opcion 1")
    public String opcion1;

    @SerializedName("Opcion 2")
    public String opcion2;

    @SerializedName("Opcion 3")
    public String opcion3;

    @SerializedName("Opcion 4")
    public String opcion4;

    @SerializedName("Opcion 5")
    public String opcion5;

    @SerializedName("Opcion 6")
    public String opcion6;

    @SerializedName("Texto respuesta")
    public String textoRespuesta;

    @SerializedName("Grupo A")
    public String grupoA;

    @SerializedName("Grupo B")
    public String grupoB;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(String opcion5) {
        this.opcion5 = opcion5;
    }

    public String getOpcion6() {
        return opcion6;
    }

    public void setOpcion6(String opcion6) {
        this.opcion6 = opcion6;
    }


    public String getGrupoA() {
        return grupoA;
    }

    public void setGrupoA(String grupoA) {
        this.opcion6 = grupoA;
    }

    public String getGrupoB() {
        return grupoB;
    }

    public void setGrupoB(String grupoB) {
        this.grupoB = grupoB;
    }

    @Override
    public String toString() {
        return "QuestionItem{" +
                "id=" + id +
                ", tema='" + tema + '\'' +
                ", tipo='" + tipo + '\'' +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", opcion1='" + opcion1 + '\'' +
                ", opcion2='" + opcion2 + '\'' +
                ", opcion3='" + opcion3 + '\'' +
                ", opcion4='" + opcion4 + '\'' +
                ", opcion5='" + opcion5 + '\'' +
                ", GrupoA='" + grupoA + '\'' +
                ", GrupoB='" + grupoB + '\'' +
                ", textoRespuesta='" + textoRespuesta + '\'' +
                '}';
    }
}
