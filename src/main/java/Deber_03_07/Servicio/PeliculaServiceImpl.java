/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deber_03_07.Servicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import Deber_03_07.Modelo.Pelicula;
import static Deber_03_07.Servicio.ActorServiceImpl.actorList;
import java.io.File;

/**
 *
 * @author Mauricio Ortiz
 */
public class PeliculaServiceImpl implements PeliculaService {

    private static List<Pelicula> peliculaList = new ArrayList<>();

    @Override
    public void crear(Pelicula pelicula) {

        this.peliculaList.add(pelicula);
        this.almacenarArchivo(pelicula, "C:/Netbeans1/pelicula.dat");
    }

    @Override
    public List<Pelicula> listar() {
        return this.peliculaList;
    }

    @Override
    public void modificar(Pelicula pelicula, int codigo) {

        var indice = -1;
        for (var peliculas : this.peliculaList) {
            indice++;
            if (codigo == peliculas.getCodigoPelicula()) {
                this.peliculaList.set(indice, pelicula);

            }

        }
        this.ReGrabar();
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var peliculas : this.peliculaList) {
            indice++;
            if (codigo == peliculas.getCodigoPelicula()) {
                this.peliculaList.remove(indice);
            }
            this.ReGrabar();
        }
        
    }

    @Override
    public List<Pelicula> recuperarArchivo(String ruta) {
        var peliculalist = new ArrayList<Pelicula>();
        DataInputStream entrada = null;
        try {
            entrada = new DataInputStream(new FileInputStream(ruta));
            while (true) {

                var codigo = entrada.readInt();
                var nombre = entrada.readUTF();
                var genero = entrada.readUTF();
                var year = entrada.readInt();
                var idioma = entrada.readUTF();
                var clasificacion = entrada.readUTF();
                var duracion = entrada.readInt();
                var rese??a = entrada.readUTF();

                var pelicula = new Pelicula(codigo, nombre, genero, year, idioma, clasificacion, duracion, rese??a);
                peliculalist.add(pelicula);
            }
        } catch (IOException e) {
            try {
                entrada.close();
            } catch (IOException ex) {
                Logger.getLogger(PeliculaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return peliculalist;

    }

    @Override
    public void almacenarArchivo(Pelicula pelicula, String ruta) {
        DataOutputStream salida = null;

        try {
            salida = new DataOutputStream(new FileOutputStream(ruta, true));
            salida.writeInt(pelicula.getCodigoPelicula());
            salida.writeUTF(pelicula.getNombrePelicula());
            salida.writeUTF(pelicula.getGenero());
            salida.writeInt(pelicula.getYearLanzamiento());
            salida.writeUTF(pelicula.getIdioma());
            salida.writeUTF(pelicula.getClasificacion());
            salida.writeInt(pelicula.getDuracion());
            salida.writeUTF(pelicula.getRese??a());

        } catch (IOException ex) {
            Logger.getLogger(PeliculaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setUniversidadList(List<Pelicula> peliculaList) {
        PeliculaServiceImpl.peliculaList = peliculaList;
    }

    @Override
    public Pelicula PeliculaCodigo(int codigo) {
        Pelicula retorno = null;
        for (var pelicula : this.peliculaList) {
            if (codigo == pelicula.getCodigoPelicula()) {
                retorno = pelicula;
                break;

            }
        }
        return retorno;
    }

    public void ReGrabar() {
        var Borrarfile = new File("C:/Netbeans1/pelicula.dat");
        Borrarfile.delete();

       
    }
}
