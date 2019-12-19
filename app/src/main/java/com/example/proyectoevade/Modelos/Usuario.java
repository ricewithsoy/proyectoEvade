package com.example.proyectoevade.Modelos;

public class Usuario {
    public static Usuario[] usuario;
    private Integer id;
    private String nombre;
    private String correo;
    private String psw;
    private int Id;
    private boolean estado; //true si está pendiente - false si está comprado
    private static final boolean ACTIVO=true;

    //Constructor


    public Usuario(int Id, String nombre, String correo, String psw, boolean estado) {
        this.Id = Id;
        this.nombre = nombre;
        this.correo = correo;
        this.psw = psw;
        this.estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) { this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {

        String desactivado;
        if(estado) desactivado="eliminar";
        else desactivado="desactivado";
        return nombre + ": " + desactivado;
    }}



