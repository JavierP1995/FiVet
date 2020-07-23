/*
 * MIT License
 *
 * Copyright (c) 2020 Javier Palacios Arce
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package tdd;

import contratos.Contratos;
import contratos.ContratosImpl;
import tdd.model.*;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * ApiRestEndpoint class.
 *
 * @author Javier Palacios Arce.
 */
public class ApiRestEndpoints {

    /**
     * The Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ApiRestEndpoints.class);

    /**
     * The contratos instance.
     */
    private static final Contratos contratos = new ContratosImpl("jdbc:sqlite:fivet.db");

    private ApiRestEndpoints() {
        //nothing
    }

    /**
     * Formateo e insersion de una ficha
     * @param ctx the Javalin {@link Context}
     */
    public static void insertarFicha(Context ctx) {
        //
        log.debug("Guardando una ficha..");
        Integer numero = Integer.parseInt(ctx.queryParam("numero"));
        String nombre = ctx.queryParam("nombre");
        String especie = ctx.queryParam("especie");
        ZonedDateTime fechaNacimiento = ZonedDateTime.parse(ctx.queryParam("fechaNacimiento"));
        String raza = ctx.queryParam("raza");
        Character sexo = ctx.queryParam("sexo").charAt(0);
        String color = ctx.queryParam("color");
        Character tipo = ctx.queryParam("tipo").charAt(0);
        Long idC = Long.parseLong(ctx.queryParam("cuidador"));
        Persona cuidador = contratos.getCuidador(idC);
        //
        Ficha ficha = new Ficha(numero, nombre, especie, fechaNacimiento, raza, sexo, color, tipo, cuidador);
        contratos.registrarPaciente(ficha);
    }

    /**
     * Formateo e insersion de un cuidador
     * @param ctx the Javalin {@link Context}
     */
    public static void insertCuidador( Context ctx) {
        //
        log.debug("Guardando un cuidador..");
        String nombre = ctx.queryParam("nombre");
        String direccion = ctx.queryParam("direccion");
        Integer telefonoFijo = Integer.parseInt(ctx.queryParam("telefonoFijo"));
        Integer telefonoMovil = Integer.parseInt(ctx.queryParam("telefonoMovil"));
        String email = ctx.queryParam("nombre");
        String rut = ctx.queryParam("rut");
        //
        Persona persona = new Persona(nombre,direccion,telefonoFijo,telefonoMovil,email,rut);
        contratos.registrarCuidador(persona);

    }

    /**
     * Buscando una ficha
     * @param ctx the Javalin {@link Context}
     */
    public static void findFichas(Context ctx) {
        //
        log.debug("buscando una ficha..");
        String query = ctx.queryParam("query");
        List<Ficha> fichas = contratos.buscarFicha(query);
        ctx.json(fichas);
    }

    /**
     * Accediendo a la lista de fichas en persistencia
     * @param ctx the Javalin {@link Context}
     */
    public static void getAllFichas(Context ctx) {
        //
        log.debug("Obteniendo las fichas..");
        List<Ficha> fichas = contratos.getAllFichas();
        ctx.json(fichas);
    }

    /**
     * Accediendo a la lista de cuidadores en persistencia
     * @param ctx the Javalin {@link Context}
     */
    public static void getAllCuidadores(Context ctx) {
        //
        log.debug("Obteniendo los cuidadores..");
        List<Persona> personas = contratos.getAllPersonas();
        ctx.json(personas);
    }

    /**
     * Obteniendo el cuidador de una mascota a traves de su abstraccion en la ficha.
     *
     * @param ctx the Javalin {@link Context}
     */
    public static void getPersonaFromFicha(Context ctx) {
        //
        log.debug("El cuidador es..");
        Integer numero = Integer.parseInt(ctx.pathParam("numero"));
        Persona duenio = contratos.getPersonaFromFicha(numero);
        ctx.json(duenio);
    }


}