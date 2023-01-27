/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deber_03_07.Control;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import Deber_03_07.Servicio.ActorServiceImpl;
import Deber_03_07.Modelo.Actor;
import Deber_03_07.Servicio.PeliculaServiceImpl;

/**
 *
 * @author Mauricio Ortiz
 */
public class ActorControl {

    private ActorServiceImpl actorServiceImpl = new ActorServiceImpl();
    private PeliculaServiceImpl peliculaServiceImpl = new PeliculaServiceImpl();

    public void crear(String[] data) {
        try {
            var retorno = "No se puede crear Universidad:";

            var codigoActor = Integer.valueOf(data[0]).intValue();
            var nombreActor = data[1];
            var lugarNacimiento = data[2];
            var edad = Integer.valueOf(data[3]).intValue();
            var genero = data[4];
            var nominaciones = data[5];
            var numeroNominaciones = Integer.valueOf(data[6]).intValue();
            var pelicula = this.peliculaServiceImpl.PeliculaCodigo(Integer.valueOf(data[7]));

            if (codigoActor < 0) {
                retorno += " El codigo no es valido ";

            } else {
                if (pelicula == null) {
                    retorno += " Pelicula fuera del registro ";
                } else {
                    var actor = new Actor(codigoActor, nombreActor, lugarNacimiento, edad, genero, nominaciones, numeroNominaciones, pelicula);
                    if (this.codigoActual(codigoActor)) {
                        throw new RuntimeException(" Codigo Existente ");

                    } else {
                        this.actorServiceImpl.crear(actor);
                        retorno = "Creado Satisfactoriamente ";
                    }

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
        for (var actor : this.actorServiceImpl.Listar()) {
            if (actor.getCodigoActor() == codigo) {
                retorno = true;

            }
        }

        return retorno;
    }

    public void modificar(String[] data) {
        try {
            var retorno = "No se puede crear el actor:";

            var codigoActor = Integer.valueOf(data[0]).intValue();
            var nombreActor = data[1];
            var lugarNacimiento = data[2];
            var edad = Integer.valueOf(data[3]).intValue();
            var genero = data[4];
            var nominaciones = data[5];
            var numeroNominaciones = Integer.valueOf(data[6]).intValue();
            var pelicula = this.peliculaServiceImpl.PeliculaCodigo(Integer.valueOf(data[7]));
            var actormodificar = Integer.valueOf(data[8]).intValue();

            if (codigoActor < 0) {
                retorno += " El codigo no es valido ";

            } else {
                if (pelicula == null) {
                    retorno += " Pelicula fuera del registro ";
                } else {
                    var actor = new Actor(codigoActor, nombreActor, lugarNacimiento, edad, genero, nominaciones, numeroNominaciones, pelicula);
                    if (!this.codigoActual(actormodificar)) {
                        throw new RuntimeException(" Codigo No Existente ");

                    } else {
                        this.actorServiceImpl.modificar(actor, actormodificar);
                        retorno = "Modificado Satisfactoriamente ";
                    }

                }
            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Error en los parametros");
        } catch (RuntimeException e1) {
            throw new RuntimeException("Codigo No Existente");
        }

    }

    public void eliminar(String codigos) {

        var codigo = Integer.valueOf(codigos).intValue();
        try {
            if (!this.codigoActual(codigo)) {
                throw new RuntimeException(" Codigo No Existente ");

            } else {

                this.actorServiceImpl.eliminar(codigo);
            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Codigo no valido");
        }

    }

    public List<Actor> Listar() {
        return this.actorServiceImpl.Listar();
    }

}
