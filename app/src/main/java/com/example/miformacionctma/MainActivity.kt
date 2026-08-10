package com.example.miformacionctma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miformacionctma.model.*
import com.example.miformacionctma.domain.*
import com.example.miformacionctma.ui.theme.MiFormacionCTMATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // PruebasSemana2.ejecutar()

        val actividades = listOf(
            ActividadFormativa(1, "Kotlin básico", "Repasar funciones", 80, 1, Prioridad.ALTA),
            ActividadFormativa(2, "Compose inicial", null, 40, 4, Prioridad.MEDIA),
            ActividadFormativa(3, "Diagnóstico", null, 100, -2, Prioridad.BAJA)
        )
        val urgentes = ReglasActividad.actividadesUrgentes(actividades).size
        val promedio = ReglasActividad.promedioProgreso(actividades)
        // val ordenadas = ReglasActividad.ordenarActividades(actividades)
        val resumen = buildString {
            appendLine("Urgentes: $urgentes")
            appendLine("Promedio: ${promedio.toInt()}%")
            appendLine("Actividades:")
            appendLine(
                actividades
                    .sortedBy { it.id }
                    .joinToString(", ") { it.titulo }
            )
        }

        setContent {
            MiFormacionCTMATheme {
                PantallaInicio(resumen)
            }
        }
    }
}

@Composable
fun PantallaInicio(resumen: String) {
    Column(
        modifier = Modifier
         .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp, 54.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Mi Formación CTMA",
            style = MaterialTheme.typography.headlineMedium
        )

        Text("Hola, Aprendices")
        Text(resumen)

        // Card valores
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text("Valores Ágiles", style = MaterialTheme.typography.titleMedium)
                Text("• Individuos e interacciones", style = MaterialTheme.typography.bodyMedium)
                Text("• Software funcionando", style = MaterialTheme.typography.bodyMedium)
                Text("• Colaboración con el cliente", style = MaterialTheme.typography.bodyMedium)
                Text("• Respuesta al cambio", style = MaterialTheme.typography.bodyMedium)
            }
        }

        // Card principios
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = "Principios Ágiles",
                    style = MaterialTheme.typography.titleMedium
                )

                PrincipioItem(
                    titulo = "1. Satisfacer al cliente",
                    descripcion = "Entregar valor útil desde etapas tempranas y de forma continua."
                )

                PrincipioItem(
                    titulo = "2. Aceptar cambios",
                    descripcion = "Los cambios en los requisitos pueden mejorar el producto final."
                )

                PrincipioItem(
                    titulo = "3. Entregas frecuentes",
                    descripcion = "Mostrar funcionalidades funcionando en periodos cortos."
                )

                PrincipioItem(
                    titulo = "4. Trabajo conjunto",
                    descripcion = "Desarrolladores y usuarios deben colaborar constantemente."
                )

                PrincipioItem(
                    titulo = "5. Equipos motivados",
                    descripcion = "Las personas motivadas producen mejores resultados."
                )

                PrincipioItem(
                    titulo = "6. Comunicación directa",
                    descripcion = "Hablar directamente reduce errores y acelera decisiones."
                )

                PrincipioItem(
                    titulo = "7. Software funcional",
                    descripcion = "El progreso real se mide por funcionalidades que funcionan."
                )

                PrincipioItem(
                    titulo = "8. Ritmo sostenible",
                    descripcion = "El equipo debe mantener una carga de trabajo equilibrada."
                )

                PrincipioItem(
                    titulo = "9. Excelencia técnica",
                    descripcion = "El buen diseño y el código limpio facilitan la evolución del sistema."
                )

                PrincipioItem(
                    titulo = "10. Simplicidad",
                    descripcion = "Hacer solo lo necesario evita trabajo innecesario."
                )

                PrincipioItem(
                    titulo = "11. Autoorganización",
                    descripcion = "Los equipos organizan su propio trabajo y toman decisiones técnicas."
                )

                PrincipioItem(
                    titulo = "12. Mejora continua",
                    descripcion = "El equipo revisa su trabajo y busca mejorar en cada Sprint."
                )
            }
        }
    }
}

@Composable
fun PrincipioItem(titulo: String, descripcion: String) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
            text = titulo,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = descripcion,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    MiFormacionCTMATheme {
        PantallaInicio("Urgentes: 1\nPromedio: 87%")
    }
}
