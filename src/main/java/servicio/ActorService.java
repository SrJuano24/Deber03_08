/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Actor;
import modelo.Pelicula;

/**
 *
 * @author Mauricio Ortiz
 */
public interface ActorService {

    public void crear(Actor actor);

    public void modificar(Actor actor, int codigo);

    public void eliminar(int codigo);

    public List<Actor> Listar();

    public Actor ActorCodigo(int codigo);
    
      public List<Actor> recuperarArchivo(String ruta);

    public void almacenarArchivo(Actor actor, String ruta);
    

}
