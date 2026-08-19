package com.example.miformacionctma.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EstadoActividad(progreso: Int) {
    val texto = when {
        progreso >= 100 -> "Completada"
        progreso > 0 -> "En proceso"
        else -> "Pendiente"
    }

    Text(
        text = texto,
        style = MaterialTheme.typography.bodySmall
    )
}