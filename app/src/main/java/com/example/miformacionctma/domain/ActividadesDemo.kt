package com.example.miformacionctma.domain

import com.example.miformacionctma.model.ActividadFormativa
import com.example.miformacionctma.model.Prioridad

val actividadesDemo = listOf(
    ActividadFormativa(
        id = 1L,
        titulo = "Construir pantalla Compose accesible",
        descripcion = "Crear la interfaz principal usando Jetpack Compose y Material 3.",
        progreso = 65,
        diasRestantes = 3,
        prioridad = Prioridad.ALTA
    ),

    ActividadFormativa(
        id = 2L,
        titulo = "Diseñar tarjeta reutilizable de actividades",
        descripcion = "Implementar TarjetaActividad como composable reutilizable y desacoplado.",
        progreso = 40,
        diasRestantes = 5,
        prioridad = Prioridad.ALTA
    ),

    ActividadFormativa(
        id = 3L,
        titulo = "Validar títulos largos y adaptación visual en diferentes tamaños de pantalla",
        descripcion = "Comprobar que el diseño no se recorte cuando el texto sea demasiado extenso.",
        progreso = 20,
        diasRestantes = 7,
        prioridad = Prioridad.MEDIA
    ),

    ActividadFormativa(
        id = 4L,
        titulo = "Preparar estado vacío de la pantalla",
        descripcion = "Mostrar un mensaje comprensible cuando no existan actividades registradas.",
        progreso = 100,
        diasRestantes = 0,
        prioridad = Prioridad.MEDIA
    ),

    ActividadFormativa(
        id = 5L,
        titulo = "Aplicar tema Material 3 y tipografía consistente",
        descripcion = "Centralizar colores, tamaños y estilos del proyecto para evitar duplicación.",
        progreso = 55,
        diasRestantes = 2,
        prioridad = Prioridad.ALTA
    ),

    ActividadFormativa(
        id = 6L,
        titulo = "Revisar accesibilidad con fuente grande",
        descripcion = "Probar escalado de texto, contraste y tamaños táctiles adecuados para distintos usuarios.",
        progreso = 15,
        diasRestantes = 6,
        prioridad = Prioridad.MEDIA
    ),

    ActividadFormativa(
        id = 7L,
        titulo = "Implementar LazyColumn con claves estables",
        descripcion = "Usar key = { it.id } para mejorar la recomposición y mantener el estado de los elementos.",
        progreso = 80,
        diasRestantes = 1,
        prioridad = Prioridad.ALTA
    ),

    ActividadFormativa(
        id = 8L,
        titulo = "Agregar adaptación para pantallas anchas con BoxWithConstraints",
        descripcion = "Cambiar entre lista y cuadrícula según el ancho disponible del dispositivo.",
        progreso = 30,
        diasRestantes = 4,
        prioridad = Prioridad.MEDIA
    ),

    ActividadFormativa(
        id = 9L,
        titulo = "Documentar decisiones de UX y accesibilidad",
        descripcion = "Registrar hallazgos encontrados durante las pruebas y las correcciones realizadas.",
        progreso = 10,
        diasRestantes = 8,
        prioridad = Prioridad.BAJA
    ),

    ActividadFormativa(
        id = 10L,
        titulo = "Preparar demostración final y revisión cruzada del Sprint de UI Compose",
        descripcion = "Verificar funcionamiento, capturas, commits y explicación técnica del incremento desarrollado.",
        progreso = 0,
        diasRestantes = 10,
        prioridad = Prioridad.MEDIA
    )
)