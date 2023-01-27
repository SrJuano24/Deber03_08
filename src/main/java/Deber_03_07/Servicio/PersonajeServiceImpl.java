/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deber_03_07.Servicio;

import Deber_03_07.Modelo.Personaje;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Deber_03_07.Servicio.PersonajeServiceImpl.personajeList;

/**
 *
 * @author David
 */
public class PersonajeServiceImpl implements PersonajeService {

    public static List<Personaje> personajeList = new ArrayList<>();

    public PersonajeServiceImpl() {
    }

    @Override
    public void crear(Personaje personaje) {
        this.personajeList.add(personaje);
         this.almacenarArchivo(personaje, "C:/Netbeans1/personaje.dat");
        
        
    }

    @Override
    public List<Personaje> listar() {
        return this.personajeList;
    }

    @Override
    public void modificar(Personaje personaje, int codigo) {
        var indice = -1;
        for (var personajes : this.personajeList) {
            indice++;
            if (codigo == personajes.getCodigoPersonaje()) {
                this.personajeList.set(indice, personaje);

            }

        }
    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var personaje : this.personajeList) {
            indice++;
            if (codigo == personaje.getCodigoPersonaje()) {
                this.personajeList.remove(indice);

            }

        }
    }

    @Override
    public List<Personaje> recuperarArchivo(String ruta) {
        List<Personaje> personajeList= new ArrayList<Personaje>();
        
        
        ObjectInputStream entrada =null;
        try{
            var fis=new FileInputStream(new File(ruta));
            while(fis.available()>0){
            entrada = new ObjectInputStream(fis);
            Personaje personaje = (Personaje) entrada.readObject();
            personajeList.add(personaje);
            
            
            }
            entrada.close();
 
        }catch(Exception ex){
            try {
                entrada.close();
            } catch (IOException ex1) {
                Logger.getLogger(PersonajeServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    return  personajeList;
    }

    @Override
    public void almacenarArchivo(Personaje personaje, String ruta) {
        ObjectOutputStream salida=null;
        
        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta, true));
            salida.writeObject(personaje);
            salida.close();
        
        } catch (Exception ex) {
            
            Logger.getLogger(PersonajeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setPersonajeList(List<Personaje> personajeList) {
        PersonajeServiceImpl.personajeList = personajeList;
    }

    public static List<Personaje> getPersonajeList() {
        return personajeList;
    }

}
