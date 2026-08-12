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
                titulo = "Clase de Wilson 1 porque solo Wilson da clases",
                descripcion = "Variables y funciones",
                progreso = 40,
                diasRestantes = 5,
                prioridad = Prioridad.MEDIA
            ),
            ActividadFormativa(
                id = 2,
                titulo = "Clase de Wilson 2",
                descripcion = "Android Studio",
                progreso = 90,
                diasRestantes = 3,
                prioridad = Prioridad.BAJA
            ),
            ActividadFormativa(
                id = 3,
                titulo = "Programación Orientada a Objetos",
                descripcion = "Clases y objetos",
                progreso = 100,
                diasRestantes = -1,
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
// PREVIEWS DE ACCESIBILIDAD Y TEMAS
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