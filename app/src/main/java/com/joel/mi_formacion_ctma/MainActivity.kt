package com.joel.mi_formacion_ctma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.mi_formacion_ctma.ui.components.TarjetaActividad
import com.joel.mi_formacion_ctma.ui.theme.MiFormacionCTMATheme
import domain.ReglasActividad
import model.ActividadFormativa
import model.Prioridad

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
fun EncabezadoFormacion(
    nombre: String,
    resumen: String
) {
    Column {
        Text(
            text = "Mi Formación CTMA",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Hola, $nombre"
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ilustracion_formacion),
            contentDescription = "Ilustración relacionada con la formación y el estudio",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text(
            text = resumen
        )
    }
}

@Composable
fun ListaActividades(
    actividades: List<ActividadFormativa>
) {
    LazyColumn {
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
        EncabezadoFormacion(
            nombre = nombre,
            resumen = "Aquí organizarás actividades y evidencias."
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
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
                    text = """
                    ¿Qué es Scrum?
                    Scrum es un marco de trabajo ágil que permite gestionar proyectos de manera iterativa e incremental, promoviendo la colaboración, la adaptación al cambio y la entrega continua de valor.
                    
                    Valores de Scrum
                    
                    1. Compromiso: Los integrantes del equipo se comprometen a alcanzar los objetivos establecidos.
                    
                    2. Enfoque: El equipo concentra sus esfuerzos en el trabajo del Sprint y las metas definidas.
                    
                    3. Apertura: Se fomenta la transparencia y la comunicación honesta entre todos los participantes.
                    
                    4. Respeto: Cada miembro valora las capacidades, opiniones y aportes de los demás.
                    
                    5. Valentía: El equipo tiene la capacidad de enfrentar problemas, desafíos y cambios.
                    
                    Principios Ágiles aplicados en Scrum
                    
                    1. Satisfacer al cliente mediante la entrega temprana y continua de software con valor.
                    
                    2. Aceptar cambios en los requisitos, incluso en etapas avanzadas del desarrollo.
                    
                    3. Entregar software funcional frecuentemente, en períodos cortos de tiempo.
                    
                    4. Colaborar diariamente entre el negocio y los desarrolladores.
                    
                    5. Construir proyectos alrededor de personas motivadas y brindarles apoyo.
                    
                    6. Favorecer la comunicación cara a cara como el método más efectivo.
                    
                    7. Medir el progreso principalmente mediante software funcional.
                    
                    8. Mantener un ritmo de desarrollo sostenible a largo plazo.
                    
                    9. Prestar atención continua a la excelencia técnica y al buen diseño.
                    
                    10. Mantener la simplicidad, maximizando el trabajo que no es necesario realizar.
                    
                    11. Permitir que los mejores diseños y soluciones surjan de equipos autoorganizados.
                    
                    12. Reflexionar periódicamente para mejorar la efectividad y ajustar el comportamiento del equipo.
                    """.trimIndent()
                )
            }
        }
    }
}

val actividadesPreview = listOf(
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
    ),
    ActividadFormativa(
        id = 4,
        titulo = "Principios de Scrum",
        descripcion = "Valores y principios ágiles",
        progreso = 60,
        diasRestantes = 7,
        prioridad = Prioridad.MEDIA
    ),
    ActividadFormativa(
        id = 5,
        titulo = "Diseño de interfaces",
        descripcion = "Componentes visuales en Compose",
        progreso = 30,
        diasRestantes = 10,
        prioridad = Prioridad.BAJA
    ),
    ActividadFormativa(
        id = 6,
        titulo = "Layouts en Jetpack Compose",
        descripcion = "Column, Row y Box",
        progreso = 75,
        diasRestantes = 4,
        prioridad = Prioridad.ALTA
    ),
    ActividadFormativa(
        id = 7,
        titulo = "Accesibilidad en aplicaciones",
        descripcion = "Semantics y contentDescription",
        progreso = 20,
        diasRestantes = 8,
        prioridad = Prioridad.MEDIA
    ),
    ActividadFormativa(
        id = 8,
        titulo = "Manejo de estados",
        descripcion = "Estado y recomposición",
        progreso = 50,
        diasRestantes = 6,
        prioridad = Prioridad.ALTA
    ),
    ActividadFormativa(
        id = 9,
        titulo = "Pruebas de interfaz",
        descripcion = "Validación de componentes",
        progreso = 10,
        diasRestantes = 12,
        prioridad = Prioridad.BAJA
    ),
    ActividadFormativa(
        id = 10,
        titulo = "Entrega del incremento",
        descripcion = "Preparación de la demostración final",
        progreso = 85,
        diasRestantes = 2,
        prioridad = Prioridad.ALTA
    )
)

@Preview(
    name = "Lista de actividades",
    showBackground = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
fun ListaActividadesPreview() {
    MiFormacionCTMATheme {
        ListaActividades(
            actividades = actividadesPreview
        )
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

@Preview(
    name = "Normal",
    showBackground = true
)
@Composable
fun EncabezadoFormacionPreview() {
    MiFormacionCTMATheme {
        EncabezadoFormacion(
            nombre = "Joel",
            resumen = "Aquí organizarás actividades y evidencias."
        )
    }
}

@Preview(
    name = "Fuente Grande",
    showBackground = true,
    fontScale = 1.5f
)
@Composable
fun EncabezadoFormacionFuenteGrandePreview() {
    MiFormacionCTMATheme {
        EncabezadoFormacion(
            nombre = "Joel",
            resumen = "Aquí organizarás actividades y evidencias."
        )
    }
}

@Preview(
    name = "Ancho Ampliado",
    showBackground = true,
    widthDp = 800
)
@Composable
fun EncabezadoFormacionAnchoAmpliadoPreview() {
    MiFormacionCTMATheme {
        EncabezadoFormacion(
            nombre = "Joel",
            resumen = "Aquí organizarás actividades y evidencias."
        )
    }
}

@Preview(
    name = "Tarjeta con título largo",
    showBackground = true,
    widthDp = 360
)
@Composable
fun TarjetaActividadPreview() {
    MiFormacionCTMATheme {
        TarjetaActividad(
            actividad = ActividadFormativa(
                id = 1,
                titulo = "Clase de Wilson 1 porque solo Wilson da clases y este es un título bastante largo",
                descripcion = "Variables y funciones",
                progreso = 40,
                diasRestantes = 5,
                prioridad = Prioridad.MEDIA
            ),
            onClick = { }
        )
    }
}

@Preview(
    name = "Progreso límite",
    showBackground = true,
    widthDp = 360
)
@Composable
fun TarjetaActividadProgresoLimitePreview() {
    MiFormacionCTMATheme {
        TarjetaActividad(
            actividad = ActividadFormativa(
                id = 3,
                titulo = "Programación Orientada a Objetos",
                descripcion = "Clases y objetos",
                progreso = 100,
                diasRestantes = -1,
                prioridad = Prioridad.ALTA
            ),
            onClick = { }
        )
    }
}