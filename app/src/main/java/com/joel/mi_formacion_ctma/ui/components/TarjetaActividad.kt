package com.joel.mi_formacion_ctma.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.mi_formacion_ctma.model.ActividadFormativa
import com.joel.mi_formacion_ctma.model.DatosEjemplo
import com.joel.mi_formacion_ctma.model.Prioridad

@Composable
fun TarjetaActividad(
    actividad: ActividadFormativa,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val progresoNormalizado = (actividad.progreso / 100f).coerceIn(0f, 1f)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .semantics {
                contentDescription = "Actividad: ${actividad.titulo}, progreso ${actividad.progreso} por ciento, prioridad ${actividad.prioridad.name}"
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = actividad.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Chip de Prioridad
                val chipColor = when (actividad.prioridad) {
                    Prioridad.ALTA -> MaterialTheme.colorScheme.error
                    Prioridad.MEDIA -> MaterialTheme.colorScheme.tertiary
                    Prioridad.BAJA -> MaterialTheme.colorScheme.secondary
                }

                SuggestionChip(
                    onClick = { },
                    label = {
                        Text(
                            text = actividad.prioridad.name,
                            style = MaterialTheme.typography.labelSmall,
                            color = chipColor
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = actividad.descripcion ?: "",
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Indicador de Progreso
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LinearProgressIndicator(
                    progress = { progresoNormalizado },
                    modifier = Modifier
                        .weight(1f)
                        .height(8.dp),
                    color = if (actividad.progreso == 100) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "${actividad.progreso}%",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Días restantes: ${actividad.diasRestantes}",
                style = MaterialTheme.typography.labelSmall,
                color = if (actividad.diasRestantes <= 2) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaActividadPreview() {
    MaterialTheme {
        TarjetaActividad(
            actividad = DatosEjemplo.listaActividades.first(),
            modifier = Modifier.padding(16.dp)
        )
    }
}