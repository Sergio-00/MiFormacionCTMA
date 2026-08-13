package com.joel.mi_formacion_ctma.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.mi_formacion_ctma.ui.components.TarjetaActividad
import com.joel.mi_formacion_ctma.ui.theme.MiFormacionCTMATheme
import model.ActividadFormativa
import model.Prioridad

@Composable
fun PantallaActividades(
    actividades: List<ActividadFormativa>
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->

        if (actividades.isEmpty()) {
            EstadoVacio(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Text(
                        text = "Mis actividades",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }

                items(
                    items = actividades,
                    key = { it.id }
                ) { actividad ->
                    TarjetaActividad(
                        actividad = actividad,
                        onClick = { }
                    )
                }
            }
        }
    }
}

@Composable
fun EstadoVacio(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "No tienes actividades",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Aún no has agregado ninguna actividad formativa.",
            modifier = Modifier.padding(top = 8.dp)
        )

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Agregar actividad"
            )
        }
    }
}

@Preview(
    name = "Estado vacío",
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun EstadoVacioPreview() {
    MiFormacionCTMATheme {
        EstadoVacio()
    }
}

@Preview(
    name = "Pantalla con actividades",
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun PantallaActividadesPreview() {
    MiFormacionCTMATheme {
        PantallaActividades(
            actividades = listOf(
                ActividadFormativa(
                    id = 1,
                    titulo = "Clase de Wilson",
                    descripcion = "Variables y funciones",
                    progreso = 40,
                    diasRestantes = 5,
                    prioridad = Prioridad.MEDIA
                ),
                ActividadFormativa(
                    id = 2,
                    titulo = "Programación Orientada a Objetos",
                    descripcion = "Clases y objetos",
                    progreso = 100,
                    diasRestantes = -1,
                    prioridad = Prioridad.ALTA
                )
            )
        )
    }
}

@Preview(
    name = "Pantalla ancho ampliado",
    showBackground = true,
    widthDp = 800,
    heightDp = 640
)
@Composable
fun PantallaActividadesAnchoAmpliadoPreview() {
    MiFormacionCTMATheme {
        PantallaActividades(
            actividades = listOf(
                ActividadFormativa(
                    id = 1,
                    titulo = "Clase de Wilson",
                    descripcion = "Variables y funciones",
                    progreso = 40,
                    diasRestantes = 5,
                    prioridad = Prioridad.MEDIA
                ),
                ActividadFormativa(
                    id = 2,
                    titulo = "Programación Orientada a Objetos",
                    descripcion = "Clases y objetos",
                    progreso = 100,
                    diasRestantes = -1,
                    prioridad = Prioridad.ALTA
                ),
                ActividadFormativa(
                    id = 3,
                    titulo = "Diseño de interfaces",
                    descripcion = "Componentes visuales en Compose",
                    progreso = 60,
                    diasRestantes = 7,
                    prioridad = Prioridad.MEDIA
                )
            )
        )
    }
}