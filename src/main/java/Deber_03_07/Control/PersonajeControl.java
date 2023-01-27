/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deber_03_07.Control;

import java.time.LocalDate;
import java.util.List;

import Deber_03_07.Modelo.Personaje;
import Deber_03_07.Servicio.ActorServiceImpl;
import Deber_03_07.Servicio.PersonajeServiceImpl;

/**
 *
 * @author David
 */
public class PersonajeControl {

    private static PersonajeServiceImpl personajeServiceImpl = new PersonajeServiceImpl();
    private static ActorServiceImpl actorServiceImpl = new ActorServiceImpl();

    public PersonajeControl() {
        this.personajeServiceImpl = new PersonajeServiceImpl();
    }

    public void crear(String[] data) {
        try {
            var retorno = "No se puede crear la Asignatura:";

            var codigoPersonaje = Integer.valueOf(data[0]).intValue();;
            var nombrePersonaje = data[1];
            var edadPersonaje = Integer.valueOf(data[2]).intValue();
            var rol = data[3];
            var calificacion = data[4];
            var descripcionPersonaje = data[5];

            var actor = this.actorServiceImpl.ActorCodigo(Integer.valueOf(data[6]));

            if (actor == null) {
                throw new NumberFormatException(" No existe carrera ");
            }

            if (edadPersonaje < 0) {
                retorno += " El numero de Horas no son validos ";
            } else {
                if (actor == null) {
                    retorno += " Universidad fuera del registro ";
                } else {
                    var personaje = new Personaje(codigoPersonaje, nombrePersonaje, edadPersonaje, rol, calificacion, descripcionPersonaje, actor);
                    if (this.codigoActual(codigoPersonaje)) {
                        throw new RuntimeException(" Codigo Existente ");
                    } else {
                        this.personajeServiceImpl.crear(personaje);
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
        for (var personaje : this.personajeServiceImpl.listar()) {
            if (personaje.getCodigoPersonaje() == codigo) {
                retorno = true;

            }
        }

        return retorno;
    }

    public void modificar(String[] data) {
        try {
            var retorno = "No se puede modificar el personaje:";

            var codigoPersonaje = Integer.valueOf(data[0]).intValue();;
            var nombrePersonaje = data[1];
            var edadPersonaje = Integer.valueOf(data[2]).intValue();
            var rol = data[3];
            var calificacion = data[4];
            var descripcionPersonaje = data[5];
            var actor = this.actorServiceImpl.ActorCodigo(Integer.valueOf(data[6]));
            var actormodificar = Integer.valueOf(data[7]).intValue();

            if (edadPersonaje < 0) {
                retorno += " El numero de Horas no son validos ";

            } else {
                if (actor == null) {
                    retorno += " Universidad fuera del registro ";
                } else {
                    var personaje = new Personaje(codigoPersonaje, nombrePersonaje, edadPersonaje, rol, calificacion, descripcionPersonaje, actor);
                    if (!this.codigoActual(actormodificar)) {
                        throw new RuntimeException(" Codigo No Existente ");

                    } else {
                        this.personajeServiceImpl.modificar(personaje, actormodificar);
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

                this.personajeServiceImpl.eliminar(codigo);
            }
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Codigo no valido");
        }

    }

    public List<Personaje> Listar() {
        return this.personajeServiceImpl.listar();

    }
}
