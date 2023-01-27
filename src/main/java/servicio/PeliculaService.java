/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Pelicula;

/**
 *
 * @author Mauricio Ortiz
 */
public interface PeliculaService {

    public Pelicula PeliculaCodigo(int codigo);

    public void crear(Pelicula pelicula);

    public void modificar(Pelicula pelicula, int codigo);

    public void eliminar(int codigo);

    public List<Pelicula> listar();
    
    public List<Pelicula> recuperarArchivo(String ruta);
    
    public void almacenarArchivo(Pelicula pelicula, String ruta);

}
