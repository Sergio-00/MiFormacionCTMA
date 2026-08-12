package com.joel.mi_formacion_ctma

import com.joel.mi_formacion_ctma.domain.ReglasActividad
import com.joel.mi_formacion_ctma.model.ActividadFormativa
import com.joel.mi_formacion_ctma.model.Prioridad
import org.junit.Assert.assertEquals
import org.junit.Test

class ReglasActividadTest {

    private val actividadesPrueba = listOf(
        ActividadFormativa(1, "Actividad A", "Desc", 40, 5, Prioridad.MEDIA),
        ActividadFormativa(2, "Actividad B", "Desc", 90, 2, Prioridad.BAJA),
        ActividadFormativa(3, "Actividad C", "Desc", 100, -1, Prioridad.ALTA)
    )

    @Test
    fun calcularPromedioProgreso_esCorrecto() {
        val promedio = ReglasActividad.promedioProgreso(actividadesPrueba)
        assertEquals(76.66, promedio, 0.1)
    }

    @Test
    fun actividadesUrgentes_filtraCorrectamente() {
        val urgentes = ReglasActividad.actividadesUrgentes(actividadesPrueba)
        assertEquals(1, urgentes.size)
        assertEquals(2, urgentes.first().id)
    }
}