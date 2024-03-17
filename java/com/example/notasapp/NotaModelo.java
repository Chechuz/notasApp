package com.example.notasapp;

public class NotaModelo {
    int id;
    String titulo, detalle, fecha, hora;

    NotaModelo(){

    }

    public NotaModelo(String titulo, String detalle, String fecha, String hora) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
        this.hora = hora;
    }
    public NotaModelo(int id, String titulo, String detalle, String fecha, String hora) {
        this.id = id;
        this.titulo = titulo;
        this.detalle = detalle;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
