/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import modelo.Personaje;
import java.util.List;

/**
 *
 * @author David
 */
public interface PersonajeService {

    public void crear(Personaje personaje);

    public void modificar(Personaje personaje, int codigo);

    public void eliminar(int codigo);

    public List<Personaje> listar();
    
    public List<Personaje> recuperarArchivo(String ruta) ;
    
    public void almacenarArchivo(Personaje personaje, String ruta) ;
    
    
    
    
    
}
