/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paseoperros.controlador;

import co.edu.umanizales.listase.modelo.ListaSE;
import co.edu.umanizales.listase.modelo.Nodo;
import co.edu.umanizales.listase.modelo.Perro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Camilo
 */
@Named(value = "listaSEController")
@SessionScoped
public class ListaSEController implements Serializable
{

    private ListaSE listaPerros;
    private Perro perroMostrar;
    private Nodo temp;
    private byte numero;
     

    /**
     * Creates a new instance of ListaSEController
     */
    public ListaSEController()
    {
    }

    @PostConstruct
    private void iniciar()
    {
        listaPerros = new ListaSE();
        // Conectaría a un archivo plano o a una base de datos para llenar la lista de perros
        listaPerros.adicionarNodo(new Perro("Pastor", (byte) 1, (byte) 3,"macho"));
        listaPerros.adicionarNodo(new Perro("Lulú", (byte) 2, (byte) 4,"hembra"));
        listaPerros.adicionarNodo(new Perro("Firulais", (byte) 3, (byte) 6,"macho"));

        listaPerros.adicionarNodoInicio(new Perro("Rocky", (byte) 4, (byte) 5,"macho"));
        perroMostrar = listaPerros.getCabeza().getDato();
        temp = listaPerros.getCabeza();
    }

    public Nodo getTemp()
    {
        return temp;
    }

    public void setTemp(Nodo temp)
    {
        this.temp = temp;
    }

    public Perro getPerroMostrar()
    {
        return perroMostrar;
    }

    public void setPerroMostrar(Perro perroMostrar)
    {
        this.perroMostrar = perroMostrar;
    }

    public ListaSE getListaPerros()
    {
        return listaPerros;
    }

    public void setListaPerros(ListaSE listaPerros)
    {
        this.listaPerros = listaPerros;
    }

    public byte getNumero()
    {
        return numero;
    }

    public void setNumero(byte numero)
    {
        this.numero = numero;
    }


    public void irSiguiente()
    {
        //if(temp.getSiguiente()!=null)
        //{
        temp = temp.getSiguiente();
        perroMostrar = temp.getDato();
        //}
    }

    public void irPrimero()
    {
        temp = listaPerros.getCabeza();
        perroMostrar = temp.getDato();
    }

    public void irUltimo()
    {

        temp = listaPerros.getCabeza();
        while (temp.getSiguiente() != null)
        {
            temp = temp.getSiguiente();
        }
        /// Parado en el último nodo
        perroMostrar = temp.getDato();
    }

    public void invertir()
    {
        listaPerros.invertir();
        irPrimero();
    }

    public void intercambiar()
    {
        listaPerros.intercambiarExtremos();
        irPrimero();
    }

    public void eliminar(byte numero)
    {
        listaPerros.eliminarNodo(numero);
        irPrimero();
    }

    public Nodo encontrarPerro()
    {
       
        Nodo encontrado = listaPerros.encontrarPosicion((byte) numero);
        perroMostrar = encontrado.getDato();
        return encontrado;

    }

    public void flitroGenero(String genero){
        listaPerros.filtrarGenero(genero);
        irPrimero();
    }
}
