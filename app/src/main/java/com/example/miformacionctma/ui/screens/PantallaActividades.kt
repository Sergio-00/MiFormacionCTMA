package com.example.miformacionctma.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miformacionctma.domain.actividadesDemo
import com.example.miformacionctma.model.ActividadFormativa
import com.example.miformacionctma.ui.components.TarjetaActividad
import com.example.miformacionctma.ui.components.SeccionPresentacion
import com.example.miformacionctma.ui.theme.MiFormacionCTMATheme

@Composable
fun ContenidoAdaptable(actividades: List<ActividadFormativa>) {
    BoxWithConstraints {
        if (maxWidth < 600.dp) {
            PantallaActividades(actividades)
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(actividades, key = { it.id }) { actividad ->
                    TarjetaActividad(actividad)
                }
            }
        }
    }
}

@Composable
fun PantallaActividades(
    actividades: List<ActividadFormativa>, onActividadClick: (ActividadFormativa) -> Unit = {}
) {
    val urgentes = actividades.count {
        it.progreso < 100 && it.diasRestantes <= 2
    }

    val promedio = if (actividades.isNotEmpty()) {
        actividades.map { it.progreso }.average().toInt()
    } else {
        0
    }

    val resumen = buildString {
        appendLine("Urgentes: $urgentes")
        appendLine("Promedio: $promedio%")
        appendLine("Actividades: ${actividades.size}")
    }

    Scaffold { padding ->

        if (actividades.isEmpty()) {
            EstadoVacio(modifier = Modifier.padding(padding))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    SeccionPresentacion(resumen)
                }

                item {
                    EncabezadoActividades(actividades)
                }

                items(
                    items = actividades, key = { it.id }) { actividad ->
                    TarjetaActividad(
                        actividad = actividad, onClick = { onActividadClick(actividad) })
                }
            }
        }
    }
}

@Composable
private fun EncabezadoActividades(actividades: List<ActividadFormativa>) {
    val completadas = actividades.count { it.progreso >= 100 }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Resumen", style = MaterialTheme.typography.titleMedium
                )

                Text("Total: ${actividades.size}")
                Text("Completadas: $completadas")
            }
        }
    }
}

@Composable
private fun EstadoVacio(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "No hay actividades registradas",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Agrega una actividad para comenzar a organizar tu formación.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PantallaActividadesPreview() {
    MiFormacionCTMATheme {
        PantallaActividades(actividadesDemo)
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
private fun PantallaActividadesPreviewAncha() {
    MiFormacionCTMATheme {
        PantallaActividades(actividadesDemo)
    }
}