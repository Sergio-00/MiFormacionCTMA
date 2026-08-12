package com.joel.mi_formacion_ctma.model

object DatosEjemplo {
    val listaActividades = listOf(
        ActividadFormativa(
            id = 1,
            titulo = "Guía 1: Modelado de Clases y Reglas de Negocio en Kotlin Puro",
            descripcion = "Definición de variables, colecciones, data classes y null safety.",
            progreso = 100,
            diasRestantes = 0,
            prioridad = Prioridad.ALTA
        ),
        ActividadFormativa(
            id = 2,
            titulo = "Guía 2: Pruebas Unitarias y Control de Versiones con Git",
            descripcion = "Implementación de pruebas unitarias y gestión de ramas en GitHub.",
            progreso = 100,
            diasRestantes = 0,
            prioridad = Prioridad.MEDIA
        ),
        ActividadFormativa(
            id = 3,
            titulo = "Guía 3: Interfaces Declarativas con Jetpack Compose y Material 3",
            descripcion = "Diseño de tarjetas, listas perezosas, estado y adaptabilidad.",
            progreso = 60,
            diasRestantes = 2,
            prioridad = Prioridad.ALTA
        ),
        ActividadFormativa(
            id = 4,
            titulo = "Taller de Accesibilidad y Semántica en Android Studio",
            descripcion = "Validación de contraste, tamaño de fuente y descripciones para lector de pantalla.",
            progreso = 40,
            diasRestantes = 4,
            prioridad = Prioridad.MEDIA
        ),
        ActividadFormativa(
            id = 5,
            titulo = "Auditoría de UX y Pruebas Cruzadas de Pantallas Móviles",
            descripcion = "Evaluación heurística de la interfaz con compañeros de equipo.",
            progreso = 10,
            diasRestantes = 6,
            prioridad = Prioridad.BAJA
        ),
        ActividadFormativa(
            id = 6,
            titulo = "Configuración del Entorno de Desarrollo y SDK Android",
            descripcion = "Instalación de Android Studio, emuladores y herramientas Gradle.",
            progreso = 100,
            diasRestantes = 0,
            prioridad = Prioridad.ALTA
        ),
        ActividadFormativa(
            id = 7,
            titulo = "Diseño de Prototipo de Alta Fidelidad en Figma para Muevelo Ya",
            descripcion = "Maquetación de flujos de usuario y sistema de diseño inicial.",
            progreso = 85,
            diasRestantes = 1,
            prioridad = Prioridad.ALTA
        ),
        ActividadFormativa(
            id = 8,
            titulo = "Documentación Técnica del Sistema y Casos de Uso del Proyecto",
            descripcion = "Redacción de especificaciones funcionales y diagramas UML.",
            progreso = 30,
            diasRestantes = 7,
            prioridad = Prioridad.BAJA
        ),
        ActividadFormativa(
            id = 9,
            titulo = "Integración de Iconografía y Recursos Gráficos Vectoriales",
            descripcion = "Optimización de assets en formato XML Vector Drawable.",
            progreso = 0,
            diasRestantes = 10,
            prioridad = Prioridad.BAJA
        ),
        ActividadFormativa(
            id = 10,
            titulo = "Sustentación de Avance de Proyecto y Entrega de Evidencias SENA",
            descripcion = "Presentación ejecutiva ante el instructor y compañeros de ficha.",
            progreso = 0,
            diasRestantes = 12,
            prioridad = Prioridad.MEDIA
        )
    )
}