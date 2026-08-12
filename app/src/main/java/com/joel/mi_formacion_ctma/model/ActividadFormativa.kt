package com.joel.mi_formacion_ctma.model

data class ActividadFormativa(
    val id: Long,
    val titulo: String,
    val descripcion: String?,
    val progreso: Int,
    val diasRestantes: Int,
    val prioridad: Prioridad
)