/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import modelo.Actor;

/**
 *
 * @author David
 */
public class Personaje implements Serializable {

    private int codigoPersonaje;
    private String nombrePersonaje;
    private int edadPersonaje;
    private String rol;
    private String calificacion;
    private String descripcionPersonaje;
    private Actor actor;

    public Personaje(int codigoPersonaje, String nombrePersonaje, int edadPersonaje, String rol, String calificacion, String descripcionPersonaje, Actor actor) {
        this.codigoPersonaje = codigoPersonaje;
        this.nombrePersonaje = nombrePersonaje;
        this.edadPersonaje = edadPersonaje;
        this.rol = rol;
        this.calificacion = calificacion;
        this.descripcionPersonaje = descripcionPersonaje;
        this.actor = actor;
    }

    public int getCodigoPersonaje() {
        return codigoPersonaje;
    }

    public void setCodigoPersonaje(int codigoPersonaje) {
        this.codigoPersonaje = codigoPersonaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public int getEdadPersonaje() {
        return edadPersonaje;
    }

    public void setEdadPersonaje(int edadPersonaje) {
        this.edadPersonaje = edadPersonaje;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcionPersonaje() {
        return descripcionPersonaje;
    }

    public void setDescripcionPersonaje(String descripcionPersonaje) {
        this.descripcionPersonaje = descripcionPersonaje;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Personaje{" + "codigoPersonaje=" + codigoPersonaje + 
                ", nombrePersonaje=" + nombrePersonaje + ", edadPersonaje="
                + edadPersonaje + ", rol=" + rol + ", calificacion=" 
                + calificacion + ", descripcionPersonaje=" 
                + descripcionPersonaje + ", actor=" + actor + '}';
    }


}
