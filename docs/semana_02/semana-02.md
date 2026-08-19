# Semana 2 · Núcleo Kotlin

## Objetivo

Aplicar tipos, operadores, control de flujo, funciones y colecciones de Kotlin en el caso **Mi Formación CTMA**.

---

## Mapa de conexión semana 1-2

| Archivo                 | Responsabilidad            |
|-------------------------|----------------------------|
| `MainActivity.kt`       | Interfaz y resumen visible |
| `ActividadFormativa.kt` | Modelo de datos            |
| `ReglasActividad.kt`    | Reglas de negocio          |
| `PruebasSemana2.kt`     | Validación de escenarios   |

---

## Reglas implementadas

* `validarActividad`
* `estadoActividad`
* `actividadesUrgentes`
* `promedioProgreso`
* `buscarPorTitulo`
* `ordenarActividades` (reto adicional)

---

## Explicación del comparador

Las actividades se ordenan con tres criterios:

1. **Vencidas primero**.
2. **Prioridad alta antes que media y baja**.
3. **Menor número de días restantes**.

Esto permite mostrar primero las actividades más críticas.

---

## Práctica de null safety

Se utilizó:

```kotlin
val descripcion: String?
```

No se usó el operador `!!`, ya que puede producir excepciones si el valor es nulo.

---

## Resultados de validación

| Escenario               | Resultado                                                                  |
|-------------------------|----------------------------------------------------------------------------|
| Título vacío            | [El título es obligatorio]                                                 |
| Progreso 120            | [El progreso debe estar entre 0 al 100]                                    |
| Días -1                 | VENCIDA                                                                    |
| Progreso 100 y días -2  | COMPLETADA                                                                 |
| Lista vacía             | 0.0                                                                        |
| Búsqueda por “ kotlin ” | Se encontró la actividad "Kotlin básico" dentro de la lista de resultados. |

---

## Preguntas de sustentación

### ¿Por qué elegiste `val`?

Porque los datos de una actividad no necesitan modificarse después de crearse.

### ¿Qué pasaría si la lista estuviera vacía?

`promedioProgreso` devuelve `0.0`, evitando divisiones inválidas.

### ¿Dónde podría aparecer `null`?

En `descripcion`, controlado mediante `String?`.

### ¿Por qué una regla no debería estar duplicada dentro del composable?

Para separar la lógica de negocio de la interfaz y evitar inconsistencias.

### Modificación de urgencia a tres días

```kotlin
fun actividadesUrgentes(actividades: List<ActividadFormativa>) =
    actividades.filter {
        it.progreso < 100 && it.diasRestantes <= 3
    }
```

Con este cambio, las actividades con exactamente **3 días restantes** también se consideran urgentes.
