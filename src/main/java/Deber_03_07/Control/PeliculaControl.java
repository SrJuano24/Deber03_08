/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deber_03_07.Control;

import java.time.LocalDate;
import java.util.List;
import Deber_03_07.Modelo.Pelicula;
import Deber_03_07.Servicio.PeliculaServiceImpl;

/**
 *
 * @author Mauricio Ortiz
 */
public class PeliculaControl {

    private PeliculaServiceImpl peliculaServiceImpl = new PeliculaServiceImpl();

    public void crear(String[] data) throws Exception {
        try {
            var retorno = "No se pudo crear la pelicula:";

            var codigoPelicula = Integer.valueOf(data[0]).intValue();
            var nombrePelicula = data[1];
            var Genero = data[2];
            var yearLanzamiento = Integer.valueOf(data[3]).intValue();
            var idioma = data[4];
            var clasificacion = data[5];
            var duracion = Integer.valueOf(data[6]).intValue();
            var reseña = data[7];

            if (yearLanzamiento < 1980) {
                retorno += " El año no es valido ";

            } else {
                var pelicula = new Pelicula(codigoPelicula, nombrePelicula, Genero, yearLanzamiento, idioma, clasificacion, duracion, reseña);
                if (this.codigoActual(codigoPelicula)) {
                    throw new RuntimeException(" Codigo Existente ");

                } else {
                    this.peliculaServiceImpl.crear(pelicula);
                }

            }

        } catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Codigo Existente");
        }

    }

    public boolean codigoActual(int codigo) {
        var retorno = false;
        for (var pelicula : this.peliculaServiceImpl.listar()) {
            if (pelicula.getCodigoPelicula() == codigo) {
                retorno = true;

            }
        }

        return retorno;
    }

    public List<Pelicula> Listar() {
        return this.peliculaServiceImpl.listar();
    }

    public void modificar(String[] data) {
        try {
            var retorno = "No se puede crear Universidad";

            var codigoPelicula = Integer.valueOf(data[0]).intValue();
            var nombrePelicula = data[1];
            var Genero = data[2];
            var yearLanzamiento = Integer.valueOf(data[3]).intValue();
            var idioma = data[4];
            var clasificacion = data[5];
            var duracion = Integer.valueOf(data[6]).intValue();
            var reseña = data[7];
            var peliculaModificada = Integer.valueOf(data[8]).intValue();

            if (yearLanzamiento < 1980) {
                retorno += " El año no es valido ";

            } else {
                var pelicula = new Pelicula(codigoPelicula, nombrePelicula, Genero, yearLanzamiento, idioma, clasificacion, duracion, reseña);
                if (!this.codigoActual(peliculaModificada)) {
                    throw new RuntimeException(" Codigo No Existente ");
                } else {
                    this.peliculaServiceImpl.modificar(pelicula, peliculaModificada);
                    retorno = "Pelicula modificada Exitosamente ";
                }

            }

        } catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Codigo No Existe");
        }

    }

    public void eliminar(String codigos) {
        var codigo = Integer.valueOf(codigos).intValue();
        try {
            if (!this.codigoActual(codigo)) {
                throw new RuntimeException(" Codigo No Existente ");

            } else {

                this.peliculaServiceImpl.eliminar(codigo);
            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Codigo no valido");
        }
    }
}
