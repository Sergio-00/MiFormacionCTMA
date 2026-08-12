package com.example.miformacionctma.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.miformacionctma.model.ActividadFormativa
import com.example.miformacionctma.model.Prioridad

@Composable
fun TarjetaActividad(
    actividad: ActividadFormativa,
    onClick: () -> Unit = {}
) {
    val progresoSeguro = actividad.progreso.coerceIn(0, 100)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = actividad.titulo,
                style = MaterialTheme.typography.titleMedium
            )

            actividad.descripcion?.let { descripcion ->
                Text(
                    text = descripcion,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = "Progreso: $progresoSeguro%",
                style = MaterialTheme.typography.bodyMedium
            )

            LinearProgressIndicator(
                progress = progresoSeguro / 100f,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Prioridad: ${textoPrioridad(actividad.prioridad)}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "${actividad.diasRestantes} días restantes",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

private fun textoPrioridad(prioridad: Prioridad): String {
    return when (prioridad) {
        Prioridad.BAJA -> "Baja"
        Prioridad.MEDIA -> "Media"
        Prioridad.ALTA -> "Alta"
    }
}