package com.joel.mi_formacion_ctma.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.mi_formacion_ctma.model.ActividadFormativa
import com.joel.mi_formacion_ctma.model.DatosEjemplo
import com.joel.mi_formacion_ctma.ui.components.DetalleActividadDialog
import com.joel.mi_formacion_ctma.ui.components.EncabezadoFormacion
import com.joel.mi_formacion_ctma.ui.components.SeccionScrum
import com.joel.mi_formacion_ctma.ui.components.TarjetaActividad

@Composable
fun PantallaActividades(
    actividades: List<ActividadFormativa>,
    nombreAprendiz: String,
    modifier: Modifier = Modifier,
    onActividadClick: (ActividadFormativa) -> Unit = {}
) {
    var textoBusqueda by remember { mutableStateOf("") }
    var soloUrgentes by remember { mutableStateOf(false) }
    var actividadSeleccionada by remember { mutableStateOf<ActividadFormativa?>(null) }

    val actividadesFiltradas = actividades.filter { actividad ->
        val coincideTexto = actividad.titulo.contains(textoBusqueda, ignoreCase = true) ||
                (actividad.descripcion?.contains(textoBusqueda, ignoreCase = true) ?: false)
        val coincideUrgencia = if (soloUrgentes) actividad.diasRestantes in 0..3 else true

        coincideTexto && coincideUrgencia
    }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            val total = actividades.size
            val completadas = actividades.count { it.progreso == 100 }
            val resumenTexto = if (total > 0) {
                "Avance: $completadas de $total completadas (${(completadas * 100) / total}%)"
            } else {
                "Sin actividades registradas"
            }

            EncabezadoFormacion(
                nombreAprendiz = nombreAprendiz,
                resumen = resumenTexto
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = textoBusqueda,
                onValueChange = { textoBusqueda = it },
                label = { Text("Buscar actividad...") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                FilterChip(
                    selected = soloUrgentes,
                    onClick = { soloUrgentes = !soloUrgentes },
                    label = { Text("Solo Urgentes (≤ 3 días)") }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (actividadesFiltradas.isEmpty()) {
                EstadoVacio(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            } else {
                BoxWithConstraints(
                    modifier = Modifier.weight(1f)
                ) {
                    val esPantallaAncha = maxWidth >= 600.dp

                    if (esPantallaAncha) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            contentPadding = PaddingValues(bottom = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Muestra la Sección Scrum ocupando ambas columnas
                            item(span = { GridItemSpan(2) }) {
                                SeccionScrum()
                            }

                            items(
                                items = actividadesFiltradas,
                                key = { actividad -> actividad.id }
                            ) { actividad ->
                                TarjetaActividad(
                                    actividad = actividad,
                                    onClick = {
                                        actividadSeleccionada = actividad
                                        onActividadClick(actividad)
                                    }
                                )
                            }
                        }
                    } else {
                        LazyColumn(
                            contentPadding = PaddingValues(bottom = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            items(
                                items = actividadesFiltradas,
                                key = { actividad -> actividad.id }
                            ) { actividad ->
                                TarjetaActividad(
                                    actividad = actividad,
                                    onClick = {
                                        actividadSeleccionada = actividad
                                        onActividadClick(actividad)
                                    }
                                )
                            }

                            // Muestra la Sección Scrum arriba de las actividades
                            item {
                                SeccionScrum()
                            }
                        }
                    }
                }
            }
        }

        // Diálogo emergente
        actividadSeleccionada?.let { actividad ->
            DetalleActividadDialog(
                actividad = actividad,
                onDismiss = { actividadSeleccionada = null }
            )
        }
    }
}

@Composable
fun EstadoVacio(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.semantics {
            contentDescription = "No hay actividades disponibles"
        },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = "📋",
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "No se encontraron actividades",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Intenta cambiar los filtros de búsqueda o la palabra clave.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(name = "Pantalla con Diálogo", showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun PantallaActividadesPreview() {
    MaterialTheme {
        PantallaActividades(
            actividades = DatosEjemplo.listaActividades,
            nombreAprendiz = "Andrés Felipe"
        )
    }
}