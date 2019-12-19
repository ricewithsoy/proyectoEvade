package com.example.proyectoevade.Modelos;

import java.util.ArrayList;

public class ListaDeUsuarios {

    private static ListaDeUsuarios instancia=new ListaDeUsuarios();
    private ArrayList<Usuario> ListaDeUsuarios;

    private ListaDeUsuarios() {
        ListaDeUsuarios=new ArrayList<>();

    }
    public static ListaDeUsuarios getInstancia() {return instancia; }
    public void agregarUsuario(Usuario usuario)
    {
        ListaDeUsuarios.add(usuario);
    }
    public Usuario getUsuario(int id)
    {
        return ListaDeUsuarios.get(id);
    }
    public ArrayList<Usuario> getListaDeUsuarios()
    {
        return ListaDeUsuarios;
    }
    public void eliminarInactivos()

    {
        for(int i=0; i<getListaDeUsuarios().size(); i++)
        {
            if(getListaDeUsuarios().get(i).isEstado()==false)
            {
                getListaDeUsuarios().remove(i);
                i--;
            }
        }
    }
}
