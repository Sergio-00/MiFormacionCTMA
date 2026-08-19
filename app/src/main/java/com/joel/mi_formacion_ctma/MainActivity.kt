package com.joel.mi_formacion_ctma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.joel.mi_formacion_ctma.model.ActividadFormativa
import com.joel.mi_formacion_ctma.model.DatosEjemplo
import com.joel.mi_formacion_ctma.model.Prioridad
import com.joel.mi_formacion_ctma.ui.screens.PantallaActividades
import com.joel.mi_formacion_ctma.ui.theme.MiFormacionCTMATheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val actividades = listOf(
            ActividadFormativa(
                id = 1,
                titulo = "Guía 1: Modelado e Inicio Android",
                descripcion = "Variables, colecciones y reglas de negocio",
                progreso = 100,
                diasRestantes = 0,
                prioridad = Prioridad.ALTA
            ),
            ActividadFormativa(
                id = 2,
                titulo = "Guía 2: Lógica Kotlin y Pruebas",
                descripcion = "POO, data classes y pruebas unitarias con JUnit",
                progreso = 100,
                diasRestantes = 0,
                prioridad = Prioridad.MEDIA
            ),
            ActividadFormativa(
                id = 3,
                titulo = "Guía 3: Interfaces con Jetpack Compose",
                descripcion = "UI declarativa, Material 3 y accesibilidad",
                progreso = 40,
                diasRestantes = 3,
                prioridad = Prioridad.ALTA
            )
        )

        setContent {
            MiFormacionCTMATheme {
                PantallaActividades(
                    actividades = actividades,
                    nombreAprendiz = "Andrés Felipe",
                    onActividadClick = { _ -> }
                )
            }
        }
    }
}

// ==========================================
// PREVIEWS
// ==========================================

@Preview(
    name = "Modo Claro",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainActivityPreviewLight() {
    MiFormacionCTMATheme(darkTheme = false) {
        PantallaActividades(
            actividades = DatosEjemplo.listaActividades,
            nombreAprendiz = "Andrés Felipe"
        )
    }
}

@Preview(
    name = "Modo Oscuro",
    showBackground = true,
    showSystemUi = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MainActivityPreviewDark() {
    MiFormacionCTMATheme(darkTheme = true) {
        PantallaActividades(
            actividades = DatosEjemplo.listaActividades,
            nombreAprendiz = "Andrés Felipe"
        )
    }
}