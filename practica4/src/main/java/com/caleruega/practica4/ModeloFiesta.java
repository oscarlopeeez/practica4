package com.caleruega.practica4;

public class ModeloFiesta {
    private String fecha;
    private String evento;

    public ModeloFiesta(String fecha, String evento) {
        this.fecha = fecha;
        this.evento = evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }
}