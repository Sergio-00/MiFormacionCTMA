package com.joel.mi_formacion_ctma.domain

import com.joel.mi_formacion_ctma.model.ActividadFormativa
import com.joel.mi_formacion_ctma.model.EstadoActividad

object ReglasActividad {
    fun validarActividad(
        actividad: ActividadFormativa
    ): List<String> {

        val errores = mutableListOf<String>()

        if (actividad.titulo.trim().isEmpty()) {
            errores.add("El título está vacío.")
        }

        if (actividad.progreso !in 0..100) {
            errores.add("El progreso debe estar entre 0 y 100.")
        }

        return errores
    }

    fun estadoActividad(
        actividad: ActividadFormativa
    ): EstadoActividad {

        return when {

            actividad.progreso == 100 ->
                EstadoActividad.COMPLETADA

            actividad.diasRestantes < 0 ->
                EstadoActividad.VENCIDA

            actividad.progreso == 0 ->
                EstadoActividad.PENDIENTE

            else ->
                EstadoActividad.EN_PROCESO
        }
    }

    fun actividadesUrgentes(
        lista: List<ActividadFormativa>
    ): List<ActividadFormativa> {

        return lista.filter {

            it.diasRestantes <= 2 &&
                    estadoActividad(it) != EstadoActividad.COMPLETADA

        }
    }

    fun promedioProgreso(
        lista: List<ActividadFormativa>
    ): Double {

        if (lista.isEmpty()) {
            return 0.0
        }

        return lista
            .map { it.progreso }
            .average()
    }

    fun buscarPorTitulo(
        lista: List<ActividadFormativa>,
        texto: String
    ): List<ActividadFormativa> {

        val criterio = texto.trim()

        return lista.filter {

            it.titulo.contains(
                criterio,
                ignoreCase = true
            )

        }
    }

    fun ordenarActividades(
        lista: List<ActividadFormativa>
    ): List<ActividadFormativa> {

        return lista.sortedWith(
            compareBy<ActividadFormativa> {

                estadoActividad(it) != EstadoActividad.VENCIDA

            }.thenByDescending {

                it.prioridad

            }.thenBy {

                it.diasRestantes

            }
        )
    }
}