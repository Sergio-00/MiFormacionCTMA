package com.joel.mi_formacion_ctma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import domain.ReglasActividad
import model.ActividadFormativa
import model.Prioridad
import com.joel.mi_formacion_ctma.ui.theme.MiFormacionCTMATheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

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
        val actividadesOrdenadas = ReglasActividad.ordenarActividades(actividades)

        val promedio = ReglasActividad.promedioProgreso(actividades)
        val urgentes = ReglasActividad.actividadesUrgentes(actividades)

        val listaOrdenada = actividadesOrdenadas.joinToString("\n") {
            "• ${it.titulo}"
        }

        val resumen = buildString {
            appendLine("Total actividades: ${actividades.size}")
            appendLine("Promedio de progreso: ${"%.1f".format(promedio)}%")
            appendLine("Actividades urgentes: ${urgentes.size}")
            appendLine()
            appendLine("Actividades ordenadas:")
            append(listaOrdenada)
        }

        setContent {
            MiFormacionCTMATheme {
                PantallaInicio(resumen = resumen)
            }
        }
    }
}

@Composable
fun PantallaInicio(
    nombre: String = "Aprendiz",
    resumen: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Mi Formación CTMA",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Hola, $nombre")

        Text(
            text = "Aquí organizarás actividades y evidencias."
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Resumen de actividades",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = resumen)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Scrum: Valores y Principios",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = """
                    ¿Qué es Scrum?
                    Scrum es un marco de trabajo ágil que permite gestionar proyectos de manera iterativa e incremental, promoviendo la colaboración, la adaptación al cambio y la entrega continua de valor.
                    
                    Valores de Scrum
                    
                    1. Compromiso: Los integrantes del equipo se comprometen a alcanzar los objetivos establecidos.
                    
                    2. Enfoque: El equipo concentra sus esfuerzos en el trabajo del Sprint y las metas definidas.
                    
                    3. Apertura: Se fomenta la transparencia y la comunicación honesta entre todos los participantes.
                    
                    4. Respeto: Cada miembro valora las capacidades, opiniones y aportes de los demás.
                    
                    5. Valentía: El equipo tiene la capacidad de enfrentar problemas, desafíos y cambios.
                    
                    Principios de Scrum
                    
                    1. Control empírico del proceso: Las decisiones se basan en la observación, inspección y adaptación.
                    
                    2. Autoorganización: Los equipos gestionan su propio trabajo y toman decisiones de manera autónoma.
                    
                    3. Colaboración: Se promueve el trabajo conjunto entre clientes, usuarios y equipo de desarrollo.
                    
                    4. Priorización basada en valor: Se desarrollan primero las funcionalidades que generan mayor valor.
                    
                    5. Desarrollo iterativo e incremental: El producto se construye en pequeñas entregas sucesivas.
                    
                    6. Adaptación al cambio: Los requisitos pueden ajustarse según las necesidades del proyecto.
                    
                    7. Entrega frecuente de valor: Se generan resultados funcionales de forma continua.
                    """.trimIndent()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    MiFormacionCTMATheme {
        PantallaInicio(
            resumen = """
                Total actividades: 3
                Promedio de progreso: 76.7%
                Actividades urgentes: 1
            """.trimIndent()
        )
    }
}