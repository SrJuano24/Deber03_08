/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

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
import modelo.Pelicula;

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
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var peliculas : this.peliculaList) {
            indice++;
            if (codigo == peliculas.getCodigoPelicula()) {
                this.peliculaList.remove(indice);

            }

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
                var reseña = entrada.readUTF();

                var pelicula = new Pelicula(codigo, nombre, genero, year, idioma, clasificacion, duracion, reseña);
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
            salida.writeUTF(pelicula.getReseña());

        } catch (IOException ex) {
            Logger.getLogger(PeliculaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setUniversidadList(List<Pelicula> peliculaList) {
        PeliculaServiceImpl.peliculaList = peliculaList;
    }

    public void ModificarArchivo(Pelicula universidad, int indice, String ruta) {
        /*ficheroEntrada =new File("clientes.dat");
ficheroSalida = new File("temporal.dat");
try(FileInputStream flujoEntrada = new FileInputStream(ficheroEntrada);
    FileOutputStream flujoSalida = new FileOutputStream (ficheroSalida))
{
    lector = new ObjectInputStream (flujoEntrada);
    escritor = new ObjectOutputStream(flujoSalida); 
    Cliente cliente;
    while(true)
    { 
        cliente = (Cliente)lector.readObject();
        if(!borrarNif.equals(cliente.dni))
        {
            escritor.writeObject(cliente);
        }   
    }
}
catch (FileNotFoundException fnfe)
{
    System.out.println("Fichero no encontrado");
}
catch (IOException ioe)
{
    //ioe.printStackTrace();
}
ficheroEntrada.delete();
ficheroSalida.renameTo(ficheroEntrada);*/

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
}
