/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deber_03_07.Servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Deber_03_07.Modelo.Actor;
import Deber_03_07.Modelo.Pelicula;

/**
 *
 * @author Mauricio Ortiz
 */
public class ActorServiceImpl implements ActorService {

    public static List<Actor> actorList = new ArrayList<>();

    public ActorServiceImpl() {

    }

    @Override
    public void crear(Actor actor) {
        this.actorList.add(actor);
        this.almacenarArchivo(actor, "C:/Netbeans1/actor.dat");
    }

    @Override
    public List<Actor> Listar() {
        return this.actorList;
    }

    @Override
    public void modificar(Actor actor, int codigo) {
        var indice = -1;
        for (var actores : this.actorList) {
            indice++;
            if (codigo == actores.getCodigoActor()) {
                this.actorList.set(indice, actor);

            }

        }
        this.ReGrabar();

    }

    @Override
    public void eliminar(int codigo) {
        var indice = -1;
        for (var actores : this.actorList) {
            indice++;
            if (codigo == actores.getCodigoActor()) {
                this.actorList.remove(indice);

            }
            this.ReGrabar();
        }

    }

    @Override
    public List<Actor> recuperarArchivo(String ruta) {
        List<Actor> actorList = new ArrayList<Actor>();

        ObjectInputStream entrada = null;
        try {
            var fis = new FileInputStream(new File(ruta));
            while (fis.available() > 0) {
                entrada = new ObjectInputStream(fis);
                Actor actor = (Actor) entrada.readObject();
                actorList.add(actor);

            }
            entrada.close();

        } catch (Exception ex) {
            try {
                entrada.close();
            } catch (IOException ex1) {
                Logger.getLogger(ActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return actorList;

    }

    @Override
    public void almacenarArchivo(Actor actor, String ruta) {
        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream(ruta, true));
            salida.writeObject(actor);
            salida.close();

        } catch (Exception ex) {

            Logger.getLogger(ActorServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> carreralist) {
        ActorServiceImpl.actorList = carreralist;
    }

    @Override
    public Actor ActorCodigo(int codigo) {
        Actor retorno = null;
        for (var actores : this.actorList) {
            if (codigo == actores.getCodigoActor()) {
                retorno = actores;
                break;

            }
        }
        return retorno;
    }

    public void ReGrabar() {
        var Borrarfile = new File("C:/Netbeans1/actor.dat");
        Borrarfile.delete();

        for (var i = 0; i < actorList.size(); i++) {
            this.almacenarArchivo(actorList.get(i), "C:/Netbeans1/actor.dat");

        }

    }
}
