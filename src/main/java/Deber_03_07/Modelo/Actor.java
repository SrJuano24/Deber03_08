/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deber_03_07.Modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Mauricio Ortiz
 */
public class Actor implements Serializable {

    private int codigoActor;
    private String nombreActor;
    private String lugarNacimiento;
    private int edad;
    private String genero;
    private String nominaciones;
    private int numeroNominaciones;
    private Pelicula pelicula;

    public Actor(int codigoActor, String nombreActor, String lugarNacimiento, int edad, String genero, String nominaciones, int numeroNominaciones, Pelicula pelicula) {
        this.codigoActor = codigoActor;
        this.nombreActor = nombreActor;
        this.lugarNacimiento = lugarNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.nominaciones = nominaciones;
        this.numeroNominaciones = numeroNominaciones;
        this.pelicula = pelicula;
    }

    public String clasificacionNominacion() {
        var retorno = "Desconocido";
        if (numeroNominaciones < 2) {
            retorno = "Se considera un buen actor";
        } else {
            if (numeroNominaciones < 5) {
                retorno = "Se considera un muy buen actor";
            } else {
                retorno = "Se considera un excelente actor";
            }

        }
        return retorno;
    }

    public int getCodigoActor() {
        return codigoActor;
    }

    public void setCodigoActor(int codigoActor) {
        this.codigoActor = codigoActor;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNominaciones() {
        return nominaciones;
    }

    public void setNominaciones(String nominaciones) {
        this.nominaciones = nominaciones;
    }

    public int getNumeroNominaciones() {
        return numeroNominaciones;
    }

    public void setNumeroNominaciones(int numeroNominaciones) {
        this.numeroNominaciones = numeroNominaciones;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Actor{" + "codigoActor=" + codigoActor + ", nombreActor="
                + nombreActor + ", lugarNacimiento=" + lugarNacimiento
                + ", edad=" + edad + ", genero=" + genero + ", nominaciones="
                + nominaciones + ", numeroNominaciones=" + numeroNominaciones
                + " basado en esto el actor : "
                + this.clasificacionNominacion() + '}';
    }
}
