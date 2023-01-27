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
public class Pelicula implements Serializable {

    private int codigoPelicula;
    private String nombrePelicula;
    private String Genero;
    private int yearLanzamiento;
    private String idioma;
    private String clasificacion;
    private int duracion;
    private String reseña;

    public Pelicula(int codigoPelicula, String nombrePelicula, String Genero, int yearLanzamiento, String idioma, String clasificacion, int duracion, String reseña) {
        this.codigoPelicula = codigoPelicula;
        this.nombrePelicula = nombrePelicula;
        this.Genero = Genero;
        this.yearLanzamiento = yearLanzamiento;
        this.idioma = idioma;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.reseña = reseña;
    }

    public String getClasificacionEdad() {
        var retorno = "Desconocido";
        switch (clasificacion) {
            case "A":
                retorno = "es para todo tipo de publico";
                break;
            case "B":
                retorno = "es para niños con compañia de adultos";
                break;
            case "C":
                retorno = "es para mayores de edad";
                break;
            default:
                throw new AssertionError();
        }
        return retorno;
    }

    public int getCodigoPelicula() {
        return codigoPelicula;
    }

    public void setCodigoPelicula(int codigoPelicula) {
        this.codigoPelicula = codigoPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getYearLanzamiento() {
        return yearLanzamiento;
    }

    public void setYearLanzamiento(int yearLanzamiento) {
        this.yearLanzamiento = yearLanzamiento;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getReseña() {
        return reseña;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "codigoPelicula=" + codigoPelicula
                + ", nombrePelicula=" + nombrePelicula + ", Genero="
                + Genero + ", yearLanzamiento=" + yearLanzamiento
                + ", idioma=" + idioma + ", clasificacion="
                + clasificacion + ", esta clasificacion: "
                + this.getClasificacionEdad()
                + ", duracion=" + duracion + " horas "
                + ", rese\u00f1a=" + reseña + '}';
    }

}
